/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jeulabyrinth;

import java.util.ArrayList;

/**
 *
 * @author vdruo
 */
public class Joueur {
    
    // liste de carte à recolter du joueur
    ArrayList<String> CartesJoueurs;
    // couleur du joueur
    String couleur;
    //nom du joueur
    String nom;
  
    
    public Joueur(String nom){
        CartesJoueurs = new ArrayList<String>();
        this.nom = nom;
    }
    
    public void affecterCouleur(String color) {
        couleur = color;
    }

    public String getNom() {
        return nom;
    }
    
    public String lireCouleur() {
        return couleur;
    }
    
    public void recolterObjet(){
        CartesJoueurs.remove(0);
    }
    
    //methode qui verifie si le joueur à gagner, cad s'il n'a plus d'objet à recuperer
    public boolean Victoire(){
        if (CartesJoueurs.size()==0){
            return true;
        } else {
            return false;
        }
    }
    
    
    
    
}
