/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jeulabyrinth;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JButton;
import java.awt.geom.AffineTransform;
import java.awt.geom.Ellipse2D;


/**
 *
 * @author vdruo
 */
public class TuileGraphique extends JButton {
    
    Tuile tuileAssociee;
    BufferedImage image = null;
    BufferedImage positionJoueur = null;

    public TuileGraphique(Tuile tuileAssociee) {
        this.tuileAssociee = tuileAssociee;
        if (tuileAssociee.getName()=="chemin") {
            tuileAssociee.name = "tuile1";
        }
        else if (tuileAssociee.getName()=="corner") {
            tuileAssociee.name = "tuile2";
        }
        
        try {
            this.image = ImageIO.read(new File("./test/imageTuiles" + tuileAssociee.nImage + "/" + tuileAssociee.getName() + ".png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    

    
    // methode pour tourner la tuile graphique dans le sens horaire (en fonction de son parametre nImage, on va charger l'image du fichier correspondant)
    public void tournerTuileGraphiqueSensHoraire(Tuile t) {
        t.tournerTuileSensHoraire();
        if (t.nImage==1){
            t.nImage=2;
        } else if (t.nImage==2){
            t.nImage=3;
        } else if (t.nImage==3){
            t.nImage=4;
        } else if (t.nImage==4){
            t.nImage=1;
        }
        
        // charger la nouvelle image
        try {
            this.image = ImageIO.read(new File("./test/imageTuiles" + t.nImage + "/" + t.getName() + ".png"));
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    // methode pour tourner la tuile graphique dans le sens trigo (en fonction de son parametre nImage, on va charger l'image du fichier correspondant)
    public void tournerTuileGraphiqueSensTrigo(Tuile t) {
        t.tournerTuileSensTrigo();
        if (t.nImage==1){
            t.nImage=4;
        } else if (t.nImage==4){
            t.nImage=3;
        } else if (t.nImage==3){
            t.nImage=2;
        } else if (t.nImage==2){
            t.nImage=1;
        }
        
        // charger la nouvelle image
        try {
            this.image = ImageIO.read(new File("./test/imageTuiles" + t.nImage + "/" + t.getName() + ".png"));
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    
    
    
    
    
    // afficher la tuile
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        //dessiner l'image
        g.drawImage(image, 0, 0, getWidth(), getHeight(), null);
        
        // Dessiner un rond de couleur pour le joueur
        //si un joueur est sur las case
        if (tuileAssociee.colPlayer.size()>0){
            Graphics2D g2d = (Graphics2D) g;
            int diametreRond = 15;
            int xRond = 0;
            int yRond = 0;
            int offset = 9;
            
            //joueur bleu
            if (tuileAssociee.colPlayer.contains("bleu")){
                xRond = getWidth() / 4 - diametreRond / 2 + offset;
                yRond = getHeight() / 4 - diametreRond / 2 + offset;
                g2d.setColor(Color.BLUE); // Couleur du rond
                //dessiner le rond
                g2d.fill(new Ellipse2D.Double(xRond, yRond, diametreRond, diametreRond));
            } 
            //joueur vert
            if (tuileAssociee.colPlayer.contains("vert")){ 
                xRond =  3 * getWidth() / 4 - diametreRond / 2 - offset;
                yRond = getHeight() / 4 - diametreRond / 2 + offset;
                g2d.setColor(Color.GREEN);
                //dessiner le rond
                g2d.fill(new Ellipse2D.Double(xRond, yRond, diametreRond, diametreRond));
            } 
            //joueur jaune
            if (tuileAssociee.colPlayer.contains("jaune")){ 
                xRond =  getWidth() / 4 - diametreRond / 2 + offset;
                yRond = 3 * getHeight() / 4 - diametreRond / 2 - offset;
                g2d.setColor(Color.YELLOW);
                //dessiner le rond
                g2d.fill(new Ellipse2D.Double(xRond, yRond, diametreRond, diametreRond));
            } 
            //joueur rouge
            if (tuileAssociee.colPlayer.contains("rouge")){ 
                xRond =  3 * getWidth() / 4 - diametreRond / 2 - offset;
                yRond = 3 * getHeight() / 4 - diametreRond / 2 - offset;
                g2d.setColor(Color.RED);
                //dessiner le rond
                g2d.fill(new Ellipse2D.Double(xRond, yRond, diametreRond, diametreRond));
            }
            
            
        }
        
    }
    
    
    
}
