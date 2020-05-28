package gobblets;

import gobblets.data.Etat;
import gobblets.ihm.IHM;
import gobblets.logic.Jeu;

public class GobbletMain {
	private static boolean run = true;
	// La classe principale depuis laquelle se lancera le jeu dans la console
	public static void main(String[] args){
		while(run) {
		Jeu gobblets = new Jeu();
		//l'ihm, nottament sa langue est initialisee dans jeu donc on le recupère
        IHM ihm = gobblets.getIHM();
        try {
        	while (gobblets.getEtat() == Etat.JEUENCOURS) {
                ihm.display(gobblets.getPlateau(), gobblets.getJoueurActif());
                gobblets.setEtat(gobblets.play());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("\n");
	}
		
	}

}
