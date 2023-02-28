package com.kata.finance.valocb.service;

import com.kata.finance.valocb.model.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;

public class GenerateFile {
    private static final Logger logger = LogManager.getLogger(GenerateFile.class);
    public static Set<OutPutFileFormat> outPutFileFormatSte;


    /**
     *
     */
    public static void  createPortefeuilleFile(){
        Set<Portefeuille> portefeuilles = PriceService.portefeuilles;
    }


    /**
     * Methode qui permet de Créer le fichier csv donnant la valeur des produits par client
     *
     * @throws IOException
     */
    public static  void createClientProductFile() throws IOException {
        outPutFileFormatSte = new HashSet<OutPutFileFormat>();
        Set<PortefeuilleByClient> portefeuilleByClients = ProductService.mesPorteufeuilles;

        for(PortefeuilleByClient portefeuilleByClient : portefeuilleByClients){
            Map<String,Integer> produitLists = portefeuilleByClient.getProduitList();
           int valeurPortefeuille =  calculerValeurParProduit(produitLists,PriceService.portefeuilles);
            outPutFileFormatSte.add(new OutPutFileFormat(portefeuilleByClient.getClientName(),valeurPortefeuille));
        }
        generateOutPutData(outPutFileFormatSte,ReadInputFile.inputFileConfig.getReportingClientFileName());

    }

    /**
     *
     * Methode qui calcule la valeur des produits d'un client
     *
     * @param produitLists : liste des produits du client
     * @param portefeuilles : les composants des produits du client courant
     * @return
     */
    public static int calculerValeurParProduit(Map<String,Integer> produitLists,Set<Portefeuille> portefeuilles){
        int somme = 0;
        int nombreProduit = 0;

        for(String key : produitLists.keySet()){

            nombreProduit = produitLists.get(key);
            for (Portefeuille portefeuille : portefeuilles ) {
                List<Produit> produits = portefeuille.getProduits();
                Produit currentProduit = produits.stream().filter(p -> p.getProduitName().equals(key)).findAny().orElse(null);
                if (currentProduit != null){
                    List<Underlying> underlyings = currentProduit.getUnderlyings();
                    for (Underlying underlying : underlyings) {
                        float parity = getCurrencyValue(underlying.getCurrency(),ForexService.forexSet);
                        somme += underlying.getPrice()*parity;
                    }
                }
            }

        }

        return somme*nombreProduit;
    }

    /**
     *
     * Méthode qui calcul la valeur de chaque portefeuille
     * @throws IOException
     */
    public static void evaluatePortefeuille( ) throws IOException {
        outPutFileFormatSte = new HashSet<OutPutFileFormat>();
            for (Portefeuille portefeuille : PriceService.portefeuilles) {
                int valeurPortefeuille = 0;
                List<Produit> produits = portefeuille.getProduits();
                for(Produit produit : produits) {
                    int valeurProduit = 0;
                    List<Underlying> underlyings = produit.getUnderlyings();
                    for(Underlying underlying : underlyings){
                        float parity = getCurrencyValue(underlying.getCurrency(),ForexService.forexSet);
                        valeurProduit += underlying.getPrice()*parity;
                    }
                    valeurPortefeuille += valeurProduit;
                }
                outPutFileFormatSte.add(new OutPutFileFormat(portefeuille.getPortefeuilleName(),valeurPortefeuille));
            }
        generateOutPutData(outPutFileFormatSte,ReadInputFile.inputFileConfig.getReportingPortfolioFileName());
    }

    public static float getCurrencyValue(String currency, Set<Forex> forexSet){
        float currencyValue = 1f;

        for (Forex f : forexSet ){
          if(f.getOtherForex().equals(currency)){
              currencyValue = (float) f.getParity();
          }
        }
        return currencyValue;
    }

    /**
     *
     * @param datas
     * @param fileName
     * @throws IOException
     */
    public static void generateOutPutData(Set<OutPutFileFormat> datas, String fileName) throws IOException{
        String folderPath = getClassL()+ fileName ;
        try{
            FileWriter fw = new FileWriter(folderPath);
            fw.write("Nom"+ReadInputFile.inputFileConfig.getOutputFileSeperator()+" Valeur");
            fw.append('\n');
            for(OutPutFileFormat line : datas) {

                fw.write(line.getName()+ReadInputFile.inputFileConfig.getOutputFileSeperator()+line.getValue());
                fw.append('\n');
            }
            fw.close();
        }catch(Exception e){
            System.out.println(e);
        }
    }

    /**
     *
     * @return
     */
    public static String getClassL(){
    String path = Thread.currentThread().getContextClassLoader().getResource("").getPath().toString();
    return  path;
}
}
