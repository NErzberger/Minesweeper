package main;

import javax.swing.JButton;
import javax.swing.JPanel;

import controller.PlayingFieldController;


import java.awt.GridLayout;

/**
 * 
 * @author Nico
 * @author Larissa
 *
 */
public class Playingfield extends JPanel{

	private ButtonPlayingfield[] field;
	
	
	/**
	 * Konstruktor der Klasse {@link Playingfield}. Wird dieser Konstruktor aufgerufen, wird das Spielfeld aufgebaut.
	 * Hierfür werden in die Klassenvariable Objekte der Klasse {@link ButtonPlayingfield} gesetzt, 
	 * welche in einem Grid angeordnet werden.
	 * @param width
	 * @param height
	 */
	public Playingfield(int width, int height) {
		//rufe Controller auf
		PlayingFieldController pfController = new PlayingFieldController(width, height, this);
		
		field = new ButtonPlayingfield[width*height];
		setLayout(new GridLayout(height, width));
		
		for (int i = 0; i < field.length; i++) {
			field[i] = new ButtonPlayingfield("", pfController, i);
			this.add(field[i]);
		}
		
		//rufe Methoden showBombs() & countBombsAround() auf, was die Variable valueButton belegt
		pfController.showBombs();
		pfController.countBombsAround();
	}

	/**
	 * Diese Methode gibt einen Button Array der Klasse {@link JButton} zurück.
	 * @return
	 */
	public ButtonPlayingfield[] getField() {
		return field;
	}

	/**
	 * Diese Methode setzt ein Button Array in die Klassenvariable field, welche ebenfalls ein Array der Klasse {@link JButton} ist.
	 * @param field
	 */
	public void setField(ButtonPlayingfield[] field) {
		this.field = field;
	}
}
