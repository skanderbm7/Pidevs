/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package tn.esprit.tests;

import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import tn.esprit.entities.Colis;
import tn.esprit.entities.Mission;
import tn.esprit.services.ColisService;
import tn.esprit.services.MissionService;
/**
 * FXML Controller class
 *
 * @author Pc
 */
public class Mission_interfaceController implements Initializable {

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
    
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
      // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    @FXML
   private void ajouterm(ActionEvent event) {
        Mission m = new Mission(Date.valueOf(myDatePicker.getValue()), Integer.parseInt(solde.getText()), Integer.parseInt(id_livreur.getText()), adress_destination.getText(), Integer.parseInt(num_distinateur.getText()), Integer.parseInt(id_colis.getText()));

//        Mission m = new Mission(Date.valueOf(myDatePicker.getValue()), Integer.parseInt(solde_livrison_mission.getText()),Integer.parseInt(id_livreur.getText()),adress_destination.getText(),Integer.parseInt(num_distinateur.getText()),Integer.parseInt(id_colis.getText()));
//        System.out.println(m);
        new MissionService().ajouter(m);
        new Alert(Alert.AlertType.CONFIRMATION,"mission ajouté avec succéss ",ButtonType.OK).show();

    }

    @FXML
  public void getDate(ActionEvent event) {
  
  LocalDate myDate = myDatePicker.getValue();
  String myFormattedDate = myDate.format(DateTimeFormatter.ofPattern("MMM-dd-yyyy"));

    }

    @FXML
    private void retour(ActionEvent event) throws IOException {
           FXMLLoader loader = new FXMLLoader(Colis_InterfaceController.class.getResource("../../../gui/Menucm.fxml"));
        Parent root = loader.load();
        solde.getScene().setRoot(root);
    }


     

}