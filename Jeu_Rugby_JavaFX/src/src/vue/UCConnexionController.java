/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src.vue;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import sun.security.util.Password;

/**
 * FXML Controller class
 *
 * @author anbrousse1
 */
public class UCConnexionController extends BorderPane{

    @FXML
    TextField id;
    
    @FXML 
    PasswordField mdp; 
    
    @FXML 
    Label label;
    
    public MainController main;
    
    
    public UCConnexionController(MainController main){
        this.main = main;
        try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/UCConnexion.fxml"));
            loader.setController(this);
            loader.setRoot(this);
            loader.load();
        }catch(IOException e){
            e.printStackTrace();
        }
    }
    
    public void connexion(Event e){
        
        if(!main.jeu.connexion(id.getText(), mdp.getText())){
            label.setText("Connexion impossible, vérifier vos identifiants.");
        }else{
            UCAccueilController uc = new UCAccueilController(main);
            main.anchorpane.getChildren().clear();
            main.anchorpane.getChildren().add(uc);
            setAnchor(uc);
        }
        
        
    }

    private void setAnchor(Node u){
        AnchorPane.setBottomAnchor(u, 0.0);
        AnchorPane.setTopAnchor(u, 0.0);
        AnchorPane.setLeftAnchor(u, 0.0);
        AnchorPane.setRightAnchor(u, 0.0);
    }
    

    
}
