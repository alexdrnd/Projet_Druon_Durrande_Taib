/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jeulabyrinth;

import java.util.ArrayList;
import java.util.Random;



/**
 *
 * @author vdruo
 */
public class Plateau {
    
    // attribut grilleDeJeu qui est un tableau ? deux dimensions de Tuiles, qui va permettre de repr?senter la grille de jeu
    Tuile[][] grilleDeJeu;
    // attribut TuilesDeJeu qui est une ArrayList, elle contient toutes les tuiles du jeu (tuiles "objets", tuiles "d?part", tuiles "chemin, tuiles "corner")
    ArrayList<Tuile> TuilesDeJeu = new ArrayList<Tuile>();
    // attribut tuileCourante, qui contient la tuile qui n'est pas sur le plateau
    Tuile tuileCourante;
    
    String ANSI_RESET = "\u001B[0m";
    String ANSI_RED = "\u001B[31m";
    
    
    public Plateau() {
        ajoutTuilesDeJeu();
        grilleDeJeu = creerGrilleDeJeu();
    }
    
    
    // methode qui créer et ajoute ? la liste TuilesDeJeu l'ensemble des tuiles du jeu
    public void ajoutTuilesDeJeu() {
        // ajouter les 24 tuiles "objet"
        String[][] DicoObjets = DicoObjets();
        
        for (int i=0 ; i<DicoObjets.length ; i++){
            
            // ajouter l'objet
            Tuile tuile = creerTuileObjet(DicoObjets[i][0]);
            
            // ajouter les directions
            for (int j=1 ; j<4 ; j++) {
                if (DicoObjets[i][j]!= null){
                    tuile.ajouterDirection(DicoObjets[i][j]);
                }
            }
            TuilesDeJeu.add(tuile);
        }
        
        // ajouter les 12 tuiles "chemin"
        for (int i=0 ; i<12 ; i++) {
            Tuile tuile = creerTuileChemin();
            TuilesDeJeu.add(tuile);
        }
        
        // ajouter les 10 tuiles "corner"
        for (int i=0 ; i<10 ; i++) {
            Tuile tuile = creerTuileCorner();
            TuilesDeJeu.add(tuile);
        }
    }
    
    
    // methode qui renvoit le dictionnaire comprenant les infos des direction de chaque tuile "objet"
    public String[][] DicoObjets(){
        // dictionnaire
        String[][] DicoObjets = {
                                    {"araignee","haut","gauche",null}, 
                                    {"bague","haut","bas","gauche"},
                                    {"bourse","haut","droite","gauche"},
                                    {"carteTresor","haut","bas","gauche"},
                                    {"chandelier","droite","bas","gauche"},
                                    {"chauveSouris","haut","droite","gauche"},
                                    {"chouette","droite","bas",null},
                                    {"cle","haut","droite","gauche"},
                                    {"couronne","haut","bas","gauche"},
                                    {"crane","haut","droite","bas"},
                                    {"dragon","haut","droite","gauche"},
                                    {"epee","haut","droite","bas"},
                                    {"fantome","haut","droite","gauche"},
                                    {"fee","haut","droite","gauche"},
                                    {"genie","haut","droite","gauche"},
                                    {"gobelin","haut","droite","gauche"},
                                    {"heaume","droite","bas","gauche"},
                                    {"lezard","haut","gauche",null},
                                    {"livre","haut","droite","gauche"},
                                    {"papillon","haut","gauche",null},
                                    {"rat","bas","gauche",null},
                                    {"saphir","haut","droite","bas"},
                                    {"scarabee","haut","droite",null},
                                    {"tresor","droite","bas","gauche"},
                                    {"departB","droite","bas",null},
                                    {"departJ","haut","droite",null},
                                    {"departR","haut","gauche",null},
                                    {"departV","bas","gauche",null} 
                                 };
        
        return DicoObjets;
    }
    
    // methode pour creer une tuile de type "objet"
    public Tuile creerTuileObjet(String objet){
        Tuile tuile = new Tuile(objet, objet);
        return tuile;
    }
    
    // methode pour creer une tuile de type "chemin"
    public Tuile creerTuileChemin(){
        Tuile tuile = new Tuile(" ", "chemin");
        tuile.ajouterDirection("haut");
        tuile.ajouterDirection("bas");
        return tuile;
    }
    
