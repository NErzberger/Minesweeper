package view;

import javax.swing.JPanel;

import java.awt.Component;
import java.awt.GridLayout;

import controller.IButtonPlayingfield;
import controller.IPanelComponent;
import controller.PlayingFieldController;

/**
 * Das Playingfield implementiert das Interface IPanelComponent. 
 * @author Nico
 * @author Larissa
 *
 */
public class Playingfield extends JPanel implements IPanelComponent{
	
	/**
	 * Diese Klassenvariable ist vom Typ {@link PlayingFieldController}.
	 */
	private PlayingFieldController pfController;
		
	/**
	 * Konstruktor der Klasse {@link Playingfield}. Wird dieser Konstruktor aufgerufen, wird das Spielfeld aufgebaut.
	 * Hierf�r werden in die Klassenvariable Objekte der Klasse {@link ButtonPlayingfield} gesetzt, 
	 * welche in einem Grid angeordnet werden.
	 */
	public Playingfield() {
		//rufe Controller auf
		this.pfController = new PlayingFieldController(this, new MessageBox());
		// erstelle ein Spielfeld mit der im Model festgelegten H�he & Breite
		pfController.setField(new IButtonPlayingfield[pfController.getDg().getWidth()*pfController.getDg().getHeight()]);
		// lege ein GridLayout fest
		setLayout(new GridLayout(pfController.getDg().getHeight(), pfController.getDg().getWidth()));
		
		// f�ge auf jedes Feld des Spielfelds einen Button hinzu
		for (int i = 0; i < pfController.getField().length; i++) {
			pfController.getField()[i] = new ButtonPlayingfield("", pfController, i);
			this.add((Component) pfController.getField()[i]);
		}
		
		//rufe Methoden showBombs() & countBombsAround() auf, welche die Variable valueButton belegen
		pfController.showBombs();
		pfController.countBombsAround();
	}

	/**
	 * Diese Methode gibt den Wert der Variablen pfController des Typs {@link PlayingFieldController} zur�ck. 
	 * @return pfController
	 */
	public PlayingFieldController getPlayingFieldController() {
		return this.pfController;
	}
}