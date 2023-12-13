/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package jeulabyrinth;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author vdruo
 */
public class PartieGraphique extends javax.swing.JFrame {

    int nbJoueur = 2;
    String nomJ1;
    String nomJ2;
    String nomJ3;
    String nomJ4;
    PlateauGraphique plateau;
    private ArrayList<Joueur> listeJoueurs = new ArrayList<>();
    Random generateurAleat = new Random();
    ArrayList<String> listeDeCartes;
    private Joueur joueurCourant;
    
    
    
    
    
    /**
     * Creates new form PartieGraphique
     */
    public PartieGraphique() {
        initComponents();
        creerArriereplan();
        ajouterPanneauJoueur();
        
    }

    
    //methode pour creer l'arriere plan, et ajouter les elements graphique par dessus
    public void creerArriereplan() {

        // Charger l'image de fond
        BufferedImage backgroundImage = null;
        try {
            backgroundImage = ImageIO.read(new File("./test/imageFond/imageFond.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Utiliser l'image de fond pour la fenêtre
        setContentPane(new JLabel(new ImageIcon(backgroundImage)));
    }
    
    //methode pour ajouter le panneauJoueurs
    public void ajouterPanneauJoueur(){
        placerElementsPanneauJoueurs();
        setLayout(new BorderLayout());
        panneauJoueurs.setOpaque(false);
        add(panneauJoueurs, BorderLayout.CENTER);
        setVisible(true);
    }
    
    //methode pour placer mes élements sur le pannel PanneauJoueurs
    public void placerElementsPanneauJoueurs(){
        panneauJoueurs.setLayout(new GridBagLayout());
        
        // ajouter le label Combien de joueurs voulez vous ?
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(0, 0, 500, 0);
        panneauJoueurs.add(jLabel1, gbc);
        
        // Créer un groupe de boutons pour en selectionner un a la fois
        ButtonGroup groupeBoutons = new ButtonGroup();
        groupeBoutons.add(bouton2J);
        groupeBoutons.add(bouton3J);
        groupeBoutons.add(bouton4J);
        
        // ajouter les boutons 
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(0, 0, 400, 200);
        panneauJoueurs.add(bouton2J, gbc);
         
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(0, 00, 400, 0);
        panneauJoueurs.add(bouton3J, gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(0, 200, 400, 0);
        panneauJoueurs.add(bouton4J, gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(0, 0, 300, 0);
        panneauJoueurs.add(boutonValider, gbc);  
    }
    
    
    //methode pour ajouter le panneauNomJoueurs
    public void ajouterPanneauNomJoueur(){
        placerElementsPanneauNomJoueurs();
        setLayout(new BorderLayout());
        panneauNomJoueurs.setOpaque(false);
        add(panneauNomJoueurs, BorderLayout.CENTER);
        setVisible(true);
    }
    
    //methode pour placer mes élements sur le pannel PanneauJoueurs
    public void placerElementsPanneauNomJoueurs(){
        panneauNomJoueurs.setLayout(new GridBagLayout());
        
        // ajouter le label NomJ1
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(0, 0, 500, 100);
        panneauNomJoueurs.add(LabelNomJ1, gbc);
        
        
        // NomJ2 
        gbc.insets = new Insets(0, 0, 400, 100);
        panneauNomJoueurs.add(LabelNomJ2, gbc);
        
        gbc.insets = new Insets(0, 0, 300, 100);
        panneauNomJoueurs.add(LabelNomJ3, gbc);
        
        
        gbc.insets = new Insets(0, 0, 200, 100);
        panneauNomJoueurs.add(LabelNomJ4, gbc);
        
        //ajouter les textFields
        gbc.insets = new Insets(0, 300, 500, 0);
        panneauNomJoueurs.add(NomJ1, gbc);
        NomJ1.setPreferredSize(new Dimension(150, NomJ1.getPreferredSize().height));
        
        gbc.insets = new Insets(0, 300, 400, 0);
        panneauNomJoueurs.add(NomJ2, gbc);
        NomJ2.setPreferredSize(new Dimension(150, NomJ2.getPreferredSize().height));
        
        gbc.insets = new Insets(0, 300, 300, 0);
        panneauNomJoueurs.add(NomJ3, gbc);
        NomJ3.setPreferredSize(new Dimension(150, NomJ3.getPreferredSize().height));
        
        gbc.insets = new Insets(0, 300, 200, 0);
        panneauNomJoueurs.add(NomJ4, gbc);
        NomJ4.setPreferredSize(new Dimension(150, NomJ4.getPreferredSize().height));
        
        gbc.insets = new Insets(0, 100, 0, 0);
        panneauNomJoueurs.add(boutonValider1, gbc);
        
        if (nbJoueur==2){
            LabelNomJ1.setVisible(true);
            LabelNomJ2.setVisible(true);
            LabelNomJ3.setVisible(false);
            LabelNomJ4.setVisible(false);
            NomJ1.setVisible(true);
            NomJ2.setVisible(true);
            NomJ3.setVisible(false);
            NomJ4.setVisible(false);
        } else if (nbJoueur==3){
            LabelNomJ1.setVisible(true);
            LabelNomJ2.setVisible(true);
            LabelNomJ3.setVisible(true);
            LabelNomJ4.setVisible(false);
            NomJ1.setVisible(true);
            NomJ2.setVisible(true);
            NomJ3.setVisible(true);
            NomJ4.setVisible(false);
        } else if (nbJoueur==4){
            LabelNomJ1.setVisible(true);
            LabelNomJ2.setVisible(true);
            LabelNomJ3.setVisible(true);
            LabelNomJ4.setVisible(true);
            NomJ1.setVisible(true);
            NomJ2.setVisible(true);
            NomJ3.setVisible(true);
            NomJ4.setVisible(true);
        }
    }
    
    //methode pour ajouter le panneauCarteEtBoutonsDeplacement a droite de la JFrame
    public void ajouterpanneauCarteEtBoutonsDeplacement(){
        placerElementspanneauCarteEtBoutonsDeplacement();
        setLayout(new BorderLayout());
        panneauCarteEtBoutonsDeplacement.setOpaque(false);
        add(panneauCarteEtBoutonsDeplacement, BorderLayout.EAST);
        panneauCarteEtBoutonsDeplacement.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 200));
        setVisible(true);
    }
    
    //methode pour placer mes élements sur le pannel panneauCarteEtBoutonsDeplacement
    public void placerElementspanneauCarteEtBoutonsDeplacement(){
        panneauCarteEtBoutonsDeplacement.setLayout(new GridBagLayout());
        
        // ajouter les éléments
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        
        // boutonDeplacerBas 
        gbc.insets = new Insets(500, 300, 0, 0);
        panneauCarteEtBoutonsDeplacement.add(boutonDeplacerBas, gbc);
        
        // boutonDeplacerHaut 
        gbc.insets = new Insets(400, 300, 0, 0);
        panneauCarteEtBoutonsDeplacement.add(boutonDeplacerHaut, gbc);
        
        // boutonOK 
        gbc.insets = new Insets(450, 300, 0, 0);
        panneauCarteEtBoutonsDeplacement.add(boutonOK, gbc);
        
        // boutonDeplacerGauche 
        gbc.insets = new Insets(450, 225, 0, 0);
        panneauCarteEtBoutonsDeplacement.add(boutonDeplacerGauche, gbc);
        
        // boutonDeplacerDroite 
        gbc.insets = new Insets(450, 375, 0, 0);
        panneauCarteEtBoutonsDeplacement.add(boutonDeplacerDroite, gbc);
        
        
    }
    
    //methode qui permet au joueur d'avancer
    public void avancerCase(String direction){
        plateau.plateauGraphique.avancerCase(joueurCourant.lireCouleur(), direction);   
    }
    
    // methode qui creer les joueurs
    public void creerJoueurs() {
        if (!nomJ1.isEmpty()){
            Joueur j1 = new Joueur(nomJ1);
            listeJoueurs.add(j1);
        }
        if (!nomJ2.isEmpty()){
            Joueur j2 = new Joueur(nomJ2);
            listeJoueurs.add(j2);
        }
        if (!nomJ3.isEmpty()){
            Joueur j3 = new Joueur(nomJ3);
            listeJoueurs.add(j3);
        }
        if (!nomJ4.isEmpty()){
            Joueur j4 = new Joueur(nomJ4);
            listeJoueurs.add(j4);
        }
    }
    
    // methode qui distribut aleatoirement une couleur aux joueurs
    public void attribuerCouleurJoueur() {
        
        ArrayList<String> dicoCouleur = new ArrayList<>();
        dicoCouleur.add("bleu");
        dicoCouleur.add("jaune");
        dicoCouleur.add("rouge");
        dicoCouleur.add("vert");
        
        for (int i=0 ; i<listeJoueurs.size() ; i++) {
            int a = generateurAleat.nextInt(dicoCouleur.size());
            listeJoueurs.get(i).affecterCouleur(dicoCouleur.get(a));
            dicoCouleur.remove(a);
        }
      
    }
    
    // creer la liste des objets à recolter pour chaque joueur
    public void creerListeObjetsJoueur() {
        CarteGraphique c = new CarteGraphique();
        listeDeCartes = new ArrayList<>();
        listeDeCartes = c.cartesObjet;
        
        // on veut 6 cartes par joueur
        for (int i = 0 ; i<listeJoueurs.size() ; i++){
            for (int j = 0 ; j<6 ; j++){
                int a = generateurAleat.nextInt(listeDeCartes.size());
                listeJoueurs.get(i).CartesJoueurs.add(listeDeCartes.get(a));
                listeDeCartes.remove(a);
            }
        } 
    }
    
    // changer le joueur courant
    public void changerJoueurCourant(){
        if (listeJoueurs.size()==2){
            if (joueurCourant==listeJoueurs.get(0)){
                joueurCourant=listeJoueurs.get(1);
            } else {
                joueurCourant=listeJoueurs.get(0);
            }      
            
        }else if(listeJoueurs.size()==3){
            if (joueurCourant==listeJoueurs.get(0)){
                joueurCourant=listeJoueurs.get(1);
            } else if (joueurCourant==listeJoueurs.get(1)){
                joueurCourant=listeJoueurs.get(2);
            } else {
                joueurCourant=listeJoueurs.get(0);
            }
            
        }else if(listeJoueurs.size()==4){
            if (joueurCourant==listeJoueurs.get(0)){
                joueurCourant=listeJoueurs.get(1);
            } else if (joueurCourant==listeJoueurs.get(1)){
                joueurCourant=listeJoueurs.get(2);
            } else if (joueurCourant==listeJoueurs.get(2)){
                joueurCourant=listeJoueurs.get(3);
            } else {
                joueurCourant=listeJoueurs.get(0);
            }
        }
        
        
    }
    
    //methode qui recolte l'objet du joueur 
    public void recolterObjet(){
        //obtenir la position du joueur
        for (int i = 0 ; i<7 ; i++){
            for (int j=0 ; j<7 ; j++){
                if(plateau.plateauGraphique.grilleDeJeu[i][j].colPlayer.contains(joueurCourant.lireCouleur())){
                    Tuile t = plateau.plateauGraphique.grilleDeJeu[i][j];
                    // verifier si la tuile contient l'objet que le joueur doit recolter
                    if (t.getObject().equals(joueurCourant.CartesJoueurs.get(0))){
                        joueurCourant.recolterObjet();
                    }
                }
            }
        }
    }
    
    //methode qui initialise la partie
    public void initialiserPartie(){
        creerJoueurs();
        attribuerCouleurJoueur();
        creerListeObjetsJoueur();
        // un joueur au hazard debute
        
        int a = generateurAleat.nextInt(listeJoueurs.size());
        joueurCourant = listeJoueurs.get(a);
        
        // creer le plateau et affiche la position des joueurs
        plateau = new PlateauGraphique();
        for (int i=0 ; i<listeJoueurs.size() ; i++){
            switch (listeJoueurs.get(i).lireCouleur()) {
                case "bleu" :
                    plateau.plateauGraphique.grilleDeJeu[0][0].setColPlayer("bleu");
                    break;
                case "jaune" :
                    plateau.plateauGraphique.grilleDeJeu[6][0].setColPlayer("jaune");
                    break;
                case "rouge" :
                    plateau.plateauGraphique.grilleDeJeu[6][6].setColPlayer("rouge");
                    break;
                case "vert" :
                    plateau.plateauGraphique.grilleDeJeu[0][6].setColPlayer("vert");
                    break;
            }
        }
        
        add(plateau.layeredPane);
        ajouterpanneauCarteEtBoutonsDeplacement();   
    }
    
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panneauJoueurs = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        bouton2J = new javax.swing.JRadioButton();
        bouton3J = new javax.swing.JRadioButton();
        bouton4J = new javax.swing.JRadioButton();
        boutonValider = new javax.swing.JToggleButton();
        panneauNomJoueurs = new javax.swing.JPanel();
        LabelNomJ1 = new javax.swing.JLabel();
        LabelNomJ2 = new javax.swing.JLabel();
        LabelNomJ3 = new javax.swing.JLabel();
        LabelNomJ4 = new javax.swing.JLabel();
        NomJ1 = new javax.swing.JTextField();
        NomJ2 = new javax.swing.JTextField();
        NomJ3 = new javax.swing.JTextField();
        NomJ4 = new javax.swing.JTextField();
        boutonValider1 = new javax.swing.JToggleButton();
        panneauCarteEtBoutonsDeplacement = new javax.swing.JPanel();
        boutonDeplacerDroite = new javax.swing.JButton();
        boutonDeplacerGauche = new javax.swing.JButton();
        boutonDeplacerBas = new javax.swing.JButton();
        boutonDeplacerHaut = new javax.swing.JButton();
        boutonOK = new javax.swing.JButton();
        CarteObjet = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(700, 700));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel1.setText("Combien de joueurs êtes-vous ?");

        bouton2J.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        bouton2J.setText("2");

        bouton3J.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        bouton3J.setText("3");

        bouton4J.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        bouton4J.setText("4");

        boutonValider.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        boutonValider.setText("Valider");
        boutonValider.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boutonValiderActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panneauJoueursLayout = new javax.swing.GroupLayout(panneauJoueurs);
        panneauJoueurs.setLayout(panneauJoueursLayout);
        panneauJoueursLayout.setHorizontalGroup(
            panneauJoueursLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panneauJoueursLayout.createSequentialGroup()
                .addContainerGap(35, Short.MAX_VALUE)
                .addGroup(panneauJoueursLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panneauJoueursLayout.createSequentialGroup()
                        .addComponent(bouton2J, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(61, 61, 61)
                        .addComponent(bouton3J)
                        .addGap(64, 64, 64)
                        .addComponent(bouton4J, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(175, 175, 175))
            .addGroup(panneauJoueursLayout.createSequentialGroup()
                .addGap(95, 95, 95)
                .addComponent(boutonValider, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panneauJoueursLayout.setVerticalGroup(
            panneauJoueursLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panneauJoueursLayout.createSequentialGroup()
                .addGap(94, 94, 94)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panneauJoueursLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bouton2J)
                    .addComponent(bouton3J)
                    .addComponent(bouton4J))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(boutonValider)
                .addContainerGap(26, Short.MAX_VALUE))
        );

        getContentPane().add(panneauJoueurs, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 490, 260));

        LabelNomJ1.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        LabelNomJ1.setText("Nom Joueur 1 :");

        LabelNomJ2.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        LabelNomJ2.setText("Nom Joueur 2 :");

        LabelNomJ3.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        LabelNomJ3.setText("Nom Joueur 3 :");

        LabelNomJ4.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        LabelNomJ4.setText("Nom Joueur 4 :");

        NomJ1.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        NomJ1.setMinimumSize(new java.awt.Dimension(150, 250));
        NomJ1.setName(""); // NOI18N

        NomJ2.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        NomJ2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NomJ2ActionPerformed(evt);
            }
        });

