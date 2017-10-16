/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src.Model;

import java.io.Serializable;

/**
 *
 * @author anbrousse1
 */
public class Recette implements Serializable {

    private String nom;

    public Recette(String nom) {
        setNom(nom);
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
    

    @Override
    public String toString() {
        return nom;
    }
    
    
    
    
    
    
}
