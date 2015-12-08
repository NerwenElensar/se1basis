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
	
	
    public Runde(){}

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

}
