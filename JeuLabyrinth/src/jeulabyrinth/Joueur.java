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
    
    // liste de carte à recolté du joeur
    ArrayList<String> CartesJoueurs;
    // couleur du joueur
    String color;
    //nom du joueur
    String nom;
    
    
    
    public Joueur(String nom){
        CartesJoueurs = new ArrayList<String>();
        this.nom = nom;
    }
    
    public void affecterCouleur(String color) {
        color = color;
    }
    
    
    
}
