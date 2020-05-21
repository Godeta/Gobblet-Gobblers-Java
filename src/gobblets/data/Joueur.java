package gobblets.data;

import java.util.ArrayList;

import gobblets.ihm.Erreur;
import gobblets.interaction.Action;
import gobblets.logic.PiecePasdisponibleException;

//Cette classe modélise un joueur générique
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

    //méthode qui retourne les pièces que l'utilisateur n'a pas encore placées
    public ArrayList<Piece> getPieces() {
        return pieces;
    }

    //setter pour les éléments de la maison du joueur
    public void setPieces(ArrayList<Piece> pieces) {
        this.pieces = pieces;
    }

    //méthode qui ajoute une pièce à la maison du joueur, en affectant la couleur du joueur au champ couleur de la pièce
    public void ajoutPiece(Piece p) throws PiecePasdisponibleException {
        if (p != null) {
            pieces.add(p);
        }
        else throw new PiecePasdisponibleException(Erreur.ARGUMENTINCORECT);
    }

    //teste si la pièce passée en paramètre appartient au joueur
    public boolean aPiece(Piece p) {
        return pieces.contains(p);
    }

    //enlève une pièce d'une taille donnée de la maison du joueur
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

    //teste si la joueur a au moins une pièce d'une certain taille dans sa maison
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

    //gère la saisi d'une action par le joueur
    public abstract Action choisirAction(Plateau p) throws Exception;
    public abstract Object clone();
}