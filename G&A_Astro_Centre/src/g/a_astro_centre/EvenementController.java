/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package g.a_astro_centre;

import Gestion_des_Evenement.Evenement;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
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
import javafx.scene.control.Alert;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author oumar
 */
public class EvenementController implements Initializable {

    @FXML
    private TextField txtlieu;
    @FXML
    private TextField txtGain;
    @FXML
    private DatePicker textdate;
    @FXML
    private AnchorPane vbb;
    @FXML
    private TableView<Evenement> table;
    @FXML
    private TableColumn<Evenement, Date> coldate;
    @FXML
    private TableColumn<Evenement, String> collieu;
    @FXML
    private TableColumn<Evenement, String> coltype;
    @FXML
    private TableColumn<Evenement, Float> colgain;
    @FXML
    private Label lab_nb;

    /**
     * Initializes the controller class.
     */
    Evenement ss ;
    ObservableList<Evenement>liste=FXCollections.observableArrayList();
    @FXML
    private RadioButton educat;
    @FXML
    private RadioButton obser;
    @FXML
    private ToggleGroup typee;
    @FXML
    private Label lab_tot;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        coldate.setCellValueFactory(new PropertyValueFactory<Evenement,Date>("date"));
        collieu.setCellValueFactory(new PropertyValueFactory<Evenement,String>("lieu"));
        coltype.setCellValueFactory(new PropertyValueFactory<Evenement,String>("type"));
        colgain.setCellValueFactory(new PropertyValueFactory<Evenement,Float>("gain"));
        setupTablee();
        nbevent();
        tot_g();
        table.setItems(liste);
      
    }    
    private void nbevent(){lab_nb.setText(String.valueOf(liste.size()));}
        private void tot_g(){
            float tot=0;
            for(Evenement ev:liste){tot=tot+ev.getGain();}
            lab_tot.setText(String.valueOf(tot));
        }

    private void setupTablee() {
        Evenement stl0 = new Evenement(new Date(2023 - 1900, 1, 20), "Tunis","Educatif",100);
        Evenement stl1 = new Evenement(new Date(2023 - 1900, 2, 2), "Tabarka","Observatif",200);
        Evenement stl2 = new Evenement(new Date(2023 - 1900, 3, 22), "Sousse", "obsevatif",300);
        Evenement stl3 = new Evenement(new Date(2023 - 1900, 11, 17), "Sfax","Educatif",400);
      //  table_st_n.getItems().addAll(stl0, stl1, stl2, stl3);
           liste.addAll(stl0, stl1, stl2, stl3);   
       }
    @FXML
    private void Add(ActionEvent event) {
       Date d=java.sql.Date.valueOf(textdate.getValue());
       if(educat.isSelected()==true){
       Evenement s=new Evenement(d,txtlieu.getText(),"Observatif",100);
       liste.add(s);
             table.refresh();
             nbevent();
    }
       if(obser.isSelected()==true){    Evenement s=new Evenement(d,txtlieu.getText(),"Educatif",100);
       liste.add(s);
             table.refresh();
             nbevent();
     }
        tot_g();
    }

    @FXML
    private void Update(ActionEvent event) {
                for(Evenement st:liste){
            if(ss.equals(st)){
                if(educat.isSelected()==true){st.setType("Educatif");}
                if(obser.isSelected()==true){st.setType("Observatif");}
                st.setDate(java.sql.Date.valueOf(textdate.getValue()));
                st.setLieu(txtlieu.getText());
                st.setGain(Float.parseFloat(txtGain.getText()));
                table.refresh();
                
        }
             tot_g();
    }
    }

    @FXML
    private void delete(ActionEvent event) {
         Evenement selectedItem = table.getSelectionModel().getSelectedItem();

        if (selectedItem != null) {
            liste.remove(selectedItem);
            table.refresh();
       nbevent();
        tot_g();
        }
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

    @FXML
    private void rowClicked(MouseEvent event) {
              Evenement st = table.getSelectionModel().getSelectedItem();
        textdate.setValue(st.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
     //  if(st.getType()=="Observatif"){obser.selectedProperty()}
        txtGain.setText(String.valueOf(st.getGain()));
        txtlieu.setText(st.getLieu());
        
        ss=st;
    }
    
}
