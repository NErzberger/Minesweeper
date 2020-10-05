package view;

import javax.swing.JOptionPane;

import controller.IMessageBox;
import controller.PlayingFieldController;

public class MessageBox implements IMessageBox {
	private PlayingFieldController pf;
	
	public MessageBox(PlayingFieldController pf) {
		this.pf = pf;
	}
	
	// Nachricht bei Sieg oder Niederlage
		public void showMessage(String title, String message, PlayingFieldController pf) {
			pf.turnAll();
			String[] options = new String[2];
			options[0] = new String("Neustart");
			options[1] = new String("Schlieﬂen");
			int returnValue = JOptionPane.showOptionDialog(null, message, title, 0, 
					JOptionPane.INFORMATION_MESSAGE, null, options, null);
			if (returnValue == 0) {
				pf.restart();
			}
			// Beenden des Spiels / Schlieﬂen
			if (returnValue == 1) {
				System.exit(0);
			}
		}
}
