package main;

/**
 * Die Enumeration Imagetype soll die Imagetypen unterscheidbar machen.
 * <ol>
 * <li>BOMB steht für eine Bombe. Alle Felder, die diesen Wert zugewiesen bekommen, bekommen als Image eine Bombe.</li>
 * <li>FLAG steht für eine Flagge. Alle Felder, die diesen Wert zugewiesen bekommen, bekommen als Image eine Flagge</li>
 * <li>NONE wird dazu verwendet um dem Button mitzuteilen, dass er das momentan verwendete Image löschen und somit kein Image anzeigen soll.</li>
 * </ol>
 * 
 * @author Nico
 * @author Larissa
 *
 */
public enum Imagetype {
	BOMB, FLAG, NONE;
}
