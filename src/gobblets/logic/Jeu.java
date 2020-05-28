package gobblets.logic;

//pour les couleurs
import static org.fusesource.jansi.Ansi.*;
import static org.fusesource.jansi.Ansi.Color.*;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

//Constructeur qui exploite des methodes de saisie afin d'initialiser le jeu

import java.util.Random;
import java.util.Scanner;

import gobblets.data.Couleur;
import gobblets.data.Etat;
import gobblets.data.Joueur;
import gobblets.data.JoueurIA;
import gobblets.data.Piece;
import gobblets.data.Plateau;
import gobblets.ihm.Dictionnaire;
import gobblets.ihm.IHM;
import gobblets.ihm.Menu;
import gobblets.ihm.langues.Allemand;
import gobblets.ihm.langues.Anglais;
import gobblets.ihm.langues.Espagnol;
import gobblets.ihm.langues.Francais;
import gobblets.ihm.texte.SaisieConsole;
import gobblets.interaction.Action;
import gobblets.interaction.Enregistrer;
import gobblets.interaction.Termination;

public class Jeu implements Serializable{
    private Plateau plateau;
    private Joueur j1 = null, j2 = null, joueurActif = null;
    private Etat etat;
    private transient Scanner sc2  = new Scanner(System.in);
    private transient IHM saisie;

    public Jeu() {
        plateau = Plateau.initPlateau();
        /* temp */
        saisie = new SaisieConsole();
        etat = Etat.JEUENCOURS;
  	  	//on effectue le choix de la langue une seule fois au debut du jeu
        choixLangue(saisie);    
        do {
        System.out.println(ansi().fg(BLUE).a(saisie.getLanguage().menu(Menu.MENU_MENU)).fg(WHITE));
        } while (menu_display(saisie)==0);
    }

    public void changeJoueur() {
        if (joueurActif == j1) joueurActif = j2;
        else joueurActif = j1;
    }

    private Etat changeEtat(Etat current, Couleur winner) {
        if (current != Etat.MATCHNUL && winner != null) { // si le jeu est deja match nul ou pas de gagnant rien a faire
            if (current == Etat.JEUENCOURS) { // pas encore de gagnant
                if (winner == j1.getCouleur()) { // j1 = gagnant
                    System.out.println(ansi().fg(YELLOW).a(saisie.getLanguage().etat(Etat.JOUEUR1GAGNE)).fg(WHITE));
                   return Etat.JOUEUR1GAGNE;
                }
                else if (winner == j2.getCouleur()) { // j2 = gagnant
                	System.out.println(ansi().fg(YELLOW).a(saisie.getLanguage().etat(Etat.JOUEUR2GAGNE)).fg(RED));
                    return Etat.JOUEUR2GAGNE;
                }
            }
            // deja un gagnant
            else if ((current == Etat.JOUEUR1GAGNE && winner == j2.getCouleur()) || (current == Etat.JOUEUR2GAGNE && winner == j1.getCouleur())) {
            	System.out.println(saisie.getLanguage().etat(Etat.MATCHNUL));
            	 return Etat.MATCHNUL;
            }
        }
        return Etat.MATCHNUL;
    }

