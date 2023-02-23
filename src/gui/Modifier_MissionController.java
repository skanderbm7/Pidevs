/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package gui;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import tn.esprit.entities.Mission;

/**
 * FXML Controller class
 *
 * @author Pc
 */
public class Modifier_MissionController implements Initializable {

    @FXML
    private DatePicker myDatePicker;
    @FXML
    private TextField solde;
    @FXML
    private TextField id_livreur;
    @FXML
    private TextField adress_destination;
    @FXML
    private TextField num_distinateur;
    @FXML
    private TextField id_colis;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void getDate(ActionEvent event) {
    }

    @FXML
    private void ajouterm(ActionEvent event) {
    }

    @FXML
    private void retour(ActionEvent event) {
    }
    private Mission mission;
    void setData(Mission selectedItem) {
        this.mission = selectedItem;
    }
    
}
