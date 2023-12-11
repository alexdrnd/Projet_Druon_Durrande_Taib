/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jeulabyrinth;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author vdruo
 */
public class Partie {
    
    private ArrayList<Joueur> listeJoueurs = new ArrayList<>();
    private Joueur joueurCourant;
    public Plateau plateau;
    Random generateurAleat = new Random();
    Scanner sc = new Scanner(System.in);

    public Partie() {
        initialiserPartie();
        lancerPartie();
    }
    
    // methode qui creer les joueurs
    public void creerJoueurs() {
        int nbJoueurs = 0;
        while (nbJoueurs!=2 && nbJoueurs!=3 && nbJoueurs!=4){
        System.out.println("Combien de joueurs etes-vous ?");
        nbJoueurs = sc.nextInt();

        if (nbJoueurs >= 2 && nbJoueurs <= 4) {
            for (int i = 1; i <= nbJoueurs; i++) {
                System.out.println("Quel est le nom du joueur " + i + "?");
                String playerName = sc.next();
                Joueur joueur = new Joueur(playerName);
                listeJoueurs.add(joueur);
            }
        } else {
            System.out.println("Le nombre de joueurs specifie n'est pas pris en charge. Veuillez recommencez.\n");
        }
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
        Carte c = new Carte();
        ArrayList<String> listeDeCartes = new ArrayList<>();
        listeDeCartes = c.creerListeCarte();
        
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
    
    //methode qui initialise la partie
    public void initialiserPartie(){
        creerJoueurs();
        attribuerCouleurJoueur();
        creerListeObjetsJoueur();
        // un joueur au hazard debute
        
        int a = generateurAleat.nextInt(listeJoueurs.size());
        joueurCourant = listeJoueurs.get(a);
        
        // creer le plateau et affiche la position des joueurs
        plateau = new Plateau();
        for (int i=0 ; i<listeJoueurs.size() ; i++){
            switch (listeJoueurs.get(i).lireCouleur()) {
                case "bleu" :
                    plateau.grilleDeJeu[0][0].setColPlayer("bleu");
                    break;
                case "jaune" :
                    plateau.grilleDeJeu[6][0].setColPlayer("jaune");
                    break;
                case "rouge" :
                    plateau.grilleDeJeu[6][6].setColPlayer("rouge");
                    break;
                case "vert" :
                    plateau.grilleDeJeu[0][6].setColPlayer("vert");
                    break;
            }
        }
        
        System.out.println(plateau.afficherGrilleDeJeu());
    }
    
    //methode qui lance la partie
    public void lancerPartie(){
        
        // tant qu'aucun joueur n'a gagne, la partie se profile de la meme maniere :
        while (leJeuContinu()){
            System.out.println(joueurCourant.getNom() + ", c'est a vous de jouer. Vous etes le joueur " + joueurCourant.lireCouleur());
            System.out.println("Vous devez collecter l'objet " + joueurCourant.CartesJoueurs.get(0) + ". Il vous reste " + joueurCourant.CartesJoueurs.size() + " objets a recolter.");
            // demander au joueur s'il veut tourner la tuile ou la placer sur la grille
            tournerOuPlacerTuile();
            //demander au joueur d'avancer
            avancerCase();
            //verifier si le joueur recupere un objet et le retirer de sa liste
            recolterObjet();
            //passer au joueur suivant
            changerJoueurCourant();
        }
        
        System.out.println("Felicitation " + joueurCourant.getNom() + ", vous avez gagne !");
        
    }
    
    //methode qui verifie qu'aucun joueur n'a gagné, cad que tous les joueurs doivent encore recuperer des objets
    public boolean leJeuContinu(){
        boolean rep = true;
        for (int i=0 ; i<listeJoueurs.size() ; i++){
            if (listeJoueurs.get(i).Victoire()){
                rep =false;
            }
        }
        return rep;
    }
    
    //methode qui demande au joueur s'il veut tourner la tuile ou la placer sur la grille
    public void tournerOuPlacerTuile(){
        String rep ="";
        while (!rep.equals("ok")){
            System.out.println("\n\nPour tourner la tuile vers la gauche tapez 'g'\nPour tourner la tuile vers la droite tapez 'd'\nPour inserer la tuile sur la grille tapez 'ok'");
            rep = sc.next();
            if (rep.equals("g")){
                plateau.tuileCourante.tournerTuileSensTrigo();
                System.out.println(plateau.afficherGrilleDeJeu());
            } else if (rep.equals("d")){
                plateau.tuileCourante.tournerTuileSensHoraire();
                System.out.println(plateau.afficherGrilleDeJeu());
            }
        }
        
        // inserer la tuile
        rep ="";
        while (!rep.equals("ligne") && !rep.equals("colonne")){
            System.out.println("\nVoulez-vous inserer la tuile sur une ligne ou sur une colonne ? (vous pouvez seulement inserer des tuiles sur les lignes et les colonnes d'index pair)");
            System.out.println("\nTapez 'ligne' ou 'colonne'");
            rep = sc.next();
        }
        int n =10;
        while(n!=2 && n!=4 && n!=6){
            System.out.println("\nSur quelle index de " + rep + " voulez-vous inserer la tuile ?"); 
            n = sc.nextInt();
        }
        
        String direction="";
        if (rep.equals("ligne")){
            while (!direction.equals("d") && !direction.equals("g")){
                System.out.println("\nVoulez-vous inserer la tuile par la droite ou par la gauche ?");
                System.out.println("Tapez 'd' ou 'g'");
                direction = sc.next();
            }
            if (direction.equals("d")){
                plateau.insererTuileLigneADroite(n-1);
            } else if (direction.equals("g")){
                plateau.insererTuileLigneAGauche(n-1);
            }
        } else if (rep.equals("colonne")){
            while (!direction.equals("h") && !direction.equals("b")){
                System.out.println("\nVoulez-vous inserer la tuile par le haut ou par le bas ?");
                System.out.println("Tapez 'h' ou 'b'");
                direction = sc.next();
            }
            if (direction.equals("h")){
                plateau.insererTuileColonneHaut(n-1);
            } else if (direction.equals("b")){
                plateau.insererTuileColonneBas(n-1);
            }
        }
        
        System.out.println(plateau.afficherGrilleDeJeu());
        
        
    }
    
    //methode qui demande au joueur d'avancer
    public void avancerCase(){
        String direction = "";
        while (!direction.equals("ok")){
            do {
                System.out.println("Dans quelle direction voulez vous avancer ? (haut, droite, bas ,gauche)");
                System.out.println("Tapez 'h' ou 'd' ou 'b' ou'g'");
                System.out.println("Si vous voulez arreter d'avancer, tapez 'ok'");
                direction = sc.next();
            } while(!direction.equals("h") && !direction.equals("d") && !direction.equals("b") && !direction.equals("g") && !direction.equals("ok"));
            if (!direction.equals("ok")){
                
                if (direction.equals("h")){
                    direction="haut";
                } else if (direction.equals("d")){
                    direction="droite";
                } else if (direction.equals("b")){
                    direction="bas";
                } else if (direction.equals("g")){
                    direction="gauche";
                }
                
                System.out.println(direction);
                plateau.avancerCase(joueurCourant.lireCouleur(), direction);
                System.out.println(plateau.afficherGrilleDeJeu());
            }
        }   
    }
    
    //methode qui recolte l'objet du joueur 
    public void recolterObjet(){
        //obtenir la position du joueur
        for (int i = 0 ; i<7 ; i++){
            for (int j=0 ; j<7 ; j++){
                if(plateau.grilleDeJeu[i][j].colPlayer != null && plateau.grilleDeJeu[i][j].colPlayer.contains(joueurCourant.lireCouleur())){
                    Tuile t = plateau.grilleDeJeu[i][j];
                    // verifier si la tuile contient l'objet que le joueur doit recolter
                    if (t.getObject() != null && t.getObject().equals(joueurCourant.CartesJoueurs.get(0))){
                        joueurCourant.recolterObjet();
                        System.out.println("Objet recolte\n");
                    }
                }
            }
        }
        
        
    }
    
    
    
    
}
