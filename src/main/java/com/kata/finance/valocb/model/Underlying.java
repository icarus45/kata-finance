package com.kata.finance.valocb.model;

public class Underlying {
    private String underlyingName;
    private String Currency;
    private double Price;

    public Underlying() {
    }

    public Underlying(String underlyingName, String currency, double price) {
        this.underlyingName = underlyingName;
        Currency = currency;
        Price = price;
    }

    public String getUnderlyingName() {
        return underlyingName;
    }

    public void setUnderlyingName(String underlyingName) {
        this.underlyingName = underlyingName;
    }

    public String getCurrency() {
        return Currency;
    }

    public void setCurrency(String currency) {
        Currency = currency;
    }

    public double getPrice() {
        return Price;
    }

    public void setPrice(double price) {
        Price = price;
    }

    @Override
    public String toString() {
        return "Underlying{" +
                "underlyingName='" + underlyingName + '\'' +
                ", Currency='" + Currency + '\'' +
                ", Price=" + Price +
                '}';
    }
}
