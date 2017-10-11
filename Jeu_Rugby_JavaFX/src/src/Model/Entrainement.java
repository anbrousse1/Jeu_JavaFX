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
public enum Entrainement {
    MUSCUlATION ("musculation",1),
    OPPOSITION ("opposition",2),
    PHYSIQUE ("physique",3);
    
    private String name = "";
    private int force = 0;
    
    Entrainement(String name,int force){
        this.name = name;
        this.force = force;
    }
    
    public String toString(){
        return name;
    }

    public int getForce() {
        return force;
    }
    
    
    
}
