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
import javafx.collections.ObservableList;
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

       
    
    
    public Jeu(Persistance_Brut stub) {
        this.stub = stub;
        users = stub.getAllUsers();       
    }    
   
    
    public boolean connexion(String login, String mdp){
        for(Utilisateur u : users){
            if(u.getLogin().equals(login) && u.getMot_de_passe().equals(mdp)){
                setCurrent_user(u);
                return true;
            }
        }
        return false;
    }

   
    
    
    
    
}
