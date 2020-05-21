package gobblets.data;
//enumeration, on a 3 tailles diff�rentes
public enum Taille {
    PETITE('o'),
    MOYENNE('O'),
    GRANDE('0');
//chaque pi�ce � un symbole
    private char symbole;
    Taille(char c) {
        symbole = c;
    }

    public char getSymbole() { return symbole; }
    //teste si la taille peut recouvrir la pi�ce pass� en param�tre
    public boolean recouvre(Taille t) { return t == null || getSymbole()<t.getSymbole(); }
    //teste si la taille peut recouvrir la taille pass� en param�tre
    public boolean recouvre(Piece p) { return p == null || recouvre(p.getTaille()); }
    
}