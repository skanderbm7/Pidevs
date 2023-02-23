/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package tn.esprit.tests;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author Pc
 */
public class Acceuil_proController implements Initializable {

    @FXML
    private Label lemail;
    @FXML
    private Button logout;
    @FXML
    private Button changepassword;
    @FXML
    private Button lgererprofile;
    @FXML
    private Label lnom;
    @FXML
    private Button btnEv;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void logout(MouseEvent event) {
    }


    @FXML
    private void gererProfile(MouseEvent event) {
    }

    @FXML
    private void gestEv(ActionEvent event) {
    }

    @FXML
    private void menu_mission(ActionEvent event) throws IOException{
         FXMLLoader loader = new FXMLLoader(Acceuil_proController.class.getResource("../../../gui/Menucm.fxml"));
        Parent root = loader.load();
        btnEv.getScene().setRoot(root);
    }

    @FXML
    private void menu_c(ActionEvent event) throws IOException {
           FXMLLoader loader = new FXMLLoader(getClass().getResource("../../../gui/Menucp.fxml"));
        Parent root = loader.load();
        btnEv.getScene().setRoot(root);
    }
    
}
