/**
 * SE1 Aufgabe 11
 * @author Robert Scheffel, Jennifer Momsen
 * @date 05.12.2015
 */
package se1app.applicationcore;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Runde implements IRunde {
	
    @Id
    @GeneratedValue
    private Integer id;
    
    @OneToMany
    private List<Wurf> wuerfe = new ArrayList<>();
    
    private String name;
	
	
    /**
     * Constructor
     */
    public Runde(){}
    
    /**
     * Constructor
     * @param name
     */
    public Runde(String name){
    	this.name = name;
    }
    
    public String getName(){
    	return name;
    }

	@Override
	public void loescheWurf(Wurf wurf) {
		wuerfe.remove(wurf);
		
	}

	@Override
	public List<Wurf> getWuerfe() {
		return wuerfe;
	}

	@Override
	public Wurf getWurf(int i) {
		return wuerfe.get(i);
	}

	@Override
	public void addWurf() {
		wuerfe.add(new Wurf());
	}

	@Override
	public void addWurf(int count) {
		for(int i = 0; i < count ; i++){
			this.addWurf();
		}
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((wuerfe == null) ? 0 : wuerfe.hashCode());
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
		Runde other = (Runde) obj;
		if(name == null) {
			if(other.name != null)
				return false;
		}
		else if(!name.equals(other.name))
			return false;
		if(wuerfe == null) {
			if(other.wuerfe != null)
				return false;
		}
		else if(!wuerfe.equals(other.wuerfe))
			return false;
		return true;
	}

}
