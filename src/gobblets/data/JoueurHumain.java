package gobblets.data;

import gobblets.ihm.Avertissement;
import gobblets.ihm.Erreur;
import gobblets.ihm.IHM;
import gobblets.ihm.texte.SaisieConsole;
import gobblets.interaction.*;
import gobblets.logic.PiecePasdisponibleException;

//Classe d�finissant un joueur que l'on peut contr�ler
public class JoueurHumain extends Joueur {
    public JoueurHumain(String nom, Couleur couleur) {
        super(nom, couleur);
    }

    //Impl�mentation de la m�thode abstraite de la classe Joueur, utilise les m�thodes de une instance de la classe IHM
    public Action choisirAction(Plateau p) throws Exception {
        IHM i = new SaisieConsole();
        ActionType choix = i.saisirAction(this);
        switch (choix) {
            case PLACER: return creerActionPlacer(i, p);
            case DEPLACER: return creerActionDeplacer(i, p);
            case QUITTER: return creerActionQuitter(i, p);
            default: return null;
        }
    }

    private Action creerActionPlacer(IHM i, Plateau p) {
        try {
            System.out.println(i.getLanguage().avertissement(Avertissement.CHOIXDESTINATION));
            int[] coord = i.saisirCoordonnees();
            if (checkCoord(coord)) throw new PiecePasdisponibleException(Erreur.ARGUMENTINCORECT);
            Taille t = i.saisirTaille();
            Case destination = p.getPlateau()[coord[0]][coord[1]];
            return new Placement(t, destination);
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

    private Action creerActionDeplacer(IHM i, Plateau p) {
        try {
            int[] coord;
            System.out.println(i.getLanguage().avertissement(Avertissement.CHOIXORIGIN));
            coord = i.saisirCoordonnees();
            if (checkCoord(coord)) throw new PiecePasdisponibleException(Erreur.ARGUMENTINCORECT);
            Case origin = p.getPlateau()[coord[0]][coord[1]];
            System.out.println(i.getLanguage().avertissement(Avertissement.CHOIXDESTINATION));
            coord = i.saisirCoordonnees();
            if (checkCoord(coord)) throw new PiecePasdisponibleException(Erreur.ARGUMENTINCORECT);
            Case destination = p.getPlateau()[coord[0]][coord[1]];
            return new Deplacement(origin, destination);
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

    private boolean checkCoord(int[] coord) {
        return coord[0] > 2 || coord[0] < 0 || coord[1] > 2 || coord[1] < 0;
    }

    private Action creerActionQuitter(IHM i, Plateau p) {
        return new Termination();
    }

    public Object clone() {
        JoueurHumain cloneObject = new JoueurHumain(getNom(), getCouleur());
        cloneObject.setPieces(getPieces());
        return cloneObject;
    }
}