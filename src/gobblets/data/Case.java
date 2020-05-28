package gobblets.data;

//Constructeur qui initialise les references vers les pi�ces � null
public class Case {
	//3 types de pi�ces
    private Piece petite, moyenne, grande;

//teste si la case peut accepter une pi�ce d'une taille donnee, retourne true si elle peut �tre placee
public boolean acceptePiece(Taille t) {
    return t.recouvre(plusGrandePiece());
}

//enleve la plus grande pi�ce de la case et retourne sa reference
public Piece enlevePiece() {
    Piece rPiece = plusGrandePiece();
    if (grande != null) grande = null;
    else if (moyenne != null) moyenne = null;
    else petite = null;
    return rPiece;
}

//place une pi�ce dans la case
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

//retourne la reference vers la plus grande pi�ce, sans enlever la pi�ce
public Piece plusGrandePiece() {
  return grande != null ? grande : moyenne != null ? moyenne : petite;
}

//retourne une phrase indiquant les pi�ces sur la cases
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
