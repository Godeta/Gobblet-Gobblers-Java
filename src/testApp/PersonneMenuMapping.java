package testApp;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import testApp.model.Personne;

public class PersonneMenuMapping {
    //Objet servant de r�f�rence � notre classe principale
    //afin de pouvoir r�cup�rer le Stage principal.
	//et ainsi fermer l'application
    private TestMain main;
    
    //M�thode qui sera utilis�e dans l'initialisation de l'IHM
    //dans notre classe principale
    public void setMainApp(TestMain mainApp) {
        this.main = mainApp;
    }

    
	//Fermer l'application
	@FXML
	public void fermer() {
		//On affiche un message car on est poli.
		Alert bye = new Alert(AlertType.INFORMATION);
		bye.setTitle("Au revoir !");
		bye.setHeaderText("See you soon...");
		bye.setContentText("Et merci d'avoir suivi ce cours");
		bye.showAndWait();
		
		//Et on clos le stage principal, donc l'application
		this.main.getStage().close();
	}
	
	@FXML
	public void nouveau() {
		//On affiche la popup avec une personne inexistante
	    this.main.affichePersonneDialogue(new Personne(), "Cr�ation d'une personne");
	}
	
	
}
