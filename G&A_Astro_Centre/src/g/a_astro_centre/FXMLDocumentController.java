package g.a_astro_centre;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class FXMLDocumentController {

    

    @FXML
    private TextField txtnamee;
    @FXML
    private PasswordField txtpass;
   
    @FXML
    private Label labf;
    @FXML
    private AnchorPane vbb;

  

    @FXML
    private void loginnn(ActionEvent event) {
          if(txtnamee.getText().equals("")){
              labf.setText("verifie user");
              Alert elert=new Alert(AlertType.WARNING);
              elert.setTitle("No choice");
              elert.setHeaderText("");
              elert.setContentText("choose User");
              elert.showAndWait();
          }
        else if(txtpass.getText().equals("")){
            labf.setText("verifie password");
             Alert elert=new Alert(AlertType.WARNING);
              elert.setTitle("No choice");
              elert.setHeaderText("");
              elert.setContentText("Rong password");
              elert.showAndWait();
        }
         else if(txtpass.getText().equals("123")&& !txtnamee.getText().trim().equals("ghazi")){labf.setText("verifie user");
          Alert elert=new Alert(AlertType.WARNING);
              elert.setTitle("No choice");
              elert.setHeaderText("");
              elert.setContentText("choose User");
              elert.showAndWait();
         }
         else if(!txtpass.getText().equals("123")&& txtnamee.getText().trim().equals("ghazi")){labf.setText("verifie password");
         Alert elert=new Alert(AlertType.WARNING);
              elert.setTitle("No choice");
              elert.setHeaderText("");
              elert.setContentText("Rong password");
              elert.showAndWait();
         }

        else if(txtnamee.getText().trim().equals("ghazi")&& txtpass.getText().trim().equals("123")){
            try {
                vbb.getScene().getWindow().hide();//pou eliminer la premier page lor de lexcution de la deusiemme

                Stage st = new Stage();
                Parent root = FXMLLoader.load(getClass().getResource("menu.fxml"));
                
                Scene scene = new Scene(root);
                st.setTitle("menu");
                st.setScene(scene);
                st.show();
                
            } catch (IOException ex) {
                Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
       
        else{labf.setText("Indefined");
        Alert elert=new Alert(AlertType.WARNING);
              elert.setTitle("No choice");
              elert.setHeaderText("");
              elert.setContentText("Indefined");
              elert.showAndWait();
        }
    }

    
 
}
