/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jeulabyrinth;

import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.ImageIcon;

/**
 *
 * @author vdruo
 */
public class Tuile {
    
    // attribut direction qui est une ArrayList, qui comporte toutes les directions que le joueur peut emprunter
    ArrayList<String> directions; 
    // attribut object qui est un String, indique quel objet est present sur la tuile, indique null si aucun objet est present
    String object;
    // attribut nom qui est un String, qui indique ce que represente la case (objet, chemin, corner)
    String name;
    // attribut onBoard qui est un booleen, indique si la tuile est sur le plateau ou non
    boolean onBoard = true;
    // attribut qui indique la couleur du joueur sur la tuile, s'il y a un joueur
    ArrayList<String> colPlayer;
    // attribut int qui indique à quel fichier l'image de la tuile appartient en fonction de son sens
    int nImage = 1;
    
    String ANSI_RESET = "\u001B[0m";
    String ANSI_RED = "\u001B[31m";
    String ANSI_GREEN = "\u001B[32m";
    String ANSI_YELLOW = "\u001B[33m";
    String ANSI_BLUE = "\u001B[34m";
    String ANSI_PURPLE = "\u001B[35m";
    String ANSI_CYAN = "\u001B[36m";

    
    
    /**
     * Constructeur, attribut des valeurs aux diff?rents parametres en fonction de ce qu'on lui donne en parametre de fonction
     * @param direction attribut ways qui est une ArrayList, qui comporte toutes les directions de passage que la tuile peut permetre
     * @param object attribut object qui est un String, indique quel objet est present sur la tuile, indique null si aucun objet est present
     * @param onBoard attribut onBoard qui est un booleen, indique si la tuile est sur le plateau ou non
     */
    public Tuile(String object, String name) {
        this.directions = new ArrayList<String>();
        this.object = object;
        this.name = name;
        this.colPlayer = new ArrayList();
        this.object = ObjetTuile();
       
    }
    
    
    
    // Méthode pour ajouter une direction ? l'ArrayList direction
    public void ajouterDirection(String way) {
        directions.add(way);
    }
    
    
    // methode pour tourner la tuile dans le sens horaire, ce qui change les valeurs de direction
    public void tournerTuileSensHoraire() {
        
        for (int i = 0 ; i < directions.size() ; i++) {
               
            // remplacer "haut" par "droite"
            if (directions.get(i) == "haut") {
                directions.set(i, "droite");
            }
        
            // remplacer "droite" par "bas"
            else if (directions.get(i) == "droite") {
                directions.set(i, "bas");
            }
        
            // remplacer "bas" par "gauche"
            else if (directions.get(i) == "bas") {
                directions.set(i, "gauche");
            }
        
            // remplacer "gauche" par "haut"
            else if (directions.get(i) == "gauche") {
                directions.set(i, "haut");
            } 
        }
    }
    
    
    // methode pour tourner la tuile dans le sens trigonom?trique, ce qui change les valeurs de direction
    public void tournerTuileSensTrigo() {
        
        for (int i = 0 ; i < directions.size() ; i++) {
               
            // remplacer "haut" par "gauche"
            if (directions.get(i) == "haut") {
                directions.set(i, "gauche");
            }
        
            // remplacer "gauche" par "bas"
            else if (directions.get(i) == "gauche") {
                directions.set(i, "bas");
            }
        
            // remplacer "bas" par "droite"
            else if (directions.get(i) == "bas") {
                directions.set(i, "droite");
            }
        
            // remplacer "droite" par "haut"
            else if (directions.get(i) == "droite") {
                directions.set(i, "haut");
            } 
        }
    }

    
    
    public String getObject() {
        return object;
    }

    
    public String getName() {
        return name;
    }
    

    public ArrayList<String> getDirection() {
        return directions;
    }

    
    public boolean isOnBoard() {
        return onBoard;
    }

    
    public void setOnBoard(boolean onBoard) {
        this.onBoard = onBoard;
    }

    public void setColPlayer(String colplayer) {
        colPlayer.add(colplayer);
    }
    
    
    
