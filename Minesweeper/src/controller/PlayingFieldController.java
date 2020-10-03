package controller;


import java.awt.GridLayout;

import javax.swing.JOptionPane;

import main.ButtonPlayingfield;
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
	 * In der Klassenvariable width wird die Breite des Spielfeldes festgehalten.
	 */
	private int width;
	private int height;
	
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
		this.height = height;
	}
	
	//public PlayingFieldController() {}
	
	/**
	 * zeige Bomben im Playingfield an
	 */
	public void showBombs() {
		String[] posBombs = dg.getPositionBombs();
		
		for(int i=0; i<posBombs.length;i++) {
			if(posBombs[i] != null) {
				pf.getField()[i].setValueButton("x");
			
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
				
				// prüfe, ob rechts eine Bombe liegt (so lange wir uns auf dem Spielfeld befinden)
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
				// direkt darüber
				} if(j-width >= 0 && posBombs[j-width]!= null) {
					counter++;
				}// schräg links oben
				 if(j-width-1 >= 0 && (j-width)%width !=0 && posBombs[j-width-1]!= null) {
					counter++;
				// schräg rechts oben
				} if(j-width+1 >= 0 && (j-width+1)%width!=0 && posBombs[j-width+1]!= null) {
					counter++;
				}// schräg links unten
				 if(j+width-1<posBombs.length && (j+width)% width!=0 && posBombs[j+width-1]!= null) {
					counter++;
				// schräg rechts unten
				} if(j+width+1<posBombs.length && (j+width+1)%width!=0 && posBombs[j+width+1]!= null) {
					counter++;
				}
				pf.getField()[j].setValueButton(""+counter); 
			}
			
			
		}
		
	}

	/**
	 * Methode, die regelt, was passiert, wenn ein Button gedrückt wird
	 * @param bp
	 */
	public void pressingButton(ButtonPlayingfield bp) {
		
		
		// Boolean pressed wird auf wahr gesetzt -> Button wurde gedrückt
		bp.setPressed(true);
		// Wert des Buttons wird angezeigt
		bp.setText(bp.getValueButton());
		
		// wenn eine Mine getroffen wird
		if(bp.getValueButton().equals("x")) {
			String[] options = new String[2];
			options[0] = new String("Neustart");
			options[1] = new String("Schließen");
			int returnValue = JOptionPane.showOptionDialog(pf,"Du hast eine Mine getroffen.","Leider verloren!", 0,JOptionPane.INFORMATION_MESSAGE,null,options,null);
			System.out.println(returnValue);
			
			// Neustart des Spiels (funktioniert derzeit nur 4x)
			if(returnValue==0) {
				for(int i=0; i<pf.getField().length; i++) {
					if(pf.getField()[i].isPressed()) {
						pf.getField()[i].setPressed(false);
						pf.getField()[i].setText(null);
					}
				}
				
				dg.setBombs(dg.getNumberBombs());
				this.showBombs();
				this.countBombsAround();
				
				
			}
			
			// Beenden des Spiels / Schließen
			if(returnValue==1) {
				System.exit(0);
			}
			
		}
	}
	
	
	
	
}
