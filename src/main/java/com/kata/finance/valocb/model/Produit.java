package com.kata.finance.valocb.model;

import java.util.List;

public class Produit {
    private String produitName;
    private List<Underlying> underlyings;

    public Produit() {
    }

    public Produit(String produitName, List<Underlying> underlyings) {
        this.produitName = produitName;
        this.underlyings = underlyings;
    }

    public String getProduitName() {
        return produitName;
    }

    public void setProduitName(String produitName) {
        this.produitName = produitName;
    }

    public List<Underlying> getUnderlyings() {
        return underlyings;
    }

    public void setUnderlyings(List<Underlying> underlyings) {
        this.underlyings = underlyings;
    }
}
