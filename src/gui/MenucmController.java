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
import tn.esprit.tests.Colis_InterfaceController;

/**
 * FXML Controller class
 *
 * @author Pc
 */
public class MenucmController implements Initializable {

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
    private void colis_interface(ActionEvent event) throws IOException {
       FXMLLoader loader = new FXMLLoader(MenucmController.class.getResource("Colis_Affichage.fxml"));
        Parent root = loader.load();
        scene_box.getScene().setRoot(root);
    }

    @FXML
    private void mission_interface(ActionEvent event)  throws IOException {
        FXMLLoader loader = new FXMLLoader(MenucmController.class.getResource("Mission_Affichage.fxml"));
        Parent root = loader.load();
        scene_box.getScene().setRoot(root);
    }
    
}
