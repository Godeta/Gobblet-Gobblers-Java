package gobblets.data;

import gobblets.ihm.Avertissement;
import gobblets.ihm.Erreur;
import gobblets.ihm.IHM;
import gobblets.ihm.texte.SaisieConsole;
import gobblets.interaction.Action;
import gobblets.interaction.Deplacement;
import gobblets.interaction.Placement;
import gobblets.interaction.Termination;
import gobblets.logic.PiecePasdisponibleException;

//Classe definissant un joueur que l'on peut contrôler
public class JoueurHumain extends Joueur {
	private IHM i;
    public JoueurHumain(String nom, Couleur couleur) {
        super(nom, couleur);
    }
    
    public JoueurHumain(String nom, Couleur couleur, IHM i) {
        super(nom, couleur);
        this.i = i;
    }

    //Implementation de la methode abstraite de la classe Joueur, utilise les methodes de une instance de la classe IHM
    public Action choisirAction(Plateau p) throws Exception {
        ActionType choix = i.saisirAction(this);
        switch (choix) {
            case PLACER: return Placer(i, p);
            case DEPLACER: return Deplacer(i, p);
            case QUITTER: return Quitter(i, p);
            default: return null;
        }
    }

    private Action Placer(IHM i, Plateau p) {
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

    private Action Deplacer(IHM i, Plateau p) {
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

    private Action Quitter(IHM i, Plateau p) {
        return new Termination();
    }

    public IHM getI() {
		return i;
	}

	public void setI(IHM i) {
		this.i = i;
	}

	public Object clone() {
        JoueurHumain cloneObject = new JoueurHumain(getNom(), getCouleur());
        cloneObject.setPieces(getPieces());
        return cloneObject;
    }
}