    // methode qui dessine la tuille en fonction des directions qu'elle contient
    public String DessinTuile(int nLigne){
        // haut bas
        if (directions.equals(Arrays.asList("haut", "bas")) || directions.equals(Arrays.asList("bas", "haut"))) {
            return DessinHautBas(nLigne);}
        // droite gauche
        else if (directions.equals(Arrays.asList("droite", "gauche")) || directions.equals(Arrays.asList("gauche", "droite"))) {
            return DessinDroiteGauche(nLigne);}
        // haut droite
        else if (directions.equals(Arrays.asList("haut", "droite")) || directions.equals(Arrays.asList("droite", "haut"))) {
            return DessinHautDroite(nLigne);}
        // droite bas
        else if (directions.equals(Arrays.asList("droite", "bas")) || directions.equals(Arrays.asList("bas", "droite"))) {
            return DessinDroiteBas(nLigne);}
        // bas gauche
        else if (directions.equals(Arrays.asList("bas", "gauche")) || directions.equals(Arrays.asList("gauche", "bas"))) {
            return DessinBasGauche(nLigne);}
        // haut gauche
        else if (directions.equals(Arrays.asList("haut", "gauche")) || directions.equals(Arrays.asList("gauche", "haut"))) {
            return DessinHautGauche(nLigne);}
        // haut droite gauche
        else if (directions.equals(Arrays.asList("haut", "droite", "gauche")) || directions.equals(Arrays.asList("haut", "gauche", "droite")) || directions.equals(Arrays.asList("droite", "haut", "gauche")) || directions.equals(Arrays.asList("droite", "gauche", "haut")) || directions.equals(Arrays.asList("gauche", "haut", "droite")) || directions.equals(Arrays.asList("gauche", "droite", "haut"))) {
            return DessinHautDroiteGauche(nLigne);}
        // droite bas gauche
        else if (directions.equals(Arrays.asList("droite", "bas", "gauche")) || directions.equals(Arrays.asList("droite", "gauche", "bas")) || directions.equals(Arrays.asList("bas", "droite", "gauche")) || directions.equals(Arrays.asList("bas", "gauche", "droite")) || directions.equals(Arrays.asList("gauche", "droite", "bas")) || directions.equals(Arrays.asList("gauche", "bas", "droite"))) {
            return DessinDroiteBasGauche(nLigne);}
        // haut bas gauche
        else if (directions.equals(Arrays.asList("haut", "bas", "gauche")) || directions.equals(Arrays.asList("haut", "gauche", "bas")) || directions.equals(Arrays.asList("bas", "haut", "gauche")) || directions.equals(Arrays.asList("bas", "gauche", "haut")) || directions.equals(Arrays.asList("gauche", "haut", "bas")) || directions.equals(Arrays.asList("gauche", "bas", "haut"))) {
            return DessinHautBasGauche(nLigne);}
        // haut droite bas
        else {
            return DessinHautDroiteBas(nLigne);}
        
    }
    
    
    
    
    //dessine un chemin vertical
    public String DessinHautBas(int nLigne){
        String c1 = "////     ////";
        String c2 = "////     ////";
        String c3 = "//// " + ColorPlayerRouge() + object + ColorPlayerVert() +  " ////";
        String c4 = "//// " + ColorPlayerBleu() +  " " + ColorPlayerJaune() + " ////";
        String c5 = "////     ////";
        String c6 = "////     ////";
        
        if (nLigne == 1){
            return c1;
        } else if (nLigne==2){
            return c2;
        } else if (nLigne==3){
            return c3;
        }else if (nLigne==4){
            return c4;
        }else if (nLigne==5){
            return c5;
        }else {
            return c6;
        }
    }
    
    //dessine un chemin horizontal
    public String DessinDroiteGauche(int nLigne){
        String c1 = "/////////////";
        String c2 = "/////////////";
        String c3 = "     " + ColorPlayerBleu() + object + ColorPlayerJaune() +"     ";
        String c4 = "     " + ColorPlayerRouge() + " " + ColorPlayerVert() + "     ";
        String c5 = "/////////////";
        String c6 = "/////////////";
        
        if (nLigne == 1){
            return c1;
        } else if (nLigne==2){
            return c2;
        } else if (nLigne==3){
            return c3;
        }else if (nLigne==4){
            return c4;
        }else if (nLigne==5){
            return c5;
        }else {
            return c6;
        }
    }
    
    //dessine un corner "haut" et "droite"
    public String DessinHautDroite(int nLigne){
        String c1 = "////     ////";
        String c2 = "////     ////";
        String c3 = "//// " + ColorPlayerBleu() + object + ColorPlayerJaune() + "     ";
        String c4 = "//// " + ColorPlayerRouge() + " " + ColorPlayerVert() + "     ";
        String c5 = "/////////////";
        String c6 = "/////////////";
        
        if (nLigne == 1){
            return c1;
        } else if (nLigne==2){
            return c2;
        } else if (nLigne==3){
            return c3;
        }else if (nLigne==4){
            return c4;
        }else if (nLigne==5){
            return c5;
        }else {
            return c6;
        }
    }
    
