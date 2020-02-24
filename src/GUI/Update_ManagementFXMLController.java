/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Connexion.image;
import Entity.User;
import Service.UserService;
import com.github.sarxos.webcam.Webcam;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author HP
 */
public class Update_ManagementFXMLController implements Initializable {

    @FXML
    private TextField txt1;
    @FXML
    private TextField txt2;
    @FXML
    private TextField txt11;
    @FXML
    private TextField txt111;
    @FXML
    private TextField txt112;
    @FXML
    private TextField txt1121;
    @FXML
    private Button bot2;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void capture(MouseEvent event) throws IOException {
        String nom=txt2.getText().toString();
        Webcam webcam = Webcam.getDefault();
webcam.open();
ImageIO.write(webcam.getImage(), "PNG", new File("C:\\Users\\HP\\Desktop\\img\\"+nom+".png"));
    }

    @FXML
    private void ajouterIm(ActionEvent event) {
  image img=new image();
      img.filen();
      String pth=img.getp();
      if(pth==null)
      {
       showAlertWithHeaderText("path is null");
      }
else
{
    txt1121.setText(pth);
    }
    }

    @FXML
    private void modify(ActionEvent event) {
    String F_name=txt1.getText().toString();
    String L_name=txt2.getText().toString();
    String mail=txt11.getText().toString();
    String Numero=txt111.getText().toString();
    String pass=txt112.getText().toString();
    String photo=txt1121.getText().toString();
     if(F_name.length()!=0 && L_name.length()!=0 && mail.length()!=0 && Numero.length()!=0 && photo.length()!=0 && pass.length()!=0)
   {
        if(pass.length()>=8)
        {
            if(Numero.length()==8 && Numero.matches("^[0-9]+$"))
            {
                if(isEmailAdress(mail))
                {
                UserService usrs=new UserService();  
               if(usrs.update(new User(FXMLIdentificationController.id,F_name,L_name,pass,FXMLIdentificationController.usr_type,mail,photo,Integer.parseInt(Numero)))==true)
               {
                   JOptionPane.showMessageDialog(null, "            success");
               }
               else{
                   showAlertWithHeaderText("Error");
               }
            }
                else{
                showAlertWithHeaderText("invalid mail address");
            }
            }
             else{
                showAlertWithHeaderText("invalid phone number");
            }
    }   
     else{
            showAlertWithHeaderText("the size of password should be greater then 8 character");
               }
   }
     else
     {
         showAlertWithHeaderText("all fields should be not null");
     }
    }
   private void showAlertWithHeaderText(String msg) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("ADD");
        alert.setHeaderText("Results:");
        alert.setContentText(msg);
        alert.showAndWait();
    }
   public static boolean isEmailAdress(String email){
Pattern p = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,4}$");
Matcher m = p.matcher(email.toUpperCase());
return m.matches();
}
}
