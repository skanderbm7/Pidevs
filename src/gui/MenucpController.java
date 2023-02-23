/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.layout.HBox;

/**
 * FXML Controller class
 *
 * @author Pc
 */
public class MenucpController implements Initializable {

    @FXML
    private HBox scene_box;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void covoiturage_interface(ActionEvent event) throws IOException {
       FXMLLoader loader = new FXMLLoader(MenucmController.class.getResource("Covoiturage_Affichage.fxml"));
        Parent root = loader.load();
        scene_box.getScene().setRoot(root);
    }

    @FXML
    private void participation_interface(ActionEvent event)  throws IOException {
        FXMLLoader loader = new FXMLLoader(MenucmController.class.getResource("Participation_Affichage.fxml"));
        Parent root = loader.load();
        scene_box.getScene().setRoot(root);
    }

    
}
