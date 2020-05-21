package gobblets.ihm.langues;

import java.util.HashMap;

import gobblets.data.ActionType;
import gobblets.data.Couleur;
import gobblets.data.Etat;
import gobblets.data.Taille;
import gobblets.ihm.Avertissement;
import gobblets.ihm.Dictionnaire;
import gobblets.ihm.Erreur;

//Classe qui implémente le dictionnaire espagnol
public class Espagnol implements Dictionnaire {

	 private HashMap<Couleur, String> couleurs;
	    private HashMap<Taille, String> tailles;
	    private HashMap<Etat, String> etats;
	    private HashMap<ActionType, String> actions;
	    private HashMap<Erreur,String> erreurs;
	    private HashMap<Avertissement, String> avertissements;

	    public Espagnol() {
	        /* couleurs */
	        couleurs = new HashMap<Couleur, String>();
	        couleurs.put(Couleur.ROUGE, "Rojo");
	        couleurs.put(Couleur.VERT, "Verde");
	        couleurs.put(Couleur.JAUNE, "Amarillo");
	        couleurs.put(Couleur.BLEU, "Azul");
	        couleurs.put(Couleur.BLANC, "Blanco");
	        /* tailles */
	        tailles = new HashMap<Taille, String>();
	        tailles.put(Taille.GRANDE, "Grande");
	        tailles.put(Taille.MOYENNE, "Media");
	        tailles.put(Taille.PETITE, "Pequena");
	        /* etats */
	        etats = new HashMap<Etat, String>();
	        etats.put(Etat.JEUENCOURS, "Juego en progresso");
	        etats.put(Etat.JEUQUITTE, "Salir del juego");
	        etats.put(Etat.JOUEUR1GAGNE, "! Jugador 1 ganado !");
	        etats.put(Etat.JOUEUR2GAGNE, "! Jugador 2 ganado !");
	        etats.put(Etat.MATCHNUL, "Empate");
	        /* actions */
	        actions = new HashMap<ActionType, String>();
	        actions.put(ActionType.DEPLACER, "Moverse");
	        actions.put(ActionType.PLACER, "Poner");
	        actions.put(ActionType.QUITTER, "Salir");
	        /* erreurs */
	        erreurs = new HashMap<Erreur, String>();
	        erreurs.put(Erreur.ARGUMENTINCORECT, "Argumento incorrecto");
	        erreurs.put(Erreur.CASEBLOQUE, "Caja bloqueda");
	        erreurs.put(Erreur.DIAGONALEINCORECTE, "Diagonal incorrecto");
	        erreurs.put(Erreur.ORIGINVIDE, "Origen vacio");
	        erreurs.put(Erreur.PASDEPIECEDISPONIBLE, "Ninguna pieza disponible");
	        erreurs.put(Erreur.PASTAPIECE, "! No es tu pieza !");
	        /* avertissements */
	        avertissements = new HashMap<Avertissement, String>();
	        avertissements.put(Avertissement.CHOIXACTION, "Elige tu accion");
	        avertissements.put(Avertissement.CHOIXDESTINATION, "? Cual es la destinacion ?");
	        avertissements.put(Avertissement.CHOIXORIGIN, "? Origen ?");
	        avertissements.put(Avertissement.CHOIXTAILLE, "? Tamano ?");
	        avertissements.put(Avertissement.COULEURJOUEUR, "Color del jugador");
	        avertissements.put(Avertissement.NOMJOUEUR, "Apellido del jugador");
	        avertissements.put(Avertissement.TONTOUR, "Turno de");
	        avertissements.put(Avertissement.SAISIECOORDONNEES, "Ingresar coordenadas");
	        avertissements.put(Avertissement.SAISIECOORDONNEE1, "Primera coordenada");
	        avertissements.put(Avertissement.SAISIECOORDONNEE2, "Segunda coordenada");
	        avertissements.put(Avertissement.MAISON, "Casa");
	        avertissements.put(Avertissement.CHOIXTYPEJOUEUR, "? Que tipo de jugador ?");
	        avertissements.put(Avertissement.SAISIEJOUEUR, "Entrada del jugador ");
	        avertissements.put(Avertissement.JOUEURHUMAIN, "Jugador Humano ");
	        avertissements.put(Avertissement.JOUEURIA, "Jugador IA ");
	        avertissements.put(Avertissement.ANNULER, "Cancelar ");
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
	
}
