/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author oumar
 */
public class PersonnelController implements Initializable {

    @FXML
    private AnchorPane vbb;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void home(ActionEvent event) {
        try {
            vbb.getScene().getWindow().hide();
            Stage st=new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("menu.fxml"));
            Scene scene = new Scene(root);
            st.setTitle("menu ");
            st.setScene(scene);
            st.show();
        } catch (IOException ex) {
            Logger.getLogger(Satt_naturelController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
   

    @FXML
    private void employer(ActionEvent event) {
        try {
            vbb.getScene().getWindow().hide();
            Stage st=new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("Employer.fxml"));
            Scene scene = new Scene(root);
            st.setTitle("employers ");
            st.setScene(scene);
            st.show();
        } catch (IOException ex) {
            Logger.getLogger(Satt_naturelController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void observ(ActionEvent event) {
        try {
            vbb.getScene().getWindow().hide();
            Stage st=new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("Observateur.fxml"));
            Scene scene = new Scene(root);
            st.setTitle("observateur ");
            st.setScene(scene);
            st.show();
        } catch (IOException ex) {
            Logger.getLogger(Satt_naturelController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
