package Gestion_des_Satellites;

import java.util.Date;
import java.util.Scanner;

public  sealed class Satellite  permits SatelliteArtificiel ,SatelliteNaturel{
        protected int Id;

    protected String nom;
    protected String orbite;
    protected float vitesse;
    
public Satellite(/*int id,*/String nom, String orbite, float v) {
        //this.Id=id;
        this.nom = nom;
        this.orbite = orbite;
        this.vitesse=v;
    }

   public void saisirsatellie(){
    Scanner scan=new Scanner(System.in);
    System.out.print("donner le non de sattelite :");
    nom=scan.nextLine();
     System.out.print("donner le lorbite de sattelite :");
     orbite=scan.nextLine();
    System.out.print("donner le vitesse  de sattelite :");
    vitesse=scan.nextFloat();
     }

    public void prédiction() {
       System.out.println("se satellite est a lorbite "+this.orbite +" tourne avec le vitesse "+this.vitesse);
    }


    @Override
    public String toString() {
        return "Satellite{" +
                "nom='" + this.getNom() + '\'' +
                "vitesse='" +this.getVitesse()+ '\'' +                
                "orbite='" +this.getOrbite()+ '\'' +
                '}';
    }


    public int getId() {
        return Id;
    }

    public String getNom() {
        return nom;
    }

    public String getOrbite() {
        return orbite;
    }

    public float getVitesse() {
        return vitesse;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setOrbite(String orbite) {
        this.orbite = orbite;
    }

    public void setVitesse(float vitesse) {
        this.vitesse = vitesse;
    }
}
