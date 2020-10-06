package main;

import controller.IMainView;
import view.MainView;

/**
 * Mittels der Klasse Main kann das Programm mit jeder möglichen GUI gestartet werden. 
 * <h1>Warnung:</h1>
 * Es ist Notwendig dass die GUI eine Klasse namens MainView hat und diese das Interface IMainView implementiert.
 * Dadurch wird automatisch die Methode run() aufgerufen und das Programm startet.
 * 
 * @author Nico
 * @author Larissa
 *
 */
public class Main{

	public Main(IMainView mView) {
		mView.run();
	}
	

	/**
	 * Hier wird die Applikation gestartet.
	 */
	public static void main(String[] args) {
		new Main(new MainView());
		
	}


}
