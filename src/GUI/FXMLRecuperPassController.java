/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Connexion.Cryptage;
import Connexion.DataSource;
import Service.UserService;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

/**
 * FXML Controller class
 *
 * @author HP
 */
public class FXMLRecuperPassController implements Initializable {
private Connection c;
private Statement st;
private ResultSet rs;
    @FXML
    private TextField txt;
    @FXML
    private Button bot1;
    @FXML
    private Button bott2;
    public static String Nom;
    public static String email;
    public static String pass;
    public static int Number;
    @FXML
    private Text txt1;
    UserService us;
     Cryptage crypt;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
         c=DataSource.getInstance().getCon();
         us=new UserService();
          crypt=new Cryptage();
    }    

    @FXML
    private void cancel(ActionEvent event) {
    try {
                           FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("FXMLIdentification.fxml"));
                           Parent root1 = (Parent) fxmlLoader.load();
                           Stage stage = new Stage();
                           stage.initStyle(StageStyle.UNDECORATED);
                           stage.setScene(new Scene(root1));  
                           stage.show();
                           Stage stage1 = (Stage) bot1.getScene().getWindow(); 
                           stage1.close();
                           } catch (IOException ex) {
                                Logger.getLogger(FXMLInscriptionController.class.getName()).log(Level.SEVERE, null, ex);
                            }
    }

    @FXML
    private void search(ActionEvent event) throws SQLException {
    String tt=txt.getText().toString();
    if(tt.contains("@"))
    { 
        ResultSet rs=us.display(tt);
	if(rs.next()) {
            try{        
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("FXMLEnvoyerPassWithMail.fxml"));
                           Nom=rs.getString("LastName_U");
                           email=rs.getString("Email");
                           String passwr=rs.getString("Password");
                           System.out.println(passwr);
                
                           System.out.println(pass);
                           Parent root1 = (Parent) fxmlLoader.load();
                           Stage stage = new Stage();
                           stage.initStyle(StageStyle.UNDECORATED);
                           stage.setScene(new Scene(root1));  
                           stage.show();
                           Stage stage1 = (Stage) bott2.getScene().getWindow(); 
                           stage1.close();
            }
            catch (IOException ex) {
               showAlertWithHeaderText("page not found");
               }
            }
        else{
            showAlertWithHeaderText("invalid mail address");
        }
    }
    else
    {
        if(tt.length()==8)
        {       
            int nb=Integer.parseInt(tt);
            ResultSet rs=us.display(nb);
            if(rs.next()){
            try{        
           FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("FXMLEnvoyerPassWithPhone.fxml"));
                           Nom=rs.getString("LastName_U");
                           email=rs.getString("Email");
              
                           Number=rs.getInt("Phone_Number");
                             Parent root1 = (Parent) fxmlLoader.load();
                           Stage stage = new Stage();
                           stage.initStyle(StageStyle.UNDECORATED);
                           stage.setScene(new Scene(root1));  
                           stage.show();
                           Stage stage1 = (Stage) bott2.getScene().getWindow(); 
                           stage1.close();
            }
            catch (IOException ex) {
               showAlertWithHeaderText("page not found");
                            }
            }
        else{
            showAlertWithHeaderText("invalid phone number");
        }
    }
        else{
             showAlertWithHeaderText("phone number should has 8 charcter");
        }
    }
    }
 private void showAlertWithHeaderText(String msg) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Account");
        alert.setHeaderText("Results:");
        alert.setContentText(msg);
        alert.showAndWait();
    }

    @FXML
    private void retour(MouseEvent event) {
      try {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("FXMLIdentification.fxml"));
                           Parent root1 = (Parent) fxmlLoader.load();
                           Stage stage = new Stage();
                           stage.initStyle(StageStyle.UNDECORATED);
                           stage.setScene(new Scene(root1));  
                           stage.show();
                           Stage stage1 = (Stage) txt.getScene().getWindow(); 
                           stage1.close();
                           } 
       catch (IOException ex) {
           showAlertWithHeaderText("page not found");
                            }
    }
}

 
 