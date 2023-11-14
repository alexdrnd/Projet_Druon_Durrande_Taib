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
public class Plateau {
    
    // attribut grille qui est un tableau ? deux dimensions de Tuiles, qui va permettre de repr?senter la grille de jeu
    Tuile[][] grille;
    // attribut TuilesDeJeu qui est une ArrayList, elle contient toutes les tuiles du jeu (tuiles "objets", tuiles "d?part", tuiles "chemin, tuiles "corner")
    ArrayList<Tuile> TuilesDeJeu;
    
    
    
    public Plateau() {
        this.grille = new Tuile[7][7];
        
    for (int i=0 ; i<7 ; i++){
        for (int j=0 ; j<7 ; j++) {
            grille[i][j] = new Tuile(new ArrayList<>() , "arraignee");
            grille[i][j].ajouterDirection("haut");
        }
    }   
      
    }
    
    
    
    
    
    
}
