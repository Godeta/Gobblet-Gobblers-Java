package Application.view;

import Application.MainClass;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class gameMap {
    
    //Objet servant de r�f�rence � notre classe principale
    //afin de pouvoir r�cup�rer la liste de nos objets.
    private MainClass main;
    private GridPane grille;
    private Stage stageDialogue;
	@FXML
	/*g�ner� avec : for i in range(10) :
    print("private Button caseGG"+str(i)+";") en python*/
	private Button caseGG0;
	@FXML
	private Button caseGG2;
	@FXML
	private Button caseGG3;
	@FXML
	private Button caseGG4;
	@FXML
	private Button caseGG5;
	@FXML
	private Button caseGG6;
	@FXML
	private Button caseGG7;
	@FXML
	private Button caseGG8;
	@FXML
	private Button caseGG9;

    //Un constructeur par d�faut
    public gameMap() { }

    //M�thode qui initialise notre interface graphique
    //avec nos donn�es m�tier
    @FXML
    private void initialize() {
        // Initialize 
    }
    
    //M�thode qui sera utilis�e dans l'initialisation de l'IHM
    //dans notre classe principale
    public void setMainApp(MainClass mainApp) {
        this.main = mainApp;
		stageDialogue = main.getStage();
    }
    public void setStage(Stage s) {stageDialogue = s;}
    
    @FXML
    public String choixTaille() {
    	//Button btn = (Button) event.getSource();
        int c = main.affichePieceDialogue();
        if (c ==1) {
        	return ".";
        }
        else if (c ==2) {
        	return "o";
        }
        else if (c ==3) {
        	return "O";
        }
        else {
        	return "";}
        }
    
    /*g�ner� avec : for i in range(10) :
  print("public void caseGG"+str(i)+"() {\ncaseGG"+str(i)+".setText(choixTaille() ); }") en python */
    @FXML
    public void caseGG0() {
    	caseGG0.setText(choixTaille() ); }
    @FXML	
    public void caseGG9() {
    	caseGG9.setText("o" ); }
    @FXML
    	public void caseGG2() {
    	caseGG2.setText(choixTaille() ); }
    @FXML
    	public void caseGG3() {
    	caseGG3.setText(choixTaille() ); }
    @FXML
    	public void caseGG4() {
    	caseGG4.setText(choixTaille() ); }
    @FXML
    	public void caseGG5() {
    	caseGG5.setText(choixTaille() ); }
    @FXML
    	public void caseGG6() {
    	caseGG6.setText(choixTaille() ); }
    @FXML
    	public void caseGG7() {
    	caseGG7.setText(choixTaille() ); }
    @FXML
    	public void caseGG8() {
    	caseGG8.setText(choixTaille() ); }
    
}
