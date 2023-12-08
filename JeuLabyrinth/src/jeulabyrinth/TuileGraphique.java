/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jeulabyrinth;

import java.awt.image.BufferedImage;
import java.awt.Graphics;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JButton;


/**
 *
 * @author vdruo
 */
public class TuileGraphique extends JButton {
    
    Tuile tuileAssociee;
    BufferedImage image = null;

    public TuileGraphique(Tuile tuileAssociee) {
        this.tuileAssociee = tuileAssociee;
        if (tuileAssociee.getName()=="chemin") {
            tuileAssociee.name = "tuile1";
        }
        else if (tuileAssociee.getName()=="corner") {
            tuileAssociee.name = "tuile2";
        }
        
        try {
            this.image = ImageIO.read(new File("./test/imageTuiles/" + tuileAssociee.getName() + ".png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        
    }
    
    
    
    
    // afficher la tuile
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image, 0, 0, getWidth(), getHeight(), null);
       // g.drawOval(0,0,);
        
        
        
    }
    
    
    
}
