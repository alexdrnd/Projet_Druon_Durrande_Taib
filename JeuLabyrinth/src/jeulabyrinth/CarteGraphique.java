/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jeulabyrinth;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.JButton;

/**
 *
 * @author vdruo
 */
public class CarteGraphique extends JButton {
   
    BufferedImage image = null;
    String[] DicoObjets = {"araignee","bague","bourse","carteTresor","chandelier","chauveSouris","chouette",
                           "cle","couronne","crane","dragon","epee","fantome","fee","genie","gobelin","heaume",
                           "lezard","livre","papillon","rat","saphir","scarabee","tresor"};
    // liste qui comporte tous les objets que le joueur peut collecter
    ArrayList<String> cartesObjet = new ArrayList<String>();
    
    
    public CarteGraphique() {
        creerListeCarte();
    }
    
    
    // complete l'arrayList avec toutes les cartes objets
    public ArrayList<String> creerListeCarte() {
        String[] DicoCartesObjets = DicoObjets;
        for (int i=0 ; i<DicoCartesObjets.length ; i++) {
            cartesObjet.add(DicoCartesObjets[i]);
            //charger l'image de la carte
            try {
                this.image = ImageIO.read(new File("./test/imageTuiles1/" + DicoCartesObjets[i] + ".png"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return cartesObjet;
    }
    
}
