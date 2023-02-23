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
import tn.esprit.entities.Mission;
import tn.esprit.utils.MaConnection;

/**
 *
 * @author Pc
 */
public class MissionService implements InterfaceService <Mission> {
    private final Connection cnx = MaConnection.getInstance().getCnx();

    @Override
    public void ajouter(Mission t) {
             try{
            PreparedStatement ps = cnx.prepareStatement("INSERT INTO MISSION (date_livraison,solde_livraison,id_livreur,adresse_des,num_des,id_colis) values (?,?,?,?,?,?)");
            ps.setDate(1,t.getDate_livrison());
            ps.setInt(2,t.getSolde_livrison());
            ps.setInt(3,t.getId_livreur());
            ps.setString(4,t.getAdresse_des());
            ps.setInt(5,t.getNum_des());
            ps.setInt(6,t.getId_colis());
            ps.executeUpdate();
                 System.out.println("mission ajout avec succes");
        }catch(Exception ignored){
                 System.out.println(ignored.getMessage());
        }
    }

    @Override
    public void modifier(Mission t) {
        try{
            PreparedStatement ps = cnx.prepareStatement("UPDATE MISSION set date_livrison = ? , solde_livrison = ? , id_livreur = ? , adresse_des = ? , num_des = ? , id_colis = ?  where id_mission = ?");
            ps.setDate(1,t.getDate_livrison());
            ps.setInt(2,t.getSolde_livrison());
            ps.setInt(3,t.getId_livreur());
            ps.setString(4,t.getAdresse_des());
            ps.setInt(5,t.getNum_des());
            ps.setInt(6,t.getId_colis());
            ps.setInt(7,t.getId_mission());

            ps.executeUpdate();
        }catch(Exception ignored){
    }
    }

    @Override
    public List<Mission> afficher() {
try{
            Statement st =  cnx.createStatement();
            ResultSet rs = st.executeQuery("select * from mission ");
            List<Mission> liste_Mission = new ArrayList<>();
            while(rs.next()){
                liste_Mission.add(new Mission(rs.getInt(1), rs.getDate(2), rs.getInt(3) , rs.getInt(4) , rs.getString(5) , rs.getInt(6),rs.getInt(7)));
            }
            System.out.println(liste_Mission);
            return liste_Mission;
        }catch(Exception ignored){
            
            System.out.println(ignored.getMessage());
            return null;
        }
    }

    @Override
    public void supprimer(Mission t) {
              try{
            PreparedStatement ps = cnx.prepareStatement("DELETE FROM MISSION WHERE id_mission  = ?");
            ps.setInt(1,t.getId_mission());
            ps.executeUpdate();
        }catch(Exception ignored){
            
        }
    }
}
