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
                grille[i][j] = new Tuile("arraignee");
                grille[i][j].ajouterDirection("haut");
            }
        }   
        
        ajoutTuilesDeJeu();
        System.out.println(TuilesDeJeu);
        
    }
    
    
    // methode qui cr?er et ajoute ? la liste l'ensemble des tuiles du jeu
    public void ajoutTuilesDeJeu() {
        
        String[][][][] DicoObjets = DicoObjets();
        
        // ajouter les tuiles "objet"
        for (int i=0 ; i<DicoObjets.length ; i++){
            
            Tuile tuile = creerTuileObjet(DicoObjets[i][0][0][0]);
            
            for (int j=1 ; j<4 ; j++) {
                if (DicoObjets[i][0][0][j]!= null){
                    tuile.ajouterDirection(DicoObjets[i][0][0][j]);
                }
            }
            TuilesDeJeu.add(tuile);
        }
    }
    
    
    // methode qui renvoit le dictionnaire comprenant les infos des object et des direction de chaque tuile
    public String[][][][] DicoObjets(){
        // dictionnaire
        String[][][][] DicoObjets = {
                                    {{{"araignee","haut","gauche",null}}}, 
                                    {{{"bague","haut","bas","gauche"}}},
                                    {{{"bourse","haut","droite","gauche"}}},
                                    {{{"carteTresor","haut","bas","gauche"}}},
                                    {{{"chandelier","droite","bas","gauche"}}},
                                    {{{"chauveSouris","haut","droite","gauche"}}},
                                    {{{"chouette","droite","bas",null}}},
                                    {{{"cle","haut","droite","gauche"}}},
                                    {{{"couronne","haut","bas","gauche"}}},
                                    {{{"crane","haut","droite","bas"}}},
                                    {{{"dragon","haut","droite","gauche"}}},
                                    {{{"epee","haut","droite","bas"}}},
                                    {{{"fantome","haut","droite","gauche"}}},
                                    {{{"fee","haut","droite","gauche"}}},
                                    {{{"genie","haut","droite","gauche"}}},
                                    {{{"gobelin","haut","droite","gauche"}}},
                                    {{{"heaume","droite","bas","gauche"}}},
                                    {{{"lezard","haut","gauche",null}}},
                                    {{{"livre","haut","droite","gauche"}}},
                                    {{{"papillon","haut","gauche",null}}},
                                    {{{"rat","bas","gauche",null}}},
                                    {{{"saphir","haut","droite","bas"}}},
                                    {{{"scarabee","haut","droite",null}}},
                                    {{{"tresor","droite","bas","gauche"}}},
                                    {{{"departB","droite","bas",null}}},
                                    {{{"departJ","haut","droite",null}}},
                                    {{{"departR","haut","gauche",null}}},
                                    {{{"departV","bas","gauche",null}}}, 
                                    };
        
        return DicoObjets;
    }
    
    // methode pour creer une tuile de type "objet"
    public Tuile creerTuileObjet(String objet){
        Tuile tuile = new Tuile(objet);
        return tuile;
    }
    
}
