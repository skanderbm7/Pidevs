/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tn.esprit.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import tn.esprit.entities.Participation;
import tn.esprit.utils.MaConnection;

/**
 *
 * @author Pc
 */
public class ParticipationService implements InterfaceService<Participation>{
        private final Connection cnx = MaConnection.getInstance().getCnx();

    @Override
    public void ajouter(Participation participation) {
       try{
            PreparedStatement ps = cnx.prepareStatement("INSERT INTO PARTICIPATION (id_passager,id_covoiturage ) values (?,?)");
            ps.setInt(2,participation.getCouvoiturage_id());
            ps.setInt(1,participation.getPassager_id());
            ps.executeUpdate();
        }catch (Exception ignored){
            System.out.println(ignored.getMessage());
        }    }

    @Override
    public void modifier(Participation participation) {
         try{
            PreparedStatement ps = cnx.prepareStatement("UPDATE PARTICIPATION SET id_passager = ? ,id_covoiturage = ? WHERE id_participation = ?");
            ps.setInt(2,participation.getCouvoiturage_id());
            ps.setInt(1,participation.getPassager_id());
            ps.setInt(3,participation.getId_participation());

            ps.executeUpdate();
        }catch (Exception ignored){
            System.out.println(ignored.getMessage());
                    

        }
    }

    @Override
    public List<Participation> afficher() {
        try{
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM PARTICIPATION WHERE 1");
            List<Participation> participations = new ArrayList<>();
            while(rs.next()){
               participations.add(new Participation(rs.getInt(1),rs.getInt(2),rs.getInt(3)));
            }
            return participations;
        }catch(Exception ignored){
            return null;
        }
    }

    @Override
    public void supprimer(Participation participation) {
        try{
            PreparedStatement ps = cnx.prepareStatement("DELETE FROM PARTICIPATION WHERE id_participation = ?");
            ps.setInt(1,participation.getId_participation());
            ps.executeUpdate();
        }catch (Exception ignored){

        }
    }

}
