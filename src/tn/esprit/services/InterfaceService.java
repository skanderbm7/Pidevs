/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package tn.esprit.services;

import java.util.List;

/**
 *
 * @author Pc
 * @param <T>
 */
public interface InterfaceService <T>{
    public void ajouter(T t);
    public void modifier(T t);
    public List<T> afficher();
    public void supprimer(T t);
}
