package gobblets.logic;

//pour les couleurs
import static org.fusesource.jansi.Ansi.ansi;
import static org.fusesource.jansi.Ansi.Color.BLUE;
import static org.fusesource.jansi.Ansi.Color.WHITE;

//Constructeur qui exploite des méthodes de saisie afin d'initialiser le jeu

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
import gobblets.interaction.Termination;

public class Jeu {
    private Plateau plateau;
    private Joueur j1 = null, j2 = null, joueurActif = null;
    private Etat etat;
    private Scanner sc2  = new Scanner(System.in);
    private IHM saisie;

    public Jeu() {
        plateau = Plateau.initPlateau();
        /* temp */
        saisie = new SaisieConsole();
        etat = Etat.JEUENCOURS;
  	  	//on effectue le choix de la langue une seule fois au début du jeu
        choixLangue(saisie);    
        do {
        System.out.println(ansi().eraseScreen().fg(BLUE).a(saisie.getLanguage().menu(Menu.MENU_MENU)).fg(WHITE));
        } while (menu_display(saisie)==0);
    }

    public void changeJoueur() {
        if (joueurActif == j1) joueurActif = j2;
        else joueurActif = j1;
    }

    private void changeEtat(Etat current, Couleur winner) {
        if (current != Etat.MATCHNUL && winner != null) { // si le jeu est deja match nul ou pas de gagnant rien a faire
            if (current == Etat.JEUENCOURS) { // pas encore de gagnant
                if (winner == j1.getCouleur()) { // j1 = gagnant
                    current = Etat.JOUEUR1GAGNE;
                    System.out.println("Victoire du joueur 1 !!!");
                }
                else if (winner == j2.getCouleur()) { // j2 = gagnant
                    current = Etat.JOUEUR2GAGNE;
                    System.out.println("Victoire du joueur 2 !!!");
                }
            }
            // deja un gagnant
            else if ((current == Etat.JOUEUR1GAGNE && winner == j2.getCouleur()) || (current == Etat.JOUEUR2GAGNE && winner == j1.getCouleur())) {
            	current = Etat.MATCHNUL; System.out.println("Match nul !");
            }
        }
    }

    private Etat updateEtat(Etat current) {
        try {
            for (int i = 0; i < 3; i++) { // parcours ligne et colonnes
                if (plateau.verifierLigne(i) != null){
                    changeEtat(current, plateau.verifierLigne(i));
                }
                if (plateau.verifierColonne(i) != null) {
                    changeEtat(current, plateau.verifierColonne(i));
                }
            }
            // premiere diagonale
            if (plateau.verifierDiagonale('a') != null) {
                changeEtat(current, plateau.verifierDiagonale('a'));
            }
            // seconde diagonale
            if (plateau.verifierDiagonale('b') != null) {
                changeEtat(current, plateau.verifierDiagonale('b'));
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
                /* detection termination */
                if (a instanceof Termination)
                    return Etat.JEUQUITTE;
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
        case "2":  /*saisie.ouvrir();*/ break;
        //aide
        case "3":  aide(saisie); break;
        //à propos
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
  	 * Pour la saisie des joueurs au début de la partie
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
  		System.out.println("ba voilà quoi");
  		System.out.println("\n\n");
  	}
  	
  	public void Apropos(IHM saisie) {
  		System.out.println("\n\n");
  		System.out.println("Ce projet a été fait en Mai 2020 dans le cadre de nos études à l'IUT GRAND OUEST NORMANDIE par Arnaud GODET et Paul GOUBARD-LANGERS.");
  		System.out.println("\n\n");
  	}
  	
  	public IHM getIHM () {
  		return saisie;
  	}
  	public Dictionnaire getIHMLang () {
  		return saisie.getLanguage();
  	}
  	
}
