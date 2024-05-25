package Gestion_de_Centre_Astro;


import java.util.Scanner;
import java.util.Set;

public final class Equipement {
    private String nom;
    private String type;
    private String etat;
    private Set<Integer> id;

   

    
    public Equipement(String nom, String type,String etat) {
        this.nom = nom;
        this.type = type;
        this.etat = etat;
    }

    
     public void saisir() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Saisir le nom de l'équipement : ");
        nom = scanner.next();
        System.out.println("Saisir le type : ");
        type = scanner.next();
        System.out.println("Saisir l'état : ");
        etat = scanner.next();
    }
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        if (nom == null || nom.isEmpty()) {
            throw new IllegalArgumentException("Le nom de l'équipement ne peut pas être vide.");
        }
        this.nom = nom;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        if (type == null || type.isEmpty()) {
            throw new IllegalArgumentException("Le type de l'équipement ne peut pas être vide.");
        }
        this.type = type;
    }

    public String getEtat() {
        return etat;
    }
 
    
    public Set<Integer> getId() {
        return id;
    }
    
    public void setEtat(String etat) {
        this.etat = etat;
    }

    @Override
    public String toString() {
        return "Equipement{" +
                "nom='" + nom + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
