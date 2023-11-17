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
    ArrayList<String> directions = new ArrayList<String>(); 
    // attribut object qui est un String, indique quel objet est present sur la tuile, indique null si aucun objet est present
    String object;
    // attribut nom qui est un String, qui indique ce que represente la case (objet, chemin, corner)
    String name;
    // attribut onBoard qui est un booleen, indique si la tuile est sur le plateau ou non
    boolean onBoard = true;
    // attribut qui indique la couleur du joueur sur la tuile, s'il y a un joueur
    String colPlayer = null;

    
    
    /**
     * Constructeur, attribut des valeurs aux diff?rents parametres en fonction de ce qu'on lui donne en parametre de fonction
     * @param direction attribut ways qui est une ArrayList, qui comporte toutes les directions de passage que la tuile peut permetre
     * @param object attribut object qui est un String, indique quel objet est present sur la tuile, indique null si aucun objet est present
     * @param onBoard attribut onBoard qui est un booleen, indique si la tuile est sur le plateau ou non
     */
    public Tuile(String object, String name) {
        this.directions = new ArrayList<>();
        this.object = object;
        this.name = name;
       
    }
    
    
    
    // M?thode pour ajouter une direction ? l'ArrayList direction
    public void ajouterDirection(String way) {
        directions.add(way);
    }
    
    
    // methode pour tourner la tuile dans le sens horaire, ce qui change les valeurs de direction
    public void tournerTuileSensHoraire() {
        
        for (int i = 0 ; i < directions.size() ; i++) {
               
            // remplacer "haut" par "droite"
            if (directions.get(i) == "haut") {
                directions.set(i, "droite");
            }
        
            // remplacer "droite" par "bas"
            else if (directions.get(i) == "droite") {
                directions.set(i, "bas");
            }
        
            // remplacer "bas" par "gauche"
            else if (directions.get(i) == "bas") {
                directions.set(i, "gauche");
            }
        
            // remplacer "gauche" par "haut"
            else if (directions.get(i) == "gauche") {
                directions.set(i, "haut");
            } 
        }
    }
    
    
    // methode pour tourner la tuile dans le sens trigonom?trique, ce qui change les valeurs de direction
    public void tournerTuileSensTrigo() {
        
        for (int i = 0 ; i < directions.size() ; i++) {
               
            // remplacer "haut" par "gauche"
            if (directions.get(i) == "haut") {
                directions.set(i, "gauche");
            }
        
            // remplacer "gauche" par "bas"
            else if (directions.get(i) == "gauche") {
                directions.set(i, "bas");
            }
        
            // remplacer "bas" par "droite"
            else if (directions.get(i) == "bas") {
                directions.set(i, "droite");
            }
        
            // remplacer "droite" par "haut"
            else if (directions.get(i) == "droite") {
                directions.set(i, "haut");
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
        return directions;
    }

    
    public boolean isOnBoard() {
        return onBoard;
    }

    
    public void setOnBoard(boolean onBoard) {
        this.onBoard = onBoard;
    }

    public void setColPlayer(String colPlayer) {
        this.colPlayer = colPlayer;
    }
    
    
    
    
    @Override
    public String toString() {
        return name + "{" + "direction=" + directions + ", object=" + object + ", onBoard=" + onBoard + '}';
    }
    
    
    
    
    
    
    
    
    
    
    
    
}
