package controller;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import main.Main;
import model.DataGrid;
import view.ButtonPlayingfield;
import view.Imagetype;
import view.Playingfield;

/**
 * Die Klasse PlayingFieldController verbindet die Klassen {@link Playingfield}
 * und {@link DataGrid}. Ziel der Klasse ist es, das Spielfeld aufzubauen.
 * 
 * @author Nico
 * @author Larissa
 *
 */

public class PlayingFieldController {
	/**
	 * Diese Klassenvariable dient als Container und ist vom Typ
	 * {@link Playingfield}.
	 */
	private IPanelComponent pf;
	
	private IMessageBox mbox;
	/**
	 * Diese Klassenvariable dient als Container und ist vom Typ {@link DataGird}.
	 */
	private DataGrid dg;
	/**
	 * In der Klassenvariable width wird die Breite & Höhe des Spielfeldes
	 * festgehalten.
	 */
	private int width;
	private int height;

	/**
	 * Anzahl der Bomben, die bereits markiert wurden
	 */
	private int bombsFlagged;

	/**
	 * Anzahl der Felder, die bereits umgedreht wurden
	 */
	private int turnedFields;

	/**
	 * Konstruktor der Klasse {@link PlayingFieldController}.
	 * 
	 * @param width
	 * @param height
	 * @param pf
	 */
	public PlayingFieldController(int width, int height, IPanelComponent pf, IMessageBox mbox) {
		dg = new DataGrid(width, height, 5);
		this.pf = pf;
		this.mbox = mbox;
		this.width = width;
		this.height = height;
	}


	/**
	 * zeige Bomben im Playingfield an
	 */
	public void showBombs() {
		String[] posBombs = dg.getPositionBombs();

		for (int i = 0; i < posBombs.length; i++) {
			if (posBombs[i] != null) {
				pf.getField()[i].setValueButton("x");

			}
		}

	}

	/**
	 * Anzahl Bomben in umliegenden Feldern
	 */
	public void countBombsAround() {
		String[] posBombs = dg.getPositionBombs();
		for (int j = 0; j < (posBombs.length); j++) {
			int counter = 0;
			if (posBombs[j] == null) {

				// prüfe, ob rechts eine Bombe liegt (so lange wir uns auf dem Spielfeld
				// befinden)
				if (j < posBombs.length && (j + 1) % width != 0 && posBombs[j + 1] != null) { // da oben
																								// posBombs.length-1 ist
																								// hier nur < notwendig,
																								// nicht <=
					counter++;
				}
				// links
				if (j - 1 >= 0 && j % width != 0 && posBombs[j - 1] != null) {
					counter++;
				}
				// direkt darunter
				if (j + width < posBombs.length && posBombs[j + width] != null) {
					counter++;
					// direkt darüber
				}
				if (j - width >= 0 && posBombs[j - width] != null) {
					counter++;
				} // schräg links oben
				if (j - width - 1 >= 0 && (j - width) % width != 0 && posBombs[j - width - 1] != null) {
					counter++;
					// schräg rechts oben
				}
				if (j - width + 1 >= 0 && (j - width + 1) % width != 0 && posBombs[j - width + 1] != null) {
					counter++;
				} // schräg links unten
				if (j + width - 1 < posBombs.length && (j + width) % width != 0 && posBombs[j + width - 1] != null) {
					counter++;
					// schräg rechts unten
				}
				if (j + width + 1 < posBombs.length && (j + width + 1) % width != 0
						&& posBombs[j + width + 1] != null) {
					counter++;
				}
				pf.getField()[j].setValueButton("" + counter);
			}

		}

	}

