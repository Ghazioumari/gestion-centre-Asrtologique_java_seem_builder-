/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Gestion_de_personnel;

import java.util.Date;

/**
 *
 * @author oumar
 */
public class Employe extends Personne{
    
     private Date dateEmbauche;
    private float salaire;
    private String poste;

    public Employe(String nom, String prenom, String email, String telephone, String adresse,Date dateEmbauche,float salaire,String poste) {
        super(nom, prenom, email, telephone, adresse);
       this. dateEmbauche=dateEmbauche;
        this.salaire=salaire;
        this.poste=poste;
    }

    public void setDateEmbauche(Date dateEmbauche) {
        this.dateEmbauche = dateEmbauche;
    }

    public void setSalaire(float salaire) {
        this.salaire = salaire;
    }

    public void setPoste(String poste) {
        this.poste = poste;
    }

    public Date getDateEmbauche() {
        return dateEmbauche;
    }

    public float getSalaire() {
        return salaire;
    }

    public String getPoste() {
        return poste;
    }
    
     @Override
    public String toString() { 
    StringBuilder sb = new StringBuilder();
    sb.append(super.toString());
         sb.append("Employé{");
         sb.append(super.toString());
         sb.append(", dateEmbauche=");
         sb.append(dateEmbauche).append(", poste='");
 
        sb.append("'}");
       
       /*for (String membre : competences) {
            sb.append("- ").append(membre).append("\n");
        }*/
         return sb.toString();
}
}
