/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src.Model;

/**
 *
 * @author anbrousse1
 */
public class FabriqueRecette {
    
   public static Recette fabriqueRecette(String nom){
       return new Recette(nom);
   }
    
}
