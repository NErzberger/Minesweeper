package main;

/**
 * Das Enum Imagetype soll die Imagetypen unterscheidbar machen.
 * <ol>
 * <li>BOMB steht f�r eine Bombe. Alle Felder die diesen Wert zugewiesen bokommen, bekommen als Image eine Bombe.</li>
 * <li>FLAG steht f�r eine Flagge. Alle Felder die diesen Wert zugewiesen bekommen, bekommen als Image eine Flagge</li>
 * <li>NONE wird dazu verwendet um dem Button mitzuteilen, dass er das momentan verwendete Image l�schen soll.</li>
 * </ol>
 * 
 * @author Nico
 * @author Larissa
 *
 */
public enum Imagetype {
	BOMB, FLAG, NONE;
}
