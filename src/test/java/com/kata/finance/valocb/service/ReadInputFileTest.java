package com.kata.finance.valocb.service;

import com.kata.finance.valocb.model.InputFileConfig;
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

    private ReadInputFile readInputFile;
    private InputFileConfig inputConfig;

    @BeforeEach
    public void init() {

        readInputFile = new ReadInputFile();
        inputConfig = new InputFileConfig();
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
        assertEquals(1, readInputFile.inputFileConfig.getForexLineSeparator().length());

    }


    @Test
    void pricesLineSeparatorSizeIsOne() throws IOException {
        readInputFile.readInputConfigFile();
        assertEquals(1, readInputFile.inputFileConfig.getPricesLineSeparator().length());
    }

    @Test
    void productLineSeparatorSizeIsOne() throws IOException {
        readInputFile.readInputConfigFile();
        assertEquals(1, readInputFile.inputFileConfig.getProductLineSeparator().length());
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
        inputConfig = readInputFile.inputFileConfig;
        assertTrue(inputConfig.getProductFirstLineNumber() > 0);
        assertTrue(inputConfig.getForexFirstLineNumber() > 0);
        assertTrue(inputConfig.getPricesFirstLineNumber() > 0);
        assertNotNull(inputConfig.getProductLineSeparator());
        assertNotNull(inputConfig.getPricesLineSeparator());
        assertNotNull(inputConfig.getForexLineSeparator());
        assertNotNull(inputConfig.getOutputFileSeperator());
        assertNotNull(inputConfig.getReportingClientFileName());
    }

    @Test
    void propertiesFileExist() {
        String rootPath = Thread.currentThread().getContextClassLoader().getResource("inputFileConfig.properties").getPath();
        File file = new File(rootPath);
        assertTrue(file.exists());
    }

    @Test
    void forexFileContentIsValide() {
        forexFileExist();
    }

    @Test
    void readProductFile() throws IOException {
        productFileExist();
        inputConfigFileDataIsNotEmpty();
        ProductService productService = new ProductService();
        //int firstLinePosition, String separateur
        //productService.mesPorteufeuilles(inputFileConfig.getProductFirstLineNumber(), inputFileConfig.getProductLineSeparator());
    }

}