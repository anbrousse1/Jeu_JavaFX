/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src.ModelView;

import src.ModelView.JoueurVM;
import java.util.ArrayList;
import java.util.Dictionary;
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
import src.Model.Equipe;
import src.Model.Joueur;
import src.Model.Match;

/**
 *
 * @author anbrousse1
 */
public class EquipeVM {

    private final StringProperty nom = new SimpleStringProperty();
    public String getNom() {return nom.get();}
    private void setNom(String value) {nom.set(value);}
    public StringProperty nomProperty() {return nom;}
    
    private final IntegerProperty niveau = new SimpleIntegerProperty();
        public int getNiveau() {return niveau.get();}
        public void setNiveau(int value) {niveau.set(value);}
        public IntegerProperty niveauProperty() {return niveau;}
    
    
    private int nb_joueur;
    
    private ObservableList<JoueurVM> joueursObs = FXCollections.observableArrayList();
    private final ListProperty<JoueurVM> joueurs = new SimpleListProperty<>(joueursObs);
        public ObservableList<JoueurVM> getJoueurs() {return joueurs.get();}
        private void setJoueurs(ObservableList<JoueurVM> value) {joueurs.set(value);}
        public ListProperty<JoueurVM> joueursProperty() {return joueurs;}    

   
    
    
    
    
    private List<Match> match;
    
    Map<Integer,JoueurVM> equipes = new HashMap<>();
    Equipe equipe ; 
            
    public EquipeVM(String nom) {
        equipe = new Equipe(nom);
        setNom(nom);
        setNiveau(0);
        this.nb_joueur = 0;
    }
    
    public EquipeVM(String nom,ObservableList<JoueurVM> joueurs){
        equipe = new Equipe(nom, retourneJoueurs(joueurs));
        setNom(nom);
        setNiveau(0);
        setJoueurs(joueurs);
        this.nb_joueur = joueurs.size();
        
    }
    
    public ObservableList<Joueur> retourneJoueurs(ObservableList<JoueurVM> joueurs){
        ObservableList<Joueur> list = FXCollections.observableArrayList();
        for(JoueurVM j : joueurs){
            list.add(j.joueur);
        }
        return list;
    }


    
    public void ajouterJoueur(JoueurVM j){
        getJoueurs().add(j);
        equipe.ajouterJoueur(j.joueur);
        nb_joueur ++;
    }
    
    public void ajouterMatch(Match m){
        match.add(m);
    }
    
   

   
    public void setNb_joueur(int nb_joueur) {
        this.nb_joueur = nb_joueur;
    }

  

    public int getNb_joueur() {
        return nb_joueur;
    }

    public Map<Integer, JoueurVM> getEquipes() {
        return equipes;
    }


    public List<Match> getMatch() {
        return match;
    }
    
    
    
    
    
    
    
    public void editer_equipe_random(){
        int i = 1;
        for(JoueurVM j : getJoueurs()){
            if(i > 7){
                return;
            }
            equipes.put(i, j);
            i++;
        }
    }
   
   
    public void up_niveau(int i) {
        setNiveau(getNiveau() + i);
    }

    public void down_niveau(int i) {
        if(getNiveau()- i < 0){
            
        }else{
            setNiveau(getNiveau() - i);
 
        }
    }

    @Override
    public String toString() {
        return getNom();
    }
    
    


    
    
}
