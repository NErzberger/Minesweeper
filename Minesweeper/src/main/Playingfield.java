package main;

import javax.swing.JButton;
import javax.swing.JPanel;

import controller.PlayingFieldController;
import model.DataGrid;

import java.awt.GridLayout;

public class Playingfield extends JPanel{

	private JButton[] field;
	
	public Playingfield(int width, int height) {
		//rufe Controller auf
		PlayingFieldController pfController = new PlayingFieldController(width, height,this);
		
		field = new JButton[width*height];
		setLayout(new GridLayout(width, height));
		
		for (int i = 0; i < field.length; i++) {
			field[i] = new ButtonPlayingfield("this is button "+ i);
			this.add(field[i]);
		}
		
		//rufe Methode showBombs auf
		pfController.showBombs();
	}

	public JButton[] getField() {
		return field;
	}

	public void setField(JButton[] field) {
		this.field = field;
	}
}
