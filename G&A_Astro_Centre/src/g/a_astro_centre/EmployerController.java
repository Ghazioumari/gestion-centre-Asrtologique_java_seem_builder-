/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package g.a_astro_centre;

import Gestion_de_personnel.Employe;
import java.io.IOException;
import java.net.URL;
import java.time.ZoneId;
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
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
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
public class EmployerController implements Initializable {

    @FXML
    private TextField txtnom;
    @FXML
    private TextField txtprenom;
    @FXML
    private TextField txtmail;
    @FXML
    private TextField txttelephone;
    @FXML
    private TextField txtadresse;
    @FXML
    private TextField txtsalaire;
    @FXML
    private TextField txtposte;
    @FXML
    private DatePicker txtdate;
    @FXML
    private Button menu;
    @FXML
    private AnchorPane vbb;
    @FXML
    private TableView<Employe> table_emp;
    @FXML
    private TableColumn<Employe, String> colnom;
    @FXML
    private TableColumn<Employe, String> colprenom;
    @FXML
    private TableColumn<Employe, String> colmail;
    @FXML
    private TableColumn<Employe, String> coltele;
    @FXML
    private TableColumn<Employe, String> coladress;
    @FXML
    private TableColumn<Employe,Date> coldate;
    @FXML
    private TableColumn<Employe, Float> colsalaire;
    @FXML
    private TableColumn<Employe, String> colposte;
    @FXML
    private Label lab_nbemp;
    @FXML
    private Label tot_sal;
     Employe ss;
  ObservableList<Employe> liste=FXCollections.observableArrayList() ; 
  
  /*
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
      colnom.setCellValueFactory(new PropertyValueFactory<Employe,String>("nom"));
      colprenom.setCellValueFactory(new PropertyValueFactory<Employe,String>("prenom"));
      colmail.setCellValueFactory(new PropertyValueFactory<Employe,String>("email"));
      coltele.setCellValueFactory(new PropertyValueFactory<Employe,String>("telephone"));
      coladress.setCellValueFactory(new PropertyValueFactory<Employe,String>("adresse"));
      coldate.setCellValueFactory(new PropertyValueFactory<Employe,Date>("dateEmbauche"));
      colsalaire.setCellValueFactory(new PropertyValueFactory<Employe,Float>("salaire"));
      colposte.setCellValueFactory(new PropertyValueFactory<Employe,String>("poste"));
       settable();
   nbempl();
       tot_g();
           table_emp.setItems(liste);


    }    
 private void settable(){
  Employe stl0 = new Employe("ali", "ali","aliali@gmail.com","21255233","tunis",new Date(2023 - 1900, 1, 20),30,"chef");
  Employe stl1 = new Employe("ahmed"," ahmedali","ahhhali@gmail.com","55255233","Tabarka",new Date(2023 - 1900, 1, 20),20,"ingenieur");
  Employe stl2 = new Employe("rami", "ayadi","ramili@gmail.com","96255233","Aryana",new Date(2023 - 1900, 1, 20),15,"ingenieur");
  Employe stl3 = new Employe("jed", "aloui","jedaloui@gmail.com","27255233","Sfax",new Date(2023 - 1900, 1, 20),80,"Directeur");
           liste.addAll(stl0, stl1, stl2, stl3);
       
 }
 private void nbempl(){lab_nbemp.setText(String.valueOf(liste.size()));}
 private void tot_g(){
            float tot=0;
            for(Employe ev:liste){tot=tot+ev.getSalaire();}
            tot_sal.setText(String.valueOf(tot));
        }
   
  @FXML
    private void add(ActionEvent event) {
         String no = txtnom.getText();
         String noo = txtprenom.getText();

        boolean empExiste = false;
        for (Employe st : liste) {
            if (st.getNom().equals(no)&&st.getPrenom().equals(noo)) {
                empExiste = true;
             break;
            }
        }
        if (!empExiste) {
          java.sql.Date dl = java.sql.Date.valueOf(txtdate.getValue());
            Employe nouveauemp = new Employe(txtnom.getText(), txtprenom.getText(),txtmail.getText(),txttelephone.getText(),txtadresse.getText(),dl,
                    Float.parseFloat(txtsalaire.getText()),txtposte.getText() );
            liste.add(nouveauemp);
           
     txtnom.setText("");
     txttelephone.setText("");
     txtprenom.setText("");
     txtadresse.setText("");
     txtsalaire.setText("");
     txtposte.setText("");
     txtmail.setText("");
        }
        nbempl();
        tot_g();
        table_emp.refresh();
    }

    @FXML
    private void delete(ActionEvent event) {
        Employe emp=table_emp.getSelectionModel().getSelectedItem();
        if( emp != null){
        liste.remove(emp);
        table_emp.refresh();
        nbempl();
        tot_g();
        }
        
    }

    @FXML
    private void update(ActionEvent event) {
        for(Employe em:liste){
        if(ss.equals(em)){
        em.setNom(txtnom.getText());
        em.setPrenom(txtprenom.getText());
        em.setAdresse(txtadresse.getText());
        em.setPoste(txtposte.getText());
        em.setEmail(txtmail.getText());
        em.setTelephone(txttelephone.getText());
        em.setSalaire(Float.parseFloat(txtsalaire.getText()));
        em.setDateEmbauche(java.sql.Date.valueOf(txtdate.getValue()));

        }
        }
        tot_g();
          table_emp.refresh();
    }
    @FXML
    private void rowClicked(MouseEvent event) {
         Employe st = table_emp.getSelectionModel().getSelectedItem();
     txtdate.setValue(st.getDateEmbauche().toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
     txtnom.setText(st.getNom());
     txttelephone.setText(st.getTelephone());
     txtprenom.setText(st.getPrenom());
     txtadresse.setText(st.getAdresse());
     txtsalaire.setText(String.valueOf(st.getSalaire()));
     txtposte.setText(st.getPoste());
     txtmail.setText(st.getPoste());
        
        ss=st;
    }
    @FXML
    private void menu(ActionEvent event) {
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
