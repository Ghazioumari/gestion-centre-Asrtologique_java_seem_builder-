/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package g.a_astro_centre;

import java.awt.event.MouseEvent;
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
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author oumar
 */
public class MenuController implements Initializable {

    
    @FXML
    private Button home;
    @FXML
    private AnchorPane vbb;
    @FXML
    private Label labtext;

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
     
    }    

    @FXML
    private void home(ActionEvent event) {
        try {
            vbb.getScene().getWindow().hide();
            Stage st = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
            
            Scene scene = new Scene(root);
            st.setTitle("login");
            st.setScene(scene);
            st.show();
        } catch (IOException ex) {
            Logger.getLogger(MenuController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void sethome(javafx.scene.input.MouseEvent event) {
    }

    @FXML
    private void personnel(ActionEvent event) {
        try {
            vbb.getScene().getWindow().hide();
            Stage st = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("Personnel.fxml"));
            
            Scene scene = new Scene(root);
            st.setTitle("personnes");
            st.setScene(scene);
            st.show();
        } catch (IOException ex) {
            Logger.getLogger(MenuController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void sattelitte(ActionEvent event) {
        try {
            vbb.getScene().getWindow().hide();
            Stage st = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("sattelite.fxml"));
            
            Scene scene = new Scene(root);
            st.setTitle("sattelites");
            st.setScene(scene);
            st.show();
        } catch (IOException ex) {
            Logger.getLogger(MenuController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void evenemt(ActionEvent event) {
        try {
            vbb.getScene().getWindow().hide();
            Stage st = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("evenement.fxml"));
            
            Scene scene = new Scene(root);
            st.setTitle("events");
            st.setScene(scene);
            st.show();
        } catch (IOException ex) {
            Logger.getLogger(MenuController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void equipement(ActionEvent event) {
        try {
            vbb.getScene().getWindow().hide();
            Stage st = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("equipement.fxml"));
            
            Scene scene = new Scene(root);
            st.setTitle("equipemnet");
            st.setScene(scene);
            st.show();
        } catch (IOException ex) {
            Logger.getLogger(MenuController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
