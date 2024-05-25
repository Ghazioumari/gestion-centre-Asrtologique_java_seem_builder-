/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Gestion_de_personnel;

/**
 *
 * @author oumar
 */
public class Observateur extends Personne {
    private String objectif;
    private float montant;

    public Observateur(String nom, String prenom, String email, String telephone, String adresse ,String objecti, float montan) {
        super(nom, prenom, email, telephone, adresse);
        
        objectif=objecti;
        montant=montan;

    }

    public String getObjectif() {
        return objectif;
    }

    public float getMontant() {
        return montant;
    }

    public void setObjectif(String objectif) {
        this.objectif = objectif;
    }

    public void setMontant(float montant) {
        this.montant = montant;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
      sb.append(  super.toString());
       sb.append(  "Observateur{" + "objectif=" + objectif + ", montant=" + montant + '}');
    return sb.toString() ;
    }

}
