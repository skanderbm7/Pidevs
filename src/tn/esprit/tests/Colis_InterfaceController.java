/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package tn.esprit.tests;

import gui.MenucmController;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import tn.esprit.entities.Colis;
import tn.esprit.services.ColisService;

/**
 * FXML Controller class
 *
 * @author Pc
 */
public class Colis_InterfaceController implements Initializable {

    @FXML
    private ComboBox<String> categorie_colis;
    @FXML
    private TextField poids_colis;

    /**
     * Initializes the controller class.
     */
    List<String> Categories = new ArrayList();
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Categories.add("Fragile");
        Categories.add("Liquide");
        Categories.add("Solide");
        Categories.add("Animal");
        Categories.add("Dossier");
        categorie_colis.getItems().setAll(Categories);
    }    

    @FXML
    private void ajouter(ActionEvent event) {
        Colis c = new Colis(categorie_colis.getSelectionModel().getSelectedItem(), Integer.parseInt(poids_colis.getText()));
        new ColisService().ajouter(c);
        new Alert(Alert.AlertType.CONFIRMATION,"Colis ajouté avec succéss ",ButtonType.OK).show();
    }


    @FXML
    private void retour(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(Colis_InterfaceController.class.getResource("../../../gui/Colis_Affichage.fxml"));
        Parent root = loader.load();
        categorie_colis.getScene().setRoot(root);
    }
    
}
