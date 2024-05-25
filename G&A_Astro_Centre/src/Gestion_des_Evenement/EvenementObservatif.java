/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Gestion_des_Evenement;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author oumar
 */
public class EvenementObservatif extends Evenement{
      private ArrayList<String> observations;

    public EvenementObservatif(Date date, String lieu, String type ,float d) {
        super(date, lieu, type,d);
       
        this.observations = new ArrayList<>();
    }

    @Override
    public void saisir() throws ParseException {
        super.saisir(); 
             Scanner scanner = new Scanner(System.in);

         System.out.print("Saisir une lobservation ");
        String ob = scanner.nextLine();
        while (!ob.isEmpty()) {
            this.observations.add(ob);
            System.out.print("Saisir une autre leçon (ou appuyez sur Entrée pour terminer) : ");
            ob = scanner.nextLine();
        }
    }
    
    
    public List<String> getObservations() {
        return observations;
    }
    public void setObservations(ArrayList<String> observations) {
        if (observations == null) {
            throw new IllegalArgumentException("La liste d'observations ne peut pas être nulle.");
        }
        this.observations = observations;
    }


    public void ajouterObservation(String observation) {
        if (observation == null || observation.isEmpty()) {
            throw new IllegalArgumentException("L'observation ne peut pas être vide.");
        }
        this.observations.add(observation);
    }

    public void supprimerObservation(String observation) {
        if (observation == null || observation.isEmpty()) {
            throw new IllegalArgumentException("L'observation ne peut pas être vide.");
        }
        this.observations.remove(observation);
    }

    @Override
    public String toString() {
       StringBuilder sb = new StringBuilder();
           sb.append(super.toString());
           for (String membre : observations) {
            sb.append("- ").append(membre).append("\n");
        }
         return sb.toString();
    }
    
}
