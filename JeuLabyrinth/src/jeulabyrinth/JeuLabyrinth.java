/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package jeulabyrinth;


import java.util.ArrayList;

/**
 *
 * @author Alexandre
 */
public class JeuLabyrinth {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    
    Plateau p = new Plateau();
    System.out.println(p.grilleDeJeu[6][6]);
    p.grilleDeJeu[6][6].tournerTuileSensHoraire();
    System.out.println(p.getObjet(6, 6));
    System.out.println(p.getDirection(6, 6));
    }
    
}
