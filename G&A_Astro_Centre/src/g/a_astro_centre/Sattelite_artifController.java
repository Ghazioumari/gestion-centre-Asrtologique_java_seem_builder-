/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package g.a_astro_centre;
import Gestion_des_Satellites.*;

import Gestion_des_Satellites.SatelliteArtificiel;
import java.io.IOException;
import java.net.URL;

import java.util.Date;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author oumar
 */
public class Sattelite_artifController implements Initializable {

    @FXML
    private AnchorPane vbb;
    @FXML
    private TextField txtnom;
    @FXML
    private TextField txtorbit;
    @FXML
    private TextField txtvitess;
    @FXML
    private TextField txtetat;
    @FXML
    private TextField txtdure;
    @FXML
    private TextField txtdate;
    @FXML
    private TableColumn<SatelliteArtificiel, String> col_nom;
    @FXML
    private TableColumn<SatelliteArtificiel, String> col_orbite;
    @FXML
    private TableColumn<SatelliteArtificiel, Float> col_vitesse;
    @FXML
    private TableColumn<SatelliteArtificiel, String> col_date;
    @FXML
    private TableColumn<SatelliteArtificiel, String> col_etat;
    @FXML
    private TableColumn<SatelliteArtificiel, Integer> col_dure;
    @FXML
    private TableView<SatelliteArtificiel> table_sat_a;

    /**
     * Initializes the controller class.
     */
    
    SatelliteArtificiel ss;
     ObservableList<SatelliteArtificiel> liste=FXCollections.observableArrayList() ;
    @FXML
    private Label labelaff;
        
     
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
        col_nom.setCellValueFactory(new PropertyValueFactory<SatelliteArtificiel,String>("nom"));
         col_orbite.setCellValueFactory(new PropertyValueFactory<SatelliteArtificiel,String>("orbite")); 
         col_vitesse.setCellValueFactory(new PropertyValueFactory<SatelliteArtificiel,Float>("vitesse"));
         col_date.setCellValueFactory(new PropertyValueFactory<SatelliteArtificiel,String>("dateLancement") );
         col_etat.setCellValueFactory(new PropertyValueFactory<SatelliteArtificiel,String>("etatOperationnel")); 
         col_dure.setCellValueFactory(new PropertyValueFactory<SatelliteArtificiel,Integer>("dureeVie")); 
        setupTable();  
        nbsatt();
        table_sat_a.setItems(liste);
    }  
    private void nbsatt(){
        labelaff.setText(String.valueOf(liste.size()));
    }
    
     private void setupTable() {
      //Date d1=new Date(2023- 1900 , 0, 1);
      
        SatelliteArtificiel stl0 = new SatelliteArtificiel("ISS", "OTB", 1000,"12/12/2020", "operationel",1);
        SatelliteArtificiel stl1 = new SatelliteArtificiel("GPS ", "OMT", 2004,"18/1/2020", "operationel",2);
        SatelliteArtificiel stl2 = new SatelliteArtificiel("Landsat ", "héliosynchrone", 3005,"1/1/2019", "operationel",3);
        SatelliteArtificiel stl3 = new SatelliteArtificiel("Sputnik 1 ", "OTB", 4520,"20/15/20220", "operationel",4);
      //  table_st_n.getItems().addAll(stl0, stl1, stl2, stl3);
           liste.addAll(stl0, stl1, stl2, stl3);

    }
    @FXML
    private void add(ActionEvent event) {
            String no = txtnom.getText();
        boolean satelliteExiste = false;
        for (SatelliteArtificiel st : liste) {
            if (st.getNom().equals(no)) {
                satelliteExiste = true;
             /*   st.setVitesse(Float.parseFloat(txtvitess.getText()));
                st.setOrbite(txtorbit.getText());
                st.setDiametre(Float.parseFloat(txtdiamet.getText()));
                st.setPeriodeRevolution(Float.parseFloat(txtpetride_rev.getText()));
                */break;
            }
        }
        if (!satelliteExiste) {
            //    java.sql.Date dl = java.sql.Date.valueOf(txtdate.getValue());
            SatelliteArtificiel nouveauSatellite = new SatelliteArtificiel(txtnom.getText(), txtorbit.getText(),
                    Float.parseFloat(txtvitess.getText()),txtdate.getText(),txtetat.getText(),Integer.parseInt(txtvitess.getText()) );
            liste.add(nouveauSatellite);
            
        }
        nbsatt();
        table_sat_a.refresh();
    }

    @FXML
    private void update(ActionEvent event) {
         for(SatelliteArtificiel st:liste){
            if(ss.equals(st)){
                st.setOrbite(txtorbit.getText());
                st.setEtatOperationnel(txtetat.getText());
                st.setVitesse(Float.parseFloat(txtvitess.getText()));
                st.setDateLancement(txtdate.getText());
                st.setDureeVie(Integer.parseInt(txtdure.getText()));
                table_sat_a.refresh();
                
        }
    }
    }

    @FXML
    private void Delete(ActionEvent event) {
            SatelliteArtificiel selectedItem = table_sat_a.getSelectionModel().getSelectedItem();

        if (selectedItem != null) {
            liste.remove(selectedItem);
            table_sat_a.refresh();
                    nbsatt();}
        
    }
    @FXML
    private void menu(ActionEvent event) {
         try {
            vbb.getScene().getWindow().hide();
            Stage st = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("sattelite.fxml"));
            
            Scene scene = new Scene(root);
            st.setTitle("sattelite ");
            st.setScene(scene);
            st.show();
        } catch (IOException ex) {
            Logger.getLogger(MenuController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
