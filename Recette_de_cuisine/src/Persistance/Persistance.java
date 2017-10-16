/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistance;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import static java.lang.System.in;
import java.util.logging.Level;
import java.util.logging.Logger;
import src.Model.LivreRecette;
import src.Model.Recette;
import src.VM.LivreRecetteVM;
import src.VM.RecetteVM;

/**
 *
 * @author anbrousse1
 */
public class Persistance {
    
    public static void save(LivreRecette livre){
        
        ObjectOutputStream oos = null;
        try {
            File file = new File("livre.bin");
            oos = new ObjectOutputStream(new FileOutputStream(file));
            oos.writeObject(livre);
        } catch (IOException ex) {
            Logger.getLogger(Persistance.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                oos.close();
            } catch (IOException ex) {
                Logger.getLogger(Persistance.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public static LivreRecette load(){
        ObjectInputStream ooi = null;
        LivreRecette livre = null;
        try {
            File file = new File("livre.bin");
            ooi = new ObjectInputStream(new FileInputStream(file));
            livre = (LivreRecette) ooi.readObject();            
        } catch (IOException ex) {
            Logger.getLogger(Persistance.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Persistance.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                ooi.close();
            } catch (IOException ex) {
                Logger.getLogger(Persistance.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return livre;
    }
}
