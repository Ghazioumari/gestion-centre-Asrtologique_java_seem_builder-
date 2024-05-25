/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Record.java to edit this template
 */
package Gestion_des_Evenement;

/**
 *
 * @author oumar
 */

public record Lecon(String titre, int numero ) {

    public String getTitre() {
        return titre;
    }

    public int getNumero() {
        return numero;
    }
    
    public Lecon(String titre, int numero) {
        this.titre = titre;
        this.numero = numero;
    }
    
    
}