    //dessine un corner "droite" et "bas"
    public String DessinDroiteBas(int nLigne){
        String c1 ="/////////////";
        String c2 ="/////////////";
        String c3 ="//// " + ColorPlayerRouge() + " " + ColorPlayerVert() + "     ";
        String c4 ="//// " + ColorPlayerBleu() + object + ColorPlayerJaune() + "     ";
        String c5 ="////     ////";
        String c6 ="////     ////";
        
        if (nLigne == 1){
            return c1;
        } else if (nLigne==2){
            return c2;
        } else if (nLigne==3){
            return c3;
        }else if (nLigne==4){
            return c4;
        }else if (nLigne==5){
            return c5;
        }else {
            return c6;
        }
    }
    
    //dessine un corner "bas" et "gauche"
    public String DessinBasGauche(int nLigne){
        String c1 ="/////////////";
        String c2 ="/////////////";
        String c3 ="     " + ColorPlayerRouge() + " " + ColorPlayerVert() + " ////";
        String c4 ="     " + ColorPlayerBleu() + object + ColorPlayerJaune() + " ////";
        String c5 ="////     ////";
        String c6 ="////     ////";
        
        if (nLigne == 1){
            return c1;
        } else if (nLigne==2){
            return c2;
        } else if (nLigne==3){
            return c3;
        }else if (nLigne==4){
            return c4;
        }else if (nLigne==5){
            return c5;
        }else {
            return c6;
        }
    }
    
    //dessine un corner "gauche" et "haut"
    public String DessinHautGauche(int nLigne){
        String c1 ="////     ////";
        String c2 ="////     ////";
        String c3 ="     " + ColorPlayerRouge() + " " + ColorPlayerVert() + " ////";
        String c4 ="     " + ColorPlayerBleu() + object + ColorPlayerJaune() + " ////";
        String c5 ="/////////////";
        String c6 ="/////////////";
        
        if (nLigne == 1){
            return c1;
        } else if (nLigne==2){
            return c2;
        } else if (nLigne==3){
            return c3;
        }else if (nLigne==4){
            return c4;
        }else if (nLigne==5){
            return c5;
        }else {
            return c6;
        }
    }
    
    //dessine un T "haut" "droite" et "gauche"
    public String DessinHautDroiteGauche(int nLigne){
        String c1 ="////     ////";
        String c2 ="////     ////";
        String c3 ="     " + ColorPlayerRouge() + " " + ColorPlayerVert() + "     ";
        String c4 ="     " + ColorPlayerBleu() + object + ColorPlayerJaune() + "     ";
        String c5 ="/////////////";
        String c6 ="/////////////";
        
        if (nLigne == 1){
            return c1;
        } else if (nLigne==2){
            return c2;
        } else if (nLigne==3){
            return c3;
        }else if (nLigne==4){
            return c4;
        }else if (nLigne==5){
            return c5;
        }else {
            return c6;
        }
    }
    
    //dessine un T "droite" "bas" et "gauche"
    public String DessinDroiteBasGauche(int nLigne){
        String c1 ="/////////////";
        String c2 ="/////////////";
        String c3 ="     " + ColorPlayerBleu() + object + ColorPlayerJaune() + "     ";
        String c4 ="     " + ColorPlayerRouge() + " " + ColorPlayerVert() + "     ";
        String c5 ="////     ////";
        String c6 ="////     ////";
        
        if (nLigne == 1){
            return c1;
        } else if (nLigne==2){
            return c2;
        } else if (nLigne==3){
            return c3;
        }else if (nLigne==4){
            return c4;
        }else if (nLigne==5){
            return c5;
        }else {
            return c6;
        }
    }
    
    //dessine un T "haut" "bas" et "gauche"
    public String DessinHautBasGauche(int nLigne){
        String c1 ="////     ////";
        String c2 ="////     ////";
        String c3 ="     " + ColorPlayerBleu() + object + ColorPlayerJaune() + " ////";
        String c4 ="     " + ColorPlayerRouge() + " " + ColorPlayerVert() + " ////";
        String c5 ="////     ////";
        String c6 ="////     ////";
        
        if (nLigne == 1){
            return c1;
        } else if (nLigne==2){
            return c2;
        } else if (nLigne==3){
            return c3;
        }else if (nLigne==4){
            return c4;
        }else if (nLigne==5){
            return c5;
        }else {
            return c6;
        }
    }
    
