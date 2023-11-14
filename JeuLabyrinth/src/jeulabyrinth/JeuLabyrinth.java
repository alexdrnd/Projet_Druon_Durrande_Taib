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
    
    Tuile araignee = new Tuile(new ArrayList<>() , "araign?e");
    araignee.ajouterDirection("haut");
    araignee.ajouterDirection("bas"); 
    
    System.out.println(araignee);
    araignee.tournerTuileSensHoraire();
    System.out.println(araignee);
    araignee.tournerTuileSensHoraire();
    System.out.println(araignee);
    araignee.tournerTuileSensTrigo();
    System.out.println(araignee);
    
    }
    
}
