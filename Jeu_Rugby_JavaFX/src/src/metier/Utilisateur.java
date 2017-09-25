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
public class Utilisateur {
    private String nom;
    private String prenom;
    private String login;
    private String mot_de_passe;
    private int niveau;
    private Equipe equipe;

    public Utilisateur(String nom, String prenom, String login, String mot_de_passe) {
        this.nom = nom;
        this.prenom = prenom;
        this.login = login;
        this.mot_de_passe = mot_de_passe;
        this.niveau = 0;
    }

    public Utilisateur(String nom, String prenom, String login, String mot_de_passe, Equipe equipe) {
        this.nom = nom;
        this.prenom = prenom;
        this.login = login;
        this.mot_de_passe = mot_de_passe;
        this.equipe = equipe;
    }
    
    
    
    public Utilisateur(){
        this.login = login;
    }
    
    
    public void ajouterEquipe(Equipe e){
        equipe = e;
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
    
     public void setLogin(String login) {
        this.login = login;
    }

    public String getLogin() {
        return login;
    }

    public String getMot_de_passe() {
        return mot_de_passe;
    }

    public int getNiveau() {
        return niveau;
    }

    public void setNiveau(int niveau) {
        this.niveau = niveau;
    }
    
    
    public void se_connecter(){
        
    }

    public Equipe getEquipe() {
        return equipe;
    }
    
}
