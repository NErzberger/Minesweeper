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
 * Im Button ButtonPlayingfield wird das Interface {@link IButtonPlayingfield} implementiert.
 * Dabei wird die Swing Bibliothek genutzt und es wird von der Klasse {@link JButton} geerbt. 
 * 
 * @author Nico
 * @author Larissa
 *
 */
public class ButtonPlayingfield extends JButton implements IButtonPlayingfield{
	
	/**
	 * Variable des Typs {@link Boolean}, die speichert, ob der Button gedrückt wurde
	 */
	private boolean pressed = false;
	/**
	 * Variable des Typs {@link String}, der den Wert (Bombe / Zahl der Bomben außenherum) speichert
	 */
	private String valueButton;
	
	/**
	 * Variable des Typs {@link Boolean}, die speichert, ob eine Flagge gesetzt wurde
	 */
	private boolean isFlag = false;
	private int buttonId;
	
	
	public int getButtonId() {
		return buttonId;
	}

	public void setButtonId(int buttonId) {
		this.buttonId = buttonId;
	}

	/**
	 *Konstruktor der Klasse {@link ButtonPlayingfield}. 
	 * @param text
	 */
	public ButtonPlayingfield(String text, PlayingFieldController pf, int buttonId) {
		super(text);
		this.buttonId = buttonId;
		setBackground(Color.blue);
				
		addMouseListener(new MouseListener() {
			//Methoden werden nicht benötigt			
			@Override
			public void mouseReleased(MouseEvent e) {}
			@Override
			public void mousePressed(MouseEvent e) {}
			@Override
			public void mouseExited(MouseEvent e) {}
			@Override
			public void mouseEntered(MouseEvent e) {}
			
			/**
			 * Es wird geprüft, ob ein Rechtsklick oder ein Linksklick getätigt wurde. Bei einem
			 * <ol>
			 * <li>Rechtsklick wird die Methode executeRightClick() ausgeführt, welche die weitere Bearbeitung an den Contorller leitet</li>
			 * <li>Linksklick wird die Mehtode executeButtonInController ausgefürht, welche ebenfalls die Bearbeitung in den Controller weiterleitet.</li>
			 * </ol>
			 */
			@Override
			public void mouseClicked(MouseEvent e) {
				if(SwingUtilities.isRightMouseButton(e)) {
					executeRightClick(pf);
				} else {
					executeButtonInController(pf);
				}
				
			}
		});
		
		
	}
	
	/**
	 * diese Methode übergibt den Verweis auf den gedrückten Button an PlayingFieldController
	 * @param pf
	 */
	public void executeButtonInController(PlayingFieldController pf) {
		pf.pressingButton(this);
	}
	public void executeRightClick(PlayingFieldController pf) {
		pf.setFlag(this);
	}
	
	
	/**
	 * diese Methode gibt den Wert der Variable pressed zurück
	 * @return
	 */
	public boolean isPressed() {
		return pressed;
	}
	/**
	 * Diese Methode setzt die Variable visible
	 * @param pressed
	 */
	public void setPressed(boolean pressed) {
		this.pressed = pressed;
	}
	
	public void setImage(Imagetype type, int width, int height) {
		if(type != Imagetype.NONE) {
		ImageIcon icon = null;
		if(type == Imagetype.BOMB) {
			icon = new ImageIcon(Main.class.getResource("/view/bomb.png"));
		} else if(type == Imagetype.FLAG){
			icon = new ImageIcon(Main.class.getResource("/view/flag.png"));
		} 
		Image image = icon.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
		this.setIcon(new ImageIcon(image));
		
		// Für den Fall, dass das Iamge aufgehoben / gelöscht werden soll
		}else if(type == Imagetype.NONE) {
			this.setIcon(null);
		}
	}

	/**
	 * Diese Methode gibt den Wert der Variable valueButton zurück
	 * @return
	 */
	public String getValueButton() {
		return valueButton;
	}

	
	public void setValueButton(String valueButton) {
		this.valueButton = valueButton;
	}

	public boolean isFlag() {
		return isFlag;
	}

	public void setFlag(boolean isFlag) {
		this.isFlag = isFlag;
	}

	
	@Override
	public void setBackground(int r, int g, int b) {
		// TODO Auto-generated method stub
		setBackground(new Color (r,g,b));
	}

	@Override
	public void setTextMS(String text) {
		setText(text);
		
	}
}
