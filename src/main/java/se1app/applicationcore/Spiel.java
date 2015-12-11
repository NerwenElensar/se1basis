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
import javax.persistence.ManyToMany;
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
	
	@ManyToMany
	private List<Teilnehmer> allSpieler = new ArrayList<>();;
	
	private String teamName;
	
	private String spielBez;
	
	private Spielmodustyp modus = new Spielmodustyp("Standard");
	
	@OneToMany
	private List<Runde> runden;
	
	public Spiel() {
	}
	
	/**
	 * Constructor
	 * @param teamName
	 * @param spielmodus
	 */
	public Spiel(String spielBez, String teamName, String spielmodus) {
		this.teamName = teamName;
		this.spielBez = spielBez;
		runden = new ArrayList<>();
		modus = new Spielmodustyp(spielmodus);
	}
	
	/**
	 * TODO
	 * @return
	 */
	public List<Teilnehmer> getAllSpieler() {
		return allSpieler;
	}
	
	/**
	 * TODO
	 * @return
	 */
	public Spielmodustyp getSpielmodus() {
		return modus;
	}
	
	/**
	 * TODO
	 * @return
	 */
	public String getSpielBezeichnung(){
		return spielBez;
	}
	
	public Teilnehmer getTeilnehmer(String name){
			for(Teilnehmer t : allSpieler){
				if(t.getName().equals(name)){
					return t;
				}
			}
		
		return null;
	}
	
	/**
	 * TODO
	 * @return
	 */
	public String getTeamname() {
		return teamName;
	}
	
	/**
	 * TODO
	 * @param teilnehmer
	 */
	public void addTeilnehmer(Teilnehmer teilnehmer) {
		allSpieler.add(teilnehmer);
	}
	
	/**
	 * TODO
	 * @param teilnehmer
	 */
	public void removeTeilnehmer(Teilnehmer teilnehmer) {
		allSpieler.remove(teilnehmer);
	}
	
	/**
	 * TODO
	 */
	public void addRunde() {
		runden.add(new Runde());
	}
	
	/**
	 * TODO
	 * @param count
	 */
	public void addRunde(int count) {
		for(int i = 0; i < count; i++) {
			this.addRunde();
		}
	}
	
	/**
	 * TODO
	 * @return
	 */
	public List<Runde> getRunden(){
		return runden;
	}
	
	/**
	 * @param index
	 * @return
	 */
	public Runde getRunde(int index){
		return runden.get(index);
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
		if(this == obj)
			return true;
		if(obj == null)
			return false;
		if(getClass() != obj.getClass())
			return false;
		Spiel other = (Spiel) obj;
		if(id == null) {
			if(other.id != null)
				return false;
		}
		else if(!id.equals(other.id))
			return false;
		if(teamName == null) {
			if(other.teamName != null)
				return false;
		}
		else if(!teamName.equals(other.teamName))
			return false;
		return true;
	}
	
}
