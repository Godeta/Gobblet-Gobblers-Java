package Application.view;

import java.io.File;

import Application.MainClass;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import testApp.model.Personne;

public class MenuMap {
    private MainClass main;
    
    //Méthode qui sera utilisée dans l'initialisation de l'IHM
    //dans notre classe principale
    public void setMainApp(MainClass mainApp) {
        this.main = mainApp;
    }

    
	//Fermer l'application
	@FXML
	public void fermer() {
		Alert bye = new Alert(AlertType.INFORMATION);
		bye.setTitle("Au revoir !");
		bye.setHeaderText("See you soon...");
		bye.setContentText("Fin de gobblet Gobblers ;(");
		bye.showAndWait();
		
		this.main.getStage().close();
	}
	
	@FXML
	public void nouveau() {
	}
	 public void information(String titre, String message) {
		    Alert dialogue = new Alert(AlertType.INFORMATION);
		    dialogue.setTitle(titre);
		    dialogue.setHeaderText(null);
		    dialogue.setContentText(message);
		    dialogue.showAndWait();
		  }
	 
	  public void enregistrement() {
		    FileChooser dialogue = new FileChooser();
		    dialogue.setTitle("Sauvegarder la partie");
		    dialogue.getExtensionFilters().addAll(new ExtensionFilter("Fichiers texte", "*.txt"));
		    File fichierChoisi = dialogue.showSaveDialog(null);
		    if (fichierChoisi != null) {
		      information("Enregistrement réussi", "Enregistré dans le fichier : " + fichierChoisi);
		    }
		  }
		  public void ouverture() {
		    FileChooser dialogue = new FileChooser();
		    dialogue.setTitle("Ouvrir un fichier");
		    dialogue.getExtensionFilters().addAll(
		        new ExtensionFilter("Fichiers texte", "*.txt"),
		        new ExtensionFilter("Tous les fichiers", "*.*"));
		    File fichierChoisi = dialogue.showOpenDialog(null);
		    if (fichierChoisi != null) {
		      information("Ouverture réussie", "Vous avez choisi d'ouvrir le fichier :\n" + fichierChoisi);
		    }
		  }
	
	
}
