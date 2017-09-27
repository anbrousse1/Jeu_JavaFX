/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src.vue;

import java.io.IOException;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Random;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.layout.BorderPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import src.metier.Entrainement;
import src.metier.Joueur;

/**
 *
 * @author anbrousse1
 */
public class UCAccueilController extends BorderPane{

    @FXML public Label nomEquipe;
    @FXML public ListView<Joueur> listjoueur;
    @FXML private Label nom;
    @FXML private Label prenom;
    @FXML private Label age;
    @FXML private Label niveau;
    @FXML private Label poste;
    @FXML private Label label_age;
    @FXML private Label label_niveau;
    @FXML private Label label_poste;
    @FXML private Button btn_entrainer;

    
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
        nomEquipe.textProperty().bind(main.jeu.getCurrent_user().getEquipe().nomProperty());        
        listjoueur.itemsProperty().bind(main.jeu.getCurrent_user().getEquipe().joueursProperty());
        affichageComposant(false);   
        listjoueur.getSelectionModel().selectedItemProperty().addListener((o,old,newV)->{
            affichageComposant(true);
            if (old != null) {
                unbind(old);              
            }
            if (newV != null) {
                bind(newV);              
            }
        });        
          
    }
    
    private void unbind(Joueur old){
        nom.textProperty().unbindBidirectional(old.nomProperty());
        prenom.textProperty().unbindBidirectional(old.prenomProperty());
        age.textProperty().unbindBidirectional(old.ageProperty());
        niveau.textProperty().unbindBidirectional(old.niveauProperty());
        poste.textProperty().unbindBidirectional(old.getPoste().nameProperty());
    }
    
    private void bind(Joueur newV){
        nom.textProperty().bindBidirectional(newV.nomProperty());
        prenom.textProperty().bindBidirectional(newV.prenomProperty());
        age.textProperty().bindBidirectional(newV.ageProperty(),new DecimalFormat());
        niveau.textProperty().bindBidirectional(newV.niveauProperty(),new DecimalFormat());
        poste.textProperty().bindBidirectional(newV.getPoste().nameProperty());
    }
    
    private void affichageComposant(boolean b){
        label_age.setVisible(b);
        label_niveau.setVisible(b);
        label_poste.setVisible(b);
        btn_entrainer.setVisible(b);
    }
    
    
    
     public void entrainer(Event e){
         Entrainement[] entrainements = Entrainement.values();         
         int max = 3;
         int min = 0;
         int range = max - min + 1;		
	 int rand = (int) (Math.random()* range) + min;
         listjoueur.getSelectionModel().getSelectedItem().entrainer(entrainements[rand]);
         
         MessageBox.display("Entrainement",String.format("Le joueur vient de réaliser un entrainement du type %s : \n Sa force d'entrainement a augmenté de %d",
                 entrainements[rand].toString(),entrainements[rand].getForce()));
         
      
    }
    
    
}
