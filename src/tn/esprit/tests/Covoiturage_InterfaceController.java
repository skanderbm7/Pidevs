/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package tn.esprit.tests;

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
import javafx.scene.input.MouseEvent;
import tn.esprit.entities.Colis;
import tn.esprit.entities.Covoiturage;
import tn.esprit.services.ColisService;
import tn.esprit.services.CovoiturageService;

/**
 * FXML Controller class
 *
 * @author Pc
 */
public class Covoiturage_InterfaceController implements Initializable {
    @FXML
    private ListView<Covoiturage> couvoiturages;
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
         couvoiturages.getItems().setAll(new CovoiturageService().afficher());
       
    }    
    @FXML
    private void ajouter(ActionEvent event) {
               Covoiturage c = new Covoiturage(adresse_depart.getText(),adreese_arrive.getText(),date_depart.getValue().toString(),heure_depart.getSelectionModel().getSelectedItem(),Integer.parseInt(nbr_places.getText()),Float.parseFloat(prix.getText()),description.getText());
        new CovoiturageService().ajouter(c);
        new Alert(Alert.AlertType.CONFIRMATION,"Colis ajouté avec succéss ",ButtonType.OK).show();

    }
            private Covoiturage covoiturage;
    void setData(Covoiturage selectedItem) {
        this.covoiturage = selectedItem;

    }
    
    @FXML
    private void retour(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(Covoiturage_InterfaceController.class.getResource("../../../gui/Covoiturage_Affichage.fxml"));
        Parent root = loader.load();
        description.getScene().setRoot(root);

    }

    @FXML
    private void setModif(MouseEvent event) {
    }
    
}
