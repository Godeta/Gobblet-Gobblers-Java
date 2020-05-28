package gobblets.data;

//Constructeur qui initialise les references vers les pièces à null
public class Case {
	//3 types de pièces
    private Piece petite, moyenne, grande;

//teste si la case peut accepter une pièce d'une taille donnee, retourne true si elle peut être placee
public boolean acceptePiece(Taille t) {
    return t.recouvre(plusGrandePiece());
}

//enleve la plus grande pièce de la case et retourne sa reference
public Piece enlevePiece() {
    Piece rPiece = plusGrandePiece();
    if (grande != null) grande = null;
    else if (moyenne != null) moyenne = null;
    else petite = null;
    return rPiece;
}

//place une pièce dans la case
public void placePiece(Piece p) {
    if (acceptePiece(p.getTaille())) {
        switch (p.getTaille()) {
            case GRANDE:
                grande = p;
                break;
            case MOYENNE:
                moyenne = p;
                break;
            case PETITE:
                petite = p;
                break;
            default:
                break;
        }
    }
}

//retourne la reference vers la plus grande pièce, sans enlever la pièce
public Piece plusGrandePiece() {
  return grande != null ? grande : moyenne != null ? moyenne : petite;
}

//retourne une phrase indiquant les pièces sur la cases
public String toString() {
    return "Case(pieces=["+grande+","+moyenne+","+petite+"])";
}

//permet de copier une case
public Object clone() {
    Case c = null;
    try {
        c = new Case();
        if (petite != null) c.placePiece((Piece) petite.clone());
        if (moyenne != null) c.placePiece((Piece) moyenne.clone());
        if (grande != null) c.placePiece((Piece) grande.clone());
    } catch (Exception e) {
        e.printStackTrace();
    }
    return c;
}

}
