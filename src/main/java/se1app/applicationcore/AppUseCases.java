package se1app.applicationcore;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

public class AppUseCases {

	@Autowired
	SpielRepository spielRepository;

	/**
	 * 
	 */
	public AppUseCases(){
	}

	/**
	 * @param spielBez
	 * @param spielerName
	 * @param rundenIndex
	 * @param punkte
	 */
	public void punkteEintragen(String spielBez, int rundenIndex, int punkte) {
			spielRepository.findBySpielBez(spielBez).getRunden().get(rundenIndex).addWurf(punkte);
			
	}
	
	/**
	 * @param spielBez
	 * @param spielerName
	 * @param rundenIndex
	 * @param wurfIndex
	 * @param punkte
	 */
	public void punkteEintragen(String spielBez, int rundenIndex,int wurfIndex, int punkte){
		Spiel spiel = spielRepository.findBySpielBez(spielBez);
		spiel.getRunde(rundenIndex).getWurf(wurfIndex).punkteAendern(punkte);
	}


	/**
	 * @param spielRepo
	 */
	public void setSpielRepository(SpielRepository spielRepo) {
		spielRepository = spielRepo;
	}

}
