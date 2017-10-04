/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src.metier;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;


/**
 *
 * @author anbrousse1
 */
public class Joueur {

    private final StringProperty nom = new SimpleStringProperty();
        public String getNom() {return nom.get();}
        private void setNom(String value) {nom.set(value);}
        public StringProperty nomProperty() {return nom;}
        
    private final StringProperty prenom = new SimpleStringProperty();
        public String getPrenom() {return prenom.get();}
        private void setPrenom(String value) {prenom.set(value);}
        public StringProperty prenomProperty() {return prenom;}
    
    private final IntegerProperty age = new SimpleIntegerProperty();
        public int getAge() {return age.get();}
        public void setAge(int value) {age.set(value);}
        public IntegerProperty ageProperty() {return age;}
    
    private final IntegerProperty niveau = new SimpleIntegerProperty();
        public int getNiveau() {return niveau.get();}
        public void setNiveau(int value) {niveau.set(value);}
        public IntegerProperty niveauProperty() {return niveau;}
        
    private final IntegerProperty force_entrainement = new SimpleIntegerProperty();
        public int getForce_entrainement() {return force_entrainement.get();}
        public void setForce_entrainement(int value) {force_entrainement.set(value);}
        public IntegerProperty force_entrainementProperty() {return force_entrainement;}
        
    private final ObjectProperty<Poste> poste = new SimpleObjectProperty<>();
        public Poste getPoste() {return poste.get();}
        public void setPoste(Poste value) {poste.set(value);}
        public ObjectProperty posteProperty() {return poste;}
        
        
    

    public Joueur(String nom, String prenom, int age, int niveau, int force_entrainement,Poste poste) {
        setNom(nom);
        setPrenom(prenom);
        setAge(age);
        setNiveau(niveau);
        setForce_entrainement(force_entrainement);
        setPoste(poste);
        
    }
    
    
    
    
   
    
    public void entrainer(Entrainement e){
        setForce_entrainement(getForce_entrainement() + e.getForce());
        
        if(getForce_entrainement() >= 100){
            setNiveau(getNiveau() + 1);
            setForce_entrainement(getForce_entrainement() - 100);
        }
                
    }

    @Override
    public String toString() {
        return String.format("%s %s",getNom(),getPrenom());
    }  
    
    
    
    
}
