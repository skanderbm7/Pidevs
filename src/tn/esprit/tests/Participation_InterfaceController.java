/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package tn.esprit.tests;

import java.net.URL;
import java.sql.Date;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import tn.esprit.entities.Mission;
import tn.esprit.entities.Participation;
import tn.esprit.services.CovoiturageService;
import tn.esprit.services.MissionService;
import tn.esprit.services.ParticipationService;

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

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url,ResourceBundle resources ) {
        // TODO

    }    
        @FXML
   private void ajouter_participation(ActionEvent event) {
        Participation participation = new Participation (Integer.parseInt(id_passager.getText()), Integer.parseInt(id_covoiturage.getText()));

//        Mission m = new Mission(Date.valueOf(myDatePicker.getValue()), Integer.parseInt(solde_livrison_mission.getText()),Integer.parseInt(id_livreur.getText()),adress_destination.getText(),Integer.parseInt(num_distinateur.getText()),Integer.parseInt(id_colis.getText()));
//        System.out.println(m);
        new ParticipationService().ajouter(participation);
        new Alert(Alert.AlertType.CONFIRMATION,"mission ajouté avec succéss ",ButtonType.OK).show();
    
}
}
