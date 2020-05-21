package gobblets.interaction;
import gobblets.data.Joueur;

//zimmermanna Cette classe modélise l'action de quitter le jeu
public class Termination extends Action {
    public Termination() {}

    @Override
    public boolean verifier(Joueur j) {
        return true;
    }

    @Override
    public void appliquer(Joueur j) {
        
    }

    @Override
    public String toString() {
        return "Termination";
    }

}