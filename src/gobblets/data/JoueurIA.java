package gobblets.data;

import java.io.Serializable;

import gobblets.interaction.Action;
import gobblets.interaction.Placement;

//Implementation de la methode de la classe Joueur, utilise une logique interne afin de selectionner une action
public class JoueurIA extends Joueur implements Serializable {
    private Joueur adversaire;

    public JoueurIA(String nom, Couleur couleur) {
        super(nom, couleur);
    }

    public Joueur getAdversaire() {
        return adversaire;
    }

    public void setAdversaire(Joueur adversaire) {
        this.adversaire = adversaire;
    }

    //Implementation de la methode de la classe Joueur, utilise une logique interne afin de selectionner une action
    public Action choisirAction(Plateau p) {
    	Action a = null;
    	int abs = 1;
    	int ord=1;
    	//la taille de la première pièce dans la liste des pièces disponibles pour le joueur
    	Taille TAIL = this.getPieces().get(0).getTaille();
    	//tant que le palteau n'accepte pas la pièce
    	while (!p.getPlateau()[abs][ord].acceptePiece(TAIL) ) {
    		//random endroit 
    		abs = getRandomIntegerBetweenRange(0,2);
    		ord = getRandomIntegerBetweenRange(0,2);
    	}

		a = new Placement(TAIL, p.getPlateau()[abs][ord]);
        return a;
    }
    
    //avoir un entier aleatoire entre deux valeurs
    public static int getRandomIntegerBetweenRange(double min, double max){
        double x = (int)(Math.random()*((max-min)+1))+min;
        return (int) x;
    }
    
    //copier le joueur
    public Object clone() {
        JoueurIA cloneObject = new JoueurIA(getNom(), getCouleur());
        cloneObject.setPieces(getPieces());
        return cloneObject;
    }
}