package main;

import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

public class Playingfield extends JPanel{

	private JButton[] field;
	
	public Playingfield(int width, int height) {
		
		
		field = new JButton[width*height];
		setLayout(new GridLayout(width, height));
		
		for (int i = 0; i < field.length; i++) {
			field[i] = new JButton("this is button "+ i);
			this.add(field[i]);
		}
	}
}
