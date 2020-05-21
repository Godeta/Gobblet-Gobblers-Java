package gobblets.data;

import java.util.ArrayList;

import gobblets.ihm.Erreur;
import gobblets.interaction.Action;
import gobblets.logic.PiecePasdisponibleException;

//Cette classe mod�lise un joueur g�n�rique
public abstract class Joueur {
    private final String nom;
    private final Couleur couleur;
    private ArrayList<Piece> pieces;
    public Joueur(String nom, Couleur couleur) {
        this.nom = nom; this.couleur=couleur;
    }

    public String getNom() {
        return nom;
    }

    public Couleur getCouleur() {
        return couleur;
    }

    //m�thode qui retourne les pi�ces que l'utilisateur n'a pas encore plac�es
    public ArrayList<Piece> getPieces() {
        return pieces;
    }

    //setter pour les �l�ments de la maison du joueur
    public void setPieces(ArrayList<Piece> pieces) {
        this.pieces = pieces;
    }

    //m�thode qui ajoute une pi�ce � la maison du joueur, en affectant la couleur du joueur au champ couleur de la pi�ce
    public void ajoutPiece(Piece p) throws PiecePasdisponibleException {
        if (p != null) {
            pieces.add(p);
        }
        else throw new PiecePasdisponibleException(Erreur.ARGUMENTINCORECT);
    }

    //teste si la pi�ce pass�e en param�tre appartient au joueur
    public boolean aPiece(Piece p) {
        return pieces.contains(p);
    }

    //enl�ve une pi�ce d'une taille donn�e de la maison du joueur
    public Piece enlevePiece(Taille t) throws Exception {
        try {
            if (aPieceDeTaille(t)) {
                for (Object o : pieces.toArray()) {
                    if (((Piece) o).getTaille() == t)
                        return pieces.remove(pieces.indexOf(o));
                }
            }
        } catch (Exception e) {
            throw e;
        }
        return null;
    }

    //teste si la joueur a au moins une pi�ce d'une certain taille dans sa maison
    public boolean aPieceDeTaille(Taille t) throws PiecePasdisponibleException {
        if (t == null || pieces == null) throw new PiecePasdisponibleException(Erreur.ARGUMENTINCORECT);
        if (pieces.size() != 0) {
            for (Object o : pieces.toArray()) {
                if (((Piece) o).getTaille() == t)
                    return true;
            }
        }
        return false;
    }

    public String toString() {
        return "Joueur(nom="+nom+",couleur="+couleur+",pieces+"+pieces+")";
    }

    //g�re la saisi d'une action par le joueur
    public abstract Action choisirAction(Plateau p) throws Exception;
    public abstract Object clone();
}