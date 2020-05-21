package gobblets;

import java.util.Scanner;

import gobblets.data.ActionType;
import gobblets.data.Etat;
import gobblets.ihm.Dictionnaire;
import gobblets.ihm.IHM;
import gobblets.ihm.langues.Francais;
import gobblets.ihm.texte.SaisieConsole;
import gobblets.logic.Jeu;

public class GobbletMain {

    private final static Scanner sc = new Scanner(System.in);

	// La classe principale depuis laquelle se lancera le jeu dans la console
	public static void main(String[] args){
		Jeu gobblets = new Jeu();
        IHM ihm = new SaisieConsole();
        try {
        	while (gobblets.getEtat() == Etat.JEUENCOURS) {
                ihm.display(gobblets.getPlateau(), gobblets.getJoueurActif());
                gobblets.setEtat(gobblets.play());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
	}

}
