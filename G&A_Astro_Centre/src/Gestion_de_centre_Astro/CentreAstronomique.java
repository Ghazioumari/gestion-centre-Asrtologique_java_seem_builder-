/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Gestion_de_centre_Astro;

import Gestion_de_Centre_Astro.Equipement;
import Gestion_des_Evenement.Evenement;
import Gestion_des_Satellites.Satellite;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author oumar
 */
public class CentreAstronomique {
    
    private String nomCentre;
    private String adresse;
    private List<Evenement> listeEvenements;
    private Map<String, Satellite> satellitesMap; // designe le sattelitte et leur emplacement 
   private  ArrayList<Equipement> listeequipements;

   
   //tri les evenement par leur gain
   public void  tri_equi(){
    Collections.sort(listeEvenements, (o1,o2)->(int)(o1.getGain()-o2.getGain()));
   }
   
   
    public CentreAstronomique(String nomCentre, String adresse) {
        this.nomCentre = nomCentre;
        this.adresse = adresse;
        this.listeEvenements = new ArrayList<>();
        this.satellitesMap = new HashMap<>(); // Initialise la Map
       this.listeequipements = new ArrayList<>();
    }

    public String getNomCentre() {
        return nomCentre;
    }

    public void setNomCentre(String nomCentre) {
        if (nomCentre == null || nomCentre.isEmpty()) {
            throw new IllegalArgumentException("Le nom du centre ne peut pas être vide.");
        }
        this.nomCentre = nomCentre;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
    if (adresse == null || adresse.isEmpty()) {
        throw new IllegalArgumentException("L'adresse du centre ne peut pas être null.");
    }
    this.adresse = adresse;
}


    public void enregistrerObservationsAstronomiques() {
    }

    public void organiserÉvénements() {
    }

    public void gérerÉquipements() {
    }

    // Méthode pour ajouter un satellite à la Map
    public void ajouterSatellite(String nomSatellite, Satellite satellite) {
        satellitesMap.put(nomSatellite, satellite);
    }

    // Méthode pour récupérer un satellite de la Map
    public Satellite getSatellite(String nomSatellite) {
        return satellitesMap.get(nomSatellite);
    }

    @Override
    public String toString() {

            StringBuilder sb = new StringBuilder();
sb.append(this.getNomCentre());
sb.append(this.getAdresse());
  sb.append(", les evenements={");
  for(Evenement ev:listeEvenements){sb.append(ev.toString());}
  
 sb.append(", les equipement={");
  for(Equipement ev:listeequipements){sb.append(ev.toString());}
  
  
        sb.append(", satellitesMap={");
        for (Map.Entry<String, Satellite> entry : satellitesMap.entrySet()) {
            sb.append(entry.getKey()).append("=").append(entry.getValue().toString()).append(", ");
        }
        sb.append("}");

        sb.append('}');
        return sb.toString();
}
}