    //dessine un T "haut" "droite" et "bas"
    public String DessinHautDroiteBas(int nLigne){
        String c1 ="////     ////";
        String c2 ="////     ////";
        String c3 ="//// " + ColorPlayerBleu() + object + ColorPlayerJaune() + "     ";
        String c4 ="//// " + ColorPlayerRouge() + " " + ColorPlayerVert() + "     ";
        String c5 ="////     ////";
        String c6 ="////     ////";
        
        if (nLigne == 1){
            return c1;
        } else if (nLigne==2){
            return c2;
        } else if (nLigne==3){
            return c3;
        }else if (nLigne==4){
            return c4;
        }else if (nLigne==5){
            return c5;
        }else {
            return c6;
        }
    }
    
    
    //methode qui affiche l'objet de la tuile
    public String ObjetTuile(){
        if (object=="araignee"){
            return ANSI_CYAN + "a" + ANSI_RESET;
        } else if(object=="bague"){
            return ANSI_GREEN + "b" + ANSI_RESET;
        } else if(object=="bourse"){
            return ANSI_PURPLE + "b" + ANSI_RESET;
        } else if(object=="carteTresor"){
            return ANSI_RED + "c" + ANSI_RESET;
        } else if(object=="chandelier"){
            return ANSI_YELLOW + "c" + ANSI_RESET;
        } else if(object=="chauveSouris"){
            return ANSI_BLUE + "c" + ANSI_RESET;
        } else if(object=="chouette"){
            return ANSI_CYAN + "c" + ANSI_RESET;
        } else if(object=="cle"){
            return ANSI_GREEN + "c" + ANSI_RESET;
        } else if(object=="couronne"){
            return ANSI_RED + "M" + ANSI_RESET;
        } else if(object=="crane"){
            return ANSI_PURPLE + "c" + ANSI_RESET;
        } else if(object=="departB"){
            return ANSI_BLUE + "D" + ANSI_RESET;
        } else if(object=="departJ"){
            return ANSI_YELLOW + "D" + ANSI_RESET;
        } else if(object=="departR"){
            return ANSI_RED + "D" + ANSI_RESET;
        } else if(object=="departV"){
            return ANSI_GREEN + "D" + ANSI_RESET;
        } else if(object=="dragon"){
            return ANSI_YELLOW + "d" + ANSI_RESET;
        } else if(object=="epee"){
            return ANSI_BLUE + "e" + ANSI_RESET;
        } else if(object=="fantome"){
            return ANSI_CYAN + "f" + ANSI_RESET;
        } else if(object=="fee"){
            return ANSI_GREEN + "f" + ANSI_RESET;
        } else if(object=="genie"){
            return ANSI_PURPLE + "g" + ANSI_RESET;
        } else if(object=="gobelin"){
            return ANSI_RED + "g" + ANSI_RESET;
        } else if(object=="heaume"){
            return ANSI_YELLOW + "h" + ANSI_RESET;
        } else if(object=="lezard"){
            return ANSI_BLUE + "l" + ANSI_RESET;
        } else if(object=="livre"){
            return ANSI_CYAN + "l" + ANSI_RESET;
        } else if(object=="papillon"){
            return ANSI_GREEN + "p" + ANSI_RESET;
        } else if(object=="rat"){
            return ANSI_PURPLE + "r" + ANSI_RESET;
        } else if(object=="saphir"){
            return ANSI_RED + "s" + ANSI_RESET;
        } else if(object=="scarabee"){
            return ANSI_YELLOW + "s" + ANSI_RESET;
        } else if(object=="tresor"){
            return ANSI_PURPLE + "t" + ANSI_RESET;
        } else {
            return " ";
        }
    }
    
    // methode qui affiche la couleur du joueur
    // bleu
    public String ColorPlayerBleu(){
        if (colPlayer.contains("bleu")){
            return ANSI_BLUE + "X" + ANSI_RESET;
        } else {
            return " ";
        }
    }
    
    //vert
    public String ColorPlayerVert(){
        if (colPlayer.contains("vert")){
            return ANSI_GREEN + "X" + ANSI_RESET;
        } else {
            return " ";
        }
    }
    
    //jaune
    public String ColorPlayerJaune(){
        if (colPlayer.contains("jaune")){
            return ANSI_YELLOW + "X" + ANSI_RESET;
        } else {
            return " ";
        }
    }
    
    //rouge
    public String ColorPlayerRouge(){
        if (colPlayer.contains("rouge")){
            return ANSI_RED + "X" + ANSI_RESET;
        } else {
            return " ";
        }
    }
    
}





