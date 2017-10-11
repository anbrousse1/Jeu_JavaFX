/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src.persistance;

import com.sun.javafx.collections.ElementObservableListDecorator;
import src.ModelView.EquipeVM;
import src.ModelView.JoueurVM;
import src.Model.Poste;
import src.Model.Utilisateur;
import java.util.ArrayList;
import java.util.List;
import javafx.beans.property.ListProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author anbrousse1
 */
public class Persistance_Brut implements Persistance {
   
   
    private ObservableList<EquipeVM> equipesobs = FXCollections.observableArrayList();
    private final ListProperty<EquipeVM> equipes = new SimpleListProperty<EquipeVM>(equipesobs);
        public ObservableList<EquipeVM> getEquipes() {return equipes.get();}
        private void setEquipes(ObservableList<EquipeVM> value) {equipes.set(value);}
        public ListProperty<EquipeVM> equipesProperty() {return equipes;}
        
    private ObservableList<JoueurVM> joueursObs = FXCollections.observableArrayList();
    private final ListProperty<JoueurVM> joueurs = new SimpleListProperty<>(joueursObs);
        public ObservableList<JoueurVM> getJoueurs() {return joueurs.get();}
        private void setJoueurs(ObservableList<JoueurVM> value) {joueurs.set(value);}
        public ListProperty<JoueurVM> JoueursProperty() {return joueurs;}  
    
    public List<Utilisateur> user = new ArrayList<>();

    public EquipeVM asm = new EquipeVM("ASM");
    public EquipeVM rct = new EquipeVM("RCT");
    

  
    public ObservableList<EquipeVM> getAllEquipe(){ 
        
        asm.ajouterJoueur(new JoueurVM("Jarvis", "Aaron", 30, 80, 99, Poste.PILIER));
        asm.ajouterJoueur(new JoueurVM("Kayser", "Benjamin", 29, 83, 57, Poste.TALONNEUR));
        asm.ajouterJoueur(new JoueurVM("Chaume", "Raphaël", 25, 85, 52, Poste.PILIER));
        asm.ajouterJoueur(new JoueurVM("Parra", "Morgan", 29, 85, 75, Poste.DEMI_MELEE));
        asm.ajouterJoueur(new JoueurVM("Lopez", "Camille", 26, 86, 87, Poste.DEMI_OUVERTURE));       
        asm.ajouterJoueur(new JoueurVM("Fofana", "Wesley", 29, 87, 85, Poste.CENTRE));
        asm.ajouterJoueur(new JoueurVM("Rougerie", "Aurélien", 35, 82, 74, Poste.AILIER));
        asm.editer_equipe_random();
        
        rct.ajouterJoueur(new JoueurVM("Fresia", "Florian", 25, 81, 75, Poste.PILIER));
        rct.ajouterJoueur(new JoueurVM("Guirado", "Guilhem", 29, 85, 65, Poste.TALONNEUR));
        rct.ajouterJoueur(new JoueurVM("Chocci", "Xavier", 28, 79, 52, Poste.PILIER));
        rct.ajouterJoueur(new JoueurVM("Escande", "Eric", 25, 78, 75, Poste.DEMI_MELEE));
        rct.ajouterJoueur(new JoueurVM("Belleau", "Anthony", 25, 82, 75, Poste.DEMI_OUVERTURE));
        rct.ajouterJoueur(new JoueurVM("Bastaraud", "Mathieu", 25, 85, 75, Poste.CENTRE));
        rct.ajouterJoueur(new JoueurVM("Tuisova", "joah", 25, 81, 75, Poste.AILIER));
        rct.editer_equipe_random();
        
        equipesobs.add(asm);
        equipesobs.add(rct);
        
        return equipesobs;        
    }
    
    public ObservableList<JoueurVM> getJoueur(String equipe){
        switch(equipe){
            case "ASM" : 
                joueursObs.add(new JoueurVM("Jarvis", "Aaron", 30, 80, 99, Poste.PILIER));
                joueursObs.add(new JoueurVM("Kayser", "Benjamin", 29, 83, 57, Poste.TALONNEUR));
                joueursObs.add(new JoueurVM("Chaume", "Raphaël", 25, 85, 52, Poste.PILIER));
                joueursObs.add(new JoueurVM("Parra", "Morgan", 29, 85, 75, Poste.DEMI_MELEE));
                joueursObs.add(new JoueurVM("Lopez", "Camille", 26, 86, 87, Poste.DEMI_OUVERTURE));       
                joueursObs.add(new JoueurVM("Fofana", "Wesley", 29, 87, 85, Poste.CENTRE));
                joueursObs.add(new JoueurVM("Rougerie", "Aurélien", 35, 82, 74, Poste.AILIER));
                break;
            case "RCT" : 
                joueursObs.add(new JoueurVM("Fresia", "Florian", 25, 81, 75, Poste.PILIER));
                joueursObs.add(new JoueurVM("Guirado", "Guilhem", 29, 85, 65, Poste.TALONNEUR));
                joueursObs.add(new JoueurVM("Chocci", "Xavier", 28, 79, 52, Poste.PILIER));
                joueursObs.add(new JoueurVM("Escande", "Eric", 25, 78, 75, Poste.DEMI_MELEE));
                joueursObs.add(new JoueurVM("Belleau", "Anthony", 25, 82, 75, Poste.DEMI_OUVERTURE));
                joueursObs.add(new JoueurVM("Bastaraud", "Mathieu", 25, 85, 75, Poste.CENTRE));
                joueursObs.add(new JoueurVM("Tuisova", "joah", 25, 81, 75, Poste.AILIER));
                break;
        }
        return joueursObs;
        
    }
    
    public List<Utilisateur> getAllUsers(){
        user.add(new Utilisateur("toto", "otot", "toto", "1234", new EquipeVM("ASM",getJoueur("ASM"))));
        user.add(new Utilisateur("Chucky", "chuck", "chucky", "1234", rct));
        return user;
    }
    
    public void ajouter_Utilisateur(Utilisateur u){
        user.add(u);
}
}
