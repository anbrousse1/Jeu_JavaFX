/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src.Model;

import src.ModelView.EquipeVM;

/**
 *
 * @author anbrousse1
 */
public class Match {
    private int journee;
    private EquipeVM equipeA;
    private EquipeVM equipeB;
    private int pointA;
    private int pointB;
    

    public Match(int journee, EquipeVM equipeA, EquipeVM equipeB, int pointA, int pointB) {
        this.journee = journee;
        this.equipeA = equipeA;
        this.equipeB = equipeB;
        this.pointA = pointA;
        this.pointB = pointB;
    }

    public int getJournee() {
        return journee;
    }

    public EquipeVM getEquipeA() {
        return equipeA;
    }

    public EquipeVM getEquipeB() {
        return equipeB;
    }

    public int getPointA() {
        return pointA;
    }

    public int getPointB() {
        return pointB;
    }
    
    
    
    
}
