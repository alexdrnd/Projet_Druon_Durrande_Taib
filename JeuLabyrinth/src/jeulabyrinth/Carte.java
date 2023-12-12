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
public class Carte {
    
    // liste qui comporte tous les objets que le joueur peut collecter
    ArrayList<String> cartesObjet;
    
    String ANSI_RESET = "\u001B[0m";
    String ANSI_RED = "\u001B[31m";
    String ANSI_GREEN = "\u001B[32m";
    String ANSI_YELLOW = "\u001B[33m";
    String ANSI_BLUE = "\u001B[34m";
    String ANSI_PURPLE = "\u001B[35m";
    String ANSI_CYAN = "\u001B[36m";

    
    public Carte() {
        ArrayList<String> cartesObjet = new ArrayList<String>();
    }
    
    
    public String[] DicoCartesObjets(){
        // dictionnaire
        String[] DicoCartesObjets = {ANSI_CYAN + "a" + ANSI_RESET,
                                    ANSI_GREEN + "b" + ANSI_RESET,
                                    ANSI_PURPLE + "b" + ANSI_RESET,
                                    ANSI_RED + "c" + ANSI_RESET,
                                    ANSI_YELLOW + "c" + ANSI_RESET,
                                    ANSI_BLUE + "c" + ANSI_RESET,
                                    ANSI_CYAN + "c" + ANSI_RESET,
                                    ANSI_GREEN + "c" + ANSI_RESET,
                                    ANSI_RED + "M" + ANSI_RESET,
                                    ANSI_PURPLE + "c" + ANSI_RESET,
                                    ANSI_YELLOW + "d" + ANSI_RESET,
                                    ANSI_BLUE + "e" + ANSI_RESET,
                                    ANSI_CYAN + "f" + ANSI_RESET,
                                    ANSI_GREEN + "f" + ANSI_RESET,
                                    ANSI_PURPLE + "g" + ANSI_RESET,
                                    ANSI_RED + "g" + ANSI_RESET,
                                    ANSI_YELLOW + "h" + ANSI_RESET,
                                    ANSI_BLUE + "l" + ANSI_RESET,
                                    ANSI_CYAN + "l" + ANSI_RESET,
                                    ANSI_GREEN + "p" + ANSI_RESET,
                                    ANSI_PURPLE + "r" + ANSI_RESET,
                                    ANSI_RED + "s" + ANSI_RESET,
                                    ANSI_YELLOW + "s" + ANSI_RESET,
                                    ANSI_PURPLE + "t" + ANSI_RESET};
        return DicoCartesObjets;
    }
     
    
    // complete l'arrayList avec toutes les cartes objets
    public ArrayList<String> creerListeCarte() {
        String[] DicoCartesObjets = DicoCartesObjets();
        for (int i=0 ; i<DicoCartesObjets.length ; i++) {
            cartesObjet.add(DicoCartesObjets[i]);
        }
        return cartesObjet;
    }
     

    @Override
    public String toString() {
        return "Carte{" + "cartesObjet=" + cartesObjet + '}';
    }
    
    
    
    
}
