/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package jeulabyrinth;

import java.util.Scanner;
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
    int i=0;
    Scanner sc = new Scanner(System.in);
    p.grilleDeJeu[0][0].setColPlayer("bleu");
    System.out.println(p.afficherGrilleDeJeu());
    
    while (i==0) {
        System.out.println("Sur quelle ligne etes vous ?");
        int nli = sc.nextInt();
        System.out.println("Sur quelle colonne etes vous ?");
        int nco = sc.nextInt();
        System.out.println("Dans quelle directions voulez vous avancer ?");
        String rep = sc.next();
        p.avancerCase(nli, nco, "bleu", rep);
        System.out.println(p.afficherGrilleDeJeu());
    }
    
    }
    
}
