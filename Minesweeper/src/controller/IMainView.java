package controller;

/**
 * Das Programm ben�tigt eine MainView, die als Container f�r den gesamten Inhalt dient. Darin inbegriffen ist das grundlegende Grid, 
 * was das Spielfeld beinhaltet. Dieses ist durch den {@link IPanelComponent} festgelegt.
 * 
 * @author Nico
 * @author Larissa 
 * 
 */
public interface IMainView {
	
	/**
	 * Die MainView ben�tigt diese Methode, welche aus der Startklasse heraus aufgerufen wird. Diese Methode soll die MainView �ffnen
	 * und ist f�r die Konfigurierung des Startfensters verantwortlich. Art und Umfang ist der jeweiligen Implementierung �berlassen.
	 */
	public void run();
}