    // methode pour creer une tuile de type "corner"
    public Tuile creerTuileCorner(){
        Tuile tuile = new Tuile(" ", "corner");
        tuile.ajouterDirection("droite");
        tuile.ajouterDirection("bas");
        return tuile;
    }
    
    
    // methode qui permet de creer la grille de jeu
    public Tuile[][] creerGrilleDeJeu() {
        
        //creer la grille de dimension 7x7
        Tuile[][] grille = new Tuile[7][7];
        
        // placer les tuiles fixes, celles qui ne peuvent pas bouger (elles contiennent toutes un objet)
        String[] DicoTuilesFixes = DicoTuilesFixes();
        int indexDico = 0;
        for (int i = 0 ; i<7 ; i+=2){
            for (int j=0 ; j<7 ; j+=2) {
                ajouterTuileFixeAGrilleDeJeu(grille, DicoTuilesFixes[indexDico], i, j);
                indexDico+=1;
            }
        }  
        
        // placer les autres tuiles aleatoirement et melangees (on tourne un nombre de fois aleatoire la tuile pour que les directions soit au hazard)
        for (int i=0 ; i<7 ; i++) {
            for (int j=0 ; j<7 ; j++) {
                // pour les lignes d'indice pair (0,2,4,6), ajouter seulement des tuiles sur les colonnes impairs (1,3,5)
                if (i%2 == 0) {
                    if (j%2 == 1){
                        Tuile t = GetTuileAleat();
                        ajouterTuileAGrilleDeJeu(grille, t, i, j);
                    }
                } 
                // sinon, pour les lignes d'indice impair (1,3,5), ajouter des tuiles sur toutes les colonnes
                else {
                    Tuile t = GetTuileAleat();
                    ajouterTuileAGrilleDeJeu(grille, t, i, j);
                }
            }
        }
        
        tuileCourante = TuilesDeJeu.get(0);
        TuilesDeJeu.remove(0);
        tuileCourante.setOnBoard(false);
        return grille;
    }
    
    
    // methode qui renvoit le dictionnaire comprenant le nom des tuiles fixes, rang?e dans l'ordre
    public String[] DicoTuilesFixes() {
        // dictionnaire
        String[] DicoTuilesFixes = {"departB",
                                    "heaume",
                                    "chandelier",
                                    "departV",
                                    "epee",
                                    "saphir",
                                    "tresor",
                                    "bague",
                                    "crane",
                                    "cle",
                                    "couronne",
                                    "carteTresor",
                                    "departJ",
                                    "bourse",
                                    "livre",
                                    "departR"
                                    };
        return DicoTuilesFixes;
    }
    
    
    // methode pour ajouter une tuile fixe a la grille de jeu, cette tuile est ensuite retiree de l'arrayList
    public Tuile[][] ajouterTuileFixeAGrilleDeJeu(Tuile[][] grille, String name, int nLigne, int nColonne) {
        
        for (Tuile tuile : TuilesDeJeu) {
            if (tuile.getName().equals(name)) {
                grille[nLigne][nColonne] = tuile;
                TuilesDeJeu.remove(tuile);
                break; // Arr?ter la boucle car la tuile a ?t? trouv?e
            }
        }
         
       return grille;
    }
    
    
    // methode pour ajouter une tuile precise a la grille de jeu, cette tuile est ensuite retiree de l'arrayList
    public Tuile[][] ajouterTuileAGrilleDeJeu(Tuile[][] grille, Tuile t, int nLigne, int nColonne) {
        
        grille[nLigne][nColonne] = t;
        TuilesDeJeu.remove(t);        
        return grille;
    }
    
    
    // methode qui retourne aleatoirement une tuile dans l'arrayList TuilesDeJeu et qui la tourne aleatoirement
    public Tuile GetTuileAleat(){
        // piocher aleatoirement une tuile dans l'arraylist TuilesDeJeu
        Random random = new Random();
        int indexTuileAleat = random.nextInt(TuilesDeJeu.size());
        Tuile t = TuilesDeJeu.get(indexTuileAleat);
        
        // tourner un nombre aleatoire de fois cette tuile
        int nbTour = random.nextInt(1, 5);
        t.nImage = nbTour+1;
        if (t.nImage==5) {
            t.nImage=1;
        }
        for (int i=0 ; i<nbTour ; i++) {
            t.tournerTuileSensHoraire();
        }
        
        // retourner la tuile
        return t;
    }
    
    
// methodes qui permettent d'inserer la tuileCourante dans le plateau
    //methode pour inserer la tuile courante sur une ligne vers la droite (du cote gauche)
    public void insererTuileLigneAGauche(int nLigne){
        //on peut bouger uniquement les lignes d'indice impair
        if (nLigne%2==1 && nLigne<7){
            Tuile tDeReserve = grilleDeJeu[nLigne][6];
            // basculer les tuiles vers la droite 
            for (int i=0 ; i<6 ; i++) {
                grilleDeJeu[nLigne][6-i] = grilleDeJeu[nLigne][5-i];
            }
            grilleDeJeu[nLigne][0] = tuileCourante;
            grilleDeJeu[nLigne][0].setOnBoard(true);
            tuileCourante = tDeReserve;
            tuileCourante.setOnBoard(false);
        }
    }
    
    //methode pour inserer la tuile courante sur une ligne vers la gauche (du cote droit)
    public void insererTuileLigneADroite(int nLigne){
        //on peut bouger uniquement les lignes d'indice impair
        if (nLigne%2==1 && nLigne<7){
            Tuile tDeReserve = grilleDeJeu[nLigne][0];
            // basculer les tuiles vers la gauche 
            for (int i=0 ; i<6 ; i++) {
                grilleDeJeu[nLigne][i] = grilleDeJeu[nLigne][1+i];
            }
            grilleDeJeu[nLigne][6] = tuileCourante;
            grilleDeJeu[nLigne][6].setOnBoard(true);
            tuileCourante = tDeReserve;
            tuileCourante.setOnBoard(false);
        }
    }
    
