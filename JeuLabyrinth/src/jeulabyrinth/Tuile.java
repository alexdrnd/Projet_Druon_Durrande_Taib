/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jeulabyrinth;

import java.util.ArrayList;
import javax.swing.ImageIcon;

/**
 *
 * @author vdruo
 */
public class Tuile {
    
    // attribut direction qui est une ArrayList, qui comporte toutes les directions que le joueur peut emprunter
    ArrayList<String> direction = new ArrayList<String>(); 
    // attribut object qui est un String, indique quel objet est present sur la tuile, indique null si aucun objet est present
    String object;
    // attribut nom qui est un String, qui indique ce que represente la case (objet, chemin, corner)
    String name;
    // attribut onBoard qui est un booleen, indique si la tuile est sur le plateau ou non
    boolean onBoard = true;

    
    
    /**
     * Constructeur, attribut des valeurs aux diff?rents parametres en fonction de ce qu'on lui donne en parametre de fonction
     * @param direction attribut ways qui est une ArrayList, qui comporte toutes les directions de passage que la tuile peut permetre
     * @param object attribut object qui est un String, indique quel objet est present sur la tuile, indique null si aucun objet est present
     * @param onBoard attribut onBoard qui est un booleen, indique si la tuile est sur le plateau ou non
     */
    public Tuile(String object, String name) {
        this.direction = new ArrayList<>();
        this.object = object;
        this.name = name;
    }
    
    
    
    // M?thode pour ajouter une direction ? l'ArrayList direction
    public void ajouterDirection(String way) {
        direction.add(way);
    }
    
    
    // methode pour tourner la tuile dans le sens horaire, ce qui change les valeurs de direction
    public void tournerTuileSensHoraire() {
        
        for (int i = 0 ; i < direction.size() ; i++) {
               
            // remplacer "haut" par "droite"
            if (direction.get(i) == "haut") {
                direction.set(i, "droite");
            }
        
            // remplacer "droite" par "bas"
            else if (direction.get(i) == "droite") {
                direction.set(i, "bas");
            }
        
            // remplacer "bas" par "gauche"
            else if (direction.get(i) == "bas") {
                direction.set(i, "gauche");
            }
        
            // remplacer "gauche" par "haut"
            else if (direction.get(i) == "gauche") {
                direction.set(i, "haut");
            } 
        }
    }
    
    
    // methode pour tourner la tuile dans le sens trigonom?trique, ce qui change les valeurs de direction
    public void tournerTuileSensTrigo() {
        
        for (int i = 0 ; i < direction.size() ; i++) {
               
            // remplacer "haut" par "gauche"
            if (direction.get(i) == "haut") {
                direction.set(i, "gauche");
            }
        
            // remplacer "gauche" par "bas"
            else if (direction.get(i) == "gauche") {
                direction.set(i, "bas");
            }
        
            // remplacer "bas" par "droite"
            else if (direction.get(i) == "bas") {
                direction.set(i, "droite");
            }
        
            // remplacer "droite" par "haut"
            else if (direction.get(i) == "droite") {
                direction.set(i, "haut");
            } 
        }
    }

    
    
    public String getObject() {
        return object;
    }

    
    public String getName() {
        return name;
    }
    

    public ArrayList<String> getDirection() {
        return direction;
    }

    
    public boolean isOnBoard() {
        return onBoard;
    }

    
    public void setOnBoard(boolean onBoard) {
        this.onBoard = onBoard;
    }
    
    
    @Override
    public String toString() {
        return name + "{" + "direction=" + direction + ", object=" + object + ", onBoard=" + onBoard + '}';
    }
    
    
    
    
    
    
    
    
    
    
    
    
}
