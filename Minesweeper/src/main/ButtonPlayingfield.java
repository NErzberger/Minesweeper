package main;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.SwingUtilities;

import controller.PlayingFieldController;


/**
 * 
 * @author Nico
 * @author Larissa
 *
 */
public class ButtonPlayingfield extends JButton {
	
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
		/**
		 * diese Methode implementiert einen Action Listener & ruft die Methode executeButtonInController auf,
		 * damit dieser regeln kann, was beim Drücken des Buttons passieren soll
		 */
//		addActionListener(new ActionListener() {
//			
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				
//			}
//		});
		
		addMouseListener(new MouseListener() {
			
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
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

	/**
	 * Diese Methode gibt den Wert der Variable valueButton zurück
	 * @return
	 */
	public String getValueButton() {
		return valueButton;
	}

	/**
	 * Diese Methode setzt die Variable valueButton
	 * @param valueButton
	 */
	public void setValueButton(String valueButton) {
		this.valueButton = valueButton;
	}

	public boolean isFlag() {
		return isFlag;
	}

	public void setFlag(boolean isFlag) {
		this.isFlag = isFlag;
	}
	

}
