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

//Classe qui implémente le dictionnaire anglais
public class Allemand implements Dictionnaire {

	 private HashMap<Couleur, String> couleurs;
	    private HashMap<Taille, String> tailles;
	    private HashMap<Etat, String> etats;
	    private HashMap<ActionType, String> actions;
	    private HashMap<Erreur,String> erreurs;
	    private HashMap<Avertissement, String> avertissements;
	    private HashMap<Menu, String> menu;

	    public Allemand() {
	        /* couleurs */
	        couleurs = new HashMap<Couleur, String>();
	        couleurs.put(Couleur.ROUGE, "Rot");
	        couleurs.put(Couleur.VERT, "Grün");
	        couleurs.put(Couleur.JAUNE, "Gelb");
	        couleurs.put(Couleur.BLEU, "Blau");
	        couleurs.put(Couleur.BLANC, "Weiß");
	        /* tailles */
	        tailles = new HashMap<Taille, String>();
	        tailles.put(Taille.GRANDE, "Hoch");
	        tailles.put(Taille.MOYENNE, "Weg");
	        tailles.put(Taille.PETITE, "Klein");
	        /* etats */
	        etats = new HashMap<Etat, String>();
	        etats.put(Etat.JEUENCOURS, "Gerade stattfindendes Spiel");
	        etats.put(Etat.JEUQUITTE, "Das Spiel verlassen");
	        etats.put(Etat.JOUEUR1GAGNE, "Der Spieler 1 hat gewonnen !");
	        etats.put(Etat.JOUEUR2GAGNE, "Der Spieler 2 hat gewonnen !");
	        etats.put(Etat.MATCHNUL, "Zeichnen");
	        /* actions */
	        actions = new HashMap<ActionType, String>();
	        actions.put(ActionType.DEPLACER, "Bewegung");
	        actions.put(ActionType.PLACER, "Hinstellen");
	        actions.put(ActionType.QUITTER, "Verlassen");
	        /* erreurs */
	        erreurs = new HashMap<Erreur, String>();
	        erreurs.put(Erreur.ARGUMENTINCORECT, "falsches Argument");
	        erreurs.put(Erreur.CASEBLOQUE, "blockierte Box");
	        erreurs.put(Erreur.DIAGONALEINCORECTE, "falsche Diagonale");
	        erreurs.put(Erreur.ORIGINVIDE, "leerer Ursprung");
	        erreurs.put(Erreur.PASDEPIECEDISPONIBLE, "Kein Teil verfügbar");
	        erreurs.put(Erreur.PASTAPIECE, "Es ist nicht dein Zimmer !");
	        /* avertissements */
	        avertissements = new HashMap<Avertissement, String>();
	        avertissements.put(Avertissement.CHOIXACTION, "wähle eine Aktion");
	        avertissements.put(Avertissement.CHOIXDESTINATION, "Ziel ?");
	        avertissements.put(Avertissement.CHOIXORIGIN, "Ursprung ?");
	        avertissements.put(Avertissement.CHOIXTAILLE, "Schnitt ?");
	        avertissements.put(Avertissement.COULEURJOUEUR, "Spielerfarbe");
	        avertissements.put(Avertissement.NOMJOUEUR, "Spielername");
	        avertissements.put(Avertissement.TONTOUR, "wiederum von");
	        avertissements.put(Avertissement.SAISIECOORDONNEES, "Eingabe von Koordinaten :");
	        avertissements.put(Avertissement.SAISIELIGNE, "Geben Sie die Zeile ein");
	        avertissements.put(Avertissement.SAISIECOLONNE, "Geben Sie die Spalte ein");
	        avertissements.put(Avertissement.MAISON, "Haus");
	        avertissements.put(Avertissement.CHOIXTYPEJOUEUR, "Welche Art von Spieler ?");
	        avertissements.put(Avertissement.SAISIEJOUEUR, "Spielereingabe ");
	        avertissements.put(Avertissement.JOUEURHUMAIN, "menschlicher Spieler");
	        avertissements.put(Avertissement.JOUEURIA, "künstliche Intelligenz ");
	        avertissements.put(Avertissement.ANNULER, "Abbrechen ");
	        /* Menu */
	        menu = new HashMap<Menu, String>();
	        menu.put(Menu.MENU_AIDE, "Hilfe ");
	        menu.put(Menu.MENU_APROPOS, "über mich ");
	        menu.put(Menu.MENU_ENREGISTRER, "speichern ");
	        menu.put(Menu.MENU_FICHIER, "Datei ");
	        menu.put(Menu.MENU_LANGUE, "Sprache ");
	        menu.put(Menu.MENU_NOUVEAU, "neuer Teil ");
	        menu.put(Menu.MENU_OUVRIR, "öffnen ");
	        menu.put(Menu.MENU_QUITTER, "verlassen ");
	        menu.put(Menu.MENU_MENU, "Speisekarte : ");
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
