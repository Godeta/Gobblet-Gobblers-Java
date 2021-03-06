package testApp;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import testApp.model.Personne;

public class PersonneMapping {
	@FXML
    private TableView<Personne> personneTab;
    @FXML
    private TableColumn<Personne, String> NOMCOL;
    @FXML
    private TableColumn<Personne, String> PRENOMCOL;
    @FXML
    private Label NomValeur;
    @FXML
    private Label PrenomValeur;
    @FXML
    private Label DateValeur;
    @FXML
    private Label SexeValeur;
    
    //Objet servant de r�f�rence � notre classe principale
    //afin de pouvoir r�cup�rer la liste de nos objets.
    private TestMain main;

    //Un constructeur par d�faut
    public PersonneMapping() { }

    //M�thode qui initialise notre interface graphique
    //avec nos donn�es m�tier
    @FXML
    private void initialize() {
        // Initialize the Personne table with the two columns.
        NOMCOL.setCellValueFactory(cellData -> cellData.getValue().getNom());
        PRENOMCOL.setCellValueFactory(cellData -> cellData.getValue().getPrenom());
        //Nous r�cup�rons le model de notre tableau (vous connaissez maintenant)
        //o� nous r�cup�rons l'item s�lectionn� et o� nous y attachons un �couteur
        //Qui va utiliser notre m�thode de mise � jour d'IHM
        personneTab.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> initializeDescription(newValue));
    }
    
  //M�thode qui va mettre les valeurs de notre objet dans les composants
    public void initializeDescription(Personne p) {
    	//On r�initialise par d�faut
    	NomValeur.setText("");
    	PrenomValeur.setText("");
    	DateValeur.setText("");
    	SexeValeur.setText("");
    	
    	//Si un objet est pass� en param�tre, on modifie l'IHM
    	if(p != null) {
    		//ATTENTION : les accesseurs retournent des objets Property Java FX
    		//Pour r�cup�rer leurs vrais valeurs vous devez utiliser la m�thode get()
    		NomValeur.setText(p.getNom().get());
    		PrenomValeur.setText(p.getPrenom().get());
    		//Sur les deux champs si dessous, en plus de get()
    		//vous devez utiliser toString() car ce sont des objets particuliers
    		DateValeur.setText(p.getDateDeNaissance().get().toString());
    		SexeValeur.setText(p.getSexe().get().toString());
    	}
    }


    //M�thode qui sera utilis�e dans l'initialisation de l'IHM
    //dans notre classe principale
    public void setMainApp(TestMain mainApp) {
        this.main = mainApp;
        // On lie notre liste observable au composant TableView
        personneTab.setItems(main.getListDePersonne());
    }
    
    @FXML
    public void supprimerPersonne() {
    	int index = personneTab.getSelectionModel().getSelectedIndex();
    	//Si aucune ligne n'est s�lectionn�e, index vaudra -1
    	if (index > -1) {
    		personneTab.getItems().remove(index);
    	}
    	else {
    		Alert probleme = new Alert(AlertType.ERROR);
    		probleme.setTitle("Erreur");
    		probleme.setHeaderText("Veuillez s�lectionnez une ligne dans le tableau");
    		probleme.showAndWait();
    	}
    }
}