    private Etat updateEtat(Etat current) {
        try {
            for (int i = 0; i < 3; i++) { // parcours ligne 
                if (plateau.verifierLigne(i) != null){
                    current =changeEtat(current, plateau.verifierLigne(i));
                } //parcours colonnes
                if (plateau.verifierColonne(i) != null) {
                    current = changeEtat(current, plateau.verifierColonne(i));
                }
            }
            // premiere diagonale
            if (plateau.verifierDiagonale('a') != null) {
               current =  changeEtat(current, plateau.verifierDiagonale('a'));
            }
            // deuxième diagonale
            if (plateau.verifierDiagonale('b') != null) {
               current =  changeEtat(current, plateau.verifierDiagonale('b'));
            }
            //si il n'y a plus de pièces
            if (j1.getPieces().isEmpty() && j2.getPieces().isEmpty()) {
            	System.out.println(saisie.getLanguage().etat(Etat.MATCHNUL));
            return Etat.MATCHNUL;
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return current;
    }

    public Etat play() {
        Action a = null;
        Etat etatPlay = etat;
        /* action par le joueur */
        try {
            a = joueurActif.choisirAction(plateau);
            if (a != null) {
                /* detection de termination */
                if (a instanceof Termination)
                    return Etat.JEUQUITTE;
                if (a instanceof Enregistrer) {
                	Enregistrer(); return etatPlay;}
                /* autres */
                if (a.verifier(joueurActif)) {
                    a.appliquer(joueurActif);
                    changeJoueur();
                }
                etatPlay = updateEtat(etatPlay);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return etatPlay;
    }

    public Plateau getPlateau() {
        return plateau;
    }

    public Joueur getJ1() {
        return j1;
    }

    public Joueur getJ2() {
        return j2;
    }

    public Joueur getJoueurActif() {
        return joueurActif;
    }

    @Override
    public String toString() {
        return "Jeu(j1=" + j1 + ", j2=" + j2 + ", joueurActif=" + joueurActif + ", plateau=" + plateau + ")";
    }

    public Etat getEtat() {
        return etat;
    }

    public void setEtat(Etat etat) {
        this.etat = etat;
    }


/**
 * Permet de choisir la langue du jeu
 * @param sais L'IHM sur laquelle on effectue la saisie
 */
  	public void choixLangue(IHM sais) {
  		Scanner sc = new Scanner(System.in);
          System.out.println("Choisissez la langue du jeu : (1) francais, (2) anglais, (3) espagnol, (4) allemand");
          Dictionnaire fr = new Francais();
          Dictionnaire an = new Anglais();
          Dictionnaire es = new Espagnol();
          Dictionnaire alle = new Allemand ();
          String in;
          do {
          in =sc.nextLine();
          
          switch (in) {
          case "1": sais.setLanguage(fr); break;
          case "2":  sais.setLanguage(an); break;
          case "3":  sais.setLanguage(es); break;
          case "4":  sais.setLanguage(alle); break;
          default: in ="0"; System.out.println("Mauvais choix"+in);
          }
      } while(in=="0");
  	}
  	
  	/**
  	 * Affichage du menu, retourne 1 pour lancer la partie ou 0 pour retourner au menu
  	 * @param saisie
  	 */
  	public int menu_display(IHM saisie) {
  		System.out.println(saisie.getLanguage().menu(Menu.MENU_NOUVEAU) + "(1)");
  		System.out.println(saisie.getLanguage().menu(Menu.MENU_FICHIER)+ "(2)");
  		System.out.println(saisie.getLanguage().menu(Menu.MENU_AIDE)+ "(3)");
  		System.out.println(saisie.getLanguage().menu(Menu.MENU_APROPOS)+ "(4)");
  		System.out.println(saisie.getLanguage().menu(Menu.MENU_LANGUE)+ "(5)");
  		System.out.println(saisie.getLanguage().menu(Menu.MENU_QUITTER)+ "(6)");
  		
  		String in;
        do {
        in =sc2.nextLine();
        
        switch (in) {
        //nouvelle partie
        case "1": debut(saisie); return 1;
        //fichier
        case "2":  ouvrirF(); return 1;
        //aide
        case "3":  aide(saisie); break;
        //a propos
        case "4":  Apropos(saisie); break;
        //langue
        case "5":  choixLangue(saisie); break;
        //quitter
        case "6": System.exit(0); ; break;
        default: in ="0"; System.out.println("Mauvais choix"+in); 
        }
    } while(in=="0");
        return 0;
  	}
  	
  	/**
  	 * Pour la saisie des joueurs au debut de la partie
  	 * @param saisie
  	 */
  	public void debut(IHM saisie) {
  		 /* init j1 */
        do {
            try {
                j1 = saisie.saisirJoueur(1);
            } catch (Exception e) {
                System.out.println(e);
            }
        } while (j1 == null || j1.getNom() == "" || j1.getCouleur() == null);
        j1.setPieces(plateau.getMaisonJ1());
        for (Object o : j1.getPieces().toArray()) {
            ((Piece) o).setCouleur(j1.getCouleur());
        }
        /* init j2 */
        do {
            try {
                j2 = saisie.saisirJoueur(2);
            } catch (Exception e) {
                System.out.println(e);
                j2 = null;
            }
        } while ((j2 == null || j2.getNom() == "" || j2.getCouleur() == null) || j2.getNom().equals(j1.getNom()) && j2.getCouleur() == j1.getCouleur());
        j2.setPieces(plateau.getMaisonJ2());
        // IA Setup
        if (j1 instanceof JoueurIA) {
            ((JoueurIA)j1).setAdversaire(j2);
        }
        if (j2 instanceof JoueurIA) {
            ((JoueurIA)j2).setAdversaire(j1);
        }
        // pieces setup
        for (Object o : j2.getPieces().toArray()) {
            ((Piece) o).setCouleur(j2.getCouleur());
        }
        /* set starting player */
        Random r = new Random();
        joueurActif = r.nextBoolean() ? j1 : j2;
  	}

  	public void aide(IHM saisie) {
  		System.out.println("\n\n");
  		System.out.println("Depuis le menu vous pouvez : \n - Lancer une partie puis suivez les instructions pour jouer"
  				+ "\n - changer la langue "
  				+ "\n - consulter l'aide, ce que vous faites actuellement"
  				+ "quitter le jeu"
  				+ "charger une partie avec fichier->charger");
  		System.out.println("\n\n");
  	}
  	
  	public void Apropos(IHM saisie) {
  		System.out.println("\n\n");
  		System.out.println("Ce projet a ete fait en Mai 2020 dans le cadre de nos etudes a l'IUT GRAND OUEST NORMANDIE par Arnaud GODET et Paul GOUBARD-LANGERS.");
  		System.out.println("\n\n");
  	}
  	
  	 public void Enregistrer() {
     	//Nous déclarons nos objets en dehors du bloc try/catch
         ObjectOutputStream oos;
         try {
           oos = new ObjectOutputStream(
                   new BufferedOutputStream(
                     new FileOutputStream(
                       new File("game.txt"))));
             	
           //Nous allons écrire chaque objet Game dans le fichier
           oos.writeObject(this);
           //Ne pas oublier de fermer le flux !
           oos.close();
     } catch (Exception e) {
     	System.out.println(e);
     }
     }
  	 
  	/**
   	 * Permet d'ouvrir un fichier de sauvegarde pour charger un jeu
   	 */
   	public void ouvrirF() {
   		  //Nous déclarons nos objets en dehors du bloc try/catch
   		    ObjectInputStream ois;
   		  try {   	
   		      //On récupère maintenant les données !
   		      ois = new ObjectInputStream(
   		              new BufferedInputStream(
   		                new FileInputStream(
   		                  new File("game.txt"))));
   		      try {
   		        System.out.println("Chargement du plateau :");
   		        Jeu a = (Jeu)ois.readObject();
   		        this.j1= a.j1;
   		        this.j2 = a.j2;
   		        this.joueurActif= a.joueurActif;
   		        this.plateau=a.plateau;
   		        this.etat=a.etat;
   		        System.out.println("Joueur 1 :"+j1.getNom()+ j1.toString() + "Joueur 2"+j2.getNom()+j2.toString());
   		        System.out.println("plateau:"+plateau.toString());
   		      } catch (Exception e) {
   		        e.printStackTrace();
   		      }
   			
   		      ois.close();
   			} catch (Exception a) {
   				a.printStackTrace();
   			}
   	}
  	
  	public IHM getIHM () {
  		return saisie;
  	}
  	public Dictionnaire getIHMLang () {
  		return saisie.getLanguage();
  	}
  	
}
