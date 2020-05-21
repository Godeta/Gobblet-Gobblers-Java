package gobblets;

import gobblets.data.Etat;
import gobblets.ihm.IHM;
import gobblets.ihm.texte.SaisieConsole;
import gobblets.logic.Jeu;

public class GobbletMain {

	public static void main(String[] args) throws Exception{
		// La classe principale depuis laquelle se lancera le jeu dans la console
		System.out.println("Bonjour !");
		
		Jeu gobblets = new Jeu();
        System.out.println("Jeu initialisé :\n"+ gobblets);
        IHM ihm = new SaisieConsole();
        try {
        	while (gobblets.getEtat() == Etat.JEUENCOURS) {
                System.out.println("Etat jeu : " + gobblets.getEtat());
                ihm.display(gobblets.getPlateau(), gobblets.getJoueurActif());
                gobblets.setEtat(gobblets.play());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
	}

}
