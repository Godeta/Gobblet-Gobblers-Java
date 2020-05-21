package gobblets.data;
//les différents états possibles de la partie
public enum Etat {
	JEUENCOURS,
    JEUQUITTE,
	JOUEUR1GAGNE,
    JOUEUR2GAGNE,
    MATCHNUL;

    Etat() {}
}