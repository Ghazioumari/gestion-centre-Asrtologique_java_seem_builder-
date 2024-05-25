/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Gestion_des_Evenement;

import Gestion_de_personnel.*;
import Gestion_de_personnel.Observateur;
import Gestion_de_personnel.Personne;
import Interf_record.Calcule_gain;
import Interf_record.exeption_;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;


/**
 *
 * @author oumar
 */
public class Evenement implements Calcule_gain  {
      protected Date date;
    protected String lieu;
    protected String type;
    protected ArrayList<Personne> participants;
    protected float gain;
    
   
    
    public Evenement(Date date, String lieu, String type,float d) {
        this.date = date;
        this.lieu = lieu;
        this.type = type;
        this.gain=d;
       this.participants = new ArrayList<>();
    }

    public Date getDate() {
        return date;
    }

    public String getLieu() {
        return lieu;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }



    public float getGain() {
        return gain;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setLieu(String lieu) {
        this.lieu = lieu;
    }


    public void setGain(float gain) {
        this.gain = gain;
    }
    
    
    public void saisir( ) throws ParseException {
        System.out.println("Entrez la date de l'événement (dd/MM/yyyy) :");
     Scanner scanner = new Scanner(System.in);
            SimpleDateFormat datee = new SimpleDateFormat("dd/MM/yyyy");
            this.date = datee.parse(scanner.nextLine());
       
        System.out.println("Entrez le lieu de l'événement :");
        this.lieu = scanner.nextLine();

        System.out.println("Entrez la description de l'événement :");
        this.type = scanner.nextLine();

    }
      
    
    
    
     public List<Employe> LesEmployes() {
        return participants.stream().filter(p -> p instanceof Employe).map(p -> (Employe) p).collect(Collectors.toList());
    }
public List<Observateur> Lesobservateurs() {
        return participants.stream().filter(p -> p instanceof Observateur).map(p -> (Observateur) p).collect(Collectors.toList());
    }
    
 
      @Override
      public void calculerGain() {
     
        Double  p = this.LesEmployes().stream().collect(Collectors.summingDouble(Employe::getSalaire));
        Double g = this.Lesobservateurs().stream().collect(Collectors.summingDouble(Observateur::getMontant));
    gain = (float) (g-p) ;
}


    public void supprimerParticipant(Personne participant) {
    try {
        if (participant == null) {
            throw new exeption_("Le participant ne peut pas être nul.");
        }
        this.participants.remove(participant);
    } catch (exeption_ e) {
        System.err.println("Exception caught: " + e.getMessage());
    }
   
}

    public void ajouterParticipant(Personne participant) throws exeption_ {
        if (participant == null) {
            throw new exeption_("Le participant ne peut pas être nul.");
        }
        this.participants.add(participant);
    }
 
  


    @Override
    public String toString() {
        StringBuilder sb=new StringBuilder();
        sb.append("date=").append(date).append(", lieu='").append(lieu).append("', Type ='").append(this.type).append("', gain='").append(this.gain).append("'}") ;
        for(Personne el :participants){
            sb.append(el.toString());
        }
        return sb.toString() ;
        
    }
}
