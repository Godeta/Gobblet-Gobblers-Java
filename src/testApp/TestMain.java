package testApp;

import java.io.IOException;
import java.time.LocalDate;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import testApp.model.Personne;
import testApp.model.Sexe;

public class TestMain extends Application{


	//Nous cr�ons des variable de classes afin de pouvoir y acc�der partout
	//Ceci afin de pouvoir y positionner les �l�ments que nous avons fait
	//Il y a un BorderPane car le conteneur principal de notre IHM
	//est un BorderPane, nous reparlerons de l'objet Stage
	private Stage stagePrincipal;
	private BorderPane conteneurPrincipal;
	private ObservableList<Personne> listDePersonne = FXCollections.observableArrayList();
	
	public TestMain() {
		listDePersonne.add(new Personne("Proviste", "Alain", LocalDate.of(1970, 1, 1), Sexe.MASCULIN));
		listDePersonne.add(new Personne("D'Arc", "Jeanne", LocalDate.of(1431, 5, 30), Sexe.FEMININ));
		listDePersonne.add(new Personne("Caisse", "Jean", LocalDate.of(1950, 3, 3), Sexe.MASCULIN));
	}
	
	public ObservableList<Personne> getListDePersonne(){return listDePersonne;}
	
	@Override
	public void start(Stage primaryStage) {
		stagePrincipal = primaryStage;
		//Ca ne vous rappelle pas une JFrame ?
		stagePrincipal.setTitle("Application de gestion de personnes");
		
		//Nous allons utiliser nos fichier FXML dans ces deux m�thodes
		initialisationConteneurPrincipal();
		initialisationContenu();
	}

	  private void initialisationConteneurPrincipal() {
	    	//On cr�� un chargeur de FXML
	    	FXMLLoader loader = new FXMLLoader();
	    	//On lui sp�cifie le chemin relatif � notre classe
	    	//du fichier FXML a charger : dans le sous-dossier view
	    	loader.setLocation(TestMain.class.getResource("menu.fxml"));
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
	    		PersonneMenuMapping controleur = loader.getController();
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
		loader.setLocation(TestMain.class.getResource("appView.fxml"));
		try {
			//Nous r�cup�rons notre conteneur qui contiendra les donn�es
			//Pour rappel, c'est un AnchorPane...
			AnchorPane conteneurPersonne = (AnchorPane) loader.load();
			//Qui nous ajoutons � notre conteneur principal
			//Au centre, puisque'il s'agit d'un BorderPane
			conteneurPrincipal.setCenter(conteneurPersonne);
			
			//Nous r�cup�rons notre mappeur via l'objet FXMLLoader
			PersonneMapping controleur = loader.getController();
			//Nous lui passons notre instance de classe
			//pour qu'il puisse r�cup�rer notre liste observable
			controleur.setMainApp(this);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	//M�thode qui va va afficher la popup d'�dition
	//ou de cr�ation d'une personne et initialiser son contr�leur
	public void affichePersonneDialogue(Personne personne, String titre) {
	    try {
	        FXMLLoader loader = new FXMLLoader();
	        loader.setLocation(TestMain.class.getResource("PersonneDialogue.fxml"));
	        AnchorPane page = (AnchorPane) loader.load();
	        
	        // Cr�ation d'un nouveau Stage qui sera d�pendant du Stage principal
	        Stage stageDialogue = new Stage();
	        stageDialogue.setTitle(titre);
	        stageDialogue.initModality(Modality.WINDOW_MODAL);
	        
	        //Avec cette instruction, notre fen�tre modifi�e sera modale
	        //par rapport � notre stage principal
	        stageDialogue.initOwner(stagePrincipal);
	        Scene scene = new Scene(page);
	        stageDialogue.setScene(scene);
	        
	        // initialisation du contr�leur
	        PersonneDialogueMapping controller = loader.getController();
	        //On passe la personne avec laquelle nous souhaitons travailler
	        //une existante ou une nouvelle
	        controller.setPersonne(personne);
	        controller.setMainClass(this);
	        
	        // Show the dialog and wait until the user closes it
	        stageDialogue.showAndWait();
	        //return controller.isOkClicked();
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