        NomJ3.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N

        NomJ4.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N

        boutonValider1.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        boutonValider1.setText("Valider");
        boutonValider1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boutonValider1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panneauNomJoueursLayout = new javax.swing.GroupLayout(panneauNomJoueurs);
        panneauNomJoueurs.setLayout(panneauNomJoueursLayout);
        panneauNomJoueursLayout.setHorizontalGroup(
            panneauNomJoueursLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panneauNomJoueursLayout.createSequentialGroup()
                .addGap(243, 243, 243)
                .addGroup(panneauNomJoueursLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(LabelNomJ1)
                    .addComponent(LabelNomJ2)
                    .addComponent(LabelNomJ3)
                    .addComponent(LabelNomJ4))
                .addGap(30, 30, 30)
                .addGroup(panneauNomJoueursLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(NomJ2, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(NomJ3, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(NomJ4, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(NomJ1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(23, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panneauNomJoueursLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(boutonValider1, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(210, 210, 210))
        );
        panneauNomJoueursLayout.setVerticalGroup(
            panneauNomJoueursLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panneauNomJoueursLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(panneauNomJoueursLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LabelNomJ1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(NomJ1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panneauNomJoueursLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LabelNomJ2, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(NomJ2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panneauNomJoueursLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(NomJ3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LabelNomJ3, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panneauNomJoueursLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(NomJ4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LabelNomJ4, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(boutonValider1)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        getContentPane().add(panneauNomJoueurs, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 260, 570, 260));

        boutonDeplacerDroite.setBackground(new java.awt.Color(153, 204, 255));
        boutonDeplacerDroite.setText("►");
        boutonDeplacerDroite.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boutonDeplacerDroiteActionPerformed(evt);
            }
        });

        boutonDeplacerGauche.setBackground(new java.awt.Color(153, 204, 255));
        boutonDeplacerGauche.setText("◄");
        boutonDeplacerGauche.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boutonDeplacerGaucheActionPerformed(evt);
            }
        });

        boutonDeplacerBas.setBackground(new java.awt.Color(153, 204, 255));
        boutonDeplacerBas.setText("▼");
        boutonDeplacerBas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boutonDeplacerBasActionPerformed(evt);
            }
        });

        boutonDeplacerHaut.setBackground(new java.awt.Color(153, 204, 255));
        boutonDeplacerHaut.setText("▲");
        boutonDeplacerHaut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boutonDeplacerHautActionPerformed(evt);
            }
        });

        boutonOK.setBackground(new java.awt.Color(153, 204, 255));
        boutonOK.setText("OK");
        boutonOK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boutonOKActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panneauCarteEtBoutonsDeplacementLayout = new javax.swing.GroupLayout(panneauCarteEtBoutonsDeplacement);
        panneauCarteEtBoutonsDeplacement.setLayout(panneauCarteEtBoutonsDeplacementLayout);
        panneauCarteEtBoutonsDeplacementLayout.setHorizontalGroup(
            panneauCarteEtBoutonsDeplacementLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panneauCarteEtBoutonsDeplacementLayout.createSequentialGroup()
                .addGroup(panneauCarteEtBoutonsDeplacementLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panneauCarteEtBoutonsDeplacementLayout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addGroup(panneauCarteEtBoutonsDeplacementLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(boutonDeplacerBas, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(panneauCarteEtBoutonsDeplacementLayout.createSequentialGroup()
                                .addComponent(boutonDeplacerGauche, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(boutonOK, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(panneauCarteEtBoutonsDeplacementLayout.createSequentialGroup()
                        .addGap(142, 142, 142)
                        .addComponent(boutonDeplacerDroite, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panneauCarteEtBoutonsDeplacementLayout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(boutonDeplacerHaut, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(418, Short.MAX_VALUE))
        );
        panneauCarteEtBoutonsDeplacementLayout.setVerticalGroup(
            panneauCarteEtBoutonsDeplacementLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panneauCarteEtBoutonsDeplacementLayout.createSequentialGroup()
                .addGap(72, 72, 72)
                .addComponent(boutonDeplacerHaut, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addGroup(panneauCarteEtBoutonsDeplacementLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(boutonDeplacerGauche, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(boutonDeplacerDroite, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(boutonOK, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(boutonDeplacerBas, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        getContentPane().add(panneauCarteEtBoutonsDeplacement, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 530, 600, 220));

        CarteObjet.setBackground(new java.awt.Color(153, 204, 255));
        CarteObjet.setMinimumSize(new java.awt.Dimension(90, 90));
        CarteObjet.setPreferredSize(new java.awt.Dimension(0, 0));
        CarteObjet.setLayout(new java.awt.GridLayout(1, 1));
        getContentPane().add(CarteObjet, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 800, 90, 90));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void boutonValiderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boutonValiderActionPerformed
        // Récupérer la valeur du bouton sélectionné
                if (bouton2J.isSelected()) {
                    nbJoueur = 2;
                    System.out.println(nbJoueur);
                } else if (bouton3J.isSelected()) {
                    nbJoueur = 3;
                    System.out.println(nbJoueur);
                } else if (bouton4J.isSelected()) {
                    nbJoueur = 4;
                    System.out.println(nbJoueur);
                } else {
                    System.out.println("Aucune option sélectionnée");
                }
        //supprimer le panneau
        remove(panneauJoueurs);
        revalidate();
        repaint();
        
        //affiche le panneau avec les noms de joueurs
        ajouterPanneauNomJoueur();
    }//GEN-LAST:event_boutonValiderActionPerformed

    private void boutonValider1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boutonValider1ActionPerformed
        // recupérer le nom des joueurs
        nomJ1 = NomJ1.getText();
        nomJ2 = NomJ2.getText();
        nomJ3 = NomJ3.getText();
        nomJ4 = NomJ4.getText();
        
        //supprimer le panneau
        remove(panneauNomJoueurs);
        revalidate();
        repaint();
        
        //afficher la grille de jeu
        initialiserPartie();
        
    }//GEN-LAST:event_boutonValider1ActionPerformed

    private void NomJ2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NomJ2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_NomJ2ActionPerformed

    private void boutonDeplacerDroiteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boutonDeplacerDroiteActionPerformed
        avancerCase("droite");
        plateau.mettreAJourPlateauGraphique();
        repaint();
    }//GEN-LAST:event_boutonDeplacerDroiteActionPerformed

    private void boutonDeplacerGaucheActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boutonDeplacerGaucheActionPerformed
        avancerCase("gauche");
        plateau.mettreAJourPlateauGraphique();
        repaint();
    }//GEN-LAST:event_boutonDeplacerGaucheActionPerformed

    private void boutonDeplacerBasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boutonDeplacerBasActionPerformed
        avancerCase("bas");
        plateau.mettreAJourPlateauGraphique();
        repaint();
    }//GEN-LAST:event_boutonDeplacerBasActionPerformed

    private void boutonDeplacerHautActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boutonDeplacerHautActionPerformed
        avancerCase("haut");
        plateau.mettreAJourPlateauGraphique();
        repaint();
    }//GEN-LAST:event_boutonDeplacerHautActionPerformed

    private void boutonOKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boutonOKActionPerformed
        plateau.mettreAJourPlateauGraphique();
        repaint();
        recolterObjet();
        changerJoueurCourant();
        System.out.println(joueurCourant.couleur + joueurCourant.getNom() + "Vous devez collecter l'objet " + joueurCourant.CartesJoueurs.get(0) + ". Il vous reste " + joueurCourant.CartesJoueurs.size() + " objets a recolter.");
    }//GEN-LAST:event_boutonOKActionPerformed

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
            java.util.logging.Logger.getLogger(PartieGraphique.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PartieGraphique.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PartieGraphique.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PartieGraphique.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PartieGraphique().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel CarteObjet;
    private javax.swing.JLabel LabelNomJ1;
    private javax.swing.JLabel LabelNomJ2;
    private javax.swing.JLabel LabelNomJ3;
    private javax.swing.JLabel LabelNomJ4;
    private javax.swing.JTextField NomJ1;
    private javax.swing.JTextField NomJ2;
    private javax.swing.JTextField NomJ3;
    private javax.swing.JTextField NomJ4;
    private javax.swing.JRadioButton bouton2J;
    private javax.swing.JRadioButton bouton3J;
    private javax.swing.JRadioButton bouton4J;
    private javax.swing.JButton boutonDeplacerBas;
    private javax.swing.JButton boutonDeplacerDroite;
    private javax.swing.JButton boutonDeplacerGauche;
    private javax.swing.JButton boutonDeplacerHaut;
    private javax.swing.JButton boutonOK;
    private javax.swing.JToggleButton boutonValider;
    private javax.swing.JToggleButton boutonValider1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel panneauCarteEtBoutonsDeplacement;
    private javax.swing.JPanel panneauJoueurs;
    private javax.swing.JPanel panneauNomJoueurs;
    // End of variables declaration//GEN-END:variables
}
