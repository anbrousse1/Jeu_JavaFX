/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src.vue;

import src.ModelView.EquipeVM;
import src.Model.FabriqueMatchSeven;
import src.ModelView.JoueurVM;
import src.Model.Match;
import java.io.IOException;
import java.net.URL;
import java.text.DecimalFormat;
import java.util.ResourceBundle;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.BorderPane;

/**
 * FXML Controller class
 *
 * @author anbrousse1
 */
public class UCMatchController extends BorderPane {

    @FXML public Label nomEquipe;
    @FXML public Label niveauE;
    @FXML public ListView<EquipeVM> listEquipe;
    @FXML public ListView<JoueurVM> listJoueur;
    @FXML private Label nom;    
    @FXML private Label niveau;
    @FXML private Label label_niveau;
    @FXML private Button btn_affronter;
    
    MainController main;
    
    public UCMatchController(MainController main) {
        this.main = main;
         try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/UCMatch.fxml"));
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
        niveauE.textProperty().bindBidirectional(main.jeu.getCurrent_user().getEquipe().niveauProperty(), new DecimalFormat());
        listEquipe.itemsProperty().bind(main.jeu.equipesProperty());
        affichageComposant(false);   
        listEquipe.getSelectionModel().selectedItemProperty().addListener((o,old,newV)->{
            affichageComposant(true);
            if (old != null) {
                unbind(old);
                listJoueur.itemsProperty().unbind();
            }
            if (newV != null) {
                bind(newV);
                listJoueur.itemsProperty().bind(newV.joueursProperty());

            }
        });          
        
          
    }
    
    private void unbind(EquipeVM old){
        nom.textProperty().unbindBidirectional(old.nomProperty());
        niveau.textProperty().unbindBidirectional(old.niveauProperty());
    }
    
    private void bind(EquipeVM newV){
        nom.textProperty().bindBidirectional(newV.nomProperty());
        niveau.textProperty().bindBidirectional(newV.niveauProperty(),new DecimalFormat());
    }    

    private void affichageComposant(boolean b){
        label_niveau.setVisible(b);
        btn_affronter.setVisible(b);
        listJoueur.setVisible(b);
    }
    
    public void affronter(Event e){
        Match m = FabriqueMatchSeven.rencontre(main.jeu.getCurrent_user().getEquipe(), listEquipe.getSelectionModel().getSelectedItem(), 1);
        MessageBox.display("Match",String.format("Votre équipe vient d'affronter l'équipe %s pour le compte de la %d journée.\n Le résultat est : %s %d - %d %s.",
                 m.getEquipeB(),m.getJournee(),m.getEquipeA(),m.getPointA(),m.getPointB(),m.getEquipeB()));
        
    }
    
    public void retour(Event e){
        UCAccueilController uc = new UCAccueilController(main);
        main.anchorpane.getChildren().clear();
        main.anchorpane.getChildren().add(uc);
        main.setAnchor(uc);
    }
}
