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
public class Joueur {
    private String nom;
    private String prenom;
    private int age;
    private int niveau;
    private int force_entrainement;
    private Poste poste;
    
    public Joueur(String nom, String prenom, int age, int niveau, int force_entrainement,Poste poste) {
        setNom(nom);
        setPrenom(prenom);
        setAge(age);
        setNiveau(niveau);
        setForce_entrainement(force_entrainement);
        setPoste(poste);
        
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getNiveau() {
        return niveau;
    }

    public void setNiveau(int niveau) {
        this.niveau = niveau;
    }

    public int getForce_entrainement() {
        return force_entrainement;
    }

    public void setForce_entrainement(int force_entrainement) {
        this.force_entrainement = force_entrainement;
    }

    public Poste getPoste() {
        return poste;
    }

    public void setPoste(Poste poste) {
        this.poste = poste;
    }
    
    
}
