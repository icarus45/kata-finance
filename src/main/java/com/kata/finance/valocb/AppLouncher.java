package com.kata.finance.valocb;


import com.kata.finance.valocb.service.ForexService;
import com.kata.finance.valocb.service.PriceService;
import com.kata.finance.valocb.service.ProductService;
import com.kata.finance.valocb.service.GenerateFile;
import com.kata.finance.valocb.service.ReadInputFile;
import com.opencsv.exceptions.CsvException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;

public class AppLouncher {
    private static final Logger logger = LogManager.getLogger(AppLouncher.class);
    public static void main(String[] args) throws IOException, CsvException {
        logger.info("Debut du programme");
        //lecture du fichier de configuration
        ReadInputFile.readInputConfigFile();
        //lecture des fichiers de données
        ForexService.readForexFile(ReadInputFile.inputFileConfig.getForexFirstLineNumber(), ReadInputFile.inputFileConfig.getForexLineSeparator());
        ProductService.readProductFile(ReadInputFile.inputFileConfig.getProductFirstLineNumber(), ReadInputFile.inputFileConfig.getProductLineSeparator());
        PriceService.readPricesFile(ReadInputFile.inputFileConfig.getPricesFirstLineNumber(),ReadInputFile.inputFileConfig.getPricesLineSeparator());
        GenerateFile.createClientProductFile();
        GenerateFile.evaluatePortefeuille( );
        logger.info("Fin du programme");
    }
}
