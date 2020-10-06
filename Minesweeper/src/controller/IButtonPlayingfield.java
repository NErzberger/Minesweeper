package controller;

import main.Imagetype;

/**
 * Mittels diesem Interfrace soll ein Button definiert werden, welcher mit dem {@link PlayingFieldController} kompatibel ist.
 * Die zu implementierende Methoden werden in der Implementierung des Controllers benötigt. 
 * <h2>Warnung:</h2>
 * Änderungen in den Übergabeparameter und Rückgabewerte sind nicht zulässig und führen zu Ablauffehlern!
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
	 * Ist der Rückgabewert false, so wurde der Button noch nicht geklickt, ist der True wird davon ausgegangen, 
	 * dass der User den Button angeklickt hat.
	 * @return boolean
	 */
	public boolean isPressed();

	/**
	 * Mit dieser Methode soll dem Button mitgeteilt werden, dass er geklickt wurde. Dieser Wert ist für die weitere 
	 * Bearbeitung wichtig und muss entsprechend gesetzt werden. True steht dafür, dass der Button angeklickt wurde und
	 * False dafür, dass er noch nicht geklickt wurde. 
	 * @param pressed
	 */
	public void setPressed(boolean pressed);

	/**
	 * Mit dieser Methode soll in einen Button ein Image gesetzt werden können. Dabei werden 2 Arten von Images erwartet:
	 * <ol>
	 * <li>eine Bomb, welche auf Feldern erscheint, auf denen Bomben gesetzt wurden </li>
	 * <li>eine Flag, welche gewählt wird, wenn der User eine Flagge setzten will.</li>
	 * </ol>
	 * Die Auswahl der Images / Icons obliegt der Implementierung, es müssen jediglich diese 2 Images bereitgestellt werden.
	 * Darüberhinaus wird zum löschen der Images aus dem Button ein dritter möglicher Wert übergeben, was der Imagetype NONE ist.
	 * Wird dieser Wert als Typ übergeben, so soll das Image aus dem Button entfernt werden. 
	 * Die Parameter width und height sollen beim Sklalieren der Images helfen, da möglicherweise die Images zu groß sind.
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
	 * zwischen 0 und 8 zugewiesen werden können muss. Diese Werte werden im Programmablauf wiederum abgefragt. Als Übergabeparameter wurde 
	 * ein String gewählt, da eine Bombe als X gespeichert wird.
	 * @param valueButton
	 */
	public void setValueButton(String valueButton);

	/**
	 * Mit dieser Methode soll der Button abgefragt werden, ob der User den Button auf Verdacht einer Mine markiert hat oder nicht.
	 * Die Methode soll einen boolean zurückliefern, wobei True für markiert steht und False für unmarkiert.
	 * @return
	 */
	public boolean isFlag();

	/**
	 * Mittels der Methode setFalg soll dem Button mitgeteilt werden, dass auf ihn eine Flagge gesetzt wurde. Daraufhin muss der Button
	 * in einem Boolean den übergebenen Wert hineinsetzten. Dieser Wert wird im Programmablauf wierderum abgefragt. 
	 * @param isFlag
	 */
	public void setFlag(boolean isFlag);

	/**
	 * Mittels dieser Methode soll der Hintergrund des Buttons aus dem Controller heraus verändert werden können. Dazu werden RGB Farben verwendet.
	 * @param r
	 * @param g
	 * @param b
	 */
	public void setBackground(int r, int g, int b);

	/**
	 * Mittels dieser Methode soll aus dem Controller heraus der Text auf den Buttons verändert werden können bzw. ein Text geschrieben werden können. 
	 * 
	 * @param text
	 */
	public void setTextMS(String text);

	/**
	 * Mittels dieser Methode soll die ButtonID eines Buttons abgefragt werden können, welche zur Orientierung im Grid benötigt wird.
	 * @return
	 */
	public int getButtonId();

	/**
	 * Da jeder Button eine ButtonID bekommt, soll mittels dieser Methode eine ID dem Button mitgegeben werden können. Diese ID wird zur Orientierung im Grid 
	 * benötigt. Bei der ID handelt es sich um einen Integer.
	 * @param buttonId
	 */
	public void setButtonId(int buttonId);	
}
