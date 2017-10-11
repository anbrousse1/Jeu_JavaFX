/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src.Model;


import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author anbrousse1
 */
public class LivreRecette  {
        
    private String nom;
    
    public LivreRecette(String nom){
        setNom(nom);
    }
    
        private List<Recette> recettes = new ArrayList<>();

    public static final String PROP_RECETTES = "recettes";

    /**
     * Get the value of recettes
     *
     * @return the value of recettes
     */
    public List<Recette> getRecettes() {
        return recettes;
    }

    /**
     * Set the value of recettes
     *
     * @param recettes new value of recettes
     */
    public void setRecettes(List<Recette> recettes) {
        List<Recette> oldRecettes = this.recettes;
        this.recettes = recettes;
        propertyChangeSupport.firePropertyChange(PROP_RECETTES, oldRecettes, recettes);
    }

    private transient final PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this);

    /**
     * Add PropertyChangeListener.
     *
     * @param listener
     */
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        propertyChangeSupport.addPropertyChangeListener(listener);
    }

    /**
     * Remove PropertyChangeListener.
     *
     * @param listener
     */
    public void removePropertyChangeListener(PropertyChangeListener listener) {
        propertyChangeSupport.removePropertyChangeListener(listener);
    }


    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
    
    
    public void ajouterRecette(int index,String nom){
        Recette r = FabriqueRecette.fabriqueRecette(nom);
        propertyChangeSupport.fireIndexedPropertyChange(PROP_RECETTES, index, null, r);
        recettes.add(r);
    }
    
    public void ajouterRecette(int index,Recette r){
        propertyChangeSupport.fireIndexedPropertyChange(PROP_RECETTES, index, null, r);
        recettes.add(r);
    }
    
    
}
