package gobblets.data;
//enumeration, on a 3 tailles differentes
public enum Taille {
    PETITE('o'),
    MOYENNE('O'),
    GRANDE('0');
//chaque pièce a un symbole
    private char symbole;
    Taille(char c) {
        symbole = c;
    }

    public char getSymbole() { return symbole; }
    //teste si la taille peut recouvrir la pièce passe en paramètre
    public boolean recouvre(Taille t) { return t == null || getSymbole()<t.getSymbole(); }
    //teste si la taille peut recouvrir la taille passe en paramètre
    public boolean recouvre(Piece p) { return p == null || recouvre(p.getTaille()); }
    
}