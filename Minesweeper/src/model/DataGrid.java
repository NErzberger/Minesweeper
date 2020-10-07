package model;

/**
 * Die Klasse DataGrid enth�lt die Variablen positionBombs und numberBombs, welche zum Generieren des DataGrids f�r die Bomben ben�tigt werden. 
 * Ziel der Klasse ist es, dass ein Grid bereitgestellt wird, in welchem die Positionen der Bomben enthalten sind.
 * Zudem enth�lt die Klasse die Werte f�r die H�he und Breite des Spielfeldes. In dieser Klasse sind �nderungen an der Spielfeldgr��e
 * und Anzahl der Minen m�glich. 
 * 
 * @author Nico
 * @author Larissa
 *
 */
public class DataGrid {
	/**
	 * Ein eindimensionales Array der Klasse {@link String}, in dem die Positionen der Bomben festgehalten werden.
	 */
	private String[] positionBombs;
	
	/**
	 * Diese Klassenvariable des Typs {@link Integer} gibt die Anzahl der zu setzenden Bomben an.
	 */
	private int numberBombs = 5;
	
	/**
	 * Diese Klassenvariable des Tpys {@link Integer} gibt die Breite des Spielfelds an und ist unver�nderlich.
	 */
	private final int width = 6;
	/**
	 * Diese Klassenvariable des Tpys {@link Integer} gibt die H�he des Spielfelds an und ist unver�nderlich.
	 */
	private final int height = 5;
	


	/**
	 * Konstruktor der Klasse {@link DataGrid}. Bei Aufruf des Konstruktors wird die Methode setBombs aufgerufen.
	 */
	public DataGrid() {
		positionBombs = new String[width*height];
		setBombs(numberBombs);
	}
	
	/**
	 *Diese Methode verstreut mithilfe einer Zufallszahl Bomben auf dem Spielfeld und speichert diese im eindimensionalen Array positionBombs. 
	 * @param numberBombs
	 */
	public void setBombs(int numberBombs) {
		// so lange, wie Bomben zu vergeben sind, vergib sie
		while(numberBombs > 0) {
			// zuf�llige Position einer Bombe
			int randomNumber = (int) (Math.random()*(positionBombs.length));
			// wenn an dieser Stelle noch keine Bombe liegt
			if(positionBombs[randomNumber] == null) {
				// dann setze eine Bombe an diese Stelle
				positionBombs[randomNumber] = "x";
				// erniedrige die Anzahl der noch zu setzenden Bomben um 1
				numberBombs--;
			}	
		}
	}

	/**
	 * Diese Methode gibt einen String Array zur�ck, welcher die Positionen der Bomben beinhaltet.
	 * @return positionBombs
	 */
	public String[] getPositionBombs() {
		return positionBombs;
	}

	/**
	 * Diese Methode setzt die Positionen der Bomben in die Klassenvariable positionBombs.
	 * @param positionBombs
	 */
	public void setPositionBombs(String[] positionBombs) {
		this.positionBombs = positionBombs;
	}

	/**
	 * Diese Methode gibt die Anzahl der zu setzenden Bomben zur�ck.
	 * @return numberBombs
	 */
	public int getNumberBombs() {
		return numberBombs;
	}

	/**
	 * Diese Methode setzt die Anzahl der zu setzenden Bomben in die Klassenvariable numberBombs.
	 * @param numberBombs
	 */
	public void setNumberBombs(int numberBombs) {
		this.numberBombs = numberBombs;
	}
	
	/**
	 * Diese Methode gibt die Breite des Spielfelds zur�ck
	 * @return width
	 */
	public int getWidth() {
		return width;
	}

	/**
	 * Diese Methode gibt die H�he des Spielfelds zur�ck
	 * @return height
	 */
	public int getHeight() {
		return height;
	}
}