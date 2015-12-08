/**
 * 
 */
package se1app.applicationcore;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 * @author Robert
 * @date 05.12.2015
 */
@Entity
public class Spiel {	
	
    @Id
    @GeneratedValue
    private Integer id;
    
	@OneToMany
	private List<Teilnehmer> allSpieler;
	
	private String teamName;
	
	private Spielmodustyp modus = new Spielmodustyp("Standard");
	
//	@OneToMany
//	private List<Runde> runden;
	
	
	public Spiel(){
		 
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((teamName == null) ? 0 : teamName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Spiel other = (Spiel) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (teamName == null) {
			if (other.teamName != null)
				return false;
		} else if (!teamName.equals(other.teamName))
			return false;
		return true;
	}

}
