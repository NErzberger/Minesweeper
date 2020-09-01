package model;

public class DataGrid {
	private String[] positionBombs;
	private int numberBombs;
	
	public DataGrid(int width, int height, int numberBombs) {
		positionBombs = new String[width*height];
		this.numberBombs = numberBombs;
		setBombs(numberBombs);
	}
	
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
		for(int i=0; i<positionBombs.length; i++) {
			System.out.println(positionBombs[i]);
		}
	}

	public String[] getPositionBombs() {
		return positionBombs;
	}

	public void setPositionBombs(String[] positionBombs) {
		this.positionBombs = positionBombs;
	}

	public int getNumberBombs() {
		return numberBombs;
	}

	public void setNumberBombs(int numberBombs) {
		this.numberBombs = numberBombs;
	}
	
	
}