    //methode pour inserer la tuile courante sur une colonne vers le bas (en haut)
    public void insererTuileColonneHaut(int nColonne){
        //on peut bouger uniquement les colonne d'indice impair
        if (nColonne%2==1 && nColonne<7){
            Tuile tDeReserve = grilleDeJeu[6][nColonne];
            // basculer les tuiles vers le bas 
            for (int i=0 ; i<6 ; i++) {
                grilleDeJeu[6-i][nColonne] = grilleDeJeu[5-i][nColonne];
            }
            grilleDeJeu[0][nColonne] = tuileCourante;
            grilleDeJeu[0][nColonne].setOnBoard(true);
            tuileCourante = tDeReserve;
            tuileCourante.setOnBoard(false);
        }
    }
    
    //methode pour inserer la tuile courante sur une colonne vers le haut (en bas)
    public void insererTuileColonneBas(int nColonne){
        //on peut bouger uniquement les colonne d'indice impair
        if (nColonne%2==1 && nColonne<7){
            Tuile tDeReserve = grilleDeJeu[0][nColonne];
            // basculer les tuiles vers le haut 
            for (int i=0 ; i<6 ; i++) {
                grilleDeJeu[i][nColonne] = grilleDeJeu[i+1][nColonne];
            }
            grilleDeJeu[6][nColonne] = tuileCourante;
            grilleDeJeu[6][nColonne].setOnBoard(true);
            tuileCourante = tDeReserve;
            tuileCourante.setOnBoard(false);
        }
    }
    
    
    
    // methode qui verifie les directions d'une tuile donné, pour savoir si on peut avancer sur la tuile d'apres
    public boolean verifDirection(Tuile t, String direction) {
        if (t.getDirection().contains(direction)) {
            return true;
        } else {
            return false;
        }
    }
    
    
    // methode qui avance le joueur sur la tuile suivant s'il peut y aller
    public void avancerCase(String colplayer, String direction) {
        int n=0;
        for (int i=0 ; i<7 ; i++){
            for (int j=0 ; j<7 ; j++){
                if(grilleDeJeu[i][j].colPlayer.contains(colplayer)){
                    if (grilleDeJeu[i][j].getDirection().contains(direction)) {
                        switch (direction) {
                            case "haut" : 
                                if (i>0) {
                                    if (grilleDeJeu[i-1][j].getDirection().contains("bas")) {
                                        grilleDeJeu[i][j].colPlayer.remove(colplayer);
                                        grilleDeJeu[i-1][j].setColPlayer(colplayer);
                                        n+=1;
                                        break;
                                    }break;
                                }break;
                            case "droite" : 
                                if (j<6) {
                                    if (grilleDeJeu[i][j+1].getDirection().contains("gauche")) {
                                        grilleDeJeu[i][j].colPlayer.remove(colplayer);
                                        grilleDeJeu[i][j+1].setColPlayer(colplayer);
                                        n+=1;
                                        break;
                                    }break;
                                }break;
                            case "bas" : 
                                if (i<6) {
                                    if (grilleDeJeu[i+1][j].getDirection().contains("haut")) {
                                        grilleDeJeu[i][j].colPlayer.remove(colplayer);
                                        grilleDeJeu[i+1][j].setColPlayer(colplayer);
                                        n+=1;
                                        break;
                                    }break;
                                }break;
                            case "gauche" : 
                                if (j>0) {
                                    if (grilleDeJeu[i][j-1].getDirection().contains("droite")) {
                                        grilleDeJeu[i][j].colPlayer.remove(colplayer);
                                        grilleDeJeu[i][j-1].setColPlayer(colplayer);
                                        n+=1;
                                        break;
                                    }break;
                                }break;
                        }      
                    }break;
                }   
            } 
        if (n==1){
                break;
            }     
        } 
    }

    
    public String afficherGrilleDeJeu() {
        String c="";
        
        
        for (int i=1; i<8 ; i++){
            for (int k=1; k<7 ; k++){
                
                for (int j=1 ; j<8 ; j++){
                
                    c+= grilleDeJeu[i-1][j-1].DessinTuile(k);
                    if (j<7){
                        c+= ANSI_RED + "|" + ANSI_RESET;
                    }
                    if (j==7) {
                        c+= "\n";
                    }
                    
                }
            }
            if (i<7){
                c+= ANSI_RED + "--------------------------------------------------------------------------------------------------\n" + ANSI_RESET;
            }
        }
        
        c+="\n\n\n" + afficherTuileCourante();
        
        return c;
    }
   
    
    // affiche la tuille courante
    public String afficherTuileCourante(){
        String c="";
        for (int k = 1 ; k<7 ; k++){
            c+=tuileCourante.DessinTuile(k);
            c+="\n";
        }
        return c;
    }
    
    
    
    
    
}

