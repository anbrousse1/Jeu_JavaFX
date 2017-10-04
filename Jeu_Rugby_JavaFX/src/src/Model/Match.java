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
public class Match {
    private int journee;
    private Equipe equipeA;
    private Equipe equipeB;
    private int pointA;
    private int pointB;
    

    public Match(int journee, Equipe equipeA, Equipe equipeB, int pointA, int pointB) {
        this.journee = journee;
        this.equipeA = equipeA;
        this.equipeB = equipeB;
        this.pointA = pointA;
        this.pointB = pointB;
    }

    public int getJournee() {
        return journee;
    }

    public Equipe getEquipeA() {
        return equipeA;
    }

    public Equipe getEquipeB() {
        return equipeB;
    }

    public int getPointA() {
        return pointA;
    }

    public int getPointB() {
        return pointB;
    }
    
    
    
    
}
