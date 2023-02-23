/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
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
import tn.esprit.entities.Mission;
import tn.esprit.services.MissionService;

/**
 * FXML Controller class
 *
 * @author Pc
 */
public class Mission_AffichageController implements Initializable {
    @FXML
     private ListView<Mission> List_Mission;
    /**    @FXML


     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        List_Mission.getItems().setAll(new MissionService().afficher());
    }    
    @FXML
    private void retour(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(Mission_AffichageController.class.getResource("Menucm.fxml"));
        Parent root = loader.load();
        List_Mission.getScene().setRoot(root);
    }
    @FXML
    private void ajouter(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(Mission_AffichageController.class.getResource("../tn/esprit/tests/Mission_Interface.fxml"));
        Parent root = loader.load();
        List_Mission.getScene().setRoot(root);    }
    
    @FXML
    private void modifier(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(Colis_AffichageController.class.getResource("Modifier_Mission.fxml"));
        Parent root = loader.load();
        Modifier_MissionController controller = loader.getController();
        controller.setData(List_Mission.getSelectionModel().getSelectedItem());
        List_Mission.getScene().setRoot(root);
    }

    @FXML
    private void supprimer(ActionEvent event) {
        try{
            new MissionService().supprimer(List_Mission.getSelectionModel().getSelectedItem());
            new Alert(Alert.AlertType.INFORMATION,"Suppression avec succes",ButtonType.OK).show();
            List_Mission.getItems().setAll(new MissionService().afficher());
        }catch(Exception ignored){
            
        }
    }

        // TODO
    }    
    

