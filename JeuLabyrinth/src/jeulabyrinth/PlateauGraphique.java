/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package jeulabyrinth;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLayeredPane;

/**
 *
 * @author vdruo
 */
public class PlateauGraphique extends javax.swing.JFrame {

    Plateau plateauGraphique = new Plateau();
    TuileGraphique tuileGraphiqueCourante = new  TuileGraphique(plateauGraphique.tuileCourante);
    // Créer un JLayeredPane pour les composants graphique
    JLayeredPane layeredPane = new JLayeredPane();
    
    
    /**
     * Creates new form JFrameJeuLabyrinth
     */
    public PlateauGraphique() {
        
        initComponents();
        creerPlateauGraphique();
        tournerTuileCourante();
        insererTuileCouranteGraphique();
        ajouterElementsGraphique();
    }
    
    
    //methode pour ajouter les élement graphique
    public void ajouterElementsGraphique(){
        
        System.out.println("Début de ajouterElementsGraphique()");
        setLayout(new BorderLayout());
        add(layeredPane, BorderLayout.CENTER);
        
        // Utiliser un layout null pour le JLayeredPane
        layeredPane.setLayout(null);
        layeredPane.setBounds(1000,1000,0,0);
        
        // Récupérer la taille du JLayeredPane après que la fenêtre a été rendue
        pack();
        setLocationRelativeTo(null);  // Centre la fenêtre sur l'écran
        int layeredPaneWidth = layeredPane.getWidth();
        int layeredPaneHeight = layeredPane.getHeight();
        System.out.println("Début de ajouterElementsGraphique()");
        // Ajouter PlateauDeJeu au JLayeredPane
        int PlateauDeJeuWidth = PlateauDeJeu.getWidth(); 
        int PlateauDeJeuHeight = PlateauDeJeu.getHeight();
        int PlateauDeJeuX = (int) (layeredPaneWidth * 0.25); // 40% de la largeur du JLayeredPane
        int PlateauDeJeuY = (layeredPaneHeight - PlateauDeJeuHeight) / 2;
        PlateauDeJeu.setBounds(PlateauDeJeuX, PlateauDeJeuY, PlateauDeJeuWidth, PlateauDeJeuHeight);
        //rendre le fond transparent
        PlateauDeJeu.setOpaque(false);
        
        //ajouter TuileCourante sur le JLayeredPane
        int TuileCouranteWidth = TuileCourante.getWidth(); 
        int TuileCouranteHeight = TuileCourante.getHeight();
        int TuileCouranteX = (int) (layeredPaneWidth * 0.05); // 5% de la largeur du JLayeredPane
        int TuileCouranteY = (layeredPaneHeight - TuileCouranteHeight) / 2;
        TuileCourante.setBounds(TuileCouranteX, TuileCouranteY, TuileCouranteWidth, TuileCouranteHeight);
        TuileCourante.setOpaque(false);
        
        //ajouter le boutonDroite sur le JlayeredPane
        int boutonDroiteWidth = boutonDroite.getWidth(); 
        int boutonDroiteHeight = boutonDroite.getHeight();
        int boutonDroiteX = (int) (layeredPaneWidth * 0.085); // 8.5% de la largeur du JLayeredPane
        int boutonDroiteY = (int) (layeredPaneHeight * 0.57); // 57% de la hauteur du JLayeredPane
        boutonDroite.setBounds(boutonDroiteX, boutonDroiteY, boutonDroiteWidth, boutonDroiteHeight);
        
        //ajouter le boutonGauche sur le JlayeredPane
        int boutonGaucheWidth = boutonGauche.getWidth(); 
        int boutonGaucheHeight = boutonGauche.getHeight();
        int boutonGaucheX = (int) (layeredPaneWidth * 0.05); // 5% de la largeur du JLayeredPane
        int boutonGaucheY = (int) (layeredPaneHeight * 0.57); // 57% de la hauteur du JLayeredPane
        boutonGauche.setBounds(boutonGaucheX, boutonGaucheY, boutonGaucheWidth, boutonGaucheHeight);
        
        //ajouter le boutonC2B sur le JlayeredPane
        int boutonC2BWidth = boutonC2B.getWidth(); 
        int boutonC2BHeight = boutonC2B.getHeight();
        int boutonC2BX = (int) (layeredPaneWidth * 0.325); // 32.5% de la largeur du JLayeredPane
        int boutonC2BY = (int) (layeredPaneHeight * 0.8); // 80% de la hauteur du JLayeredPane
        boutonC2B.setBounds(boutonC2BX, boutonC2BY, boutonC2BWidth, boutonC2BHeight);
        
        //ajouter le boutonC4B sur le JlayeredPane
        int boutonC4BWidth = boutonC4B.getWidth(); 
        int boutonC4BHeight = boutonC4B.getHeight();
        int boutonC4BX = (int) (layeredPaneWidth * 0.443); // 44.3% de la largeur du JLayeredPane
        int boutonC4BY = (int) (layeredPaneHeight * 0.8); // 80% de la hauteur du JLayeredPane
        boutonC4B.setBounds(boutonC4BX, boutonC4BY, boutonC4BWidth, boutonC4BHeight);
        
        //ajouter le boutonC6B sur le JlayeredPane
        int boutonC6BWidth = boutonC6B.getWidth(); 
        int boutonC6BHeight = boutonC6B.getHeight();
        int boutonC6BX = (int) (layeredPaneWidth * 0.561); // 56.1% de la largeur du JLayeredPane
        int boutonC6BY = (int) (layeredPaneHeight * 0.8); // 80% de la hauteur du JLayeredPane
        boutonC6B.setBounds(boutonC6BX, boutonC6BY, boutonC6BWidth, boutonC6BHeight);
        
        //ajouter le boutonC2H sur le JlayeredPane
        int boutonC2HWidth = boutonC2H.getWidth(); 
        int boutonC2HHeight = boutonC2H.getHeight();
        int boutonC2HX = (int) (layeredPaneWidth * 0.325); // 32.5% de la largeur du JLayeredPane
        int boutonC2HY = (int) (layeredPaneHeight * 0.15); // 15% de la hauteur du JLayeredPane
        boutonC2H.setBounds(boutonC2HX, boutonC2HY, boutonC2HWidth, boutonC2HHeight);
        
        //ajouter le boutonC4H sur le JlayeredPane
        int boutonC4HWidth = boutonC4H.getWidth(); 
        int boutonC4HHeight = boutonC4H.getHeight();
        int boutonC4HX = (int) (layeredPaneWidth * 0.443); // 44.3% de la largeur du JLayeredPane
        int boutonC4HY = (int) (layeredPaneHeight * 0.15); // 15% de la hauteur du JLayeredPane
        boutonC4H.setBounds(boutonC4HX, boutonC4HY, boutonC4HWidth, boutonC4HHeight);
        
        //ajouter le boutonC6H sur le JlayeredPane
        int boutonC6HWidth = boutonC6H.getWidth(); 
        int boutonC6HHeight = boutonC6H.getHeight();
        int boutonC6HX = (int) (layeredPaneWidth * 0.561); // 56.1% de la largeur du JLayeredPane
        int boutonC6HY = (int) (layeredPaneHeight * 0.15); // 15% de la hauteur du JLayeredPane
        boutonC6H.setBounds(boutonC6HX, boutonC6HY, boutonC6HWidth, boutonC6HHeight);
        
        //ajouter le boutonL2G sur le JlayeredPane
        int boutonL2GWidth = boutonL2G.getWidth(); 
        int boutonL2GHeight = boutonL2G.getHeight();
        int boutonL2GX = (int) (layeredPaneWidth * 0.22); // 22% de la largeur du JLayeredPane
        int boutonL2GY = (int) (layeredPaneHeight * 0.31); // 31% de la hauteur du JLayeredPane
        boutonL2G.setBounds(boutonL2GX, boutonL2GY, boutonL2GWidth, boutonL2GHeight);
        
        //ajouter le boutonL4G sur le JlayeredPane
        int boutonL4GWidth = boutonL4G.getWidth(); 
        int boutonL4GHeight = boutonL4G.getHeight();
        int boutonL4GX = (int) (layeredPaneWidth * 0.22); // 22% de la largeur du JLayeredPane
        int boutonL4GY = (int) (layeredPaneHeight * 0.475); // 47.5% de la hauteur du JLayeredPane
        boutonL4G.setBounds(boutonL4GX, boutonL4GY, boutonL4GWidth, boutonL4GHeight);
        
        //ajouter le boutonL6G sur le JlayeredPane
        int boutonL6GWidth = boutonL6G.getWidth(); 
        int boutonL6GHeight = boutonL6G.getHeight();
        int boutonL6GX = (int) (layeredPaneWidth * 0.22); 
        int boutonL6GY = (int) (layeredPaneHeight * 0.64); 
        boutonL6G.setBounds(boutonL6GX, boutonL6GY, boutonL6GWidth, boutonL6GHeight);
        
        //ajouter le boutonL2D sur le JlayeredPane
        int boutonL2DWidth = boutonL2D.getWidth(); 
        int boutonL2DHeight = boutonL2D.getHeight();
        int boutonL2DX = (int) (layeredPaneWidth * 0.665); 
        int boutonL2DY = (int) (layeredPaneHeight * 0.31); 
        boutonL2D.setBounds(boutonL2DX, boutonL2DY, boutonL2DWidth, boutonL2DHeight);
        
        //ajouter le boutonL4D sur le JlayeredPane
        int boutonL4DWidth = boutonL4D.getWidth(); 
        int boutonL4DHeight = boutonL4D.getHeight();
        int boutonL4DX = (int) (layeredPaneWidth * 0.665); 
        int boutonL4DY = (int) (layeredPaneHeight * 0.475); 
        boutonL4D.setBounds(boutonL4DX, boutonL4DY, boutonL4DWidth, boutonL4DHeight);
        
        //ajouter le boutonL6D sur le JlayeredPane
        int boutonL6DWidth = boutonL6D.getWidth(); 
        int boutonL6DHeight = boutonL6D.getHeight();
        int boutonL6DX = (int) (layeredPaneWidth * 0.665); 
        int boutonL6DY = (int) (layeredPaneHeight * 0.64); 
        boutonL6D.setBounds(boutonL6DX, boutonL6DY, boutonL6DWidth, boutonL6DHeight);
        
        // Ajouter les composants aux différentes couches
        layeredPane.add(PlateauDeJeu, JLayeredPane.PALETTE_LAYER);
        layeredPane.add(TuileCourante, JLayeredPane.PALETTE_LAYER);
        layeredPane.add(boutonC2B, JLayeredPane.PALETTE_LAYER);
        layeredPane.add(boutonC4B, JLayeredPane.PALETTE_LAYER);
        layeredPane.add(boutonC6B, JLayeredPane.PALETTE_LAYER);
        layeredPane.add(boutonC2H, JLayeredPane.PALETTE_LAYER);
        layeredPane.add(boutonC4H, JLayeredPane.PALETTE_LAYER);
        layeredPane.add(boutonC6H, JLayeredPane.PALETTE_LAYER);
        layeredPane.add(boutonL2G, JLayeredPane.PALETTE_LAYER);
        layeredPane.add(boutonL4G, JLayeredPane.PALETTE_LAYER);
        layeredPane.add(boutonL6G, JLayeredPane.PALETTE_LAYER);
        layeredPane.add(boutonL2D, JLayeredPane.PALETTE_LAYER);
        layeredPane.add(boutonL4D, JLayeredPane.PALETTE_LAYER);
        layeredPane.add(boutonL6D, JLayeredPane.PALETTE_LAYER);
        layeredPane.add(boutonDroite, JLayeredPane.PALETTE_LAYER);
        layeredPane.add(boutonGauche, JLayeredPane.PALETTE_LAYER);
        
        
        layeredPane.setVisible(true);
        revalidate();
        repaint();
        
    }
    
    
    // creer un plateu graphique à partir d'un tableau console
    public void creerPlateauGraphique(){
        // parcourir l'ensemble de tuiles du plateau
        for (int i=0 ; i<7; i++) {
            for (int j=0 ; j<7 ; j++) {
                //creer la tuile
                TuileGraphique tuileG = new  TuileGraphique(plateauGraphique.grilleDeJeu[i][j]);
                //afficher la tuile sur le pannel
                PlateauDeJeu.add(tuileG);
            }
        }
        
        //charger la tuile courante et l'afficher sur le pannel
        TuileCourante.add(tuileGraphiqueCourante);
    }
    
