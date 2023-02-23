/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tn.esprit.entities;

/**
 *
 * @author Pc
 */
public class Participation {
    private int id_participation;
    private int couvoiturage_id;
    private int passager_id;

    public Participation(int couvoiturage_id, int passager_id) {
        this.couvoiturage_id = couvoiturage_id;
        this.passager_id = passager_id;
    }

    public Participation(int id_participation, int couvoiturage_id, int passager_id) {
        this.id_participation = id_participation;
        this.couvoiturage_id = couvoiturage_id;
        this.passager_id = passager_id;
    }
    

    public int getId_participation() {
        return id_participation;
    }

    public void setId_participation(int id_participation) {
        this.id_participation = id_participation;
    }

    public int getCouvoiturage_id() {
        return couvoiturage_id;
    }

    public void setCouvoiturage_id(int couvoiturage_id) {
        this.couvoiturage_id = couvoiturage_id;
    }

    public int getPassager_id() {
        return passager_id;
    }

    public void setPassager_id(int passager_id) {
        this.passager_id = passager_id;
    }

    @Override
    public String toString() {
        return "Participation{" + "id_participation=" + id_participation + ", couvoiturage_id=" + couvoiturage_id + ", passager_id=" + passager_id + '}';
    }
    
    

}

