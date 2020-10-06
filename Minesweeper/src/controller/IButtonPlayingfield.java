package controller;

import main.Imagetype;

/**
 * Mittels diesem Interfrace soll ein Button definiert werden, welcher mit dem {@link PlayingFieldController} kompatibel ist.
 * Die zu implementierende Methoden werden in der Implementierung des Controllers ben�tigt. 
 * <h2>Warnung:</h2>
 * �nderungen in den �bergabeparameter und R�ckgabewerte sind nicht zul�ssig und f�hren zu Ablauffehlern!
 * @author Nico
 * @author Larissa
 *
 */
public interface IButtonPlayingfield {

	/**
	 * Diese Aktion soll einen Linksklick der Maus abfangen und die Bearbeitung in den Controller weiterleiten.
	 * @param pf
	 */
	public void executeButtonInController(PlayingFieldController pf);

	/**
	 *Diese Aktion soll einen Rechtsklick der Maus abfangen und die Bearbeitung in den Controller weiterleiten. 
	 * @param pf
	 */
	public void executeRightClick(PlayingFieldController pf);

	/**
	 * Mit dieser Methoden soll abgefragt werden, ob der betreffende Button angeklickt wurde oder nicht. 
	 * Ist der R�ckgabewert false, so wurde der Button noch nicht geklickt, ist der True wird davon ausgegangen, 
	 * dass der User den Button angeklickt hat.
	 * @return boolean
	 */
	public boolean isPressed();

	/**
	 * Mit dieser Methode soll dem Button mitgeteilt werden, dass er geklickt wurde. Dieser Wert ist f�r die weitere 
	 * Bearbeitung wichtig und muss entsprechend gesetzt werden. True steht daf�r, dass der Button angeklickt wurde und
	 * False daf�r, dass er noch nicht geklickt wurde. 
	 * @param pressed
	 */
	public void setPressed(boolean pressed);

	/**
	 * Mit dieser Methode soll in einen Button ein Image gesetzt werden k�nnen. Dabei werden 2 Arten von Images erwartet:
	 * <ol>
	 * <li>eine Bomb, welche auf Feldern erscheint, auf denen Bomben gesetzt wurden </li>
	 * <li>eine Flag, welche gew�hlt wird, wenn der User eine Flagge setzten will.</li>
	 * </ol>
	 * Die Auswahl der Images / Icons obliegt der Implementierung, es m�ssen jediglich diese 2 Images bereitgestellt werden.
	 * Dar�berhinaus wird zum l�schen der Images aus dem Button ein dritter m�glicher Wert �bergeben, was der Imagetype NONE ist.
	 * Wird dieser Wert als Typ �bergeben, so soll das Image aus dem Button entfernt werden. 
	 * Die Parameter width und height sollen beim Sklalieren der Images helfen, da m�glicherweise die Images zu gro� sind.
	 * @param type
	 * @param width
	 * @param height
	 */
	public void setImage(Imagetype type, int width, int height);

	/**
	 * Mit dieser Methode soll der zugewiesene Wert des Button abgefragt werden, um festzustellen, ob auf diesen Button eine Bombe oder 
	 * eine Zahl gesetzt wurde.
	 * @return String
	 */
	public String getValueButton();

	/**
	 * Mit dieser Methode soll ein Wert dem Button zugewiesen werden, da jedem Button entweder eine Bombe oder eine entsprechende Zahl 
	 * zwischen 0 und 8 zugewiesen werden k�nnen muss. Diese Werte werden im Programmablauf wiederum abgefragt. Als �bergabeparameter wurde 
	 * ein String gew�hlt, da eine Bombe als X gespeichert wird.
	 * @param valueButton
	 */
	public void setValueButton(String valueButton);

	/**
	 * Mit dieser Methode soll der Button abgefragt werden, ob der User den Button auf Verdacht einer Mine markiert hat oder nicht.
	 * Die Methode soll einen boolean zur�ckliefern, wobei True f�r markiert steht und False f�r unmarkiert.
	 * @return
	 */
	public boolean isFlag();

	/**
	 * Mittels der Methode setFalg soll dem Button mitgeteilt werden, dass auf ihn eine Flagge gesetzt wurde. Daraufhin muss der Button
	 * in einem Boolean den �bergebenen Wert hineinsetzten. Dieser Wert wird im Programmablauf wierderum abgefragt. 
	 * @param isFlag
	 */
	public void setFlag(boolean isFlag);

	/**
	 * Mittels dieser Methode soll der Hintergrund des Buttons aus dem Controller heraus ver�ndert werden k�nnen. Dazu werden RGB Farben verwendet.
	 * @param r
	 * @param g
	 * @param b
	 */
	public void setBackground(int r, int g, int b);

	/**
	 * Mittels dieser Methode soll aus dem Controller heraus der Text auf den Buttons ver�ndert werden k�nnen bzw. ein Text geschrieben werden k�nnen. 
	 * 
	 * @param text
	 */
	public void setTextMS(String text);

	/**
	 * Mittels dieser Methode soll die ButtonID eines Buttons abgefragt werden k�nnen, welche zur Orientierung im Grid ben�tigt wird.
	 * @return
	 */
	public int getButtonId();

	/**
	 * Da jeder Button eine ButtonID bekommt, soll mittels dieser Methode eine ID dem Button mitgegeben werden k�nnen. Diese ID wird zur Orientierung im Grid 
	 * ben�tigt. Bei der ID handelt es sich um einen Integer.
	 * @param buttonId
	 */
	public void setButtonId(int buttonId);	
}
