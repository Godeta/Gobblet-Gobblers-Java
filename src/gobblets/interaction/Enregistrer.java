package gobblets.interaction;
import gobblets.data.Joueur;

// Cette classe modelise l'action d'enregistrer le jeu
public class Enregistrer extends Action {
    public Enregistrer() {}

    @Override
    public boolean verifier(Joueur j) {
        return true;
    }

    @Override
    public void appliquer(Joueur j) {
        
    }

    @Override
    public String toString() {
        return "Enregistrer";
    }

}