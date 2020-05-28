package gobblets;

//librairie pour utiliser les couleurs
import org.fusesource.jansi.AnsiConsole;
import static org.fusesource.jansi.Ansi.*;
import static org.fusesource.jansi.Ansi.Color.*;

public class ColorTest {

	public static void main(String[] args) {
		//pour utiliser jansi avec le plug-in Eclipse
		System.setProperty("jansi.passthrough", "true");
		
		AnsiConsole.systemInstall();
		/*test pour verifier que le plug-in eclipse http://mihai-nita.net/2013/06/03/eclipse-plugin-ansi-in-console/
		 *  a bien ete installe et permet de voir les couleurs
		 */
		System.out.println("Hello \u001b[1;31mred\u001b[0m world!");
		
		// Une classe pour tester l'affichage en couleur dans la console avec jansi !
		System.out.println( ansi().eraseScreen().fg(BLUE).a("Hello").fg(GREEN).a(" World").reset() );
	}



}