/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package g.a_astro_centre;

import Gestion_de_personnel.*;
import java.io.IOException;
import java.net.URL;
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
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author oumar
 */
public class ObservateurController implements Initializable {

    @FXML
    private TextField txtnom;
    @FXML
    private TextField txtpren;
    @FXML
    private TextField txtemail;
    @FXML
    private TextField txttele;
    @FXML
    private TextField txtadress;
    @FXML
    private TextField txtobj;
    @FXML
    private TextField txtmontan;
    @FXML
    private TableColumn<Observateur,String> colnom;
    @FXML
    private TableColumn<Observateur,String> colpreenom;
    @FXML
    private TableColumn<Observateur,String> colemail;
    @FXML
    private TableColumn<Observateur,String> coltele;
    @FXML
    private TableColumn<Observateur,String> coladress;
    @FXML
    private TableColumn<Observateur,String> colobj;
    @FXML
    private TableColumn<Observateur,Float> colmontant;

    @FXML
    private Label labnbobs;
    @FXML
    private TableView<Observateur> tableobser;
    @FXML
    private AnchorPane vbb;
   Observateur ss;
    ObservableList<Observateur>liste=FXCollections.observableArrayList();
    @FXML
    private Label tot_gain;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
     colnom.setCellValueFactory(new PropertyValueFactory<Observateur,String>("nom"));
       colpreenom.setCellValueFactory(new PropertyValueFactory<Observateur,String>("prenom"));
       colemail.setCellValueFactory(new PropertyValueFactory<Observateur,String>("email"));
       coltele.setCellValueFactory(new PropertyValueFactory<Observateur,String>("telephone"));
       coladress.setCellValueFactory(new PropertyValueFactory<Observateur,String>("adresse"));
       colobj.setCellValueFactory(new PropertyValueFactory<Observateur,String>("objectif"));
       colmontant.setCellValueFactory(new PropertyValueFactory<Observateur,Float>("montant"));
      settable();
      nbobservateur();
      tot_g();
      tableobser.setItems(liste);

    }    
    private void tot_g(){
            float tot=0;
            for(Observateur ev:liste){tot=tot+ev.getMontant();}
            tot_gain.setText(String.valueOf(tot));
        }
private void nbobservateur(){labnbobs.setText(String.valueOf( liste.size()));}
    
    private void settable(){
         Observateur stl0 = new Observateur("ali", "ali","aliali@gmail.com","21255233","tunis","chapitre1",100);
        Observateur stl1 = new Observateur("ahmed", "ahmed","ahmedahmed@gmail.com","91255233","france","chapitre3",200);
        Observateur stl2 = new Observateur("rami", "rami","ramirami@gmail.com","51255233","tunis","chapitre2",150);
        Observateur stl3 = new Observateur("mohamed", "mohamed","mohamedmohamed@gmail.com","23255233","tunis","chapitre4",300);
      //  table_st_n.getItems().addAll(stl0, stl1, stl2, stl3);
           liste.addAll(stl0, stl1, stl2, stl3);
    
    }
    
    @FXML
    private void add(ActionEvent event) {
        
         String no = txtnom.getText();
        boolean obserExiste = false;
        for (Observateur st : liste) {
            if (st.getNom().equals(no)) {
                obserExiste = true;
             /*   st.setVitesse(Float.parseFloat(txtvitess.getText()));
                st.setOrbite(txtorbit.getText());
                st.setDiametre(Float.parseFloat(txtdiamet.getText()));
                st.setPeriodeRevolution(Float.parseFloat(txtpetride_rev.getText()));
                */break;
            }
        }
        if (!obserExiste) {
            Observateur nouveauobser = new Observateur(txtnom.getText(), txtpren.getText(),
                    txtemail.getText(), txttele.getText(),
                   txtadress.getText(),txtobj.getText(),Float.parseFloat(txtmontan.getText()));
            liste.add(nouveauobser);
            txtnom.setText("");
           txtpren.setText("");
           txtemail.setText("");
          txttele.setText("");
          txtadress.setText("");
             txtobj.setText("");
             txtmontan.setText("");
                       nbobservateur();
                             tot_g();

        }
        tableobser.refresh();
    }

    @FXML
    private void update(ActionEvent event) {
         for(Observateur st:liste){
            if(ss.equals(st)){
             ss.setAdresse(txtadress.getText());
             ss.setEmail(txtemail.getText());
             ss.setMontant(Float.parseFloat( txtmontan.getText()));
             ss.setObjectif(txtobj.getText());
             ss.setTelephone(txttele.getText());
             ss.setPrenom(txtpren.getText());
             ss.setNom(txtnom.getText());
                   tot_g();

                tableobser.refresh();
                
        }
         }
         
    }

    @FXML
    private void delete(ActionEvent event) {
        //ObservableList<SatelliteNaturel> liste = table_st_n.getItems();
        Observateur selectedItem = tableobser.getSelectionModel().getSelectedItem();

        if (selectedItem != null) {
            liste.remove(selectedItem);
            tableobser.refresh();
                    nbobservateur();
                          tot_g();


        }
    }

   @FXML
    void rowClicked(MouseEvent event) {
        Observateur st = tableobser.getSelectionModel().getSelectedItem();
        txtnom.setText(st.getNom());
        txtpren.setText(st.getPrenom());
        txttele.setText(st.getTelephone());
        txtemail.setText(st.getEmail());
        txttele.setText(st.getTelephone());
        txtadress.setText(st.getAdresse());
        txtobj.setText(st.getObjectif());
        txtmontan.setText(String.valueOf(st.getMontant()));
        ss=st;
    }
    @FXML
    private void retuur(ActionEvent event) {
            try {
            vbb.getScene().getWindow().hide();
            Stage st=new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("Personnel.fxml"));
            Scene scene = new Scene(root);
            st.setTitle("personnel ");
            st.setScene(scene);
            st.show();
        } catch (IOException ex) {
            Logger.getLogger(Satt_naturelController.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }

    
}
