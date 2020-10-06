package model;

/**
 * Die Klasse DataGrid enthält die Variablen positionBombs und numberBombs, welche zum Generieren des DataGrids für die Bomben benötigt werden. 
 * Ziel der Klasse ist es, dass ein Grid bereitgestellt wird, in welchem die Positionen der Bomben enthalten sind.
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
	
	private int width;
	
	private int height;
	
	
	
	/**
	 * Konstruktor der Klasse {@link DataGrid}. Bei Aufruf des Konstruktors wird die Methode setBombs aufgerufen.
	 * @param width
	 * @param height
	 * @param numberBombs
	 */
	public DataGrid(int width, int height, int numberBombs) {
		positionBombs = new String[width*height];
		this.numberBombs = numberBombs;
		setBombs(numberBombs);
	}
	
	/**
	 *Diese Methode verstreut nach zufällig berechneten Koordinaten Bomben im eindimensionalen Array positionBombs. 
	 * @param numberBombs
	 */
	public void setBombs(int numberBombs) {
		
		// so lange, wie Bomben zu vergeben sind, vergib sie
		while(numberBombs > 0) {
			// zufällige Position einer Bombe
			int randomNumber = (int) (Math.random()*(positionBombs.length));
			
			//System.out.println(randomNumber);
			if(positionBombs[randomNumber] == null) {
				positionBombs[randomNumber] = "x";
				numberBombs--;
			}	
		}
	}

	/**
	 * Diese Methode gibt einen String Array zurück, welches die Positionen der Bomben beinhaltet.
	 * @return
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
	 * Diese Methode gibt die Anzahl der zu setztenden Bomben zurück.
	 * @return
	 */
	public int getNumberBombs() {
		return numberBombs;
	}

	/**
	 * Diese Methode setzt die zu setztenden Bomben in die Klassenvariable numberBombs.
	 * @param numberBombs
	 */
	public void setNumberBombs(int numberBombs) {
		this.numberBombs = numberBombs;
	}
	
	
}
