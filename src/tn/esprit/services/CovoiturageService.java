/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tn.esprit.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import tn.esprit.entities.Covoiturage;
import tn.esprit.utils.MaConnection;

/**
 *
 * @author Pc
 */
public class CovoiturageService implements InterfaceService <Covoiturage> {
    Connection cnx;
public CovoiturageService(){
      cnx = MaConnection.getInstance().getCnx();
}

    @Override
    public void ajouter(Covoiturage c) {
              try {
            String sql = "insert into covoiturage(id_covoiturage ,adresse_depart,adresse_arrive,date_depart,heure_depart,nb_place,prix,description,id_conducteur)"
                    + "values (?,?,?,?,?,?,?,?,?)";  
            PreparedStatement ste = cnx.prepareStatement(sql);
            ste.setInt(1, c.getId_covoiturage());
            ste.setString(2, c.getAdresse_depart());
            ste.setString(3, c.getAdresse_arrive());
            ste.setString(4, c.getDate_depart());
            ste.setString(5, c.getHeure_depart());
            ste.setInt(6, c.getNb_place());
            ste.setFloat(7, c.getPrix());
            ste.setString(8, c.getDescription());
            ste.setInt(9, c.getId_conducteur());
            ste.executeUpdate();
            System.out.println("covoiturage  ajoutée");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

    }

    @Override
    public void modifier(Covoiturage c) {
          String sql = "update covoiturage set  adresse_depart=?,adresse_arrive=?,date_depart=?,heure_depart=?,nb_place=?,prix=?,description=?,id_conducteur=? where id_covoiturage=?";
        try {
            PreparedStatement ste = cnx.prepareStatement(sql);
            ste.setString(1,c.getAdresse_depart());
            ste.setString(2,c.getAdresse_arrive());
            ste.setString(3,c.getDate_depart());
            ste.setString(4,c.getHeure_depart());
            ste.setInt(5,c.getNb_place());
            ste.setFloat(6,c.getPrix());
            ste.setString(7,c.getDescription());
            ste.setInt(8,c.getId_conducteur());
            ste.setInt(9,c.getId_covoiturage());
            
            ste.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    
    }

    @Override
    public List<Covoiturage> afficher() {
        List<Covoiturage> list = new ArrayList<>();
        
        String req = "SELECT * FROM covoiturage";
        try {
            Statement st = cnx.createStatement();
            ResultSet result = st.executeQuery(req);
            while(result.next()) {
                list.add(new Covoiturage(result.getInt(1),result.getString(2),result.getString(3),result.getString(4),result.getString(5),result.getInt(6),result.getFloat(6),result.getString(7)));
            }
            System.out.println("Personnes récupérées !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
        return list;
    }
    
    
    

    @Override
    public void supprimer(Covoiturage c) {
        String req = "DELETE FROM covoiturage WHERE id_covoiturage="+c.getId_covoiturage();
        try {
            Statement st = cnx.createStatement();
            st.executeUpdate(req);
            System.out.println("Covoiturage supprimée !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
}
