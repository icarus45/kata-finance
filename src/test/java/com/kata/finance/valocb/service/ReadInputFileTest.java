package com.kata.finance.valocb.service;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;

import static org.junit.jupiter.api.Assertions.*;

class ReadInputFileTest {

   private ReadInputFile readInputFile ;
   private Properties properties;

    @BeforeEach
    public void init() {

        readInputFile = new ReadInputFile();
        properties = new Properties();
    }


    @Test
    void inputFileConfigExist() {
        String rootPath = Thread.currentThread().getContextClassLoader().getResource("inputFileConfig.properties").getPath();
        File file = new File(rootPath);
        assertTrue(file.exists());
    }

    @Test
    void forexFirstLineNumberIsNotNull() throws IOException {
        readInputFile.readInputConfigFile();
        assertNotNull(readInputFile.inputFileConfig.getForexFirstLineNumber());

    }


    @Test
    void pricesFirstLineNumberIsNotNull() throws IOException {
        readInputFile.readInputConfigFile();
        assertNotNull(readInputFile.inputFileConfig.getPricesFirstLineNumber());

    }

    @Test
    void productFirstLineNumberIsNotNull() throws IOException {
        readInputFile.readInputConfigFile();
        assertNotNull(readInputFile.inputFileConfig.getProductFirstLineNumber());

    }

    @Test
    void forexFirstLineNumberIsGreaterThanZero() throws IOException {
        readInputFile.readInputConfigFile();
        assertTrue(readInputFile.inputFileConfig.getForexFirstLineNumber() > 0);
    }


    @Test
    void pricesFirstLineNumberIsGreaterThanZero() throws IOException {
        readInputFile.readInputConfigFile();
        assertTrue(readInputFile.inputFileConfig.getPricesFirstLineNumber() > 0);

    }

    @Test
    void productFirstLineNumberIsGreaterThanZero() throws IOException {
        readInputFile.readInputConfigFile();
        assertTrue(readInputFile.inputFileConfig.getProductFirstLineNumber() > 0);
    }

    //********* separateur pour les fichiers csv **********
    // Separateur ne doit pas est null
    @Test
    void forexLineSeparatorIsNotNull() throws IOException {
        readInputFile.readInputConfigFile();
        assertNotNull(readInputFile.inputFileConfig.getForexLineSeparator());

    }


    @Test
    void pricesLineSeparatorIsNotNull() throws IOException {
        readInputFile.readInputConfigFile();
        assertNotNull(readInputFile.inputFileConfig.getPricesLineSeparator());

    }

    @Test
    void productLineSeparatorIsNotNull() throws IOException {
        readInputFile.readInputConfigFile();
        assertNotNull(readInputFile.inputFileConfig.getProductLineSeparator());

    }




    @Test
    void forexLineSeparatorSizeIsOne() throws IOException {
        readInputFile.readInputConfigFile();
        assertEquals(1,readInputFile.inputFileConfig.getForexLineSeparator().length());

    }


    @Test
    void pricesLineSeparatorSizeIsOne() throws IOException {
        readInputFile.readInputConfigFile();
        assertEquals(1,readInputFile.inputFileConfig.getPricesLineSeparator().length());
    }

    @Test
    void productLineSeparatorSizeIsOne() throws IOException {
        readInputFile.readInputConfigFile();
        assertEquals(1,readInputFile.inputFileConfig.getProductLineSeparator().length());
    }
    //******************** **********



    @Test
   static void forexFileExist() {
        String rootPath = Thread.currentThread().getContextClassLoader().getResource("Forex.csv").getPath();
        File file = new File(rootPath);
        assertTrue(file.exists());
    }

    @Test
    void pricesFileExist() {
        String rootPath = Thread.currentThread().getContextClassLoader().getResource("Prices.csv").getPath();
        File file = new File(rootPath);
        assertTrue(file.exists());
    }

    @Test
    void productFileExist() {
        String rootPath = Thread.currentThread().getContextClassLoader().getResource("Product.csv").getPath();
        File file = new File(rootPath);
        assertTrue(file.exists());
    }


    @Test
    void inputConfigFileDataIsNotEmpty() throws IOException {
        forexFileExist();
        readInputFile.readInputConfigFile();
        properties = readInputFile.properties;
        assertNotNull(properties.getProperty("forexFirstLineNumber"));
        assertNotNull(properties.getProperty("pricesFirstLineNumber"));
        assertNotNull(properties.getProperty("productFirstLineNumber"));
        assertNotNull(properties.getProperty("forexLineSeparator"));
        assertNotNull(properties.getProperty("pricesLineSeparator"));
        assertNotNull(properties.getProperty("productLineSeparator"));
        assertNotNull(properties.getProperty("reportingPortfolioFileName"));
        assertNotNull(properties.getProperty("reportingClientFileName"));
        assertNotNull(properties.getProperty("inputFileSeperator"));
    }

    @Test
    void propertiesFileExist(){
        String rootPath = Thread.currentThread().getContextClassLoader().getResource("inputFileConfig.properties").getPath();
        File file = new File(rootPath);
        assertTrue(file.exists());
    }

    @Test
    void forexFileContentIsValide(){
        forexFileExist();
        //int currencyNomber =
    }

    @Test
    void readProductFile() throws IOException {
        productFileExist();
        inputConfigFileDataIsNotEmpty();
        ProductService productService = new ProductService();
        //int firstLinePosition, String separateur
       // productService.mesPorteufeuilles()
    }
}