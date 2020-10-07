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
	 * Wenn Meldung an den User gemacht werden soll, wird die Methode showMessage aufgerufen. Dabei werden der Titel, eine Nachricht, ein String Array mit
	 * den Optionen und ein Verweis auf den {@link IPanelComponent} mitgegeben.
	 * Die Methode soll einen Integer zurückgeben, welcher der Wert der ausgewählten Option beschreibt. Standartmäßig werdend die zwei Optionen "Neustart" und 
	 * "Schließen" sein. 
	 * @param title
	 * @param message
	 * @param options
	 * @param ipc
	 */
	public int showMessage(String title, String message, String[] options, IPanelComponent ipc);
}
