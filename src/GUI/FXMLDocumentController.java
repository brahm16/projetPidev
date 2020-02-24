/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 *
 * @author HP
 */
public class FXMLDocumentController implements Initializable {

        @FXML
     private Button Bot1; 
 
   
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void handleButton1Action(ActionEvent event){
      try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("FXMLInscription.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.initStyle(StageStyle.UNDECORATED);
            stage.setScene(new Scene(root1));  
            stage.show();
            Stage stage1 = (Stage) Bot1.getScene().getWindow(); 
            stage1.close();
        } catch (Exception e) {
            System.out.println("fdsgsg");
        }
    }

    @FXML
    private void handleButton2Action(ActionEvent event) {
     try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("FXMLIdentification.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.initStyle(StageStyle.UNDECORATED);
            stage.setScene(new Scene(root1));  
            stage.show();
            Stage stage1 = (Stage) Bot1.getScene().getWindow(); 
            stage1.close();
        } catch (Exception e) {
            System.out.println("fdsgsg");
        }
    }

    @FXML
    private void quitter(MouseEvent event) {
    System.exit(0);
    }
    
}
