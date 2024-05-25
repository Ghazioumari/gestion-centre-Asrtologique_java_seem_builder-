/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Interf_record;

/**
 *
 * @author oumar
 */
public class exeption_ extends Exception  {

    public exeption_(String msg) {
        System.out.println(msg);
    }

    @Override
    public String toString() {
        return "exeption_{" +"choix invalide"+ '}';
    }
    
    
}
