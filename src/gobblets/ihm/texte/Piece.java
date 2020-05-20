package gobblets.ihm.texte;

//affiche une pièce dans la console
public class Piece {
    private gobblets.data.Piece contenu;

    public Piece(gobblets.data.Piece p) {
        this.contenu = p;
    }

    public String getRepresentationTextuelle() {
        try {
            return "x"; //test
        } catch (Exception e) {
            return "   ";
        }
    }
}
