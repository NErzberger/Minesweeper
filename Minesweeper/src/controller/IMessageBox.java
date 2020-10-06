package controller;

/**
 * In IMessageBox soll ermöglicht werden, dass eine Meldung an den User gemacht wird. 
 *  
 * @author Nico
 * @author Larissa
 *
 */
public interface IMessageBox {
	
	/**
	 * Wenn Meldung an den User gemacht werden soll, wird die Methode showMessage aufgerufen. Dabei wird lediglich der Titel und eine Nachricht mitgegeben.
	 * Die Methode soll einen Integer zurückgeben, welcher der Wert der ausgewählten Option sein soll. Standartmäßig werdend die zwei Optionen "Neustart" und 
	 * "Schließen" sein. 
	 * 
	 * @param title
	 * @param message
	 * @param options
	 */
	public int showMessage(String title, String message, String[] options);
	
	// Macht keinen Sinn!!!!!!
	/**
	 * Wenn Meldung an den User gemacht werden soll wird die Methode showMessage aufgerufen. Dabei wird lediglich der Titel, eine Nachricht und zur Orientierung der 
	 * {@link PlayingFieldController} als Parameter mitgegeben. Weitere Vorgaben wie die Nachricht aussehen soll werden nicht gemacht.
	 * 
	 * @param title
	 * @param message
	 * @param pf
	 */
	public void showMessage(String title, String message, PlayingFieldController pf);
}
