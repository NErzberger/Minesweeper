package main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import controller.PlayingFieldController;


/**
 * 
 * @author Nico
 * @author Larissa
 *
 */
public class ButtonPlayingfield extends JButton {
	/**
	 * Variable des Typs {@link Boolean}, die speichert, ob der Button gedr�ckt wurde
	 */
	private boolean pressed = false;
	/**
	 * Variable des Typs {@link String}, der den Wert (Bombe / Zahl der Bomben au�enherum) speichert
	 */
	private String valueButton;
	
	/**
	 *Konstruktor der Klasse {@link ButtonPlayingfield}. 
	 * @param text
	 */
	public ButtonPlayingfield(String text, PlayingFieldController pf) {
		super(text);
		/**
		 * diese Methode implementiert einen Action Listener & ruft die Methode executeButtonInController auf,
		 * damit dieser regeln kann, was beim Dr�cken des Buttons passieren soll
		 */
		addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				executeButtonInController(pf);
			}
		});
	}
	
	/**
	 * diese Methode �bergibt den Verweis auf den gedr�ckten Button an PlayingFieldController
	 * @param pf
	 */
	public void executeButtonInController(PlayingFieldController pf) {
		pf.pressingButton(this);
	}
	
	
	/**
	 * diese Methode gibt den Wert der Variable pressed zur�ck
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
	 * Diese Methode gibt den Wert der Variable valueButton zur�ck
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
	

}
