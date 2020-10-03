package controller;

import main.Playingfield;
import model.DataGrid;

/**
 * Die Klasse PlayingFieldController verbindet die Klassen {@link Playingfield} und {@link DataGrid}. 
 * Ziel der Klasse ist es, das Spielfeld aufzubauen.
 * @author Nico
 * @author Larissa
 *
 */

public class PlayingFieldController {
	/**
	 * Diese Klassenvariable dient als Container und ist vom Typ {@link Playingfield}.
	 */
	private Playingfield pf;
	/**
	 * Diese Klassenvariable dient als Container und ist vom Typ {@link DataGird}.
	 */
	private DataGrid dg;
	/**
	 * In der Klassenvaiable width wird die Breite des Spielfeldes festgehalten.
	 */
	private int width;
	
	/**
	 * Konstruktor der Klasse {@link PlayingFieldController}.
	 * @param width
	 * @param height
	 * @param pf
	 */
	public PlayingFieldController(int width, int height, Playingfield pf) {
		dg = new DataGrid(width,height,3);
		this.pf = pf;
		this.width = width;
		
	}
	
	/**
	 * zeige Bomben im Playingfield an
	 */
	public void showBombs() {
		String[] posBombs = dg.getPositionBombs();
		
		for(int i=0; i<posBombs.length;i++) {
			if(posBombs[i] != null) {
				pf.getField()[i].setText("x"); 
			}
		}
		
	}
	
	/**
	 * Anzahl Bomben in umliegenden Feldern
	 */
	public void countBombsAround() {
		String[] posBombs = dg.getPositionBombs();
		for (int j = 0; j < (posBombs.length); j++) {
			int counter=0;
			if(posBombs[j] == null) {
				
				// pr�fe, ob rechts eine Bombe liegt (so lange wir uns auf dem Spielfeld befinden)
				if(j<posBombs.length && (j+1)%width!=0 && posBombs[j+1] != null) { // da oben posBombs.length-1 ist hier nur < notwendig, nicht <=
					counter++;
				}
				//links
				if(j-1 >= 0 && j%width!=0 &&  posBombs[j-1]!= null) {
					counter++;
				}
				// direkt darunter
				 if(j+width<posBombs.length && posBombs[j+width]!= null) {
					counter++;
				// direkt dar�ber
				} if(j-width >= 0 && posBombs[j-width]!= null) {
					counter++;
				}// schr�g links oben
				 if(j-width-1 >= 0 && (j-width)%width !=0 && posBombs[j-width-1]!= null) {
					counter++;
				// schr�g rechts oben
				} if(j-width+1 >= 0 && (j-width+1)%width!=0 && posBombs[j-width+1]!= null) {
					counter++;
				}// schr�g links unten
				 if(j+width-1<posBombs.length && (j+width)% width!=0 && posBombs[j+width-1]!= null) {
					counter++;
				// schr�g rechts unten
				} if(j+width+1<posBombs.length && (j+width+1)%width!=0 && posBombs[j+width+1]!= null) {
					counter++;
				}
				pf.getField()[j].setText(""+counter); 
			}
			
			
		}
		
	}
}
