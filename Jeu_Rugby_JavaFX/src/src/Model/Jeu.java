/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src.metier;

import java.util.ArrayList;
import java.util.List;
import javafx.beans.property.ListProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import src.persistance.Persistance;
import src.persistance.Persistance_Brut;

/**
 *
 * @author anbrousse1
 */
public class Jeu {
    List<Utilisateur> users = new ArrayList<>(); 
    
    
    private Persistance_Brut stub;
    
    
    private final ObjectProperty<Utilisateur> current_user = new SimpleObjectProperty<>();
        public Utilisateur getCurrent_user() {return current_user.get();}
        public void setCurrent_user(Utilisateur value) {current_user.set(value);}
        public ObjectProperty<Utilisateur> current_userProperty() {return current_user;}
        
    private ObservableList<Equipe> equipesObs = FXCollections.observableArrayList();
    private final ListProperty<Equipe> equipes = new SimpleListProperty<>(equipesObs);
        public ObservableList getEquipes() {return equipes.get();}
        public void setEquipes(ObservableList value) {equipes.set(value);}
        public ListProperty equipesProperty() {return equipes;}
        
        

       
    
    
    public Jeu(Persistance_Brut stub) {
        this.stub = stub;
        users = stub.getAllUsers(); 
        setEquipes(stub.getAllEquipe());
    }    
   
    
    public boolean connexion(String login, String mdp){
        for(Utilisateur u : users){
            if(u.getLogin().equals(login) && u.getMot_de_passe().equals(mdp)){
                setCurrent_user(u);
                enlever_current_Equipe();
                return true;
            }
        }
        return false;
    }

    private void enlever_current_Equipe(){
        for(Equipe e : equipes){
            if(e.getNom().equals(getCurrent_user().getEquipe().getNom())){
                equipes.remove(e);
            }
        }
    }
   
    
    
    
    
}
