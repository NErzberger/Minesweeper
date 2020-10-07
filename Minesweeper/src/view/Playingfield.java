package view;

import javax.swing.JPanel;

import controller.IButtonPlayingfield;
import controller.IPanelComponent;
import controller.PlayingFieldController;

import java.awt.Component;
import java.awt.GridLayout;

/**
 * Das Playingfield ist implementiert das Interface IPanelComponent. 
 * @author Nico
 * @author Larissa
 *
 */
public class Playingfield extends JPanel implements IPanelComponent{
	
	private PlayingFieldController pfController;
		
	/**
	 * Konstruktor der Klasse {@link Playingfield}. Wird dieser Konstruktor aufgerufen, wird das Spielfeld aufgebaut.
	 * Hierfür werden in die Klassenvariable Objekte der Klasse {@link ButtonPlayingfield} gesetzt, 
	 * welche in einem Grid angeordnet werden.
	 * @param width
	 * @param height
	 */
	public Playingfield() {
		//rufe Controller auf
		this.pfController = new PlayingFieldController(this, new MessageBox());
		
		pfController.setField(new IButtonPlayingfield[pfController.getDg().getWidth()*pfController.getDg().getHeight()]);
		setLayout(new GridLayout(pfController.getDg().getHeight(), pfController.getDg().getWidth()));
		
		for (int i = 0; i < pfController.getField().length; i++) {
			pfController.getField()[i] = new ButtonPlayingfield("", pfController, i);
			this.add((Component) pfController.getField()[i]);
		}
		
		//rufe Methoden showBombs() & countBombsAround() auf, was die Variable valueButton belegt
		pfController.showBombs();
		pfController.countBombsAround();
	}


	public PlayingFieldController getPlayingFieldController() {
		return this.pfController;
	}
}
