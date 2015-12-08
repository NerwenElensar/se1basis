package se1app.applicationcore;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Wurf {
	
    @Id
    @GeneratedValue
    private Integer id;
    
    
    public Wurf(){}

}
