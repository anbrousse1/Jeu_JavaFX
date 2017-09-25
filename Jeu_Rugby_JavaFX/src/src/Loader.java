/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import static javafx.fxml.FXMLLoader.load;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author anbrousse1
 */
public class Loader extends Application{

    @Override
    public void start(Stage primaryStage) throws Exception {
        
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/main.fxml"));
        Scene scene = new Scene(root);
        primaryStage.setTitle("Jeu de rugby");
        primaryStage.setScene(scene);
        primaryStage.show();
        
        
    }    
    

    
}
