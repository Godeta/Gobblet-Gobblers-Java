package gobblets.ihm.texte;

import gobblets.ihm.texte.SaisieConsole;

//affiche une pièce dans la console
public class Piece {
    private gobblets.data.Piece contenu;

    public Piece(gobblets.data.Piece p) {
        this.contenu = p;
    }

    public String getRepresentationTextuelle() {
        try {
        	return SaisieConsole.colorString(contenu.getTaille().getSymbole() + " ", contenu.getCouleur())+"|  ";
        } catch (Exception e) {
            return "  |  ";
        }
    }
}
