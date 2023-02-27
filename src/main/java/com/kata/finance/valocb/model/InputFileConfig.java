package com.kata.finance.valocb.model;

public class InputFileConfig {
    private int forexFirstLineNumber;
    private int pricesFirstLineNumber;
    private int productFirstLineNumber;
    private String forexLineSeparator;
    private String pricesLineSeparator;
    private String productLineSeparator;
    private String reportingPortfolioFileName;
    private String reportingClientFileName;
    private String outputFileSeperator;

    public InputFileConfig() {
    }

    public InputFileConfig(int forexFirstLineNumber, int pricesFirstLineNumber, int productFirstLineNumber, String forexLineSeparator, String pricesLineSeparator, String productLineSeparator, String reportingPortfolioFileName, String reportingClientFileName, String outputFileSeperator) {
        this.forexFirstLineNumber = forexFirstLineNumber;
        this.pricesFirstLineNumber = pricesFirstLineNumber;
        this.productFirstLineNumber = productFirstLineNumber;
        this.forexLineSeparator = forexLineSeparator;
        this.pricesLineSeparator = pricesLineSeparator;
        this.productLineSeparator = productLineSeparator;
        this.reportingPortfolioFileName = reportingPortfolioFileName;
        this.reportingClientFileName = reportingClientFileName;
        this.outputFileSeperator = outputFileSeperator;
    }

    public int getForexFirstLineNumber() {
        return forexFirstLineNumber;
    }

    public void setForexFirstLineNumber(int forexFirstLineNumber) {
        this.forexFirstLineNumber = forexFirstLineNumber;
    }

    public int getPricesFirstLineNumber() {
        return pricesFirstLineNumber;
    }

    public void setPricesFirstLineNumber(int pricesFirstLineNumber) {
        this.pricesFirstLineNumber = pricesFirstLineNumber;
    }

    public int getProductFirstLineNumber() {
        return productFirstLineNumber;
    }

    public void setProductFirstLineNumber(int productFirstLineNumber) {
        this.productFirstLineNumber = productFirstLineNumber;
    }

    public String getForexLineSeparator() {
        return forexLineSeparator;
    }

    public void setForexLineSeparator(String forexLineSeparator) {
        this.forexLineSeparator = forexLineSeparator;
    }

    public String getPricesLineSeparator() {
        return pricesLineSeparator;
    }

    public void setPricesLineSeparator(String pricesLineSeparator) {
        this.pricesLineSeparator = pricesLineSeparator;
    }

    public String getProductLineSeparator() {
        return productLineSeparator;
    }

    public void setProductLineSeparator(String productLineSeparator) {
        this.productLineSeparator = productLineSeparator;
    }

    public String getReportingPortfolioFileName() {
        return reportingPortfolioFileName;
    }

    public void setReportingPortfolioFileName(String reportingPortfolioFileName) {
        this.reportingPortfolioFileName = reportingPortfolioFileName;
    }

    public String getReportingClientFileName() {
        return reportingClientFileName;
    }

    public void setReportingClientFileName(String reportingClientFileName) {
        this.reportingClientFileName = reportingClientFileName;
    }

    public String getOutputFileSeperator() {
        return outputFileSeperator;
    }

    public void setOutputFileSeperator(String outputFileSeperator) {
        this.outputFileSeperator = outputFileSeperator;
    }

    @Override
    public String toString() {
        return "InputFileConfig{" +
                "forexFirstLineNumber=" + forexFirstLineNumber +
                ", pricesFirstLineNumber=" + pricesFirstLineNumber +
                ", productFirstLineNumber=" + productFirstLineNumber +
                ", forexLineSeparator='" + forexLineSeparator + '\'' +
                ", pricesLineSeparator='" + pricesLineSeparator + '\'' +
                ", productLineSeparator='" + productLineSeparator + '\'' +
                ", reportingPortfolioFileName='" + reportingPortfolioFileName + '\'' +
                ", reportingClientFileName='" + reportingClientFileName + '\'' +
                ", outputFileSeperator='" + outputFileSeperator + '\'' +

                '}';
    }
}
