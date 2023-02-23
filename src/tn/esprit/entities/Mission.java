/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tn.esprit.entities;

import java.sql.Date;

/**
 *
 * @author Pc
 */
public class Mission {
    private int id_mission;

    @Override
    public String toString() {
        return "Mission{" + "id_mission=" + id_mission + ", date_livrison=" + date_livrison + ", solde_livrison=" + solde_livrison + ", id_livreur=" + id_livreur + ", adresse_des=" + adresse_des + ", num_des=" + num_des + ", id_colis=" + id_colis + '}';
    }
    private Date date_livrison;
    private int solde_livrison;
    private int id_livreur; 
    private String adresse_des;
    private int num_des;
    private int id_colis;

    public Mission(Date date_livrison, int solde_livrison, int id_livreur, String adresse_des, int num_des, int id_colis) {
        this.date_livrison = date_livrison;
        this.solde_livrison = solde_livrison;
        this.id_livreur = id_livreur;
        this.adresse_des = adresse_des;
        this.num_des = num_des;
        this.id_colis = id_colis;
    }

    public Mission(int id_mission, Date date_livrison, int solde_livrison, int id_livreur, String adresse_des, int num_des, int id_colis) {
        this.id_mission = id_mission;
        this.date_livrison = date_livrison;
        this.solde_livrison = solde_livrison;
        this.id_livreur = id_livreur;
        this.adresse_des = adresse_des;
        this.num_des = num_des;
        this.id_colis = id_colis;
    }

    public int getId_mission() {
        return id_mission;
    }

    public void setId_mission(int id_mission) {
        this.id_mission = id_mission;
    }

    public Date getDate_livrison() {
        return date_livrison;
    }

    public void setDate_livrison(Date date_livrison) {
        this.date_livrison = date_livrison;
    }

    public int getSolde_livrison() {
        return solde_livrison;
    }

    public void setSolde_livrison(int solde_livrison) {
        this.solde_livrison = solde_livrison;
    }

    public int getId_livreur() {
        return id_livreur;
    }

    public void setId_livreur(int id_livreur) {
        this.id_livreur = id_livreur;
    }

    public String getAdresse_des() {
        return adresse_des;
    }

    public void setAdresse_des(String adresse_des) {
        this.adresse_des = adresse_des;
    }

    public int getNum_des() {
        return num_des;
    }

    public void setNum_des(int num_des) {
        this.num_des = num_des;
    }

    public int getId_colis() {
        return id_colis;
    }

    public void setId_colis(int x) {
        this.id_colis = x;
    }
    
}
