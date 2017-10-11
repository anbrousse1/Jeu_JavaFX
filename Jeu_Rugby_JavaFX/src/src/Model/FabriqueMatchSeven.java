/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src.Model;


import src.ModelView.EquipeVM;
import src.ModelView.JoueurVM;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;
import java.util.Set;

/**
 *
 * @author Anthony
 */
public class FabriqueMatchSeven implements FabriqueMatch{

  
    
    
    /**
     * Cette méthode permet de simuler une rencontre en deux équipes.
     * @param equipeA
     * @param equipeB
     * @param journee 
     * L'équipe A joue à domicile par conséquent il a plus de chance de l'emporter
     */
    public static Match rencontre(EquipeVM equipeA, EquipeVM equipeB,int journee){        
        int niveauA;
        int niveauB;
        int pointA;
        int pointB;
        
        niveauA = calcul_niveau_total(equipeA) + equipeA.getNiveau();
        niveauB = calcul_niveau_total(equipeB) + equipeB.getNiveau();
             
        Random r = new Random();
        pointA = 5 + r.nextInt(niveauA/10);

        r = new Random();
        pointB = 5 + r.nextInt(niveauB/12);   
          
        Match m = new Match(journee, equipeA, equipeB, pointA, pointB);
        
       // Affichage_Match.afficher_match(m);
        
        if(pointA > pointB){
            equipeA.up_niveau(2);
            equipeB.down_niveau(1);
        }else if(pointA < pointB){
            equipeB.up_niveau(2);
            equipeA.down_niveau(1);
        }else{
            equipeA.up_niveau(1);
            equipeB.up_niveau(1);
        }
        
        return m;
                  
    }
   
    public static int calcul_niveau_total(EquipeVM equipe){
        int niveautotal = 0;
        
        Set<Map.Entry<Integer, JoueurVM>> setEquipe = equipe.getEquipes().entrySet();
             Iterator<Map.Entry<Integer, JoueurVM>> it = setEquipe.iterator();
             while(it.hasNext()){
                Map.Entry<Integer, JoueurVM> e = it.next();
                niveautotal += e.getValue().getNiveau();
             }
        return niveautotal;
    }
   
    
}
