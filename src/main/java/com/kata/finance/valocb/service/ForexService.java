package com.kata.finance.valocb.service;

import com.kata.finance.valocb.model.Forex;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.HashSet;
import java.util.Set;


public class ForexService {

    private static final Logger logger = LogManager.getLogger(ForexService.class);
    public static Set<Forex> forexSet;

    /**
     *
     * @param firstLinePosition
     * @param separateur
     * @throws IOException
     */
    public static  void readForexFile(int firstLinePosition, String separateur) throws IOException {
        String fileName = "Forex.csv";
        InputStream iStream = null;
        try {
            ClassLoader classloader = Thread.currentThread().getContextClassLoader();
            iStream = classloader.getResourceAsStream(fileName);
            forexSet = new HashSet<Forex>();

            if (iStream == null) {
                throw new IllegalArgumentException(fileName + " file not found!");
            } else {
                InputStreamReader streamReader = new InputStreamReader(iStream, StandardCharsets.UTF_8);
                BufferedReader reader = new BufferedReader(streamReader);
                String line;
                int i = 0;
                while ((line = reader.readLine()) != null) {
                    Forex forex = new Forex();
                    if(i >= firstLinePosition){
                        line = line.toUpperCase();
                        String [] currentLine = line.split(separateur);
                        float coeff = 0;
                        if("EUR".equals(currentLine[0])){
                            coeff = Float.parseFloat(currentLine[2]);
                        }
                        else {
                            String tempsValue = currentLine[0];
                            currentLine[0] = currentLine[1];
                            currentLine[1] = tempsValue;
                            coeff = 1f / Float.parseFloat(currentLine[2]);
                        }
                        forex.setEurForex(currentLine[0]);
                        forex.setOtherForex(currentLine[1]);
                        forex.setParity(coeff);
                        forexSet.add(forex);
                    }
                    i++;
                }
            }
        }catch (IOException e) {
            e.printStackTrace();
            logger.error(e.getMessage());
        }finally {
            try {
                if(iStream != null){
                    iStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
                logger.error(e.getMessage());
            }
        }
    }


}
