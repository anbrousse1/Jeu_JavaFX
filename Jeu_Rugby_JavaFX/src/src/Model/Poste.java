/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src.Model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author anbrousse1
 */
public enum Poste {
    PILIER ("pilier"),
    TALONNEUR ("talonneur"),
    DEUXIEME_LIGNE ("deuxième ligne"),
    TROISIEME_LIGNE ("troisième ligne"),
    NUMERO_HUIT ("numéro huit"),
    DEMI_MELEE ("demi de mêlée"),
    DEMI_OUVERTURE ("demi d'ouverture"),
    CENTRE ("centre"),
    AILIER ("ailier"),
    ARRIERE ("arrière");
    
    private final StringProperty name = new SimpleStringProperty();
        public String getName() {return name.get();}
        private void setName(String value) {name.set(value);}
        public StringProperty nameProperty() {return name;}

    
    
    Poste(String nom){
        setName(nom);
    }
    
    public String toString(){
        return getName();
    }
    
}
