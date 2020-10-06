package view;

import javax.swing.JOptionPane;

import controller.IMessageBox;
import controller.PlayingFieldController;

/**
 * Die Klasse MessageBox ist die Implementierung des Interfaces IMessageBox. 
 * Das Ziel der Klasse ist das �ffnen einer MessageBox, so dass der User entscheiden kann, ob er weiterspielen m�chte oder das Spiel lieber schlie�en m�chte.
 * 
 * @author Nico
 * @author Larissa
 *
 */
public class MessageBox implements IMessageBox {

	/**
	 * Der Konsturktor ist leer, da es f�r ihr keine Variablen zu �bergeben gibt. 
	 */
	public MessageBox() {
	
	}
	
	
	// so w�rde meine finale Version der Methode aussehen. Man gibt einfach einen Titel, eine Message und die m�gliche Optionen mit. Eine stark generalisierte Methode, 
	// aber dann ist das ganze nicht relevate zeugs f�r die messagebox nicht mehr dirn und man muss die Nachrichten und auswahlm�glichkeiten dem Implementierer nicht
	// �berlassen und kann sicher davon ausgehen, dass das raus kommt was wir wollen.
	/**
	 *In dieser Methode wird lediglich ein OptionDialog aufgerufen, welcher Wert der ausgew�hlten Option zur�ck gibt. 
	 */
	public int showMessage(String title, String message, String[] options) {
//		String[] options = new String[2];
//		options[0] = new String("Neustart");
//		options[1] = new String("Schlie�en");
		return JOptionPane.showOptionDialog(null, message, title, 0, 
				JOptionPane.INFORMATION_MESSAGE, null, options, null);
	}
	
	// Nachricht bei Sieg oder Niederlage
		public void showMessage(String title, String message, PlayingFieldController pf) {
			pf.turnAll();
			String[] options = new String[2];
			options[0] = new String("Neustart");
			options[1] = new String("Schlie�en");
			int returnValue = JOptionPane.showOptionDialog(null, message, title, 0, 
					JOptionPane.INFORMATION_MESSAGE, null, options, null);
			if (returnValue == 0) {
				pf.restart();
			}
			// Beenden des Spiels / Schlie�en
			if (returnValue == 1) {
				System.exit(0);
			}
		}
}
