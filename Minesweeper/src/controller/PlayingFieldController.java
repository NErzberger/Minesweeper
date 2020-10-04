package controller;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import main.ButtonPlayingfield;
import main.Imagetype;
import main.Main;
import main.Playingfield;
import model.DataGrid;

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
	private Playingfield pf;
	/**
	 * Diese Klassenvariable dient als Container und ist vom Typ {@link DataGird}.
	 */
	private DataGrid dg;
	/**
	 * In der Klassenvariable width wird die Breite & H�he des Spielfeldes
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
	public PlayingFieldController(int width, int height, Playingfield pf) {
		dg = new DataGrid(width, height, 5);
		this.pf = pf;
		this.width = width;
		this.height = height;
	}

	// public PlayingFieldController() {}

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

				// pr�fe, ob rechts eine Bombe liegt (so lange wir uns auf dem Spielfeld
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
					// direkt dar�ber
				}
				if (j - width >= 0 && posBombs[j - width] != null) {
					counter++;
				} // schr�g links oben
				if (j - width - 1 >= 0 && (j - width) % width != 0 && posBombs[j - width - 1] != null) {
					counter++;
					// schr�g rechts oben
				}
				if (j - width + 1 >= 0 && (j - width + 1) % width != 0 && posBombs[j - width + 1] != null) {
					counter++;
				} // schr�g links unten
				if (j + width - 1 < posBombs.length && (j + width) % width != 0 && posBombs[j + width - 1] != null) {
					counter++;
					// schr�g rechts unten
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
	 * Methode, die regelt, was passiert, wenn ein Button gedr�ckt wird
	 * 
	 * @param bp
	 */
	public void pressingButton(ButtonPlayingfield bp) {
		if (!bp.isFlag()) {
			bp.setBackground(Color.green);

			// wenn eine Mine getroffen wird
			if (bp.getValueButton().equals("x")) {
				// bp.setImage(Imagetype.BOMB, 50, 50);
				showMessage("Leider verloren!", "Du hast eine Mine getroffen.");

			} else {
				// Wert des Buttons wird angezeigt
				bp.setText(bp.getValueButton());
				if (!bp.isPressed()) {
					turnedFields++;
					bp.setPressed(true);
				}
				System.out.println(turnedFields);
				if (turnedFields == (pf.getField().length - dg.getNumberBombs())) {
					showMessage("Gl�ckwunsch!", "Du hast alle freien Felder aufgedeckt!");
					turnedFields = 0;
					return;
				}
			}

			// umliegende Felder werden aufgedeckt, wenn 0 Minen au�enherum liegen; rekursiv
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
					// direkt dar�ber
				}
				if (bp.getButtonId() - width >= 0 && !pf.getField()[bp.getButtonId() - width].isPressed()) {
					bp.setPressed(true);
					pressingButton(pf.getField()[bp.getButtonId() - width]);
				} // schr�g links oben
				if ((bp.getButtonId() - width - 1) >= 0 && (bp.getButtonId() - width) % width != 0
						&& !pf.getField()[bp.getButtonId() - width - 1].isPressed()) {
					bp.setPressed(true);
					pressingButton(pf.getField()[bp.getButtonId() - width - 1]);
					// schr�g rechts oben
				}
				if ((bp.getButtonId() - width + 1 >= 0) && (bp.getButtonId() - width + 1) % width != 0
						&& !pf.getField()[bp.getButtonId() - width + 1].isPressed()) {
					bp.setPressed(true);
					pressingButton(pf.getField()[bp.getButtonId() - width + 1]);
				} // schr�g links unten
				if (bp.getButtonId() + width - 1 < pf.getField().length && (bp.getButtonId() + width) % width != 0
						&& !pf.getField()[bp.getButtonId() + width - 1].isPressed()) {
					bp.setPressed(true);
					pressingButton(pf.getField()[bp.getButtonId() + width - 1]);
					// schr�g rechts unten
				}
				if (bp.getButtonId() + width + 1 < pf.getField().length && (bp.getButtonId() + width + 1) % width != 0
						&& !pf.getField()[bp.getButtonId() + width + 1].isPressed()) {
					bp.setPressed(true);
					pressingButton(pf.getField()[bp.getButtonId() + width + 1]);
				}

			}
		}
	}

	// setFlag
	public void setFlag(ButtonPlayingfield bp) {
		if (!bp.isPressed()) {
			if (bp.isFlag()) {
				bp.setFlag(false);
				// bp.setBackground(Color.blue);
				bp.setIcon(null);
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
				showMessage("Gl�ckwunsch!", "Du hast alle Bomben markiert!");
			}
			// System.out.println(bombsFlagged);
		}
	}

	// Nachricht bei Sieg oder Niederlage
	public void showMessage(String title, String message) {
		turnAll();
		String[] options = new String[2];
		options[0] = new String("Neustart");
		options[1] = new String("Schlie�en");
		int returnValue = JOptionPane.showOptionDialog(pf, message, title, 0, JOptionPane.INFORMATION_MESSAGE, null,
				options, null);
		if (returnValue == 0) {
			restart();
		}
		// Beenden des Spiels / Schlie�en
		if (returnValue == 1) {
			System.exit(0);
		}
	}

	public void restart() {
		// Neustart des Spiels

		for (int i = 0; i < pf.getField().length; i++) {
			pf.getField()[i].setValueButton(null);
			pf.getField()[i].setPressed(false);
			pf.getField()[i].setText(null);
			pf.getField()[i].setBackground(Color.blue);
			pf.getField()[i].setIcon(null);

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
				pf.getField()[i].setBackground(Color.red);
				pf.getField()[i].setImage(Imagetype.BOMB, 50, 50);
			} else {
				pf.getField()[i].setBackground(Color.green);
				pf.getField()[i].setText(pf.getField()[i].getValueButton());
			}
			// }

		}
	}

}
