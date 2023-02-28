package com.kata.finance.valocb.service;

import com.kata.finance.valocb.model.PortefeuilleByClient;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ProductService {
    public static Set<PortefeuilleByClient> mesPorteufeuilles;

    private static final Logger logger = LogManager.getLogger(ProductService.class);

    /**
     *Methode pour lire le fichier des product:
     *
     * @param firstLinePosition : ligne de la premiére valeur
     * @param separateur : separateur utilisé au sein du fichier
     * @throws IOException
     */
    public static  void readProductFile(int firstLinePosition, String separateur) throws IOException {
        String fileName = "Product.csv";
        mesPorteufeuilles  = new HashSet<PortefeuilleByClient>();

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
                        String produitName = currentLine[0];
                        String clientName = currentLine[1];
                        int quantites  =Integer.parseInt(currentLine[2]);
                        // recherche du client (c dans le set)
                        PortefeuilleByClient currentClient = mesPorteufeuilles.stream().filter(c -> c.getClientName().equals(clientName)).findAny().orElse(null);
                        if(currentClient != null){
                            PortefeuilleByClient portefeuilleByClient = new PortefeuilleByClient();
                            PortefeuilleByClient currentClientTemps = currentClient;
                            Map<String,Integer> currentClientProduits = currentClientTemps.getProduitList();
                            mesPorteufeuilles.removeIf(p -> p.getClientName().equals(clientName));
                            //parcourrir la map pour trouver la key
                            if(currentClientProduits.containsKey(produitName)){
                                int oldValue = currentClientProduits.get(produitName);
                                Map<String,Integer> NewClientProduits = new HashMap<String,Integer>();
                                NewClientProduits.put(produitName,oldValue + quantites);
                                portefeuilleByClient.setClientName(clientName);
                                portefeuilleByClient.setProduitList(NewClientProduits);
                                mesPorteufeuilles.add(portefeuilleByClient);
                            }else{
                                currentClientProduits.put(produitName,quantites);
                                portefeuilleByClient.setClientName(clientName);
                                portefeuilleByClient.setProduitList(currentClientProduits);
                                mesPorteufeuilles.add(portefeuilleByClient);
                            }

                        }else{
                            PortefeuilleByClient portefeuilleByClient = new PortefeuilleByClient();
                            Map<String,Integer> produitList = new HashMap<String,Integer>();
                            produitList.put(produitName,quantites) ;
                            portefeuilleByClient.setClientName(clientName);
                            portefeuilleByClient.setProduitList(produitList);
                            mesPorteufeuilles.add(portefeuilleByClient);
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