	/**
	 * Methode, die regelt, was passiert, wenn ein Button gedrückt wird
	 * 
	 * @param bp
	 */
	public void pressingButton(IButtonPlayingfield bp) {
		if (!bp.isFlag()) {
			bp.setBackground(0,255,0);

			// wenn eine Mine getroffen wird
			if (bp.getValueButton().equals("x")) {
				// bp.setImage(Imagetype.BOMB, 50, 50);
				mbox.showMessage("Leider verloren!", "Du hast eine Mine getroffen.", this);
				turnedFields=0;
				return;
			} else {
				// Wert des Buttons wird angezeigt
				bp.setText(bp.getValueButton());
				if (!bp.isPressed()) {
					turnedFields++;
					bp.setPressed(true);
				}
				System.out.println(turnedFields);
				if (turnedFields == (pf.getField().length - dg.getNumberBombs())) {
					mbox.showMessage("Glückwunsch! Gewonnen!", "Du hast alle freien Felder aufgedeckt!", this);
					turnedFields = 0;
					return;
				}
			}

			// umliegende Felder werden aufgedeckt, wenn 0 Minen außenherum liegen; rekursiv
			if (bp.getValueButton().equals("0")) {

				System.out.println(bp.getButtonId());
				// decke das rechte Feld auf (so lange wir uns auf dem Spielfeld befinden)
				if ((bp.getButtonId() + 1) < pf.getField().length && (bp.getButtonId() + 1) % width != 0
						&& !pf.getField()[bp.getButtonId() + 1].isPressed()) { // da oben
					// posBombs.length-1
					// ist hier nur
					// < notwendig,
					// nicht <=
					bp.setPressed(true);
					pressingButton(pf.getField()[bp.getButtonId() + 1]);

				}
				// links
				if ((bp.getButtonId() - 1) >= 0 && (bp.getButtonId()) % width != 0
						&& !pf.getField()[bp.getButtonId() - 1].isPressed()) {
					bp.setPressed(true);
					pressingButton(pf.getField()[bp.getButtonId() - 1]);
				}
				// direkt darunter
				if (bp.getButtonId() + width < pf.getField().length
						&& !pf.getField()[bp.getButtonId() + width].isPressed()) {
					bp.setPressed(true);
					pressingButton(pf.getField()[bp.getButtonId() + width]);
					// direkt darüber
				}
				if (bp.getButtonId() - width >= 0 && !pf.getField()[bp.getButtonId() - width].isPressed()) {
					bp.setPressed(true);
					pressingButton(pf.getField()[bp.getButtonId() - width]);
				} // schräg links oben
				if ((bp.getButtonId() - width - 1) >= 0 && (bp.getButtonId() - width) % width != 0
						&& !pf.getField()[bp.getButtonId() - width - 1].isPressed()) {
					bp.setPressed(true);
					pressingButton(pf.getField()[bp.getButtonId() - width - 1]);
					// schräg rechts oben
				}
				if ((bp.getButtonId() - width + 1 >= 0) && (bp.getButtonId() - width + 1) % width != 0
						&& !pf.getField()[bp.getButtonId() - width + 1].isPressed()) {
					bp.setPressed(true);
					pressingButton(pf.getField()[bp.getButtonId() - width + 1]);
				} // schräg links unten
				if (bp.getButtonId() + width - 1 < pf.getField().length && (bp.getButtonId() + width) % width != 0
						&& !pf.getField()[bp.getButtonId() + width - 1].isPressed()) {
					bp.setPressed(true);
					pressingButton(pf.getField()[bp.getButtonId() + width - 1]);
				}// schräg rechts unten
				if (bp.getButtonId() + width + 1 < pf.getField().length && (bp.getButtonId() + width+1) % width != 0
						&& !pf.getField()[bp.getButtonId() + width + 1].isPressed()) {
					bp.setPressed(true);
					pressingButton(pf.getField()[bp.getButtonId() + width + 1]);
				}

			}
		}
	}

	// setFlag
	public void setFlag(IButtonPlayingfield bp) {
		if (!bp.isPressed()) {
			if (bp.isFlag()) {
				bp.setFlag(false);
				// bp.setBackground(Color.blue);
				bp.setIconMS(null);
				if (bp.getValueButton().equals("x")) {
					bombsFlagged--;
				} else {
					bombsFlagged++;
				}
			} else {
				bp.setFlag(true);
				// bp.setBackground(Color.yellow);
				bp.setImage(Imagetype.FLAG, 50, 50);

				if (bp.getValueButton().equals("x")) {
					bombsFlagged++;
				} else {
					bombsFlagged--;
				}
			}
			if (bombsFlagged == dg.getNumberBombs()) {
				mbox.showMessage("Glückwunsch! Gewonnen!", "Du hast alle Bomben markiert!", this);
				turnedFields=0;
				return;
			}
		}
	}

	

	public void restart() {
		// Neustart des Spiels

		for (int i = 0; i < pf.getField().length; i++) {
			pf.getField()[i].setValueButton(null);
			pf.getField()[i].setPressed(false);
			pf.getField()[i].setText(null);
			pf.getField()[i].setBackground(0,0,255);
			pf.getField()[i].setIconMS(null);
			pf.getField()[i].setFlag(false);

		}

		bombsFlagged = 0;
		turnedFields = 0;
		dg.setPositionBombs(new String[width * height]);

		dg.setBombs(dg.getNumberBombs());
		this.showBombs();
		this.countBombsAround();

	}

	// alle Felder aufdecken
	public void turnAll() {
		for (int i = 0; i < pf.getField().length; i++) {
			// if (!pf.getField()[i].isPressed()) {

			pf.getField()[i].setPressed(true);
			if (pf.getField()[i].getValueButton().equals("x")) {
				pf.getField()[i].setBackground(255,0,0);
				pf.getField()[i].setImage(Imagetype.BOMB, 50, 50);
			} else {
				pf.getField()[i].setBackground(0,255,0);
				pf.getField()[i].setText(pf.getField()[i].getValueButton());
			}
			// }

		}
	}

}
