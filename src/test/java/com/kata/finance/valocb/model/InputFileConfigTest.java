package com.kata.finance.valocb.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class InputFileConfigTest {
InputFileConfig inputFileConfig;
    @BeforeEach
    public void init() {
        inputFileConfig = new InputFileConfig();
        inputFileConfig.setProductFirstLineNumber(4);
        inputFileConfig.setPricesFirstLineNumber(4);
        inputFileConfig.setForexFirstLineNumber(4);
        inputFileConfig.setForexLineSeparator(",");
        inputFileConfig.setPricesLineSeparator(",");
        inputFileConfig.setPricesLineSeparator(",");
        inputFileConfig.setOutputFileSeperator(",");
        inputFileConfig.setReportingPortfolioFileName("Reporting-portfolio.csv");
        inputFileConfig.setReportingClientFileName("Reporting-client.csv");

    }



    @Test
    void getForexFirstLineNumber() {
        assertNotNull(inputFileConfig);
        assertTrue(inputFileConfig.getForexFirstLineNumber() > 1);
    }

    @Test
    void getPricesFirstLineNumber() {
        assertNotNull(inputFileConfig);
        assertTrue(inputFileConfig.getPricesFirstLineNumber() > 1);
    }

    @Test
    void getProductFirstLineNumber() {
        assertNotNull(inputFileConfig);
        assertTrue(inputFileConfig.getProductFirstLineNumber() > 1);
    }


    @Test
    void getForexLineSeparator() {
        assertNotNull(inputFileConfig);
        assertNotNull(inputFileConfig.getForexLineSeparator());
    }

    @Test
    void getPricesLineSeparator() {
        assertNotNull(inputFileConfig);
        assertNotNull(inputFileConfig.getPricesLineSeparator());
    }


    @Test
    void getProductLineSeparator() {
        assertNotNull(inputFileConfig);
        assertNotNull(inputFileConfig.getPricesLineSeparator());
    }


    @Test
    void getReportingPortfolioFileName() {
        assertNotNull(inputFileConfig);
        assertNotNull(inputFileConfig.getReportingPortfolioFileName());
    }

    @Test
    void getReportingClientFileName() {
        assertNotNull(inputFileConfig);
        assertNotNull(inputFileConfig.getReportingClientFileName());
    }


    @Test
    void getOutputFileSeperator() {
        assertNotNull(inputFileConfig);
        assertNotNull(inputFileConfig.getOutputFileSeperator());
    }


}