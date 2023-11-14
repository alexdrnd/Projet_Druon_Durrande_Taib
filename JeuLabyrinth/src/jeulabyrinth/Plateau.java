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
    ArrayList<Tuile> TuilesDeJeu = new ArrayList<Tuile>();
    
    
    
    public Plateau() {
        this.grille = new Tuile[7][7];
        
        for (int i=0 ; i<7 ; i++){
            for (int j=0 ; j<7 ; j++) {
                grille[i][j] = new Tuile(new ArrayList<>() , "arraignee");
                grille[i][j].ajouterDirection("haut");
            }
        }   
        
        ajoutTuilesDeJeu();
        System.out.println(TuilesDeJeu);
        
    }
    
    
    // methode qui cr?er et ajoute ? la liste l'ensemble des tuiles du jeu
    public void ajoutTuilesDeJeu() {
        String[] DicoObjets = {"araignee","bague","bourse","carteTresor","chandelier",
            "chauveSouris","chouette","cle","couronne","crane","dragon","epee","fantome",
            "fee","genie","gobelin","heaume","lezard","livre","papillon","rat","saphir",
            "scarabee","tresor","departB","departJ","departR","departV"};
        
        
        // ajouter les tuiles "objet"
        for (int i=0 ; i<DicoObjets.length ; i++){
            Tuile tuile = creerTuileObjet(DicoObjets[i]);
            tuile.ajouterDirection("haut");
            TuilesDeJeu.add(tuile);
        }
        
        
    }
    
    
    // methode pour creer une tuile de type "objet"
    public Tuile creerTuileObjet(String objet){
        Tuile tuile = new Tuile(new ArrayList<>(), objet);
        return tuile;
    }
    
}
