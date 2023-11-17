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
    System.out.println(p.grilleDeJeu[5][4]);
    p.grilleDeJeu[5][4].setColPlayer("vert");
    System.out.println(p.grilleDeJeu[5][4].colPlayer);
    p.avancerCase(5, 4, "vert" , "bas");
    System.out.println(p.grilleDeJeu[5][4].colPlayer);
    System.out.println(p.grilleDeJeu[6][4]);
    System.out.println(p.grilleDeJeu[6][4].colPlayer);
    
    
    }
    
}
