package gobblets.ihm.langues;

import java.util.HashMap;

import gobblets.ihm.Avertissement;
import gobblets.ihm.Erreur;
import gobblets.ihm.Menu;
import gobblets.data.ActionType;
import gobblets.data.Couleur;
import gobblets.data.Etat;
import gobblets.data.Taille;
import gobblets.ihm.Dictionnaire;

//Classe qui implemente le dictionnaire fran�ais
public class Francais implements Dictionnaire {
	 private HashMap<Couleur, String> couleurs;
	    private HashMap<Taille, String> tailles;
	    private HashMap<Etat, String> etats;
	    private HashMap<ActionType, String> actions;
	    private HashMap<Erreur,String> erreurs;
	    private HashMap<Avertissement, String> avertissements;
	    private HashMap<Menu, String> menu;

	    public Francais() {
	        /* couleurs */
	        couleurs = new HashMap<Couleur, String>();
	        couleurs.put(Couleur.ROUGE, "Rouge");
	        couleurs.put(Couleur.VERT, "Vert");
	        couleurs.put(Couleur.JAUNE, "Jaune");
	        couleurs.put(Couleur.BLEU, "Bleu");
	        couleurs.put(Couleur.BLANC, "Blanc");
	        /* tailles */
	        tailles = new HashMap<Taille, String>();
	        tailles.put(Taille.GRANDE, "Grande");
	        tailles.put(Taille.MOYENNE, "Moyenne");
	        tailles.put(Taille.PETITE, "Petite");
	        /* etats */
	        etats = new HashMap<Etat, String>();
	        etats.put(Etat.JEUENCOURS, "Jeu en cours");
	        etats.put(Etat.JEUQUITTE, "Jeu quitter");
	        etats.put(Etat.JOUEUR1GAGNE, "       _                               __                                     __   _ \r\n" + 
	        		"      | |                             /_ |                                   /_/  | |\r\n" + 
	        		"      | | ___  _   _  ___ _   _ _ __   | |   __ _    __ _  __ _  __ _ _ __   ___  | |\r\n" + 
	        		"  _   | |/ _ \\| | | |/ _ \\ | | | '__|  | |  / _` |  / _` |/ _` |/ _` | '_ \\ / _ \\ | |\r\n" + 
	        		" | |__| | (_) | |_| |  __/ |_| | |     | | | (_| | | (_| | (_| | (_| | | | |  __/ |_|\r\n" + 
	        		"  \\____/ \\___/ \\__,_|\\___|\\__,_|_|     |_|  \\__,_|  \\__, |\\__,_|\\__, |_| |_|\\___| (_)\r\n" + 
	        		"                                                     __/ |       __/ |               \r\n" + 
	        		"                                                    |___/       |___/                ");
	        etats.put(Etat.JOUEUR2GAGNE, "       _                               ___                                      __   _ \r\n" + 
	        		"      | |                             |__ \\                                    /_/  | |\r\n" + 
	        		"      | | ___  _   _  ___ _   _ _ __     ) |   __ _    __ _  __ _  __ _ _ __   ___  | |\r\n" + 
	        		"  _   | |/ _ \\| | | |/ _ \\ | | | '__|   / /   / _` |  / _` |/ _` |/ _` | '_ \\ / _ \\ | |\r\n" + 
	        		" | |__| | (_) | |_| |  __/ |_| | |     / /_  | (_| | | (_| | (_| | (_| | | | |  __/ |_|\r\n" + 
	        		"  \\____/ \\___/ \\__,_|\\___|\\__,_|_|    |____|  \\__,_|  \\__, |\\__,_|\\__, |_| |_|\\___| (_)\r\n" + 
	        		"                                                       __/ |       __/ |               \r\n" + 
	        		"                                                      |___/       |___/                ");
	        etats.put(Etat.MATCHNUL, "Match nul");
	        /* actions */
	        actions = new HashMap<ActionType, String>();
	        actions.put(ActionType.DEPLACER, "Deplacer");
	        actions.put(ActionType.PLACER, "Placer");
	        actions.put(ActionType.QUITTER, "Quitter");
	        actions.put(ActionType.ENREGISTRER, "Enregistrer");
	        /* erreurs */
	        erreurs = new HashMap<Erreur, String>();
	        erreurs.put(Erreur.ARGUMENTINCORECT, "Argument incorrect");
	        erreurs.put(Erreur.CASEBLOQUE, "Case Bloquee");
	        erreurs.put(Erreur.DIAGONALEINCORECTE, "Diagonale incorrecte");
	        erreurs.put(Erreur.ORIGINVIDE, "Origine vide");
	        erreurs.put(Erreur.PASDEPIECEDISPONIBLE, "Pas de pi�ce disponible");
	        erreurs.put(Erreur.PASTAPIECE, "Ceci n'est pas ta pi�ce !");
	        /* avertissements */
	        avertissements = new HashMap<Avertissement, String>();
	        avertissements.put(Avertissement.CHOIXACTION, "Choisir action");
	        avertissements.put(Avertissement.CHOIXDESTINATION, "Quelle destination ?");
	        avertissements.put(Avertissement.CHOIXORIGIN, "Origine ?");
	        avertissements.put(Avertissement.CHOIXTAILLE, "Taille ?");
	        avertissements.put(Avertissement.COULEURJOUEUR, "Couleur joueur");
	        avertissements.put(Avertissement.NOMJOUEUR, "Nom joueur");
	        avertissements.put(Avertissement.TONTOUR, "Tour de");
	        avertissements.put(Avertissement.SAISIECOORDONNEES, "Saisie coordonnees");
	        avertissements.put(Avertissement.SAISIELIGNE, "Entrez la ligne");
	        avertissements.put(Avertissement.SAISIECOLONNE, "Entrez la colonne");
	        avertissements.put(Avertissement.MAISON, "Maison");
	        avertissements.put(Avertissement.CHOIXTYPEJOUEUR, "Quel type de joueur ?");
	        avertissements.put(Avertissement.SAISIEJOUEUR, "Saisie du joueur ");
	        avertissements.put(Avertissement.JOUEURHUMAIN, "Joueur Humain ");
	        avertissements.put(Avertissement.JOUEURIA, "Joueur IA ");
	        avertissements.put(Avertissement.ANNULER, "Annuler ");
	        avertissements.put(Avertissement.AUTRE, "(Autre) ");
	        /* Menu */
	        menu = new HashMap<Menu, String>();
	        menu.put(Menu.MENU_AIDE, "Aide ");
	        menu.put(Menu.MENU_APROPOS, "A propos de nous ");
	        menu.put(Menu.MENU_ENREGISTRER, "Enregistrer ");
	        menu.put(Menu.MENU_FICHIER, "Fichier ");
	        menu.put(Menu.MENU_LANGUE, "Langue ");
	        menu.put(Menu.MENU_NOUVEAU, "Nouvelle partie ");
	        menu.put(Menu.MENU_OUVRIR, "Ouvrir ");
	        menu.put(Menu.MENU_QUITTER, "Quitter ");
	        menu.put(Menu.MENU_MENU, "                            \r\n" + 
	        		"                            \r\n" + 
	        		" _ __ ___   ___ _ __  _   _ \r\n" + 
	        		"| '_ ` _ \\ / _ \\ '_ \\| | | |\r\n" + 
	        		"| | | | | |  __/ | | | |_| |\r\n" + 
	        		"|_| |_| |_|\\___|_| |_|\\__,_|\r\n" + 
	        		"                            \r\n" + 
	        		"                            ");
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
