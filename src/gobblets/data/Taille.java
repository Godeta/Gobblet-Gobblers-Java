package gobblets.data;
//enumeration, on a 3 tailles differentes
public enum Taille {
    PETITE('o'),
    MOYENNE('O'),
    GRANDE('0');
//chaque pi�ce a un symbole
    private char symbole;
    Taille(char c) {
        symbole = c;
    }

    public char getSymbole() { return symbole; }
    //teste si la taille peut recouvrir la pi�ce passe en param�tre
    public boolean recouvre(Taille t) { return t == null || getSymbole()<t.getSymbole(); }
    //teste si la taille peut recouvrir la taille passe en param�tre
    public boolean recouvre(Piece p) { return p == null || recouvre(p.getTaille()); }
    
}