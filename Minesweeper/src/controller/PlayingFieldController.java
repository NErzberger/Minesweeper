package controller;

import javax.swing.JOptionPane;

import main.Imagetype;
import model.DataGrid;
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
	
	/**
	 * 
	 */
	private IMessageBox mbox;
	
	/**
	 * Diese Klassenvariable dient als Container und ist vom Typ {@link DataGrid}.
	 */
	private DataGrid dg;
	
	/**
	 * In der Klassenvariable width wird die Breite & Höhe des Spielfeldes
	 * festgehalten.
	 */
	private int width;
	
	/**
	 * 
	 */
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
	 * Ein eindimensionales Array der Buttons nach dem Interface {@link IButtonPlayingfield}
	 * Darin wird das Spielfeld als Grid gespeichert
	 */
	private IButtonPlayingfield[] field;
	
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
				field[i].setValueButton("x");

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
				if (j < posBombs.length && (j + 1) % width != 0 && posBombs[j + 1] != null) { 
					counter++;
				} // links
				if (j - 1 >= 0 && j % width != 0 && posBombs[j - 1] != null) {
					counter++;
				} // direkt darunter
				if (j + width < posBombs.length && posBombs[j + width] != null) {
					counter++;
				} // direkt darüber
				if (j - width >= 0 && posBombs[j - width] != null) {
					counter++;
				} // schräg links oben
				if (j - width - 1 >= 0 && (j - width) % width != 0 && posBombs[j - width - 1] != null) {
					counter++;
				} // schräg rechts oben
				if (j - width + 1 >= 0 && (j - width + 1) % width != 0 && posBombs[j - width + 1] != null) {
					counter++;
				} // schräg links unten
				if (j + width - 1 < posBombs.length && (j + width) % width != 0 && posBombs[j + width - 1] != null) {
					counter++;
				} // schräg rechts unten
				if (j + width + 1 < posBombs.length && (j + width + 1) % width != 0
						&& posBombs[j + width + 1] != null) {
					counter++;
				}
				field[j].setValueButton("" + counter);
			}

		}

	}

	/**
	 * Die Methode pressingButton übernimmt die Bearbeitung der Aktion eines Linksklicks auf die Buttons, welche das 
	 * Interface IButtonPlayingfield implementieren. 
	 * Zunächst wird geprüft, ob eine Flagge auf den Button gesetzt wurde. Wenn dem nicht so ist, so wird die 
	 * Hintergrundfarbe des Buttons auf Grün gesetzt. Daraufhin wird geprüft, ob es sich bei dem Button um eine Mine handelt.
	 * Wenn dem so ist, so hat der User das Spiel verloren und eine MessageBox nach dem Interface {@link IMessageBox} aufgerufen.
	 * Wenn dem nicht so ist, wird geprüft ob der Button bereits gedrückt wurde. Wenn nicht, so wird der Zähler der gedrückten 
	 * Buttons um eins erhöht und dem Button mitgeteilt, dass er bereits gedrückt wurde. Daraufhin wird geprüft, ob alle Felder 
	 * bzw. Buttons gedrückt wurden. Ist dem so, so wird dem User mitgeteilt, dass er gewonnen hat und der Zähler der gedrückten Buttons
	 * auf 0 gesetzt, worauf der weitere Fortgang der Methode abgebrochen wird. 
	 * Zum Schluss wird kontrolliert, ob das Feld den Wert 0 hat, also keine Bomben im direkten Umfeld hat. Ist dem so, so werden rekursiv alle 8
	 * umliegende Felder aufgedeckt. 
	 * @param bp
	 */
	public void pressingButton(IButtonPlayingfield bp) {
		if (!bp.isFlag()) {
			bp.setBackground(0,255,0);

			// wenn eine Mine getroffen wird
			if (bp.getValueButton().equals("x")) {
				// bp.setImage(Imagetype.BOMB, 50, 50);
				setMessage("Leider verloren!", "Du hast eine Mine getroffen.");
				turnedFields=0;
				return;
			} else {
				// Wert des Buttons wird angezeigt
				bp.setTextMS(bp.getValueButton());
				if (!bp.isPressed()) {
					turnedFields++;
					bp.setPressed(true);
				}
				if (turnedFields == (field.length - dg.getNumberBombs())) {
					setMessage("Glückwunsch! Gewonnen!", "Du hast alle freien Felder aufgedeckt!");
					turnedFields = 0;
					return;
				}
			}

			// umliegende Felder werden aufgedeckt, wenn 0 Minen außenherum liegen; rekursiv
			if (bp.getValueButton().equals("0")) {
				// decke das rechte Feld auf (so lange wir uns auf dem Spielfeld befinden)
				if ((bp.getButtonId() + 1) < field.length && (bp.getButtonId() + 1) % width != 0
						&& !field[bp.getButtonId() + 1].isPressed()) {
					bp.setPressed(true);
					pressingButton(field[bp.getButtonId() + 1]);
				} // links
				if ((bp.getButtonId() - 1) >= 0 && (bp.getButtonId()) % width != 0
						&& !field[bp.getButtonId() - 1].isPressed()) {
					bp.setPressed(true);
					pressingButton(field[bp.getButtonId() - 1]);
				} // direkt darunter
				if (bp.getButtonId() + width < field.length
						&& !field[bp.getButtonId() + width].isPressed()) {
					bp.setPressed(true);
					pressingButton(field[bp.getButtonId() + width]);
				} // direkt darüber
				if (bp.getButtonId() - width >= 0 && !field[bp.getButtonId() - width].isPressed()) {
					bp.setPressed(true);
					pressingButton(field[bp.getButtonId() - width]);
				} // schräg links oben
				if ((bp.getButtonId() - width - 1) >= 0 && (bp.getButtonId() - width) % width != 0
						&& !field[bp.getButtonId() - width - 1].isPressed()) {
					bp.setPressed(true);
					pressingButton(field[bp.getButtonId() - width - 1]);
				} // schräg rechts oben
				if ((bp.getButtonId() - width + 1 >= 0) && (bp.getButtonId() - width + 1) % width != 0
						&& !field[bp.getButtonId() - width + 1].isPressed()) {
					bp.setPressed(true);
					pressingButton(field[bp.getButtonId() - width + 1]);
				} // schräg links unten
				if (bp.getButtonId() + width - 1 < field.length && (bp.getButtonId() + width) % width != 0
						&& !field[bp.getButtonId() + width - 1].isPressed()) {
					bp.setPressed(true);
					pressingButton(field[bp.getButtonId() + width - 1]);
				}// schräg rechts unten
				if (bp.getButtonId() + width + 1 < field.length && (bp.getButtonId() + width+1) % width != 0
						&& !field[bp.getButtonId() + width + 1].isPressed()) {
					bp.setPressed(true);
					pressingButton(field[bp.getButtonId() + width + 1]);
				}

			}
		}
	}

	// setFlag
	/**
	 * Die Methode setFalg soll Falggen auf die Felder bzw. Buttons setzten. Hierzu wird als erstes 
	 * geprüft, ob der Button bereits gedrückt wurde. Wenn nicht, so wird kontrolliert ob der Button
	 * bereits eine Flagge hat. Wenn ja, so wird die Flagge entfernd und das Image der Flagge entfernd 
	 * und die Anzahl der markierten Bomben korrigiert. Wenn der Button noch nicht markiert wurde, so 
	 * wird die Flagge in den Button gesetzt und dem Button das Image der Falge gesetzt. Daraufhin wird
	 * die Anzahl der markierten Bomben korrigiert.
	 * Zum Schluss wird kontrolliert, ob alle Bomben markiert wurden. Wenn dem so ist, so hat der User gewonnen. 
	 * 
	 * @param bp
	 */
	public void setFlag(IButtonPlayingfield bp) {
		if (!bp.isPressed()) {
			if (bp.isFlag()) {
				bp.setFlag(false);
				// bp.setBackground(Color.blue);
				bp.setImage(Imagetype.NONE, 0, 0);
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
				setMessage("Glückwunsch! Gewonnen!", "Du hast alle Bomben markiert!");
				turnedFields=0;
				return;
			}
		}
	}

	

	/**
	 * Die Methode restart setzt alle Werte im Spielfeld auf null bzw. auf false zurück. Das Resultat ist ein defacto Spielneustart.
	 */
	public void restart() {
		// Neustart des Spiels
		for (int i = 0; i < field.length; i++) {
			field[i].setValueButton(null);
			field[i].setPressed(false);
			field[i].setTextMS(null);
			field[i].setBackground(0,0,255);
			field[i].setImage(Imagetype.NONE, 0, 0);
			field[i].setFlag(false);
		}

		bombsFlagged = 0;
		turnedFields = 0;
		dg.setPositionBombs(new String[width * height]);

		dg.setBombs(dg.getNumberBombs());
		this.showBombs();
		this.countBombsAround();

	}

	// alle Felder aufdecken
	/**
	 * In der Methode turnAll werden alle Felder bzw. Buttons im Spielfeld umgedreht, so dass das gesamte Spielfeld aufgedeckt ist.
	 */
	public void turnAll() {
		for (int i = 0; i < field.length; i++) {
			field[i].setPressed(true);
			if (field[i].getValueButton().equals("x")) {
				field[i].setBackground(255,0,0);
				field[i].setImage(Imagetype.BOMB, 50, 50);
			} else {
				field[i].setBackground(0,255,0);
				field[i].setTextMS(field[i].getValueButton());
			}
		}
	}


	/**
	 * Die Methode getField gibt das Spielfeld zurück.
	 * @return
	 */
	public IButtonPlayingfield[] getField() {
		return field;
	}


	/**
	 * Mittels der Methode setField kann ein Spielfeld neu gesetzt werden.
	 * @param field
	 */
	public void setField(IButtonPlayingfield[] field) {
		this.field = field;
	}
	
	
	public void setMessage(String title, String message) {
		turnAll();
		String[] options = new String[2];
		options[0] = new String("Neustart");
		options[1] = new String("Schließen");
		int returnValue = mbox.showMessage(title, message, options, pf);
		if (returnValue == 0) {
			restart();
		}
		// Beenden des Spiels / Schließen
		if (returnValue == 1) {
			System.exit(0);
		}
	}
	
	
}
