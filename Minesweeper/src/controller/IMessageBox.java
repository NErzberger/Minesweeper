package controller;

/**
 * In IMessageBox soll erm�glicht werden, dass eine Meldung an den User gemacht wird. 
 *  
 * @author Nico
 * @author Larissa
 *
 */
public interface IMessageBox {
	
	/**
	 * Wenn Meldung an den User gemacht werden soll, wird die Methode showMessage aufgerufen. Dabei werden der Titel, eine Nachricht, ein String Array mit
	 * den Optionen und ein Verweis auf den {@link IPanelComponent} mitgegeben.
	 * Die Methode soll einen Integer zur�ckgeben, welcher der Wert der ausgew�hlten Option beschreibt. Standartm��ig werdend die zwei Optionen "Neustart" und 
	 * "Schlie�en" sein. 
	 * @param title
	 * @param message
	 * @param options
	 * @param ipc
	 */
	public int showMessage(String title, String message, String[] options, IPanelComponent ipc);
}
