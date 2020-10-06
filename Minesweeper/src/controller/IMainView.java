package controller;

/**
 * Das Programm benötigt einen MainView, die als Container für den gesammten Inhalt dient. Darin inbegriffen ist das grundlegende Grid, 
 * was das Spielfeld beinhaltet. Das Spielfeld selbst muss nach dem Schema der {@link IPanelComponent} gestaltet werden.
 * 
 * @author Nico
 * @author Larissa 
 * 
 */
public interface IMainView {
	
	/**
	 * Die MainView benötigt eine Methode namens run, welche aus der Startklasse heraus aufgerufen wird. Diese Methode soll die MainView öffnen
	 * und ist für die Konfigurierung des Startfensters verantwortlich. Art und umfang ist der jeweiligen Implementierung überlassen.
	 */
	public void run();
}
