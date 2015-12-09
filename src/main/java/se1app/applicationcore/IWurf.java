/**
 * SE1 Aufgabe 11
 * @author Robert Scheffel, Jennifer Momsen
 * @date 05.12.2015
 */
package se1app.applicationcore;

public interface IWurf {
	
	/**
	 * Aendert die Punkte des Wurfes
	 * 
	 * @param punkte > 0 && punkte < 100 
	 */
	public void punkteAendern(int punkte);
	
	/**
	 * setzte die Punkte des Wurfes zurueck auf 0
	 */
	public void punkteLoeschen();
	
	/**
	 * liefert den Werte der Punkte
	 * @return Punkte
	 */
	public int getPunkte();
	
	

	
	

}
