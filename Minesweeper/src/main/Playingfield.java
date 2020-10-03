package main;

import javax.swing.JButton;
import javax.swing.JPanel;

import controller.PlayingFieldController;
import model.DataGrid;

import java.awt.GridLayout;

/**
 * 
 * @author Nico
 * @author Larissa
 *
 */
public class Playingfield extends JPanel{

	private JButton[] field;
	
	/**
	 * Konsturktor der Klasse {@link Playingfield}. Wird dieser Konsturktor aufgerufen, wird das Spielfeld aufgebaut. Hierfür werden in die Klassenvariable Objekte der Klasse {@link ButtonPlayingfield} gesetzt, 
	 * welche in einem Grind angeordnet werden.
	 * @param width
	 * @param height
	 */
	public Playingfield(int width, int height) {
		//rufe Controller auf
		PlayingFieldController pfController = new PlayingFieldController(width, height,this);
		
		field = new JButton[width*height];
		setLayout(new GridLayout(height, width));
		
		for (int i = 0; i < field.length; i++) {
			field[i] = new ButtonPlayingfield("this is button "+ i);
			this.add(field[i]);
		}
		
		//rufe Methode showBombs auf
		pfController.showBombs();
		pfController.countBombsAround();
	}

	/**
	 * Diese Methode gibt einen Button Array der Klasse {@link JButton} zurück.
	 * @return
	 */
	public JButton[] getField() {
		return field;
	}

	/**
	 * Diese Methode setzt ein Button Array in die Klassenvariable field, welche ebenfalls ein Array der Klasse {@link JButton} ist.
	 * @param field
	 */
	public void setField(JButton[] field) {
		this.field = field;
	}
}
