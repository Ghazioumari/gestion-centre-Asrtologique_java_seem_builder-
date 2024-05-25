/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package controllers;

import Gestion_de_Centre_Astro.Equipement;
import java.io.IOException;
import javafx.collections.ObservableList;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
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
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author oumar
 */
public class EquipementController implements Initializable {

    @FXML
    private AnchorPane vbb;
    @FXML
    private TextField txtnom;
    @FXML
    private TextField txtetat;
    @FXML
    private TextField txtype;
    @FXML
    private TableView<Equipement> table;
    @FXML
    private TableColumn<Equipement, String> colnom;
    @FXML
    private TableColumn<Equipement, String> coltype;
    @FXML
    private TableColumn<Equipement, String> coletat;
    @FXML
    private Label nbequip;
Equipement ss;
          ObservableList<Equipement> liste=FXCollections.observableArrayList() ;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
         colnom.setCellValueFactory(new PropertyValueFactory<Equipement,String>("nom"));
            coltype.setCellValueFactory(new PropertyValueFactory<Equipement,String>("type"));
            coletat.setCellValueFactory(new PropertyValueFactory<Equipement,String>("etat"));
            setupTablee();
            nbequip();
            table.setItems(liste);
    }    
  private void nbequip(){
        nbequip.setText(String.valueOf(liste.size()));
 }
       private void setupTablee() {
        Equipement stl0 = new Equipement("pc ", "informatique","bon_etat");
        Equipement stl1 = new Equipement("loop", "astro","moyen_etat");
        Equipement stl2 = new Equipement("Jumelles ", "astrolo", "bon_etat");
        Equipement stl3 = new Equipement("Télescope ", "astro","bon_etat");
      //  table_st_n.getItems().addAll(stl0, stl1, stl2, stl3);
           liste.addAll(stl0, stl1, stl2, stl3);   
       }
    @FXML
    private void add(ActionEvent event) {
         String no = txtnom.getText();
        boolean equipExiste = false;
        for (Equipement st : liste) {
            if (st.getNom().equals(no)) {
                equipExiste = true;
             /*   st.setVitesse(Float.parseFloat(txtvitess.getText()));
                st.setOrbite(txtorbit.getText());
                st.setDiametre(Float.parseFloat(txtdiamet.getText()));
                st.setPeriodeRevolution(Float.parseFloat(txtpetride_rev.getText()));
                */break;
            }
        }
        if (!equipExiste) {
            Equipement nouveauequip = new Equipement(txtnom.getText(),txtype.getText(),txtetat.getText()); 
            table.refresh();
            liste.add(nouveauequip);
            txtnom.setText("");
           txtype.setText("");
          txtetat.setText("");
    
                    nbequip();

        }
       
    }

    @FXML
    private void update(ActionEvent event) {
         for(Equipement st:liste){
            if(ss.equals(st)){
                st.setType(txtype.getText());
                st.setEtat(txtetat.getText());
                table.refresh();
                
        }
    }
    }

    @FXML
    private void delete(ActionEvent event) {
          Equipement selectedItem = table.getSelectionModel().getSelectedItem();

        if (selectedItem != null) {
            liste.remove(selectedItem);
            table.refresh();
                   nbequip();

        }
    }
    @FXML
 void rowClicked(MouseEvent event) {
        Equipement st = table.getSelectionModel().getSelectedItem();
        txtnom.setText(st.getNom());
        txtype.setText(st.getType());
        txtetat.setText(st.getEtat());
        
        ss=st;
    }

 
    @FXML
    private void retour(ActionEvent event) {
        
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


    
}
