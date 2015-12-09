/**
 * SE1 Aufgabe 11
 * @author Robert Scheffel, Jennifer Momsen
 * @date 05.12.2015
 */
package se1app.applicationcore;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Wurf implements IWurf{
	
    @Id
    @GeneratedValue
    private Integer id;
    
    private int punkte;
    
    
    public Wurf(){}
    /**
     * Constructor
     * @param punkte
     */
    public Wurf(int punkte){
    	this.punkteAendern(punkte);
    }


	@Override
	public void punkteAendern(int punkte) {
		this.punkte = punkte;
	}


	@Override
	public void punkteLoeschen() {
		punkte = 0;
	}


	@Override
	public int getPunkte() {
		return punkte;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + punkte;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if(this == obj)
			return true;
		if(obj == null)
			return false;
		if(getClass() != obj.getClass())
			return false;
		Wurf other = (Wurf) obj;
		if(punkte != other.punkte)
			return false;
		return true;
	}
	
	
}
