package view;

import javax.swing.JButton;
import javax.swing.JPanel;

import controller.IButtonPlayingfield;
import controller.IPanelComponent;
import controller.PlayingFieldController;

import java.awt.Component;
import java.awt.GridLayout;

/**
 * 
 * @author Nico
 * @author Larissa
 *
 */
public class Playingfield extends JPanel implements IPanelComponent{

	private IButtonPlayingfield[] field;
	
	private PlayingFieldController pfController;
	
	
	/**
	 * Konstruktor der Klasse {@link Playingfield}. Wird dieser Konstruktor aufgerufen, wird das Spielfeld aufgebaut.
	 * Hierfür werden in die Klassenvariable Objekte der Klasse {@link ButtonPlayingfield} gesetzt, 
	 * welche in einem Grid angeordnet werden.
	 * @param width
	 * @param height
	 */
	public Playingfield(int width, int height) {
		//rufe Controller auf
		this.pfController = new PlayingFieldController(width, height, this, new MessageBox(pfController));
		
		field = new IButtonPlayingfield[width*height];
		setLayout(new GridLayout(height, width));
		
		for (int i = 0; i < field.length; i++) {
			field[i] = new ButtonPlayingfield("", pfController, i);
			this.add((Component) field[i]);
		}
		
		//rufe Methoden showBombs() & countBombsAround() auf, was die Variable valueButton belegt
		pfController.showBombs();
		pfController.countBombsAround();
	}

	/**
	 * Diese Methode gibt einen Button Array der Klasse {@link JButton} zurück.
	 * @return
	 */
	public IButtonPlayingfield[] getField() {
		return field;
	}

	/**
	 * Diese Methode setzt ein Button Array in die Klassenvariable field, welche ebenfalls ein Array der Klasse {@link JButton} ist.
	 * @param field
	 */
	public void setField(IButtonPlayingfield[] field) {
		this.field = field;
	}
	
	public PlayingFieldController getPlayingFieldController() {
		return this.pfController;
	}
}
