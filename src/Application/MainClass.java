package Application;

import java.io.IOException;

import Application.view.MenuMap;
import Application.view.gameMap;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class MainClass extends Application{


	//Nous cr�ons des variable de classes afin de pouvoir y acc�der partout
	//Ceci afin de pouvoir y positionner les �l�ments que nous avons fait
	//Il y a un BorderPane car le conteneur principal de notre IHM
	//est un BorderPane, nous reparlerons de l'objet Stage
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

	
	public static void main(String[] args) {
		launch(args);
	}

	public Stage getStage() {
		// TODO Auto-generated method stub
		return this.stagePrincipal;
	}
}
