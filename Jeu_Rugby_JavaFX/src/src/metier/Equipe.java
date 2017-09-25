/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src.metier;

import java.util.ArrayList;
import java.util.Dictionary;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javafx.beans.property.ListProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author anbrousse1
 */
public class Equipe {

    private final StringProperty nom = new SimpleStringProperty();

    public String getNom() {
        return nom.get();
    }

    private void setNom(String value) {
        nom.set(value);
    }

    public StringProperty nomProperty() {
        return nom;
    }
    
    
    private int niveau;
    private int nb_joueur;
    
    private final ListProperty<Joueur> joueurs = new SimpleListProperty<>();
    public ObservableList getJoueurs() {return joueurs.get();}
    private void setJoueurs(ObservableList value) {joueurs.set(value);}
    public ListProperty joueursProperty() {return joueurs;}    

   
    
   
    
    
    
    private List<Match> match;
    Map<Integer,Joueur> equipes = new HashMap<>();

    public Equipe(String nom) {
        setNom(nom);
        this.niveau = 0;
        this.nb_joueur = 0;
    }
    
    public Equipe(String nom,ObservableList<Joueur> joueurs){
        setNom(nom);
        this.niveau = 0;
        setJoueurs(joueurs);
        this.nb_joueur = joueurs.size();
        
    }


    
    public void ajouterJoueur(Joueur j){
        getJoueurs().add(j);
        nb_joueur ++;
    }
    
    public void ajouterMatch(Match m){
        match.add(m);
    }
    
   

    public void setNiveau(int niveau) {
        this.niveau = niveau;
    }

    public void setNb_joueur(int nb_joueur) {
        this.nb_joueur = nb_joueur;
    }

    public int getNiveau() {
        return niveau;
    }

    public int getNb_joueur() {
        return nb_joueur;
    }

    public Map<Integer, Joueur> getEquipes() {
        return equipes;
    }


    public List<Match> getMatch() {
        return match;
    }
    
    
    
    
    
    
    
    public void editer_equipe_random(){
        int i = 1;
        for(Joueur j : joueurs){
            if(i > 7){
                return;
            }
            equipes.put(i, j);
            i++;
        }
    }
   
   
    public void up_niveau(int i) {
        setNiveau(niveau + i);
    }

    public void down_niveau(int i) {
        if(niveau - i < 0){
            
        }else{
            setNiveau(niveau - i);
 
        }
    }


    
    
}
