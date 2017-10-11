/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src.Model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ListProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import src.ModelView.JoueurVM;

/**
 *
 * @author anbrousse1
 */
public class Equipe {
    
    private String nom;
    private int niveau;
    private int nb_joueur;
    
    private ObservableList<Joueur> joueursObs = FXCollections.observableArrayList();     

    private List<Match> match;
    
    Map<Integer,Joueur> equipes = new HashMap<>();
    
    public Equipe(String nom) {
        setNom(nom);
        setNiveau(0);
        this.nb_joueur = 0;
    }
    
    public Equipe(String nom,ObservableList<Joueur> joueurs){
        setNom(nom);
        setNiveau(0);
        setJoueursObs(joueurs);
        this.nb_joueur = joueurs.size();
        
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getNiveau() {
        return niveau;
    }

    public void setNiveau(int niveau) {
        this.niveau = niveau;
    }

    public int getNb_joueur() {
        return nb_joueur;
    }

    public void setNb_joueur(int nb_joueur) {
        this.nb_joueur = nb_joueur;
    }

    public ObservableList<Joueur> getJoueursObs() {
        return joueursObs;
    }

    public void setJoueursObs(ObservableList<Joueur> joueursObs) {
        this.joueursObs = joueursObs;
    }

    public List<Match> getMatch() {
        return match;
    }

    public void setMatch(List<Match> match) {
        this.match = match;
    }

    public Map<Integer, Joueur> getEquipes() {
        return equipes;
    }

    public void setEquipes(Map<Integer, Joueur> equipes) {
        this.equipes = equipes;
    }
    
    public void ajouterJoueur(Joueur j){
        joueursObs.add(j);
        nb_joueur ++ ;
    }
    
}
