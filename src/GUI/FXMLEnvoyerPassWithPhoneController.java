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
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
 import java.net.*;
import java.io.*;

/**
 * FXML Controller class
 *
 * @author HP
 */
//import com.teknikindustries.bulksms.SMS;
import java.util.Base64;
public class FXMLEnvoyerPassWithPhoneController implements Initializable {

   @FXML
    private Button bot1;
    @FXML
    private TextField text;
    @FXML
    private Text txt;
    int nomb;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
          text.setText("WELCOME "+FXMLRecuperPassController.Nom+" !");
          nomb=FXMLRecuperPassController.Number;
    }    

    @FXML
    private void send(ActionEvent event) throws Exception  {
 String myURI = "https://api.bulksms.com/v1/messages";
    String myUsername = "kalboussi11";
    String myPassword = "Kalboussi123";
    String myData = "{to: \"216"+nomb+"\", encoding: \"UNICODE\", body: \"your password is "+FXMLRecuperPassController.pass+"\"}";
    
    URL url = new URL(myURI);
    HttpURLConnection request = (HttpURLConnection) url.openConnection();
    request.setDoOutput(true);

    // supply the credentials
    String authStr = myUsername + ":" + myPassword;
    String authEncoded = Base64.getEncoder().encodeToString(authStr.getBytes());
    request.setRequestProperty("Authorization", "Basic " + authEncoded);

    // we want to use HTTP POST
    request.setRequestMethod("POST");
    request.setRequestProperty( "Content-Type", "application/json");

    // write the data to the request
    OutputStreamWriter out = new OutputStreamWriter(request.getOutputStream());
    out.write(myData);
    out.close();

    // try ... catch to handle errors nicely
    try {
      // make the call to the API
      InputStream response = request.getInputStream();
      BufferedReader in = new BufferedReader(new InputStreamReader(response));
      String replyText;
      while ((replyText = in.readLine()) != null) {
        System.out.println(replyText);
      }
      in.close();
    } catch (IOException ex) {
      System.out.println("An error occurred:" + ex.getMessage());
      BufferedReader in = new BufferedReader(new InputStreamReader(request.getErrorStream()));
      // print the detail that comes with the error
      String replyText;
      while ((replyText = in.readLine()) != null) {
        System.out.println(replyText);
      }
      in.close();
    }
    request.disconnect();
  FXMLRecuperPassController.Number=0;
  FXMLRecuperPassController.Nom=null;
  FXMLRecuperPassController.pass=null;
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
