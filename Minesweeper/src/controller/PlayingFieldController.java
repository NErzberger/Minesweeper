package controller;

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
	 *  Diese Klassenvariable dient zum Öffnen der MessageBox und ist vom Typ {@link MessageBox}.
	 */
	private IMessageBox mbox;
	
	/**
	 * Diese Klassenvariable dient als Container und ist vom Typ {@link DataGrid}.
	 */
	private DataGrid dg;
	

	/**
	 * Diese Klassenvariable vom Typ {@link Integer} beschreibt die Anzahl der Bomben, die bereits mit Flaggen markiert wurden.
	 */
	private int bombsFlagged;

	/**
	 * Diese Klassenvariable vom Typ {@link Integer} beschreibt die Anzahl der Felder, welche bereits umgedreht wurden.
	 */
	private int turnedFields;

	/**
	 * Ein eindimensionales Array mit Buttons nach dem Interface {@link IButtonPlayingfield}
	 * Darin wird das Spielfeld als Grid gespeichert.
	 */
	private IButtonPlayingfield[] field;
	
	
	/**
	 * Konstruktor der Klasse {@link PlayingFieldController}.
	 * @param pf
	 * @param mbox
	 */
	public PlayingFieldController(IPanelComponent pf, IMessageBox mbox) {
		dg = new DataGrid();
		this.pf = pf;
		this.mbox = mbox;
	}


	/**
	 * Diese Methode markiert Buttons, auf denen eine Bombe liegt, mit dem String "x".
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
	 * Diese Methode berechnet für jeden Button die Anzahl der Bomben in umliegenden Feldern und
	 */
	public void countBombsAround() {
		// hole die Positionen der Bomben und speichere diese in einem String Array
		String[] posBombs = dg.getPositionBombs();
		// iteriere durch diesen Array, sodass jede Stelle überprüft wird
		for (int j = 0; j < (posBombs.length); j++) {
			// setze den Zähler (wieder) auf null
			int counter = 0;
			// wenn auf dem aktuellen Feld keine Bombe liegt, berechne, wie viele Bomben sich in den direkt umliegenden Feldern befinden
			if (posBombs[j] == null) {
				// prüfe, ob rechts eine Bombe liegt (so lange wir uns auf dem Spielfeld befinden)
				if (j < posBombs.length && (j + 1) % dg.getWidth() != 0 && posBombs[j + 1] != null) { 
					counter++;
				} // links
				if (j - 1 >= 0 && j % dg.getWidth() != 0 && posBombs[j - 1] != null) {
					counter++;
				} // direkt darunter
				if (j + dg.getWidth() < posBombs.length && posBombs[j + dg.getWidth()] != null) {
					counter++;
				} // direkt darüber
				if (j - dg.getWidth() >= 0 && posBombs[j - dg.getWidth()] != null) {
					counter++;
				} // schräg links oben
				if (j - dg.getWidth() - 1 >= 0 && (j - dg.getWidth()) % dg.getWidth() != 0 && posBombs[j - dg.getWidth() - 1] != null) {
					counter++;
				} // schräg rechts oben
				if (j - dg.getWidth() + 1 >= 0 && (j - dg.getWidth() + 1) % dg.getWidth() != 0 && posBombs[j - dg.getWidth() + 1] != null) {
					counter++;
				} // schräg links unten
				if (j + dg.getWidth() - 1 < posBombs.length && (j + dg.getWidth()) % dg.getWidth() != 0 && posBombs[j + dg.getWidth() - 1] != null) {
					counter++;
				} // schräg rechts unten
				if (j + dg.getWidth() + 1 < posBombs.length && (j + dg.getWidth() + 1) % dg.getWidth() != 0
						&& posBombs[j + dg.getWidth() + 1] != null) {
					counter++;
				}
				// speichere die Anzahl der umliegenden Bomben dieses Buttons in der Variable valueButton
				field[j].setValueButton("" + counter);
			}

		}

	}

	/**
	 * Die Methode pressingButton übernimmt die Bearbeitung der Aktion eines Linksklicks auf einen Button, welcher das 
	 * Interface IButtonPlayingfield implementiert. 
	 * Zunächst wird geprüft, ob eine Flagge auf den Button gesetzt wurde. Wenn dem nicht so ist, wird geprüft, ob auf dem Button eine Mine liegt.
	 * Wenn dem so ist, so hat der User das Spiel verloren, eine MessageBox nach dem Interface {@link IMessageBox} wird aufgerufen und die Methode beendet.
	 * Wenn auf dem Button keine Mine liegt, wird die Hintergrundfarbe des Buttons auf Grün gesetzt und sein Wert (die Anzahl der umliegenden Bomben
	 * angezeigt. Daraufhin wird geprüft, ob der Button bereits gedrückt wurde. Wenn nicht, so wird der Zähler der gedrückten 
	 * Buttons um eins erhöht und dem Button mitgeteilt, dass er nun bereits gedrückt wurde. Daraufhin wird geprüft, ob alle Felder ohne Bomben
	 * bzw. Buttons gedrückt wurden. Ist dem so, so wird dem User mitgeteilt, dass er gewonnen hat und danach der Zähler der gedrückten Buttons
	 * auf 0 gesetzt, worauf der weitere Fortgang der Methode abgebrochen wird (Spielende). 
	 * Zum Schluss wird kontrolliert, ob das Feld den Wert 0 hat, also keine Bomben im direkten Umfeld hat. Ist dem so, so werden rekursiv alle 8
	 * umliegenden Felder aufgedeckt. Befindet sich eine Flagge auf dem Feld, wird beim Linksklick auf dieses Feld keine Aktion ausgeführt. Auch das Aufdecken 
	 * umliegender Felder lässt mit Flaggen markierte Felder aus.
	 * @param bp
	 */
	public void pressingButton(IButtonPlayingfield bp) {
		if (!bp.isFlag()) {
			// wenn eine Mine getroffen wird
			if (bp.getValueButton().equals("x")) {
				setMessage("Leider verloren!", "Du hast eine Mine getroffen.");
				turnedFields=0;
				return;
			} else {
				// Hintergrundfarbe auf grün gesetzt
				bp.setBackground(0,255,0);
				// Wert des Buttons wird angezeigt
				bp.setTextMS(bp.getValueButton());
				// wenn Button das erste Mal gedrückt wird
				if (!bp.isPressed()) {
					turnedFields++;
					bp.setPressed(true);
				}
				// Spielgewinn, wenn alle freien Felder aufgedeckt wurden
				if (turnedFields == (field.length - dg.getNumberBombs())) {
					setMessage("Glückwunsch! Gewonnen!", "Du hast alle freien Felder aufgedeckt!");
					turnedFields = 0;
					return;
				}
			}

			// umliegende Felder werden aufgedeckt, wenn 0 Minen außenherum liegen; rekursiv
			if (bp.getValueButton().equals("0")) {
				// decke das rechte Feld auf (so lange wir uns auf dem Spielfeld befinden)
				if ((bp.getButtonId() + 1) < field.length && (bp.getButtonId() + 1) % dg.getWidth() != 0
						&& !field[bp.getButtonId() + 1].isPressed()) {
					// markiere das Feld als gedrückt
					bp.setPressed(true);
					// Rekursion, rufe die Methode auf für den neuen Button
					pressingButton(field[bp.getButtonId() + 1]);
				} // links
				if ((bp.getButtonId() - 1) >= 0 && (bp.getButtonId()) % dg.getWidth() != 0
						&& !field[bp.getButtonId() - 1].isPressed()) {
					bp.setPressed(true);
					pressingButton(field[bp.getButtonId() - 1]);
				} // direkt darunter
				if (bp.getButtonId() + dg.getWidth() < field.length
						&& !field[bp.getButtonId() + dg.getWidth()].isPressed()) {
					bp.setPressed(true);
					pressingButton(field[bp.getButtonId() + dg.getWidth()]);
				} // direkt darüber
				if (bp.getButtonId() - dg.getWidth() >= 0 && !field[bp.getButtonId() - dg.getWidth()].isPressed()) {
					bp.setPressed(true);
					pressingButton(field[bp.getButtonId() - dg.getWidth()]);
				} // schräg links oben
				if ((bp.getButtonId() - dg.getWidth() - 1) >= 0 && (bp.getButtonId() - dg.getWidth()) % dg.getWidth() != 0
						&& !field[bp.getButtonId() - dg.getWidth() - 1].isPressed()) {
					bp.setPressed(true);
					pressingButton(field[bp.getButtonId() - dg.getWidth() - 1]);
				} // schräg rechts oben
				if ((bp.getButtonId() - dg.getWidth() + 1 >= 0) && (bp.getButtonId() - dg.getWidth() + 1) % dg.getWidth() != 0
						&& !field[bp.getButtonId() - dg.getWidth() + 1].isPressed()) {
					bp.setPressed(true);
					pressingButton(field[bp.getButtonId() - dg.getWidth() + 1]);
				} // schräg links unten
				if (bp.getButtonId() + dg.getWidth() - 1 < field.length && (bp.getButtonId() + dg.getWidth()) % dg.getWidth() != 0
						&& !field[bp.getButtonId() + dg.getWidth() - 1].isPressed()) {
					bp.setPressed(true);
					pressingButton(field[bp.getButtonId() + dg.getWidth() - 1]);
				}// schräg rechts unten
				if (bp.getButtonId() + dg.getWidth() + 1 < field.length && (bp.getButtonId() + dg.getWidth()+1) % dg.getWidth() != 0
						&& !field[bp.getButtonId() + dg.getWidth() + 1].isPressed()) {
					bp.setPressed(true);
					pressingButton(field[bp.getButtonId() + dg.getWidth() + 1]);
				}
			}
		}
	}

	
	/**
	 * Die Methode setFlag soll Flaggen auf die Felder bzw. Buttons setzen. Hierzu wird als erstes 
	 * geprüft, ob der Button bereits gedrückt wurde. Wenn nicht, so wird kontrolliert ob der Button
	 * bereits eine Flagge hat. Wenn ja, so wird die Flagge entfernt (die Variable isFlag auf false gesetzt), 
	 * das Image der Flagge entfernt und die Anzahl der markierten Bomben korrigiert. Wenn der Button noch nicht markiert wurde, so 
	 * wird die Flagge in den Button gesetzt (Variable auf true) und das Image der Flagge wird angezeigt. Daraufhin wird
	 * die Anzahl der markierten Bomben korrigiert.
	 * Zum Schluss wird kontrolliert, ob alle Bomben markiert wurden. Wenn dem so ist, so hat der User gewonnen. 
	 * @param bp
	 */
	public void setFlag(IButtonPlayingfield bp) {
		// wenn Button noch nicht gedrückt wurde
		if (!bp.isPressed()) {
			// wenn Button bereits eine Flagge hat
			if (bp.isFlag()) {
				// Flagge wird entfernt
				bp.setFlag(false);
				bp.setImage(Imagetype.NONE, 0, 0);
				// Anzahl Flaggen wird korrigiert
				if (bp.getValueButton().equals("x")) {
					bombsFlagged--;
				} else {
					bombsFlagged++;
				}
			// wenn Button noch keine Flagge hat
			} else {
				// Flagge wird hinzugefügt
				bp.setFlag(true);
				bp.setImage(Imagetype.FLAG, 50, 50);
				// Anzahl an Flaggen wird korrigiert
				if (bp.getValueButton().equals("x")) {
					// wenn eine Bombe markiert wird, wird die Anzahl erhöht
					bombsFlagged++;
				} else {
					// wenn ein Feld fehlerhaft markiert wird, wird die Anzahl erniedrigt
					bombsFlagged--;
				}
			}
			// wenn alle Bomben markiert wurde, ist das Spiel gewonnen
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
		// für jeden Button werden alle Werte auf den Anfangszustand zurückgesetzt
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
		dg.setPositionBombs(new String[dg.getWidth() * dg.getHeight()]);
		
		// die Bomben werden neu gesetzt und alle anderen Felder erhalten die Zahl der umliegenden Bomben
		dg.setBombs(dg.getNumberBombs());
		this.showBombs();
		this.countBombsAround();

	}


	/**
	 * In der Methode turnAll werden alle Felder bzw. Buttons im Spielfeld umgedreht, so dass das gesamte Spielfeld aufgedeckt ist.
	 */
	public void turnAll() {
		for (int i = 0; i < field.length; i++) {
			field[i].setPressed(true);
			// Felder mit Bomben (Hintergrund rot; Bild)
			if (field[i].getValueButton().equals("x")) {
				field[i].setBackground(255,0,0);
				field[i].setImage(Imagetype.BOMB, 50, 50);
			} 
			// Felder ohne Bomben (Hintergrund grün; Anzahl umliegender Bomben wird angezeigt)
			else {
				field[i].setBackground(0,255,0);
				field[i].setTextMS(field[i].getValueButton());
			}
		}
	}

	
	/**
	 * Mit dieser Methode wird die MessageBox aufgerufen. Diese zeigt das jeweilige Spielergebnis an. Der User kann nun
	 * zwischen einem Neustart des Spiels, wobei die Methode restart aufgerufen wird, oder dem Beenden des Spiels wählen.
	 * @param title
	 * @param message
	 */
	public void setMessage(String title, String message) {
		// bei Spielende werden alle Felder aufgedeckt
		turnAll();
		// der User hat zwei Optionen: Neustart oder Schließen
		String[] options = new String[2];
		options[0] = new String("Neustart");
		options[1] = new String("Schließen");
		int returnValue = mbox.showMessage(title, message, options, pf);
		// Neustart des Spiels
		if (returnValue == 0) {
			restart();
		}
		// Beenden des Spiels / Schließen
		if (returnValue == 1) {
			System.exit(0);
		}
	}
	
	/**
	 * Die Methode getField gibt das Spielfeld zurück.
	 * @return field
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
	
	/**
	 * Diese Methode gibt das DataGrid zurück
	 * @return dg
	 */
	public DataGrid getDg() {
		return dg;
	}

	/**
	 * Mit dieser Methode kann ein DataGrid neu gesetzt werden.
	 * @param dg
	 */
	public void setDg(DataGrid dg) {
		this.dg = dg;
	}
	
	
}
