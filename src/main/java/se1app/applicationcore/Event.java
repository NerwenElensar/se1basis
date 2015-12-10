package se1app.applicationcore;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class Event {
	
	@Id
	@GeneratedValue
	private Integer id;
	@ManyToMany
	private List<Kegelbahn> kegelbahnen;
	@OneToMany
	private List<Teilnehmer> teilnehmer;
	private Date datum;
	
	public Event(){
		kegelbahnen = new ArrayList<>();
		teilnehmer = new ArrayList<>();
		datum = new Date();	
	}
	
	public Event(Date date){
		datum = date;
	}
	
	public void teilnehmerHinzufuegen(List<Teilnehmer> teilnehmer){
		this.teilnehmer = teilnehmer;
	}
	
	public void teilnehmerHinzufuegen(Teilnehmer spieler){
		
		this.teilnehmer.add(spieler);
	}
	
	public void teilnehmerEntfernen(Teilnehmer spieler){
		this.teilnehmer.remove(spieler);
	} 
	
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((datum == null) ? 0 : datum.hashCode());
		result = prime * result + ((kegelbahnen == null) ? 0 : kegelbahnen.hashCode());
		result = prime * result + ((teilnehmer == null) ? 0 : teilnehmer.hashCode());
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
		Event other = (Event) obj;
		if (datum == null) {
			if (other.datum != null)
				return false;
		} else if (!datum.equals(other.datum))
			return false;
		if (kegelbahnen == null) {
			if (other.kegelbahnen != null)
				return false;
		} else if (!kegelbahnen.equals(other.kegelbahnen))
			return false;
		if (teilnehmer == null) {
			if (other.teilnehmer != null)				return false;
		} else if (!teilnehmer.equals(other.teilnehmer))
			return false;
		return true;
	}
	
	
}
