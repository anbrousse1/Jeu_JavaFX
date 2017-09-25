/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src.metier;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;


/**
 *
 * @author anbrousse1
 */
public class Joueur {
    private String nom;
    private String prenom;
    private int age;
    private int niveau;
    private int force_entrainement;
    private Poste poste;
    
    private final StringProperty info = new SimpleStringProperty();
    public String getInfo() {return info.get(); }
    private void setInfo(String value) {info.set(value);}
    public StringProperty infoProperty() {return info;}

   

    public Joueur(String nom, String prenom, int age, int niveau, int force_entrainement,Poste poste) {
        this.nom = nom;
        this.prenom = prenom;
        this.age = age;
        this.niveau = niveau;
        this.force_entrainement = force_entrainement;
        this.poste = poste;
        
        setInfo(String.format("nom : %s prénom : %s âge : %d niveau : %d poste : %s\n",getNom(),getPrenom(),getAge(),getNiveau(),getPoste()));
    }
    
    
    
    
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getNiveau() {
        return niveau;
    }

    public void setNiveau(int niveau) {
        this.niveau = niveau;
    }

    public int getForce_entrainement() {
        return force_entrainement;
    }

    public Poste getPoste() {
        return poste;
    }
    

    public void setForce_entrainement(int force_entrainement) {
        this.force_entrainement = force_entrainement;
    }
    
    
    public void entrainer(Entrainement e){
        force_entrainement += e.getForce();
        
        if(force_entrainement >= 100){
            niveau += 1;
            force_entrainement = force_entrainement - 100;
        }
                
    }

    @Override
    public String toString() {
        return String.format("nom : %s prénom : %s âge : %d niveau : %d poste : %s\n",getNom(),getPrenom(),getAge(),getNiveau(),getPoste());
    }  
    
    
    
    
}
