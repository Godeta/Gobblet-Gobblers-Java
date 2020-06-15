package testApp;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import testApp.model.Personne;
import testApp.model.Sexe;

public class PersonneDialogueMapping {

	private Stage stageDialogue;
	@FXML
	private TextField nomFormulaire;
	@FXML
	private TextField prenomFormulaire;
	@FXML
	private DatePicker dateFormulaire;
	@FXML
	private ComboBox<Sexe> sexeFormulaire;
	
	private TestMain main;	
	private Personne personne;
	
	public void setMainClass(TestMain m) {
		main = m;
		stageDialogue = main.getStage();
	}
	
	//On initialise ici les valeurs de la liste d�roulante
	//avant de s�lectionner la valeur de la personne
	public void initialize() {
		sexeFormulaire.getItems().setAll(Sexe.values());
	}
	
	//Afin de r�cup�rer le stage de la popup
	//et pouvoir la clore
	public void setStage(Stage s) {stageDialogue = s;}
	
	public void setPersonne(Personne p) {
		personne = p;
		nomFormulaire.setText(personne.getNom().get());
		prenomFormulaire.setText(personne.getPrenom().get());
		dateFormulaire.setValue(personne.getDateDeNaissance().get());
		sexeFormulaire.getSelectionModel().select(personne.getSexe().get());
	}
	
	//M�thode de contr�le de la validit� des donn�es saisies
	private boolean controlerFormulaire() {
		boolean isOk = true;
		List<String> messageErreur = new ArrayList<>();
		if (nomFormulaire.getText() == null || nomFormulaire.getText().isEmpty()) {
			isOk = false;
			messageErreur.add("Le champ \"Nom\" est obligatoire");
		}
		if (prenomFormulaire.getText() == null || prenomFormulaire.getText().isEmpty()) {
			isOk = false;
			messageErreur.add("Le champ \"Pr�nom\" est obligatoire");
		}	
		if (dateFormulaire.getValue() == null || dateFormulaire.getValue().toString().isEmpty()) {
			isOk = false;
			messageErreur.add("Le champ \"Date\" est obligatoire");
		}
		
		if(!isOk) {
			Alert erreur = new Alert(AlertType.ERROR);
			erreur.setTitle("Erreur ! ");
			StringBuilder sb = new StringBuilder();
			messageErreur.stream().forEach((x) -> sb.append("\n" + x));
			erreur.setHeaderText(sb.toString());
			erreur.showAndWait();
		}		
		return isOk;
	}
	
	@FXML
	public void annuler() {
		//On ferme la bo�te de dialogue
		stageDialogue.close();
	}
	
	//sauvegarde de la personne, que ce soit une �dition ou une cr�ation
	public void sauvegarder() {
		if(controlerFormulaire()) {
			personne.setNom(new SimpleStringProperty(nomFormulaire.getText()));
			personne.setPrenom(new SimpleStringProperty(prenomFormulaire.getText()));
			
			//Afin de pouvoir g�rer la modification de date � la souris
			//ou en modifiant le texte du composant directement
			//On r�cup�re la date au format texte pour la r�injecter 
			//dans le composant
			dateFormulaire.setValue(
					dateFormulaire	.getConverter()
									.fromString(
											//Date du composant au format texte
											dateFormulaire.getEditor().getText()
									)
								);
			
			personne.setDateDeNaissance(new SimpleObjectProperty<LocalDate>(dateFormulaire.getValue()));
			personne.setSexe(new SimpleObjectProperty<Sexe>(sexeFormulaire.getValue()));

			//S'il s'agit d'une cr�ation, on ajoute la personne dans le tableau
			if(stageDialogue.getTitle().startsWith("Cr�ation")) {
				main.getListDePersonne().add(personne);
			}

			//On ferme la bo�te de dialogue
			stageDialogue.close();
		}
	}
}
