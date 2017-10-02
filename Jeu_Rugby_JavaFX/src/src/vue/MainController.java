/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src.vue;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.layout.AnchorPane;
import src.metier.Jeu;
import src.persistance.Persistance_Brut;

/**
 * FXML Controller class
 *
 * @author anbrousse1
 */
public class MainController {

    @FXML public AnchorPane anchorpane;
        
    Jeu jeu = new Jeu(new Persistance_Brut());
    
    @FXML
    public void initialize() {
        UCConnexionController uc = new UCConnexionController(this);
        anchorpane.getChildren().clear();
        anchorpane.getChildren().add(uc);
        setAnchor(uc);        
    }

    public static void setAnchor(Node u){
        AnchorPane.setBottomAnchor(u, 0.0);
        AnchorPane.setTopAnchor(u, 0.0);
        AnchorPane.setLeftAnchor(u, 0.0);
        AnchorPane.setRightAnchor(u, 0.0);
    }
    
    
}
