/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src.vue;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.layout.BorderPane;
import src.metier.Joueur;

/**
 *
 * @author anbrousse1
 */
public class UCAccueilController extends BorderPane{

    @FXML public Label nomEquipe;
    @FXML public ListView<Joueur> listjoueur;
    
    MainController main;
    
    public UCAccueilController(MainController main) {
        this.main = main;
         try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/UCAccueil.fxml"));
            loader.setController(this);
            loader.setRoot(this);
            loader.load();
        }catch(IOException e){
            e.printStackTrace();
        }
    }
    
    @FXML
    public void initialize() {
        /*nomEquipe.textProperty().bind(main.jeu.getCurrent_user().getEquipe().nomProperty());
        listjoueur.cellFactoryProperty().bind(main.jeu.getCurrent_user().getEquipe().joueursProperty());
        
        listjoueur.setCellFactory((param) -> {
            return new ListCell<Joueur>(){
                @Override
                protected void updateItem(Joueur item, boolean empty) {
                    super.updateItem(item, empty);
                        if (! empty) {
                              textProperty().bind(item.infoProperty());
                        } else {
                            textProperty().unbind();
                            setText("");
                        }
                    }
                };
        });  */ 
          
    }
    
    
}
