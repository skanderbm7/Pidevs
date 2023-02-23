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
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import tn.esprit.entities.Colis;
import tn.esprit.entities.Covoiturage;
import tn.esprit.entities.Mission;
import tn.esprit.services.CovoiturageService;

/**
 * FXML Controller class
 *
 * @author Pc
 */
public class Modifier_CovoiturageController implements Initializable {

    @FXML
    private ListView<Covoiturage> List_Covoiturage;
    @FXML
    private TextField adresse_depart;
    @FXML
    private TextField adreese_arrive;
    @FXML
    private DatePicker date_depart;
    @FXML
    private ComboBox<String> heure_depart;
    @FXML
    private TextField nbr_places;
    @FXML
    private TextField prix;
    @FXML
    private TextArea description;
    @FXML
    private Button retour;

      private String[] heures = {"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24" };

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        heure_depart.getItems().setAll(heures);
    }    

    @FXML
    private void ajouter(ActionEvent event) {
        covoiturage.setAdresse_arrive(adreese_arrive.getText());
        covoiturage.setAdresse_depart(adresse_depart.getText());
        covoiturage.setDate_depart(String.valueOf(date_depart.getValue()));
        covoiturage.setDescription(description.getText());
        covoiturage.setNb_place(Integer.parseInt(nbr_places.getText()));
        covoiturage.setPrix(Float.valueOf(prix.getText()));
        covoiturage.setHeure_depart(heure_depart.getSelectionModel().getSelectedItem());
        new CovoiturageService().modifier(covoiturage);
        new Alert(Alert.AlertType.INFORMATION,"Covoiturage Modifier", ButtonType.OK).show();
    }
        private Covoiturage covoiturage;
    void setData(Covoiturage selectedItem) {
        this.covoiturage = selectedItem;

    }

    @FXML
    private void retour(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(Covoiturage_AffichageController.class.getResource("Covoiturage_Affichage.fxml"));
        Parent root = loader.load();
      adreese_arrive.getScene().setRoot(root);
     }

}
