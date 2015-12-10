package se1app.applicationcore;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Kegelbahn {
	
	@Id
	@GeneratedValue
	private Integer id;
	
	private String name;
	private int anzahlKegelbahnen;
	private Adresstyp adresse;
	
	@ManyToMany(mappedBy = "kegelbahnen")
	private List<Event> events;
	
	public Kegelbahn(){
	}
	
	public Kegelbahn(String name, int anzahlKegelbahnen, Adresstyp adresse){
		this.name = name;
		this.anzahlKegelbahnen = anzahlKegelbahnen;
		this.adresse = adresse;
		this.events = new ArrayList<>();
	}
	
	public void eventHinzufuegen(Event event){
		events.add(event);
	}

}

