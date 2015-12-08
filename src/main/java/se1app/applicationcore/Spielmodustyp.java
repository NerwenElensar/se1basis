/**
 * SE1 Aufgabe 11
 * @author Robert Scheffel, Jennifer Momsen
 * @date 05.12.2015
 */
package se1app.applicationcore;

import java.io.Serializable;

/**
 * @author Robert
 * @date 05.12.2015
 */

public class Spielmodustyp implements Serializable {
	
 
	private String modus;
	
	
//	public Spielmodus(){}
	
	/**
	 * Constructor
	 * @param spielmodus
	 */
	public Spielmodustyp(String spielmodus){
		modus = spielmodus;
	}
	
	
	
	
	/**
	 * TODO
	 * @param obj
	 * @return
	 */
	public boolean checkInstance(Object obj) {
		return obj instanceof Spielmodustyp;
	}
	
	@Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + (int) ((modus.hashCode()) ^ (modus.hashCode()) >>> 32);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        // Referenzgleichheit
        if (this == obj) {
            return true;
        }
        
        // Typgleichheit
        if (!this.checkInstance(obj)) {
            return false;
        }
        
        // Wertegleichheit
        Spielmodustyp other = (Spielmodustyp)(obj);
        return modus.equals(other.modus); 
    }

}
