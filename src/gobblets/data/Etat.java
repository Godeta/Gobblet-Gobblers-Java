package gobblets.data;
//les diff�rents �tats possibles de la partie
public enum Etat {
	JEUENCOURS,
    JEUQUITTE,
	JOUEUR1GAGNE,
    JOUEUR2GAGNE,
    MATCHNUL;

    Etat() {}
}