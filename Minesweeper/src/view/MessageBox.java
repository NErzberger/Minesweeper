package view;

import java.awt.Component;

import javax.swing.JOptionPane;

import controller.IMessageBox;
import controller.IPanelComponent;

/**
 * Die Klasse MessageBox ist die Implementierung des Interfaces IMessageBox. 
 * Das Ziel der Klasse ist das �ffnen einer MessageBox, so dass der User entscheiden kann, ob er weiterspielen oder das Spiel lieber schlie�en m�chte.
 * 
 * @author Nico
 * @author Larissa
 *
 */
public class MessageBox implements IMessageBox {

	/**
	 * Der Konstruktor ist leer, da er keine Variablen �bergeben muss. 
	 */
	public MessageBox() {}
	
	
	/**
	 *In dieser Methode wird lediglich ein OptionDialog aufgerufen, welcher den Wert der ausgew�hlten Option zur�ck gibt.
	 *Mittels dem Parameter {@link IPanelComponent} ipc wird bewirkt, dass die MessageBox mittig erscheint.
	 *@param title
	 *@param message
	 *@param options
	 *@param ipc
	 */
	public int showMessage(String title, String message, String[] options, IPanelComponent ipc) {
		return JOptionPane.showOptionDialog((Component) ipc, message, title, 0, 
				JOptionPane.INFORMATION_MESSAGE, null, options, null);
	}

}
