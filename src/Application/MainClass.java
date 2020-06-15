package Application;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import Application.view.MenuMap;
import Application.view.gameMap;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import testApp.PersonneDialogueMapping;
import testApp.TestMain;
import testApp.model.Personne;
import Application.view.*;

public class MainClass extends Application{


	private Stage stagePrincipal;
	private BorderPane conteneurPrincipal;
	
	@Override
	public void start(Stage primaryStage) {
		stagePrincipal = primaryStage;
		stagePrincipal.setTitle("Gobblet Gobblers");
		
		//Nous allons utiliser nos fichier FXML dans ces deux m�thodes
		initialisationConteneurPrincipal();
		initialisationContenu();
		
	}
	
	  private void initialisationConteneurPrincipal() {
	    	//On cr�� un chargeur de FXML
	    	FXMLLoader loader = new FXMLLoader();
	    	//On lui sp�cifie le chemin relatif � notre classe
	    	//du fichier FXML a charger : dans le sous-dossier view
	    	loader.setLocation(MainClass.class.getResource("view/menu.fxml"));
	    	//*
	    	try {
	    		//Le chargement nous donne notre conteneur
	    		conteneurPrincipal = (BorderPane) loader.load();
	    		//System.out.println(conteneurPrincipal);
	    		//On d�finit une sc�ne principale avec notre conteneur
	    		Scene scene = new Scene(conteneurPrincipal);
	    		//Que nous affectons � notre Stage
	    		stagePrincipal.setScene(scene);
	    		
	    		//Initialisation de notre contr�leur
	    		MenuMap controleur = loader.getController();
	    		//On sp�cifie la classe principale afin de pour r�cup�rer le Stage
	    		//Et ainsi fermer l'application
	    		controleur.setMainApp(this);
	    		
	    		stagePrincipal.show();
	    		
	    	} catch (IOException e) {
	    		e.printStackTrace();
	    	}
	    }
	
	private void initialisationContenu() {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(MainClass.class.getResource("view/game.fxml"));
		try {
			//Nous r�cup�rons notre conteneur qui contiendra les donn�es
			//Pour rappel, c'est un AnchorPane...
			BorderPane conteneurPersonne = (BorderPane) loader.load();
			//Qui nous ajoutons � notre conteneur principal
			//Au centre, puisque'il s'agit d'un BorderPane
			conteneurPrincipal.setCenter(conteneurPersonne);
			
			//Nous r�cup�rons notre mappeur via l'objet FXMLLoader
			gameMap controleur = loader.getController();
			//Nous lui passons notre instance de classe
			//pour qu'il puisse r�cup�rer notre liste observable
			controleur.setMainApp(this);
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	//M�thode qui va va afficher la popup d'�dition
		//ou de cr�ation d'une personne et initialiser son contr�leur
		public int affichePieceDialogue() {
		    	Alert dialogue = new Alert(AlertType.CONFIRMATION);
		        dialogue.setTitle("Choix de la taille de la pi�ce");
		        dialogue.setHeaderText(null);
		        dialogue.setContentText("Vous avez 3 possibilit�es, qu'elle taille souhaitez vous utiliser ?");
		        ButtonType button1 = new ButtonType("Petite");
		        ButtonType button2 = new ButtonType("Moyenne");
		        ButtonType button3 = new ButtonType("Grande");
		        ButtonType button4 = new ButtonType("Annuler", ButtonData.CANCEL_CLOSE);
		        dialogue.getButtonTypes().setAll(button1, button2, button3, button4);
		        Optional<ButtonType> result = dialogue.showAndWait();
		        if (result.get() == button1){
		        	return 1;
		        } else if (result.get() == button2) {
		        return 2;
		        } else if (result.get() == button3) {
		        	return 3;
		        } else {
		        	return 0;
		        }
		    
		}

	
	public static void main(String[] args) {
		launch(args);
	}

	public Stage getStage() {
		// TODO Auto-generated method stub
		return this.stagePrincipal;
	}
}
