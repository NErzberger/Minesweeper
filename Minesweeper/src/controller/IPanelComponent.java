package controller;

/**
 * Der IPanelComponent soll das Spieldfeld als eindimensionalen Array der Klasse {@link IButtonPlayingfield} enthalten. 
 * Der IPanelComponent ist Bestandteil der IMainView.
 * 
 * @author Nico
 * @author Larissa
 *
 */
public interface IPanelComponent {
	/**
	 * Diese Methode erstellt das Spielfeld und stellt es in der GUI dar.
	 */
	public void drawPlayingfield();
}
