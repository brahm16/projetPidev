/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.io.IOException;
import java.net.URL;
import java.util.Properties;
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
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author HP
 */
public class FXMLEnvoyerPassWithMailController implements Initializable {

    @FXML
    private Button bot1;
    @FXML
    private TextField text;
    @FXML
    private Text txt;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
          text.setText("WELCOME "+FXMLRecuperPassController.Nom+" !");
    }    

    @FXML
    private void send(ActionEvent event) {
        System.out.println(FXMLRecuperPassController.pass);       
System.out.println("Preparing to send mail .......");
Properties props = new Properties();
props.put("mail.smtp.auth", "true");
props.put("mail.smtp.starttls.enable","true");
props.put("mail.smtp.host","smtp.gmail.com");
props.put("mail.smtp.port","587");
props.put("mail.smtp.ssl.trust", "smtp.gmail.com");
 String username = "kalboussihazem67@gmail.com";
 String password = "hazem2020";
Session session = Session.getInstance(props,new Authenticator() {
    @Override
protected PasswordAuthentication getPasswordAuthentication() {
return new PasswordAuthentication(username, password);
}
});
 Message message = new MimeMessage(session);
    try {
        message.setFrom(new InternetAddress(username));
        message.setRecipient(Message.RecipientType.TO,new InternetAddress(FXMLRecuperPassController.email));
        message.setSubject("Find password");
        message.setText("Welcome "+FXMLRecuperPassController.Nom+" your password is "+FXMLRecuperPassController.pass);
       Transport.send(message);
        JOptionPane.showMessageDialog(null,"your password was sent" ,"Succes" ,JOptionPane.PLAIN_MESSAGE );
        FXMLRecuperPassController.Nom=null;
        FXMLRecuperPassController.email=null;
        FXMLRecuperPassController.pass=null;
//System.out.println("Message_envoye");  
    } catch (Exception ex) {
        Logger.getLogger(FXMLEnvoyerPassWithMailController.class.getName()).log(Level.SEVERE, null, ex);
    }
    
    }

    @FXML
    private void retour(MouseEvent event) {
  try {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("FXMLRecuperPass.fxml"));
                           Parent root1 = (Parent) fxmlLoader.load();
                           Stage stage = new Stage();
                           stage.initStyle(StageStyle.UNDECORATED);
                           stage.setScene(new Scene(root1));  
                           stage.show();
                           Stage stage1 = (Stage) txt.getScene().getWindow(); 
                           stage1.close();
                           } catch (IOException ex) {
                              showAlertWithHeaderText("page not found");
                            }
    }
     private void showAlertWithHeaderText(String msg) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Account");
        alert.setHeaderText("Results:");
        alert.setContentText(msg);
        alert.showAndWait();
    }
}

       
    
    
