package se1app.applicationcore;

import java.io.Serializable;


/**
 * @author Robert
 * @date 05.12.2015
 */
public class Adresstyp implements Serializable {
	
	private String strasse;
	private int hausNr;
	private int plz;
	private String ort;
	
	public Adresstyp(String strasse, int hausNr, int plz, String ort) {
		this.strasse = strasse;
		this.hausNr = hausNr;
		this.plz = plz;
		this.ort = ort;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + hausNr;
		result = prime * result + ((ort == null) ? 0 : ort.hashCode());
		result = prime * result + plz;
		result = prime * result + ((strasse == null) ? 0 : strasse.hashCode());
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
		Adresstyp other = (Adresstyp) obj;
		if(hausNr != other.hausNr)
			return false;
		if(ort == null) {
			if(other.ort != null)
				return false;
		}
		else if(!ort.equals(other.ort))
			return false;
		if(plz != other.plz)
			return false;
		if(strasse == null) {
			if(other.strasse != null)
				return false;
		}
		else if(!strasse.equals(other.strasse)) {
			return false;
		}
		return true;
	}
	
}
