/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package g.a_astro_centre;

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
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author oumar
 */
public class SatteliteController implements Initializable {

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
    private void menu(ActionEvent event) {
         try {
          vbb.getScene().getWindow().hide();
            Stage st = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("menu.fxml"));
            
            Scene scene = new Scene(root);
            st.setTitle("menu");
            st.setScene(scene);
            st.show();
        } catch (IOException ex) {
            Logger.getLogger(MenuController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void sat_naturel(ActionEvent event) {
        try {
            vbb.getScene().getWindow().hide();
            Stage st = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("satt_naturel.fxml"));
            
            Scene scene = new Scene(root);
            st.setTitle(" satt naturel");
            st.setScene(scene);
            st.show();
        } catch (IOException ex) {
            Logger.getLogger(MenuController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void sat_Artificiel(ActionEvent event) {
         try {
            vbb.getScene().getWindow().hide();
            Stage st = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("sattelite_artif.fxml"));
            
            Scene scene = new Scene(root);
            st.setTitle(" satt artif");
            st.setScene(scene);
            st.show();
        } catch (IOException ex) {
            Logger.getLogger(MenuController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void sattnatur(MouseEvent event) {
    }
    
}
