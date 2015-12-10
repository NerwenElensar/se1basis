package se1app.applicationcore;


import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

public class AppUseCases {
	
	@Autowired
	SpielRepository spielRepository;
	
	@Autowired
	RundeRepository rundeRepository;
	
	@Autowired
	WurfRepository wurfReposirory;
	
	
	private Map<Teilnehmer, Runde> spielPunkte = new HashMap<>();
	
	public void punkteEintragen(String spielBez, String spielerName, int rundenIndex, int punkte) {
	
		Spiel spiel = spielRepository.findBySpielBez(spielBez);
		Teilnehmer spieler = spiel.getTeilnehmer(spielerName); 
		Runde runde = rundeRepository.findAll().get(rundenIndex);	
		runde.getWuerfe().add(new Wurf(punkte));
		spielPunkte.put(spieler, runde);
		
	}
	
	public Map<Teilnehmer,Runde> getSpielPunkte(){
		return spielPunkte;
	}
}
