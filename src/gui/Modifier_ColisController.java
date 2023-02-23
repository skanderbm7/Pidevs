/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

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
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import tn.esprit.entities.Colis;
import tn.esprit.services.ColisService;
import tn.esprit.tests.Colis_InterfaceController;

/**
 * FXML Controller class
 *
 * @author Pc
 */
public class Modifier_ColisController implements Initializable {

    @FXML
    private ComboBox<String> categorie_colis;
    @FXML
    private TextField poids_colis;

   List<String> Categories = new ArrayList();
   private Colis colis;
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
    private void modifier(ActionEvent event) {
        colis.setCategorie(categorie_colis.getSelectionModel().getSelectedItem());
        colis.setPoids(Integer.parseInt(poids_colis.getText()));
        new ColisService().modifier(colis);
        new Alert(Alert.AlertType.INFORMATION,"Mise a jours",ButtonType.OK).show();
    }

    @FXML
    private void retour(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(Modifier_ColisController.class.getResource("Colis_Affichage.fxml"));
        Parent root = loader.load();
        poids_colis.getScene().setRoot(root);
    }

    void setData(Colis colis) {
        this.colis = colis;
    }
    
}
