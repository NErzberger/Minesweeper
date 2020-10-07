package view;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.SwingUtilities;

import controller.IButtonPlayingfield;
import controller.PlayingFieldController;
import main.Imagetype;
import main.Main;

/**
 * Im Button ButtonPlayingfield wird das Interface {@link IButtonPlayingfield}
 * implementiert. Dabei wird die Swing Bibliothek genutzt und es wird von der
 * Klasse {@link JButton} geerbt.
 * 
 * @author Nico
 * @author Larissa
 *
 */
public class ButtonPlayingfield extends JButton implements IButtonPlayingfield {

	/**
	 * Klassenvariable des Typs {@link Boolean}, die speichert, ob der Button gedr�ckt
	 * wurde
	 */
	private boolean pressed = false;

	/**
	 * Klassenvariable der Klases {@link String}, der den Wert des Buttons (Bombe / Zahl
	 * der umliegenden Bomben) speichert
	 */
	private String valueButton;

	/**
	 * Klassenvariable des Typs {@link Boolean}, die speichert, ob eine Flagge gesetzt
	 * wurde
	 */
	private boolean isFlag = false;

	/**
	 * Klassenvariable des Typs {@link Integer}, die die ID des Buttons speichert
	 */
	private int buttonId;

	/**
	 * Konstruktor der Klasse {@link ButtonPlayingfield}.
	 * 
	 * @param text
	 */
	public ButtonPlayingfield(String text, PlayingFieldController pf, int buttonId) {
		super(text);
		this.buttonId = buttonId;
		// alle Buttons haben zu Beginn die Hintergrundfarbe blau
		setBackground(Color.blue);

		// MouseListener l�st eine Aktion beim Klick auf einen Button aus
		addMouseListener(new MouseListener() {
			// Methoden werden nicht ben�tigt, m�ssen aber trotzdem implementiert werden
			@Override
			public void mouseReleased(MouseEvent e) {
			}

			@Override
			public void mousePressed(MouseEvent e) {
			}

			@Override
			public void mouseExited(MouseEvent e) {
			}

			@Override
			public void mouseEntered(MouseEvent e) {
			}

			/**
			 * Es wird gepr�ft, ob ein Rechtsklick oder ein Linksklick get�tigt wurde. Bei
			 * einem
			 * <ol>
			 * <li>Rechtsklick wird die Methode executeRightClick() ausgef�hrt, welche die
			 * weitere Bearbeitung an den Contorller leitet</li>
			 * <li>Linksklick wird die Mehtode executeButtonInController ausgef�hrt, welche
			 * ebenfalls die Bearbeitung in den Controller weiterleitet.</li>
			 * </ol>
			 */
			@Override
			public void mouseClicked(MouseEvent e) {
				if (SwingUtilities.isRightMouseButton(e)) {
					executeRightClick(pf);
				} else {
					executeButtonInController(pf);
				}
			}
		});
	}

	/**
	 * Diese Methode �bergibt bei Linksklick den Verweis auf den gedr�ckten Button
	 * an PlayingFieldController.
	 * 
	 * @param pf
	 */
	public void executeButtonInController(PlayingFieldController pf) {
		pf.pressingButton(this);
	}

	/**
	 * Diese Methode �bergibt bei Rechtsklick den Verweis auf den gedr�ckten Button
	 * an PlayingFieldController.
	 * 
	 * @param pf
	 */
	public void executeRightClick(PlayingFieldController pf) {
		pf.setFlag(this);
	}

	/**
	 * Diese Methode gibt den Wert der Variable pressed zur�ck, also ob der Button
	 * gedr�ckt bereits gedr�ckt wurde.
	 * 
	 * @return pressed
	 */
	public boolean isPressed() {
		return pressed;
	}

	/**
	 * Diese Methode setzt den Wert der Variablen pressed
	 * 
	 * @param pressed
	 */
	public void setPressed(boolean pressed) {
		this.pressed = pressed;
	}

	/**
	 * Diese Methode setzt ein Image in den Button. Dieses kann entweder eine Bombe,
	 * eine Flagge oder kein Image (L�schen) sein.
	 * 
	 * @param tpye
	 * @param width
	 * @param height
	 */
	public void setImage(Imagetype type, int width, int height) {
		// wenn ein Bild gesetzt werden soll
		if (type != Imagetype.NONE) {
			// die Variable icon wird zuerst auf null zur�ckgesetzt
			ImageIcon icon = null;
			// Einf�gen einer Bombe
			if (type == Imagetype.BOMB) {
				icon = new ImageIcon(Main.class.getResource("/view/bomb.png"));
			} 
			// Einf�gen einer Flagge
			else if (type == Imagetype.FLAG) {
				icon = new ImageIcon(Main.class.getResource("/view/flag.png"));
			}
			Image image = icon.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
			this.setIcon(new ImageIcon(image));

			// f�r den Fall, dass das Image aufgehoben / gel�scht werden soll
		} else if (type == Imagetype.NONE) {
			this.setIcon(null);
		}
	}
	
	/**
	 * Diese Methode �berschreibt die gleichnamige Methode des Interfaces. Sie ver�ndert die Hintergrundfarbe.
	 * @param r
	 * @param g
	 * @param b 
	 */
	@Override
	public void setBackground(int r, int g, int b) {
		// TODO Auto-generated method stub
		setBackground(new Color(r, g, b));
	}

	/**
	 * Diese Methode �berschreibt die gleichnamige Methode des Interfaces. Sie setzt einen Text.
	 * @param text
	 */
	@Override
	public void setTextMS(String text) {
		setText(text);

	}

	/**
	 * Diese Methode gibt den Wert der Variablen valueButton des Typs {@link String} zur�ck.
	 * @return valueButton
	 */
	public String getValueButton() {
		return valueButton;
	}

	/**
	 * Diese Methode setzt den Wert der Variablen valueButton des Typs {@link String}.
	 * @param valueButton
	 */
	public void setValueButton(String valueButton) {
		this.valueButton = valueButton;
	}

	/**
	 * Diese Methode gibt den Wert der Variablen isFlag des Typs {@link Boolean} zur�ck.
	 * @return isFlag
	 */
	public boolean isFlag() {
		return isFlag;
	}

	/**
	 * Diese Methode setzt den Wert der Variablen is Flag des Typs {@link Boolean}.
	 * @param isFlag
	 */
	public void setFlag(boolean isFlag) {
		this.isFlag = isFlag;
	}
	
	/**
	 * Diese Methode gibt den Wert der Variablen buttonId des Typs {@link Integer} zur�ck.
	 */
	public int getButtonId() {
		return buttonId;
	}

	/**
	 * Diese Methode setzt den Wert der Variablen buttonId des Typs {@link Integer}.
	 * @return buttonId
	 */
	public void setButtonId(int buttonId) {
		this.buttonId = buttonId;
	}
}
