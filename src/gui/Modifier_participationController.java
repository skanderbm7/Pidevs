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
import javafx.scene.control.TextField;
import tn.esprit.entities.Colis;
import tn.esprit.entities.Mission;
import tn.esprit.entities.Participation;
import tn.esprit.services.ColisService;
import tn.esprit.services.ParticipationService;

/**
 * FXML Controller class
 *
 * @author Pc
 */
public class Modifier_participationController implements Initializable {

    @FXML
    private TextField id_passager;
    @FXML
    private TextField id_covoiturage;
    
     private Participation participation;
    @FXML
    private Button modifier_participation;


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    private void ajouter_participation(ActionEvent event) {
     participation.setPassager_id(Integer.parseInt(id_passager.getText()));
    participation.setCouvoiturage_id(Integer.parseInt(id_covoiturage.getText()));
        new ParticipationService().modifier(participation);
        new Alert(Alert.AlertType.INFORMATION,"Mise a jours",ButtonType.OK).show();

    }

    @FXML
    private void modifier_participation(ActionEvent event) {
           participation.setPassager_id(Integer.parseInt(id_passager.getText()));
    participation.setCouvoiturage_id(Integer.parseInt(id_covoiturage.getText()));
        new ParticipationService().modifier(participation);
        new Alert(Alert.AlertType.INFORMATION,"Mise a jours",ButtonType.OK).show();

    }
    
    void setData(Participation selectedItem) {
        this.participation = selectedItem;

    
}

    @FXML
    private void retour(ActionEvent event) throws IOException {
      FXMLLoader loader = new FXMLLoader(Modifier_participationController.class.getResource("participation_Affichage.fxml"));
        Parent root = loader.load();
        id_covoiturage.getScene().setRoot(root);
    }
}
