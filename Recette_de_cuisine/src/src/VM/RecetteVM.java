/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src.VM;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import src.Model.Recette;

/**
 *
 * @author anbrousse1
 */
public class RecetteVM {
    
    private Recette model;
    
    private final StringProperty nom = new SimpleStringProperty();
        public String getNom() {return nom.get();}
        public void setNom(String value) {
            nom.set(value);
        }
        public StringProperty nomProperty() {return nom;}

    public RecetteVM(String nom) {
        model = new Recette(nom);
        setNom(nom);
        nomProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                model.setNom(newValue);
            }
        });
        
    }

    public Recette getModel() {
        return model;
    }

    public void setModel(Recette model) {
        this.model = model;
    }

    @Override
    public String toString() {
        return model.toString();
    }
    
    
    
    
        
    
}
