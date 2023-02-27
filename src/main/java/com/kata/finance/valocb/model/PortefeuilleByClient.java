package com.kata.finance.valocb.model;

import java.util.Map;

public class PortefeuilleByClient {
    private String clientName;
    private Map<String,Integer> produitList;

    public PortefeuilleByClient() {
    }

    public PortefeuilleByClient(String clientName, Map<String, Integer> produitList) {
        this.clientName = clientName;
        this.produitList = produitList;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public Map<String, Integer> getProduitList() {
        return produitList;
    }

    public void setProduitList(Map<String, Integer> produitList) {
        this.produitList = produitList;
    }

    @Override
    public String toString() {
        return "PortefeuilleByClient{" +
                "clientName='" + clientName + '\'' +
                ", produitList=" + produitList +
                '}';
    }
}
