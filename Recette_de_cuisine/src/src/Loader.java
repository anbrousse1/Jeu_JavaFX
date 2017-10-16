/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src;

import Persistance.Persistance;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import src.Model.LivreRecette;
import src.VM.LivreRecetteVM;
import src.Vue.MainController;

/**
 *
 * @author anbrousse1
 */
public class Loader extends Application{

    @Override
    public void start(Stage primaryStage) throws Exception {
        LivreRecette livreRecette = Persistance.load();
        MainController mainctrl = new MainController(livreRecette);
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/main.fxml"));
        loader.setController(mainctrl);
        Parent root = loader.load();        
        Scene scene = new Scene(root);
        primaryStage.setTitle("Recette de cuisine");
        primaryStage.setScene(scene);
        primaryStage.show();
        
        
    }    

    @Override
    public void stop() throws Exception {
        super.stop(); 
        Persistance.save(MainController.livreRecette.getModel());
    }
    
    
    

    
}