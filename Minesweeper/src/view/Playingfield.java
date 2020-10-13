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
	 * Konstruktor der Klasse {@link Playingfield}. 
	 */
	public Playingfield() {
		drawPlayingfield();
	}
	
	/**
	 * In dieser Methode wird das Spielfeld aufgebaut. Auf jedes der Felder wird ein {@link ButtonPlayingfield} gelegt.
	 * Diese werden in einem Grid angeordnet.
	 * Zusätzlich werden Bomben verteilt und die Anzahl der Bomben in umliegenden Feldern wird gezählt.
	 */
	public void drawPlayingfield() {
		//rufe Controller auf
				this.pfController = new PlayingFieldController(this, new MessageBox());
				// erstelle ein Spielfeld mit der im Model festgelegten Höhe & Breite
				pfController.setField(new IButtonPlayingfield[pfController.getDg().getWidth()*pfController.getDg().getHeight()]);
				// lege ein GridLayout fest
				setLayout(new GridLayout(pfController.getDg().getHeight(), pfController.getDg().getWidth()));
				
				// füge auf jedes Feld des Spielfelds einen Button hinzu
				for (int i = 0; i < pfController.getField().length; i++) {
					pfController.getField()[i] = new ButtonPlayingfield("", pfController, i);
					this.add((Component) pfController.getField()[i]);
				}
				
				//rufe Methoden showBombs() & countBombsAround() auf, welche die Variable valueButton belegen
				pfController.showBombs();
				pfController.countBombsAround();
	}

	/**
	 * Diese Methode gibt den Wert der Variablen pfController des Typs {@link PlayingFieldController} zurück. 
	 * @return pfController
	 */
	public PlayingFieldController getPlayingFieldController() {
		return this.pfController;
	}
}