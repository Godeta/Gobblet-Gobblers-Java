package gobblets.ihm.langues;

import java.util.HashMap;

import gobblets.data.ActionType;
import gobblets.data.Couleur;
import gobblets.data.Etat;
import gobblets.data.Taille;
import gobblets.ihm.Avertissement;
import gobblets.ihm.Dictionnaire;
import gobblets.ihm.Erreur;
import gobblets.ihm.Menu;

//Classe qui implemente le dictionnaire anglais
public class Anglais implements Dictionnaire {

	 private HashMap<Couleur, String> couleurs;
	    private HashMap<Taille, String> tailles;
	    private HashMap<Etat, String> etats;
	    private HashMap<ActionType, String> actions;
	    private HashMap<Erreur,String> erreurs;
	    private HashMap<Avertissement, String> avertissements;
	    private HashMap<Menu, String> menu;

	    public Anglais() {
	        /* couleurs */
	        couleurs = new HashMap<Couleur, String>();
	        couleurs.put(Couleur.ROUGE, "Red");
	        couleurs.put(Couleur.VERT, "Green");
	        couleurs.put(Couleur.JAUNE, "Yellow");
	        couleurs.put(Couleur.BLEU, "Blue");
	        couleurs.put(Couleur.BLANC, "White");
	        /* tailles */
	        tailles = new HashMap<Taille, String>();
	        tailles.put(Taille.GRANDE, "Big");
	        tailles.put(Taille.MOYENNE, "Medium");
	        tailles.put(Taille.PETITE, "Small");
	        /* etats */
	        etats = new HashMap<Etat, String>();
	        etats.put(Etat.JEUENCOURS, "Game in process");
	        etats.put(Etat.JEUQUITTE, "Exit game");
	        etats.put(Etat.JOUEUR1GAGNE, "Player 1 won !");
	        etats.put(Etat.JOUEUR2GAGNE, "Player 2 won !");
	        etats.put(Etat.MATCHNUL, "No winner, it's a toe");
	        /* actions */
	        actions = new HashMap<ActionType, String>();
	        actions.put(ActionType.DEPLACER, "Move");
	        actions.put(ActionType.PLACER, "Place");
	        actions.put(ActionType.QUITTER, "Exit");
	        /* erreurs */
	        erreurs = new HashMap<Erreur, String>();
	        erreurs.put(Erreur.ARGUMENTINCORECT, "Incorrect argument");
	        erreurs.put(Erreur.CASEBLOQUE, "Blocked case");
	        erreurs.put(Erreur.DIAGONALEINCORECTE, "Incorrect diagonal");
	        erreurs.put(Erreur.ORIGINVIDE, "Empty origin");
	        erreurs.put(Erreur.PASDEPIECEDISPONIBLE, "No available piece");
	        erreurs.put(Erreur.PASTAPIECE, "It's not your piece !");
	        /* avertissements */
	        avertissements = new HashMap<Avertissement, String>();
	        avertissements.put(Avertissement.CHOIXACTION, "Choose an action");
	        avertissements.put(Avertissement.CHOIXDESTINATION, "Destination ?");
	        avertissements.put(Avertissement.CHOIXORIGIN, "Origin ?");
	        avertissements.put(Avertissement.CHOIXTAILLE, "Size ?");
	        avertissements.put(Avertissement.COULEURJOUEUR, "Player color");
	        avertissements.put(Avertissement.NOMJOUEUR, "Player name");
	        avertissements.put(Avertissement.TONTOUR, "Turn of");
	        avertissements.put(Avertissement.SAISIECOORDONNEES, "Coordonates input :");
	        avertissements.put(Avertissement.SAISIELIGNE, "Enter the line");
	        avertissements.put(Avertissement.SAISIECOLONNE, "Enter the column");
	        avertissements.put(Avertissement.MAISON, "House");
	        avertissements.put(Avertissement.CHOIXTYPEJOUEUR, "Which type of player ?");
	        avertissements.put(Avertissement.SAISIEJOUEUR, "Player input ");
	        avertissements.put(Avertissement.JOUEURHUMAIN, "Human Player ");
	        avertissements.put(Avertissement.JOUEURIA, "AI Player ");
	        avertissements.put(Avertissement.ANNULER, "Cancel ");
	        /* Menu */
	        menu = new HashMap<Menu, String>();
	        menu.put(Menu.MENU_AIDE, "Help ");
	        menu.put(Menu.MENU_APROPOS, "About me ");
	        menu.put(Menu.MENU_ENREGISTRER, "Save ");
	        menu.put(Menu.MENU_FICHIER, "File ");
	        menu.put(Menu.MENU_LANGUE, "Language ");
	        menu.put(Menu.MENU_NOUVEAU, "New game ");
	        menu.put(Menu.MENU_OUVRIR, "Open ");
	        menu.put(Menu.MENU_QUITTER, "Quit ");
	        menu.put(Menu.MENU_MENU, "Menu : ");
	    }

	    
	    public String couleur(Couleur c) {
	        return couleurs.get(c);
	    }

	    
	    public String taille(Taille t) {
	        return tailles.get(t);
	    }

	    
	    public String etat(Etat e) {
	        return etats.get(e);
	    }

	    
	    public String action(ActionType a) {
	        return actions.get(a);
	    }

	    
	    public String erreur(Erreur e) {
	        return erreurs.get(e);
	    }

	    
	    public String avertissement(Avertissement a) {
	        return avertissements.get(a);
	    }
	    
	    public String menu(Menu m) {
	        return menu.get(m);
	    }
}
