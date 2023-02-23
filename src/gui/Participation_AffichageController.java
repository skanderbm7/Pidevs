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
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ListView;
import tn.esprit.entities.Participation;
import tn.esprit.services.MissionService;
import tn.esprit.services.ParticipationService;

/**
 * FXML Controller class
 *
 * @author Pc
 */
public class Participation_AffichageController implements Initializable {

    @FXML
    private ListView<Participation> List_Participation;
    private Participation participation;
    @FXML
    private Button ajouter;
    @FXML
    private Button supprimer;
    @FXML
    private Button modifier;
    @FXML
    private Button retour;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
                List_Participation.getItems().setAll(new ParticipationService().afficher());

    }    


    @FXML
    private void ajouter(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(Participation_AffichageController.class.getResource("../tn/esprit/tests/Participation_Interface.fxml"));
        Parent root = loader.load();
        List_Participation.getScene().setRoot(root);  
    }

    @FXML
    private void modifier(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(Participation_AffichageController.class.getResource("Modifier_Participation.fxml"));
        Parent root = loader.load();
        Modifier_participationController controller = loader.getController();
        controller.setData(List_Participation.getSelectionModel().getSelectedItem());
        List_Participation.getScene().setRoot(root);

    }

    @FXML
    private void supprimer(ActionEvent event) {
                try{
            new ParticipationService().supprimer(List_Participation.getSelectionModel().getSelectedItem());
            new Alert(Alert.AlertType.INFORMATION,"Suppression avec succes",ButtonType.OK).show();
            List_Participation.getItems().setAll(new ParticipationService().afficher());
        }catch(Exception ignored){
            
        }
    }

    @FXML
    private void retour(ActionEvent event) throws IOException {
         FXMLLoader loader = new FXMLLoader(Mission_AffichageController.class.getResource("Menucp.fxml"));
        Parent root = loader.load();
        List_Participation.getScene().setRoot(root);

    }

    
}
