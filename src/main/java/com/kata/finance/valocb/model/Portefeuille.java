package com.kata.finance.valocb.model;

import java.util.List;

public class Portefeuille {
    private String portefeuilleName;
    private List<Produit> produits;

    public Portefeuille() {
    }

    public Portefeuille(String portefeuilleName, List<Produit> produits) {
        this.portefeuilleName = portefeuilleName;
        this.produits = produits;
    }

    public String getPortefeuilleName() {
        return portefeuilleName;
    }

    public void setPortefeuilleName(String portefeuilleName) {
        this.portefeuilleName = portefeuilleName;
    }

    public List<Produit> getProduits() {
        return produits;
    }

    public void setProduits(List<Produit> produits) {
        this.produits = produits;
    }
}
