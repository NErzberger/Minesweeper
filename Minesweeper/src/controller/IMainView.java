package controller;

/**
 * Das Programm benötigt eine MainView, die als Container für den gesamten Inhalt dient. Darin inbegriffen ist das grundlegende Grid, 
 * was das Spielfeld beinhaltet. Dieses ist durch den {@link IPanelComponent} festgelegt.
 * 
 * @author Nico
 * @author Larissa 
 * 
 */
public interface IMainView {
	
	/**
	 * Die MainView benötigt diese Methode, welche aus der Startklasse heraus aufgerufen wird. Diese Methode soll die MainView öffnen
	 * und ist für die Konfigurierung des Startfensters verantwortlich. Art und Umfang ist der jeweiligen Implementierung überlassen.
	 */
	public void run();
}
