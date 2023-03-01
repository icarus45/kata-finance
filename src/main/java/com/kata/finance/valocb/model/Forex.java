package com.kata.finance.valocb.model;

public class Forex {
    private String eurForex;
    private String otherForex;
    private float parity;

    public Forex() {
    }

    public Forex(String eurForex, String otherForex, float parity) {
        this.eurForex = eurForex;
        this.otherForex = otherForex;
        this.parity = parity;
    }

    /*
        public Forex(String eurForex, String otherForex, int parity) {
            this.eurForex = eurForex;
            this.otherForex = otherForex;
            this.parity = parity;
        }
    */
    public String getEurForex() {
        return eurForex;
    }

    public void setEurForex(String eurForex) {
        this.eurForex = eurForex;
    }

    public String getOtherForex() {
        return otherForex;
    }

    public void setOtherForex(String otherForex) {
        this.otherForex = otherForex;
    }

    public double getParity() {
        return parity;
    }

    public void setParity(float parity) {
        this.parity = parity;
    }

    @Override
    public String toString() {
        return "Forex{" +
                "eurForex='" + eurForex + '\'' +
                ", otherForex='" + otherForex + '\'' +
                ", parity=" + parity +
                '}';
    }
}
