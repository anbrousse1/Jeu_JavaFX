/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src.Vue;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.util.Callback;
import src.VM.LivreRecetteVM;
import src.VM.RecetteVM;

/**
 * FXML Controller class
 *
 * @author anbrousse1
 */
public class MainController {
    LivreRecetteVM livreRecette;  
    
    @FXML ListView<RecetteVM> liste_recette;    
    @FXML Label nomLivre;
    @FXML TextField nom_recette;
    
    @FXML
    public void initialize() {
        livreRecette = new LivreRecetteVM("Mes recettes");
        livreRecette.ajouterRecette("Tête de veau");
        livreRecette.ajouterRecette("Pot au feu");


        
        nomLivre.textProperty().bind(livreRecette.nomProperty());
        liste_recette.itemsProperty().bind(livreRecette.recettesProperty());
        
        liste_recette.getSelectionModel().selectedItemProperty().addListener((o,old,newV) -> {
            if(old != null){
                unbind(old);
            }
            if(newV != null){
                bind(newV);
            }
            
            
        }); 
        
        liste_recette.setCellFactory((param) -> {
        return new ListCell<RecetteVM>(){
            @Override
            protected void updateItem(RecetteVM item, boolean empty) {
                super.updateItem(item, empty);
                    if (empty) {
                        textProperty().unbind();
                        setText("");
                    }else{
                        textProperty().bind(item.nomProperty());

                    }
                }
            };
        });
       
    }    
    
    public void bind(RecetteVM newV){
        nom_recette.textProperty().bindBidirectional(newV.nomProperty());
    }
    
    public void unbind(RecetteVM old){
        nom_recette.textProperty().unbindBidirectional(old.nomProperty());
    }
    
    
    public void ajouter(Event e){
        livreRecette.ajouterRecette("patate");
    }
}

