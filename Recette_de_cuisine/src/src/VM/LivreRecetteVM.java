/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src.VM;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import javafx.beans.property.ListProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import src.Model.FabriqueRecette;
import src.Model.LivreRecette;
import src.Model.Recette;

/**
 *
 * @author anbrousse1
 */
public class LivreRecetteVM implements PropertyChangeListener {

    private LivreRecette model;

    private ObservableList<RecetteVM> recetteObs = FXCollections.observableArrayList();
    private final ListProperty<RecetteVM> recettes = new SimpleListProperty<>(recetteObs);

    public ObservableList getRecettes() {
        return recettes.get();
    }

    public void setRecettes(ObservableList value) {
        recettes.set(value);
    }

    public ListProperty recettesProperty() {
        return recettes;
    }

    private final StringProperty nom = new SimpleStringProperty();

    public String getNom() {
        return nom.get();
    }

    public void setNom(String value) {
        nom.set(value);
    }

    public StringProperty nomProperty() {
        return nom;
    }

    public LivreRecetteVM(String nom) {
        model = new LivreRecette(nom);
        setNom(nom);
        model.addPropertyChangeListener(this);
    }

    public LivreRecetteVM(LivreRecette model) {
        if (model == null) {
            this.model = new LivreRecette("default");
        } else {
            this.model = model;
            setNom(model.getNom());

            for (Recette r : model.getRecettes()) {
                RecetteVM rVM = new RecetteVM(r);
                this.getRecettes().add(rVM);
            }
        }

        this.model.addPropertyChangeListener(this);

    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        Recette r = (Recette) evt.getNewValue();
        RecetteVM rvm = new RecetteVM(r);
        rvm.setModel(r);
        recettes.add(rvm);

    }

    public LivreRecette getModel() {
        return model;
    }

    public void setModel(LivreRecette model) {
        this.model = model;
    }

    public ObservableList<RecetteVM> getRecetteObs() {
        return recetteObs;
    }

    public void setRecetteObs(ObservableList<RecetteVM> recetteObs) {
        this.recetteObs = recetteObs;
    }

    public void ajouterRecette(String nom) {
        model.ajouterRecette(recetteObs.size(), FabriqueRecette.fabriqueRecette(nom));
    }

    public void creerRecette(String nom) {
        model.ajouterRecette(recetteObs.size(), nom);
    }

    @Override
    public String toString() {
        return model.toString();
    }

}
