/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package Gestion_des_Evenement;

import Interf_record.exeption_;
import java.text.ParseException;
import java.util.Date;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 *
 * @author oumar
 */
public final class Evenementeducatif  extends Evenement{
    private String theme;
    private  Lecon lecon;

    public Evenementeducatif(Date date, String lieu, String type,float gain ,String theme ,Lecon lecon) {
        super(date, lieu, type,gain);
        this.theme = theme;
        
        this.lecon = lecon;
    }
    @Override
 public void saisir() throws ParseException {
        Scanner scanner = new Scanner(System.in);
        super.saisir();
        System.out.print("Saisir le thème de l'événement : ");
        this.theme = scanner.nextLine();
        System.out.print("Saisir une leçon ");
          System.out.print("Saisir le titre de lecon : ");
        String titre = scanner.nextLine();
          System.out.print("Saisir le  numero de lecon : ");
        int num = scanner.nextInt();
        this.lecon=new Lecon(titre,num);
      
      
 }

    public void setTheme(String theme) throws exeption_ {
        if (theme == null || theme.isEmpty()) {
            throw new exeption_("Le thème de l'événement éducatif ne peut pas être vide.");
        }
        this.theme = theme;
    }

    public Lecon getLecons() {
        return lecon;
    }


    @Override
    public String toString() {
         StringBuilder sb = new StringBuilder();
           sb.append( super.toString()).append("theme:").append(this.theme); 
            sb.append("le lecon ");
           sb.append(lecon.getTitre());
            sb.append("numero ");
           sb.append(lecon.getNumero());
 

 
         return sb.toString();
}
}
