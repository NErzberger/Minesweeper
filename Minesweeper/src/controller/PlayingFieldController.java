package controller;

import main.Playingfield;
import model.DataGrid;

public class PlayingFieldController {
	private Playingfield pf;
	private DataGrid dg;
	
	public PlayingFieldController(int width, int height, Playingfield pf) {
		dg = new DataGrid(width,height,4);
		this.pf = pf;
		
	}
	
	
	// zeige Bomben im Playingfield an
	public void showBombs() {
		String[] posBombs = dg.getPositionBombs();
		
		for(int i=0; i<posBombs.length;i++) {
			if(posBombs[i] != null) {
				pf.getField()[i].setText("x"); 
			}
		}
		
	}
}
