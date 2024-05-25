package controllers;

import Gestion_des_Satellites.*;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class Satt_naturelController implements Initializable {

    @FXML
    private AnchorPane vbb;
    @FXML
    private TextField txtnom;
    @FXML
    private TextField txtorbit;
    @FXML
    private TextField txtvitess;
    @FXML
    private TextField txtdiamet;
    @FXML
    private TextField txtpetride_rev;
    @FXML
    private TableColumn<SatelliteNaturel, String> col_nom;
    @FXML
    private TableColumn<SatelliteNaturel, String> col_orbite;
    @FXML
    private TableColumn<SatelliteNaturel, Float> col_vit;
    @FXML
    private TableColumn<SatelliteNaturel, Float> col_dia;
    @FXML
    private TableColumn<SatelliteNaturel, Float> col_per_rev;
    @FXML
    private TableView<SatelliteNaturel> table_st_n;    
   

    SatelliteNaturel ss;
      ObservableList<SatelliteNaturel> liste=FXCollections.observableArrayList() ;
    @FXML
    private Label labnbr;


    @Override
    public void initialize(URL url, ResourceBundle rb) {
 //    ObservableList<SatelliteNaturel> liste = table_st_n.getItems();

        col_nom.setCellValueFactory(new PropertyValueFactory<SatelliteNaturel,String>("nom"));
       col_orbite.setCellValueFactory(new PropertyValueFactory<SatelliteNaturel,String>("orbite"));
        col_vit.setCellValueFactory(new PropertyValueFactory<SatelliteNaturel,Float>("vitesse"));
        col_dia.setCellValueFactory(new PropertyValueFactory<SatelliteNaturel,Float>("diametre"));
        col_per_rev.setCellValueFactory(new PropertyValueFactory<SatelliteNaturel,Float>("periodeRevolution"));
        setupTable(); 
        nbsatt();
        table_st_n.setItems(liste);
    }
 private void nbsatt(){
        labnbr.setText(String.valueOf(liste.size()));
 }
        
        @FXML
    private void add(ActionEvent event) {
     //  ObservableList<SatelliteNaturel> liste = table_st_n.getItems();
        String no = txtnom.getText();
        boolean satelliteExiste = false;
        for (SatelliteNaturel st : liste) {
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
            SatelliteNaturel nouveauSatellite = new SatelliteNaturel(txtnom.getText(), txtorbit.getText(),
                    Float.parseFloat(txtvitess.getText()), Float.parseFloat(txtdiamet.getText()),
                    Float.parseFloat(txtpetride_rev.getText()));
            liste.add(nouveauSatellite);
            txtnom.setText("");
           txtorbit.setText("");
          txtvitess.setText("");
          txtdiamet.setText("");
             txtpetride_rev.setText("");
                    nbsatt();

        }
        table_st_n.refresh();
    }

    private void setupTable() {
        SatelliteNaturel stl0 = new SatelliteNaturel("Titan ", "Elliptique ", 3000, 1, 1);
        SatelliteNaturel stl1 = new SatelliteNaturel("Triton ", "rétrograde", 2000, 2, 2);
        SatelliteNaturel stl2 = new SatelliteNaturel("Phobos ", "Prograde ", 3333, 3, 3);
        SatelliteNaturel stl3 = new SatelliteNaturel("Deimos ", "Synchrone ", 4000, 4, 4);
      //  table_st_n.getItems().addAll(stl0, stl1, stl2, stl3);
           liste.addAll(stl0, stl1, stl2, stl3);

    }

    @FXML
    private void delete(ActionEvent event) {
        //ObservableList<SatelliteNaturel> liste = table_st_n.getItems();
        SatelliteNaturel selectedItem = table_st_n.getSelectionModel().getSelectedItem();

        if (selectedItem != null) {
            liste.remove(selectedItem);
            table_st_n.refresh();
                    nbsatt();

        }
    }

    @FXML
    void rowClicked(MouseEvent event) {
        SatelliteNaturel st = table_st_n.getSelectionModel().getSelectedItem();
        txtnom.setText(String.valueOf(st.getNom()));
        txtorbit.setText(String.valueOf(st.getOrbite()));
        txtvitess.setText(String.valueOf(st.getVitesse()));
        txtdiamet.setText(String.valueOf(st.getDiametre()));
        txtpetride_rev.setText(String.valueOf(st.getPeriodeRevolution()));
        ss=st;
    }
  @FXML
    private void Update(ActionEvent event) {
        for(SatelliteNaturel st:liste){
            if(ss.equals(st)){
             
                st.setDiametre(Float.parseFloat(txtdiamet.getText()));
                st.setOrbite(txtorbit.getText());
                st.setPeriodeRevolution(Float.parseFloat(txtpetride_rev.getText()));
                st.setVitesse(Float.parseFloat(txtvitess.getText()));
                table_st_n.refresh();
                
        }
    }
}
    @FXML
    private void men(ActionEvent event) {
        try {
            vbb.getScene().getWindow().hide();
            Stage st = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("sattelite.fxml"));
            Scene scene = new Scene(root);
            st.setTitle("sattelite ");
            st.setScene(scene);
            st.show();
        } catch (IOException ex) {
            Logger.getLogger(Satt_naturelController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

  }


/*package g.a_astro_centre;

import Gestion_des_Satellites.SatelliteNaturel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.cell.PropertyValueFactory;

public class Satt_naturelController implements Initializable {

    @FXML
    private AnchorPane vbb;
    @FXML
    private TextField txtnom;
    @FXML
    private TextField txtorbit;
    @FXML
    private TextField txtvitess;
    @FXML
    private TextField txtdiamet;
    @FXML
    private TextField txtpetride_rev;
    @FXML
    private TableColumn<SatelliteNaturel, String> col_nom;
    @FXML
    private TableColumn<SatelliteNaturel, String> col_orbite;
    @FXML
    private TableColumn<SatelliteNaturel, Float> col_vit;
    @FXML
    private TableColumn<SatelliteNaturel, Float> col_dia;
    @FXML
    private TableColumn<SatelliteNaturel, Float> col_per_rev;
    @FXML
    private TableView<SatelliteNaturel> table_st_n;

    private ObservableList<SatelliteNaturel> satelliteList = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        setupTable();

        col_nom.setCellValueFactory(new PropertyValueFactory<>("nom"));
        col_orbite.setCellValueFactory(new PropertyValueFactory<>("orbite"));
        col_vit.setCellValueFactory(new PropertyValueFactory<>("vitesse"));
        col_dia.setCellValueFactory(new PropertyValueFactory<>("diametre"));
        col_per_rev.setCellValueFactory(new PropertyValueFactory<>("periodeRevolution"));

        // Ajouter des données initiales à la liste
        setupTableData();
    }

    @FXML
    private void add(ActionEvent event) {
        String no = txtnom.getText();

        // Recherchez le satellite dans la liste
        SatelliteNaturel existingSatellite = satelliteList.stream()
                .filter(st -> st.getNom().equals(no))
                .findFirst()
                .orElse(null);

        if (existingSatellite != null) {
            // Mise à jour des données si le satellite existe déjà
            existingSatellite.setVitesse(Float.parseFloat(txtvitess.getText()));
            existingSatellite.setOrbite(txtorbit.getText());
            existingSatellite.setDiametre(Float.parseFloat(txtdiamet.getText()));
            existingSatellite.setPeriodeRevolution(Float.parseFloat(txtpetride_rev.getText()));
        } else {
            // Ajouter un nouveau satellite à la liste
            SatelliteNaturel newSatellite = new SatelliteNaturel(no, txtorbit.getText(),
                    Float.parseFloat(txtvitess.getText()), Float.parseFloat(txtdiamet.getText()),
                    Float.parseFloat(txtpetride_rev.getText()));
            satelliteList.add(newSatellite);
        }

        // Rafraîchir le tableau
        table_st_n.refresh();
    }

    @FXML
    private void setupTable() {
        table_st_n.setItems(satelliteList);
    }

    @FXML
    private void delete(ActionEvent event) {
        SatelliteNaturel selectedItem = table_st_n.getSelectionModel().getSelectedItem();

        if (selectedItem != null) {
            // Supprimer le satellite de la liste
            satelliteList.remove(selectedItem);
            table_st_n.refresh();
        }
    }

    @FXML
    void rowClicked(MouseEvent event) {
        SatelliteNaturel st = table_st_n.getSelectionModel().getSelectedItem();
        if (st != null) {
            txtnom.setText(st.getNom());
            txtorbit.setText(st.getOrbite());
            txtvitess.setText(String.valueOf(st.getVitesse()));
            txtdiamet.setText(String.valueOf(st.getDiametre()));
            txtpetride_rev.setText(String.valueOf(st.getPeriodeRevolution()));
        }
    }

    @FXML
    private void men(ActionEvent event) {
        try {
            vbb.getScene().getWindow().hide();
            Stage st = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("sattelite.fxml"));
            Scene scene = new Scene(root);
            st.setTitle("sattelite ");
            st.setScene(scene);
            st.show();
        } catch (IOException ex) {
            Logger.getLogger(Satt_naturelController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // Méthode pour ajouter des données initiales à la liste
    private void setupTableData() {
        SatelliteNaturel stl0 = new SatelliteNaturel("aaa", "orb1", 1, 1, 1);
        SatelliteNaturel stl1 = new SatelliteNaturel("bbb", "orb2", 2, 2, 2);
        SatelliteNaturel stl2 = new SatelliteNaturel("ccc", "orb3", 3, 3, 3);
        SatelliteNaturel stl3 = new SatelliteNaturel("ddd", "orb4", 4, 4, 4);
        satelliteList.addAll(stl0, stl1, stl2, stl3);
    }
}
*/