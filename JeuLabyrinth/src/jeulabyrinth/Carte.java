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
    ArrayList<String> cartesObjet = new ArrayList<String>();

    
    public Carte() {
        creerListeCarte();
    }
    
    
    public String[] DicoObjets(){
        // dictionnaire
        String[] DicoObjets = {"araignee","bague","bourse","carteTresor","chandelier",
                               "chauveSouris","chouette","cle","couronne","crane","dragon",
                               "epee","fantome","fee","genie","gobelin", "heaume","lezard",
                               "livre","papillon","rat","saphir","scarabee","tresor"};
        return DicoObjets;
    }
     
    
    // complete l'arrayList avec toutes les cartes objets
    public void creerListeCarte() {
        String[] DicoObjets = DicoObjets();
        for (int i=0 ; i<DicoObjets.length ; i++) {
            cartesObjet.add(DicoObjets[i]);
        }
    }
     

    @Override
    public String toString() {
        return "Carte{" + "cartesObjet=" + cartesObjet + '}';
    }
    
    
    
    
}
