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
import tn.esprit.entities.Covoiturage;
import tn.esprit.services.CovoiturageService;
import tn.esprit.services.MissionService;

/**
 * FXML Controller class
 *
 * @author Pc
 */
public class Covoiturage_AffichageController implements Initializable {

    @FXML
    private ListView<Covoiturage> List_Covoiturage;
    @FXML
    private Button add;
    @FXML
    private Button retour;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
     List_Covoiturage.getItems().setAll(new CovoiturageService().afficher());
     

    }    

    @FXML
    private void ajouter(ActionEvent event) throws IOException {
             FXMLLoader loader = new FXMLLoader(Covoiturage_AffichageController.class.getResource("../tn/esprit/tests/Covoiturage_Interface.fxml"));
        Parent root = loader.load();
        List_Covoiturage.getScene().setRoot(root);
    }

    @FXML
    private void modifier(ActionEvent event) throws IOException {
                FXMLLoader loader = new FXMLLoader(Participation_AffichageController.class.getResource("Modifier_Covoiturage.fxml"));
        Parent root = loader.load();
        Modifier_CovoiturageController controller = loader.getController();
        controller.setData(List_Covoiturage.getSelectionModel().getSelectedItem());
        List_Covoiturage.getScene().setRoot(root);

    }

    @FXML
    private void supprimer(ActionEvent event) {
                try{
            new CovoiturageService().supprimer(List_Covoiturage.getSelectionModel().getSelectedItem());
            new Alert(Alert.AlertType.INFORMATION,"Suppression avec succes",ButtonType.OK).show();
            List_Covoiturage.getItems().setAll(new CovoiturageService().afficher());
        }catch(Exception ignored){
            
        }
    }

    @FXML
    private void retour(ActionEvent event) throws IOException {
           FXMLLoader loader = new FXMLLoader(Covoiturage_AffichageController.class.getResource("Menucp.fxml"));
        Parent root = loader.load();
        List_Covoiturage.getScene().setRoot(root);
    }

    }
    

