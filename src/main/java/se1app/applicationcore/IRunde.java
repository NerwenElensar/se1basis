package se1app.applicationcore;

import java.util.List;
/**
 * SE1 Aufgabe 11
 * @author Robert Scheffel, Jennifer Momsen
 * @date 05.12.2015
 */
public interface IRunde {
	
		/** entfernt einen Wurf aus der Rundenliste 
	 * @param wurf
	 */
	public void loescheWurf(Wurf wurf);
	
	/**
	 * liefert die Liste der Wuerfe
	 * @return Wurf
	 */
	public List<Wurf> getWuerfe();
	
	/**
	 * Liefert den Wurf an der Position der Wurfliste
	 * @return
	 */
	public Wurf getWurf(int i);
	
	
	/**
	 * Fügt einen Wurf zur Wurfliste hinzu
	 */
	public void addWurf();
	
	/**
	 * Fuegt einen Wurf mit Punkten hinzu
	 * @param punkte
	 */
	public void addWurf(int punkte);
	
	
	/**
	 * Fügt eine Anzahl an Würfen zur Wurfliste hinzu
	 * @param count
	 */
	public void addWuerfe(int count);

}
