package gobblets;

import gobblets.data.Etat;
import gobblets.ihm.IHM;
import gobblets.ihm.texte.SaisieConsole;
import gobblets.logic.Jeu;

public class GobbletMain {

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
