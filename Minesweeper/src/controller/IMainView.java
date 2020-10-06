package controller;

/**
 * Das Programm ben�tigt einen MainView, die als Container f�r den gesammten Inhalt dient. Darin inbegriffen ist das grundlegende Grid, 
 * was das Spielfeld beinhaltet. Das Spielfeld selbst muss nach dem Schema der {@link IPanelComponent} gestaltet werden.
 * 
 * @author Nico
 * @author Larissa 
 * 
 */
public interface IMainView {
	
	/**
	 * Die MainView ben�tigt eine Methode namens run, welche aus der Startklasse heraus aufgerufen wird. Diese Methode soll die MainView �ffnen
	 * und ist f�r die Konfigurierung des Startfensters verantwortlich. Art und umfang ist der jeweiligen Implementierung �berlassen.
	 */
	public void run();
}
