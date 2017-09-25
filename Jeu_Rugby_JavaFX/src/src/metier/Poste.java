/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src.metier;

/**
 *
 * @author anbrousse1
 */
public enum Poste {
    PILIER ("pilier"),
    TALONNEUR ("talonneur"),
    DEUXIEME_LIGNE ("deuxième ligne"),
    TROISIEME_LIGNE ("troisième ligne"),
    NUMERO_HUIT ("numéro huit"),
    DEMI_MELEE ("demi de mêlée"),
    DEMI_OUVERTURE ("demi d'ouverture"),
    CENTRE ("centre"),
    AILIER ("ailier"),
    ARRIERE ("arrière");
    
    private String name = "";
    
    Poste(String nom){
        this.name = nom;
    }
    
    public String toString(){
        return name;
    }
    
}
