package com.kata.finance.valocb.service;

import com.kata.finance.valocb.model.Portefeuille;
import com.kata.finance.valocb.model.Produit;
import com.kata.finance.valocb.model.Underlying;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class PriceService {
    private static final Logger logger = LogManager.getLogger(PriceService.class);
    public static Set<Portefeuille> portefeuilles;

    /**
     *
     * @param firstLinePosition
     * @param separateur
     * @throws IOException
     */
    public static  void readPricesFile(int firstLinePosition, String separateur) throws IOException {
        String fileName = "Prices.csv";
        portefeuilles  = new HashSet<Portefeuille>();

        InputStream iStream = null;
        try {
            ClassLoader classloader = Thread.currentThread().getContextClassLoader();
            iStream = classloader.getResourceAsStream(fileName);

            if (iStream == null) {
                throw new IllegalArgumentException(fileName + " file not found!");
            } else {
                InputStreamReader streamReader = new InputStreamReader(iStream, StandardCharsets.UTF_8);
                BufferedReader reader = new BufferedReader(streamReader);
                String line;

                int i = 0;
                while ((line = reader.readLine()) != null) {
                    if(i >= firstLinePosition && !line.isBlank() && !line.isEmpty()){
                        String [] currentLine = line.split(separateur);
                        String portefeuilleName = currentLine[0];
                        String produitName = currentLine[1];
                        String UnderlyingName = currentLine[2];
                        String currencyName = currentLine[3];
                        int price = Integer.parseInt(currentLine[4]);
                        //trouver le bon portefeuille
                        Portefeuille currentPortefeuille = portefeuilles.stream().filter(p -> p.getPortefeuilleName().equals(portefeuilleName)).findAny().orElse(null);
                        if(currentPortefeuille != null){
                            Produit produit = new Produit();
                            List<Produit> produits = currentPortefeuille.getProduits();
                            List<Produit> tempProduit = produits;
                            portefeuilles.removeIf(p -> p.getPortefeuilleName().equals(portefeuilleName));
                            Produit produitToUpdate = produits.stream().filter(p-> p.getProduitName().equals(produitName)).findAny().orElse(null);
                            //si ce produit existe deja
                            if(produitToUpdate != null) {
                                // List<Produit> currentProduits = produitToUpdate.getUnderlyings();
                                Portefeuille myPortefeuille = new Portefeuille();
                                Underlying underlying = new Underlying();
                                List<Underlying> underlyings = produitToUpdate.getUnderlyings();
                                produits.removeIf(p -> p.getProduitName().equals(produitName));

                                Underlying currentUnderlying = underlyings.stream().filter(un->un.getUnderlyingName().equals(UnderlyingName)).findAny().orElse(null);
                                if(currentUnderlying == null){
                                    produit.setProduitName(produitName);
                                    underlying.setUnderlyingName(UnderlyingName);
                                    underlying.setCurrency(currencyName);
                                    underlying.setPrice(price);
                                    underlyings.add(underlying);
                                    produit.setUnderlyings(underlyings);
                                    produits.add(produit);
                                    myPortefeuille.setPortefeuilleName(portefeuilleName);
                                    myPortefeuille.setProduits(produits);
                                    portefeuilles.add(myPortefeuille);
                                }

                            }else{
                                Portefeuille myPortefeuille = new Portefeuille();
                                Underlying underlying = new Underlying();
                                List<Underlying> underlyings = new ArrayList<Underlying>();
                                produit.setProduitName(produitName);
                                underlying.setUnderlyingName(UnderlyingName);
                                underlying.setCurrency(currencyName);
                                underlying.setPrice(price);
                                underlyings.add(underlying);
                                produit.setUnderlyings(underlyings);
                                produits.add(produit);
                                myPortefeuille.setPortefeuilleName(portefeuilleName);
                                myPortefeuille.setProduits(produits);
                                portefeuilles.add(myPortefeuille);
                            }

                        }else{
                            Portefeuille myPortefeuille = new Portefeuille();
                            Produit produit = new Produit();
                            List<Produit> produits = new ArrayList<Produit>();
                            Underlying underlying = new Underlying();
                            List<Underlying> underlyings = new ArrayList<Underlying>();
                            produit.setProduitName(produitName);
                            underlying.setUnderlyingName(UnderlyingName);
                            underlying.setCurrency(currencyName);
                            underlying.setPrice(price);
                            underlyings.add(underlying);
                            produit.setUnderlyings(underlyings);
                            produits.add(produit);
                            myPortefeuille.setPortefeuilleName(portefeuilleName);
                            myPortefeuille.setProduits(produits);
                            portefeuilles.add(myPortefeuille);

                        }
                    }
                    i++;
                }
            }

        }catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                if(iStream != null){
                    iStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
