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
import tn.esprit.entities.Participation;
import tn.esprit.services.ParticipationService;
import tn.esprit.tests.Covoiturage_InterfaceController;

/**
 * FXML Controller class
 *
 * @author Pc
 */
public class Participation_InterfaceController implements Initializable {

    @FXML
    private Button ajouter_participation;
    @FXML
    private TextField id_passager;
    @FXML
    private TextField id_covoiturage;
    @FXML
    private Button retour;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void ajouter_participation(ActionEvent event) {
     Participation participation = new Participation (Integer.parseInt(id_passager.getText()), Integer.parseInt(id_covoiturage.getText()));

//        Mission m = new Mission(Date.valueOf(myDatePicker.getValue()), Integer.parseInt(solde_livrison_mission.getText()),Integer.parseInt(id_livreur.getText()),adress_destination.getText(),Integer.parseInt(num_distinateur.getText()),Integer.parseInt(id_colis.getText()));
//        System.out.println(m);
        new ParticipationService().ajouter(participation);
        new Alert(Alert.AlertType.CONFIRMATION,"participationajouté avec succéss ",ButtonType.OK).show();

    }

    @FXML
    private void retour(ActionEvent event) throws IOException {
                FXMLLoader loader = new FXMLLoader(Participation_InterfaceController.class.getResource("Participation_Affichage.fxml"));
        Parent root = loader.load();
        id_covoiturage.getScene().setRoot(root);

    }
    
}