    // mettre a jour le plateau
    public void mettreAJourPlateauGraphique(){
       //vider le grid layout
       PlateauDeJeu.removeAll();
       // parcourir l'ensemble de tuiles du plateau
        for (int i=0 ; i<7; i++) {
            for (int j=0 ; j<7 ; j++) {
                //creer la tuile
                TuileGraphique tuileG = new  TuileGraphique(plateauGraphique.grilleDeJeu[i][j]);
                //afficher la tuile sur le pannel
                PlateauDeJeu.add(tuileG);
                PlateauDeJeu.revalidate();
                PlateauDeJeu.repaint();
            }
        }
        
        // vider le grid layout
        TuileCourante.removeAll();
        //charger la tuile courante et l'afficher sur le pannel
        TuileCourante.add(tuileGraphiqueCourante);
        TuileCourante.revalidate();
        TuileCourante.repaint();
    }
    
    // tourner la tuile courante à droite
    public void tournerTuileCouranteDroite(){
        ActionListener ecouteurClick1 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tuileGraphiqueCourante.tournerTuileGraphiqueSensTrigo(plateauGraphique.tuileCourante);
                mettreAJourPlateauGraphique();
                repaint();
            }
        };
        boutonDroite.addActionListener(ecouteurClick1);
    }
    
    // tourner la tuile courante à gauche
    public void tournerTuileCouranteGauche(){
        ActionListener ecouteurClick2 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tuileGraphiqueCourante.tournerTuileGraphiqueSensHoraire(plateauGraphique.tuileCourante);
                mettreAJourPlateauGraphique();
                repaint();
            }
        };
        boutonGauche.addActionListener(ecouteurClick2);
    }
    
    // methode pour tourner la tuile courante
    public void tournerTuileCourante(){
        tournerTuileCouranteDroite();
        tournerTuileCouranteGauche();
    }
    
    // methode pour insérer la tuile courante
    public void insererTuileCouranteGraphique(){
        //inserer la tuile graphique sur la ligne 2 par la gauche
        ActionListener ecouteurClick3 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                plateauGraphique.insererTuileLigneAGauche(1);
                tuileGraphiqueCourante = new  TuileGraphique(plateauGraphique.tuileCourante);
                mettreAJourPlateauGraphique();
                repaint();
            }
        };
        boutonL2G.addActionListener(ecouteurClick3);
        
        //inserer la tuile graphique sur la ligne 4 par la gauche
        ActionListener ecouteurClick4 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                plateauGraphique.insererTuileLigneAGauche(3);
                tuileGraphiqueCourante = new  TuileGraphique(plateauGraphique.tuileCourante);
                mettreAJourPlateauGraphique();
                repaint();
            }
        };
        boutonL4G.addActionListener(ecouteurClick4);
        
        //inserer la tuile graphique sur la ligne 6 par la gauche
        ActionListener ecouteurClick5 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                plateauGraphique.insererTuileLigneAGauche(5);
                tuileGraphiqueCourante = new  TuileGraphique(plateauGraphique.tuileCourante);
                mettreAJourPlateauGraphique();
                repaint();
            }
        };
        boutonL6G.addActionListener(ecouteurClick5);
        
        //inserer la tuile graphique sur la ligne 2 par la droite
        ActionListener ecouteurClick6 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                plateauGraphique.insererTuileLigneADroite(1);
                tuileGraphiqueCourante = new  TuileGraphique(plateauGraphique.tuileCourante);
                mettreAJourPlateauGraphique();
                repaint();
            }
        };
        boutonL2D.addActionListener(ecouteurClick6);
        
        //inserer la tuile graphique sur la ligne 4 par la droite
        ActionListener ecouteurClick7 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                plateauGraphique.insererTuileLigneADroite(3);
                tuileGraphiqueCourante = new  TuileGraphique(plateauGraphique.tuileCourante);
                mettreAJourPlateauGraphique();
                repaint();
            }
        };
        boutonL4D.addActionListener(ecouteurClick7);
        
        //inserer la tuile graphique sur la ligne 6 par la droite
        ActionListener ecouteurClick8 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                plateauGraphique.insererTuileLigneADroite(5);
                tuileGraphiqueCourante = new  TuileGraphique(plateauGraphique.tuileCourante);
                mettreAJourPlateauGraphique();
                repaint();
            }
        };
        boutonL6D.addActionListener(ecouteurClick8);
        
        //inserer la tuile graphique sur la colonne 2 par le haut
        ActionListener ecouteurClick9 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                plateauGraphique.insererTuileColonneHaut(1);
                tuileGraphiqueCourante = new  TuileGraphique(plateauGraphique.tuileCourante);
                mettreAJourPlateauGraphique();
                repaint();
            }
        };
        boutonC2H.addActionListener(ecouteurClick9);
        
        //inserer la tuile graphique sur la colonne 4 par le haut
        ActionListener ecouteurClick10 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                plateauGraphique.insererTuileColonneHaut(3);
                tuileGraphiqueCourante = new  TuileGraphique(plateauGraphique.tuileCourante);
                mettreAJourPlateauGraphique();
                repaint();
            }
        };
        boutonC4H.addActionListener(ecouteurClick10);
        
        //inserer la tuile graphique sur la colonne 6 par le haut
        ActionListener ecouteurClick11 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                plateauGraphique.insererTuileColonneHaut(5);
                tuileGraphiqueCourante = new  TuileGraphique(plateauGraphique.tuileCourante);
                mettreAJourPlateauGraphique();
                repaint();
            }
        };
        boutonC6H.addActionListener(ecouteurClick11);
        
        //inserer la tuile graphique sur la colonne 2 par le bas
        ActionListener ecouteurClick12 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                plateauGraphique.insererTuileColonneBas(1);
                tuileGraphiqueCourante = new  TuileGraphique(plateauGraphique.tuileCourante);
                mettreAJourPlateauGraphique();
                repaint();
            }
        };
        boutonC2B.addActionListener(ecouteurClick12);
        
        //inserer la tuile graphique sur la colonne 4 par le bas
        ActionListener ecouteurClick13 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                plateauGraphique.insererTuileColonneBas(3);
                tuileGraphiqueCourante = new  TuileGraphique(plateauGraphique.tuileCourante);
                mettreAJourPlateauGraphique();
                repaint();
            }
        };
        boutonC4B.addActionListener(ecouteurClick13);
        
        //inserer la tuile graphique sur la colonne 6 par le bas
        ActionListener ecouteurClick14 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                plateauGraphique.insererTuileColonneBas(5);
                tuileGraphiqueCourante = new  TuileGraphique(plateauGraphique.tuileCourante);
                mettreAJourPlateauGraphique();
                repaint();
            }
        };
        boutonC6B.addActionListener(ecouteurClick14);
        
    }
    
    //methode pour cacher les boutons pour tourner et inserer la tuile
    public void cacherBoutonsTuileCourante() {
        boutonC2B.setVisible(false);
        boutonC2H.setVisible(false);
        boutonC4B.setVisible(false);
        boutonC4H.setVisible(false);
        boutonC6B.setVisible(false);
        boutonC6H.setVisible(false);
        boutonDroite.setVisible(false);
        boutonGauche.setVisible(false);
        boutonL2D.setVisible(false);
        boutonL2G.setVisible(false);
        boutonL4D.setVisible(false);
        boutonL4G.setVisible(false);
        boutonL6D.setVisible(false);
        boutonL6G.setVisible(false);
    }
    
    //methode pour affiche les boutons pour tourner et inserer la tuile
    public void afficherBoutonsTuileCourante() {
        boutonC2B.setVisible(true);
        boutonC2H.setVisible(true);
        boutonC4B.setVisible(true);
        boutonC4H.setVisible(true);
        boutonC6B.setVisible(true);
        boutonC6H.setVisible(true);
        boutonDroite.setVisible(true);
        boutonGauche.setVisible(true);
        boutonL2D.setVisible(true);
        boutonL2G.setVisible(true);
        boutonL4D.setVisible(true);
        boutonL4G.setVisible(true);
        boutonL6D.setVisible(true);
        boutonL6G.setVisible(true);
    }
    
    
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PlateauDeJeu = new javax.swing.JPanel();
        TuileCourante = new javax.swing.JPanel();
        boutonDroite = new javax.swing.JButton();
        boutonGauche = new javax.swing.JButton();
        boutonL2G = new javax.swing.JButton();
        boutonL4G = new javax.swing.JButton();
        boutonL6G = new javax.swing.JButton();
        boutonL2D = new javax.swing.JButton();
        boutonL4D = new javax.swing.JButton();
        boutonL6D = new javax.swing.JButton();
        boutonC2H = new javax.swing.JButton();
        boutonC4H = new javax.swing.JButton();
        boutonC6H = new javax.swing.JButton();
        boutonC2B = new javax.swing.JButton();
        boutonC4B = new javax.swing.JButton();
        boutonC6B = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("nj");
        setMinimumSize(new java.awt.Dimension(2147483647, 2147483647));

        PlateauDeJeu.setBackground(new java.awt.Color(51, 51, 51));
        PlateauDeJeu.setVerifyInputWhenFocusTarget(false);
        PlateauDeJeu.setLayout(new java.awt.GridLayout(7, 7));

        TuileCourante.setBackground(new java.awt.Color(153, 204, 255));
        TuileCourante.setLayout(new java.awt.GridLayout(1, 1));

        boutonDroite.setBackground(new java.awt.Color(153, 204, 255));
        boutonDroite.setText("►");
        boutonDroite.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boutonDroiteActionPerformed(evt);
            }
        });

        boutonGauche.setBackground(new java.awt.Color(153, 204, 255));
        boutonGauche.setText("◄");
        boutonGauche.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boutonGaucheActionPerformed(evt);
            }
        });

        boutonL2G.setBackground(new java.awt.Color(153, 204, 255));
        boutonL2G.setText("►");
        boutonL2G.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boutonL2GActionPerformed(evt);
            }
        });

        boutonL4G.setBackground(new java.awt.Color(153, 204, 255));
        boutonL4G.setText("►");
        boutonL4G.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boutonL4GActionPerformed(evt);
            }
        });

        boutonL6G.setBackground(new java.awt.Color(153, 204, 255));
        boutonL6G.setText("►");
        boutonL6G.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boutonL6GActionPerformed(evt);
            }
        });

        boutonL2D.setBackground(new java.awt.Color(153, 204, 255));
        boutonL2D.setText("◄");
        boutonL2D.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boutonL2DActionPerformed(evt);
            }
        });

        boutonL4D.setBackground(new java.awt.Color(153, 204, 255));
        boutonL4D.setText("◄");
        boutonL4D.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boutonL4DActionPerformed(evt);
            }
        });

        boutonL6D.setBackground(new java.awt.Color(153, 204, 255));
        boutonL6D.setText("◄");
        boutonL6D.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boutonL6DActionPerformed(evt);
            }
        });

        boutonC2H.setBackground(new java.awt.Color(153, 204, 255));
        boutonC2H.setText("▼");
        boutonC2H.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boutonC2HActionPerformed(evt);
            }
        });

        boutonC4H.setBackground(new java.awt.Color(153, 204, 255));
        boutonC4H.setText("▼");
        boutonC4H.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boutonC4HActionPerformed(evt);
            }
        });

        boutonC6H.setBackground(new java.awt.Color(153, 204, 255));
        boutonC6H.setText("▼");
        boutonC6H.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boutonC6HActionPerformed(evt);
            }
        });

        boutonC2B.setBackground(new java.awt.Color(153, 204, 255));
        boutonC2B.setText("▲");
        boutonC2B.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boutonC2BActionPerformed(evt);
            }
        });

        boutonC4B.setBackground(new java.awt.Color(153, 204, 255));
        boutonC4B.setText("▲");
        boutonC4B.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boutonC4BActionPerformed(evt);
            }
        });

        boutonC6B.setBackground(new java.awt.Color(153, 204, 255));
        boutonC6B.setText("▲");
        boutonC6B.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boutonC6BActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(287, 287, 287)
                .addComponent(boutonC2B, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(139, 139, 139)
                .addComponent(boutonC4B, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(150, 150, 150)
                .addComponent(boutonC6B, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(boutonGauche, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(boutonDroite, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(TuileCourante, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 67, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(boutonL2G, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(boutonL6G, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(boutonL4G, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(PlateauDeJeu, javax.swing.GroupLayout.PREFERRED_SIZE, 630, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(boutonL2D, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(boutonL4D, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(boutonL6D, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(12, 12, 12))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(boutonC2H, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(159, 159, 159)
                        .addComponent(boutonC4H, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(162, 162, 162)
                        .addComponent(boutonC6H, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(144, 144, 144))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(205, 205, 205)
                        .addComponent(boutonL2G, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(154, 154, 154)
                        .addComponent(boutonL4G, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(81, 81, 81)
                        .addComponent(boutonL6G, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(189, 189, 189)
                        .addComponent(boutonL2D, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(81, 81, 81)
                        .addComponent(boutonL4D, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(63, 63, 63)
                        .addComponent(boutonL6D, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(boutonC4H, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(boutonC2H, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(boutonC6H, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(PlateauDeJeu, javax.swing.GroupLayout.DEFAULT_SIZE, 630, Short.MAX_VALUE)
                        .addGap(47, 47, 47)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(boutonC2B, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(boutonC6B, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(148, 148, 148))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(boutonC4B, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(135, 135, 135))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(TuileCourante, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(boutonGauche, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(boutonDroite, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(334, 334, 334))))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void boutonDroiteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boutonDroiteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_boutonDroiteActionPerformed

    private void boutonGaucheActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boutonGaucheActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_boutonGaucheActionPerformed

    private void boutonL2GActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boutonL2GActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_boutonL2GActionPerformed

    private void boutonL4GActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boutonL4GActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_boutonL4GActionPerformed

    private void boutonL6GActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boutonL6GActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_boutonL6GActionPerformed

    private void boutonL2DActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boutonL2DActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_boutonL2DActionPerformed

    private void boutonL4DActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boutonL4DActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_boutonL4DActionPerformed

    private void boutonL6DActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boutonL6DActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_boutonL6DActionPerformed

    private void boutonC2HActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boutonC2HActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_boutonC2HActionPerformed

    private void boutonC4HActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boutonC4HActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_boutonC4HActionPerformed

    private void boutonC6HActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boutonC6HActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_boutonC6HActionPerformed

    private void boutonC2BActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boutonC2BActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_boutonC2BActionPerformed

    private void boutonC4BActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boutonC4BActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_boutonC4BActionPerformed

    private void boutonC6BActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boutonC6BActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_boutonC6BActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(PlateauGraphique.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PlateauGraphique.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PlateauGraphique.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PlateauGraphique.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PlateauGraphique().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PlateauDeJeu;
    private javax.swing.JPanel TuileCourante;
    private javax.swing.JButton boutonC2B;
    private javax.swing.JButton boutonC2H;
    private javax.swing.JButton boutonC4B;
    private javax.swing.JButton boutonC4H;
    private javax.swing.JButton boutonC6B;
    private javax.swing.JButton boutonC6H;
    private javax.swing.JButton boutonDroite;
    private javax.swing.JButton boutonGauche;
    private javax.swing.JButton boutonL2D;
    private javax.swing.JButton boutonL2G;
    private javax.swing.JButton boutonL4D;
    private javax.swing.JButton boutonL4G;
    private javax.swing.JButton boutonL6D;
    private javax.swing.JButton boutonL6G;
    // End of variables declaration//GEN-END:variables
}
