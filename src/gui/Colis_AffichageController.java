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
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ListView;
import tn.esprit.entities.Colis;
import tn.esprit.services.ColisService;
import tn.esprit.tests.Colis_InterfaceController;

/**
 * FXML Controller class
 *
 * @author Pc
 */
public class Colis_AffichageController implements Initializable {

    @FXML
    private ListView<Colis> list_colis;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        list_colis.getItems().setAll(new ColisService().afficher());
    }    

    @FXML
    private void retour(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(Colis_AffichageController.class.getResource("Menucm.fxml"));
        Parent root = loader.load();
        list_colis.getScene().setRoot(root);
    }

    @FXML
    private void ajouter(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(Colis_AffichageController.class.getResource("../tn/esprit/tests/Colis_Interface.fxml"));
        Parent root = loader.load();
        list_colis.getScene().setRoot(root);    }

    @FXML
    private void modifier(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(Colis_AffichageController.class.getResource("Modifier_Colis.fxml"));
        Parent root = loader.load();
        Modifier_ColisController controller = loader.getController();
        controller.setData(list_colis.getSelectionModel().getSelectedItem());
        list_colis.getScene().setRoot(root);
    }

    @FXML
    private void supprimer(ActionEvent event) {
        try{
            new ColisService().supprimer(list_colis.getSelectionModel().getSelectedItem());
            new Alert(Alert.AlertType.INFORMATION,"Suppression avec succes",ButtonType.OK).show();
            list_colis.getItems().setAll(new ColisService().afficher());
        }catch(Exception ignored){
            
        }
    }
    
}
