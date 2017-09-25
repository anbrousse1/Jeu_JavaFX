/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src.persistance;

import src.metier.Equipe;
import src.metier.Joueur;
import src.metier.Poste;
import src.metier.Utilisateur;
import java.util.ArrayList;
import java.util.List;
import javafx.beans.property.ListProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.collections.ObservableList;

/**
 *
 * @author anbrousse1
 */
public class Persistance_Brut implements Persistance {
   
    private final ListProperty<Equipe> equipes = new SimpleListProperty<>();
    public ObservableList getEquipes() {return equipes.get();}
    private void setEquipes(ObservableList value) {equipes.set(value);}
    public ListProperty equipesProperty() {return equipes;}  
    
    private final ListProperty<Joueur> joueurs = new SimpleListProperty<>();
    public ObservableList getJoueurs() {return joueurs.get();}
    private void setJoueurs(ObservableList value) {joueurs.set(value);}
    public ListProperty JoueursProperty() {return joueurs;}  
    
    public List<Utilisateur> user = new ArrayList<>();

    public Equipe asm = new Equipe("ASM");
    public Equipe rct = new Equipe("RCT");
    

  
    public ObservableList<Equipe> getAllEquipe(){ 
        
        asm.ajouterJoueur(new Joueur("Jarvis", "Aaron", 30, 80, 75, Poste.PILIER));
        asm.ajouterJoueur(new Joueur("Kayser", "Benjamin", 29, 83, 57, Poste.TALONNEUR));
        asm.ajouterJoueur(new Joueur("Chaume", "Raphaël", 25, 85, 52, Poste.PILIER));
        asm.ajouterJoueur(new Joueur("Parra", "Morgan", 29, 85, 75, Poste.DEMI_MELEE));
        asm.ajouterJoueur(new Joueur("Lopez", "Camille", 26, 86, 87, Poste.DEMI_OUVERTURE));       
        asm.ajouterJoueur(new Joueur("Fofana", "Wesley", 29, 87, 85, Poste.CENTRE));
        asm.ajouterJoueur(new Joueur("Rougerie", "Aurélien", 35, 82, 74, Poste.AILIER));
        asm.editer_equipe_random();
        
        rct.ajouterJoueur(new Joueur("Fresia", "Florian", 25, 81, 75, Poste.PILIER));
        rct.ajouterJoueur(new Joueur("Guirado", "Guilhem", 29, 85, 65, Poste.TALONNEUR));
        rct.ajouterJoueur(new Joueur("Chocci", "Xavier", 28, 79, 52, Poste.PILIER));
        rct.ajouterJoueur(new Joueur("Escande", "Eric", 25, 78, 75, Poste.DEMI_MELEE));
        rct.ajouterJoueur(new Joueur("Belleau", "Anthony", 25, 82, 75, Poste.DEMI_OUVERTURE));
        rct.ajouterJoueur(new Joueur("Bastaraud", "Mathieu", 25, 85, 75, Poste.CENTRE));
        rct.ajouterJoueur(new Joueur("Tuisova", "joah", 25, 81, 75, Poste.AILIER));
        rct.editer_equipe_random();
        
        getEquipes().add(asm);
        getEquipes().add(rct);
        
        return getEquipes();        
    }
    
    public ObservableList<Joueur> getJoueur(String equipe){
        switch(equipe){
            case "ASM" : 
                joueurs.add(new Joueur("Jarvis", "Aaron", 30, 80, 75, Poste.PILIER));
                joueurs.add(new Joueur("Kayser", "Benjamin", 29, 83, 57, Poste.TALONNEUR));
                joueurs.add(new Joueur("Chaume", "Raphaël", 25, 85, 52, Poste.PILIER));
                joueurs.add(new Joueur("Parra", "Morgan", 29, 85, 75, Poste.DEMI_MELEE));
                joueurs.add(new Joueur("Lopez", "Camille", 26, 86, 87, Poste.DEMI_OUVERTURE));       
                joueurs.add(new Joueur("Fofana", "Wesley", 29, 87, 85, Poste.CENTRE));
                joueurs.add(new Joueur("Rougerie", "Aurélien", 35, 82, 74, Poste.AILIER));
                break;
            case "RCT" : 
                joueurs.add(new Joueur("Fresia", "Florian", 25, 81, 75, Poste.PILIER));
                joueurs.add(new Joueur("Guirado", "Guilhem", 29, 85, 65, Poste.TALONNEUR));
                joueurs.add(new Joueur("Chocci", "Xavier", 28, 79, 52, Poste.PILIER));
                joueurs.add(new Joueur("Escande", "Eric", 25, 78, 75, Poste.DEMI_MELEE));
                joueurs.add(new Joueur("Belleau", "Anthony", 25, 82, 75, Poste.DEMI_OUVERTURE));
                joueurs.add(new Joueur("Bastaraud", "Mathieu", 25, 85, 75, Poste.CENTRE));
                joueurs.add(new Joueur("Tuisova", "joah", 25, 81, 75, Poste.AILIER));
                break;
        }
        return joueurs;
        
    }
    
    public List<Utilisateur> getAllUsers(){
        user.add(new Utilisateur("toto", "otot", "toto", "1234", new Equipe("ASM",getJoueur("ASM"))));
        user.add(new Utilisateur("Chucky", "chuck", "chucky", "1234", rct));
        return user;
    }
    
    public void ajouter_Utilisateur(Utilisateur u){
        user.add(u);
    }
}
