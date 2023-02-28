package com.kata.finance.valocb.service;

import com.kata.finance.valocb.model.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.io.IOException;
import java.io.*;
import java.util.*;

public class ReadInputFile {

    private static final Logger logger = LogManager.getLogger(ReadInputFile.class);
    public static InputFileConfig inputFileConfig;
    public static Properties properties = new Properties();
    public  static Map productsByClient;


    /**
     *
     * Methode pour lire les paramètres de configuration des fichiers
     * @throws IOException
     */
    public static void readInputConfigFile() throws IOException{
    inputFileConfig = new InputFileConfig();
    loadProperties();
    if(
            (properties.getProperty("forexFirstLineNumber") != null) &&
                    (properties.getProperty("pricesFirstLineNumber") != null) &&
                    (properties.getProperty("productFirstLineNumber") != null) &&
                    (properties.getProperty("forexLineSeparator") != null) &&
                    (properties.getProperty("pricesLineSeparator") != null) &&
                    (properties.getProperty("productLineSeparator") != null) &&
                    (properties.getProperty("reportingPortfolioFileName") != null) &&
                    (properties.getProperty("reportingClientFileName") != null) &&
                    (properties.getProperty("inputFileSeperator") != null)
    ) {
        inputFileConfig.setForexFirstLineNumber(Integer.parseInt(properties.getProperty("forexFirstLineNumber")) );
        inputFileConfig.setPricesFirstLineNumber(Integer.parseInt(properties.getProperty("pricesFirstLineNumber")));
        inputFileConfig.setProductFirstLineNumber(Integer.parseInt(properties.getProperty("productFirstLineNumber")));
        inputFileConfig.setForexLineSeparator(properties.getProperty("forexLineSeparator"));
        inputFileConfig.setPricesLineSeparator(properties.getProperty("pricesLineSeparator"));
        inputFileConfig.setProductLineSeparator(properties.getProperty("productLineSeparator"));
        inputFileConfig.setReportingClientFileName(properties.getProperty("reportingClientFileName"));
        inputFileConfig.setReportingPortfolioFileName(properties.getProperty("reportingPortfolioFileName"));
        inputFileConfig.setOutputFileSeperator(properties.getProperty("inputFileSeperator"));
    }
    }


        // This method is used to load the properties file
        static void loadProperties(){
            InputStream iStream = null;
            try {
                ClassLoader classloader = Thread.currentThread().getContextClassLoader();
                iStream = classloader.getResourceAsStream("inputFileConfig.properties");
                if(iStream == null){
                    throw new IOException("File not found");
                }else {
                    properties.load(iStream);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }finally {
                try {
                    if(iStream != null){
                        iStream.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

    }

}
