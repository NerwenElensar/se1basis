package se1app.applicationcore;

import java.util.List;

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

}
