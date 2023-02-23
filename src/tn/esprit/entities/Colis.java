/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tn.esprit.entities;

/**
 *
 * @author Pc
 */
public class Colis {
    public int id_colis	;
    public String categorie;
    public int poids ;

    @Override
    public String toString() {
        return "Colis{ categorie=" + categorie + ", poids=" + poids + '}';
    }

    public Colis() {
    }

    public Colis(int id_colis, String categorie, int poids) {
        this.id_colis = id_colis;
        this.categorie = categorie;
        this.poids = poids;
    }
    public Colis( String categorie, int poids) {
        this.categorie = categorie;
        this.poids = poids;
    }

    public int getId_colis() {
        return id_colis;
    }

    public void setId_colis(int id_colis) {
        this.id_colis = id_colis;
    }

    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    public int getPoids() {
        return poids;
    }

    public void setPoids(int poids) {
        this.poids = poids;
    }
    
}
  