package se1app.applicationcore;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@ContextConfiguration(classes = Application.class)
public class UseCaseTest {
	
	@Autowired
	private SpielRepository spielRepository;
	
	private AppUseCases useCase;
	
	@Before
	public void setUp() throws Exception {
		useCase = new AppUseCases();
		Spiel spiel = new Spiel("Spiel Eins","HeimSpiel", "normal");
		spiel.addTeilnehmer(new Teilnehmer("Luke"));
		spiel.addTeilnehmer(new Teilnehmer("Lea"));
		spiel.addRunde(10);
		spiel.getRunden().forEach(runde -> runde.addWuerfe(15)); 
		spielRepository.save(spiel);
		
		Spiel spiel2 = new Spiel("Spiel Zwei","GastSpiel", "normal");
		spiel2.addTeilnehmer(new Teilnehmer("Darth Vader"));
		spiel2.addTeilnehmer(new Teilnehmer("Imperator"));
		spiel2.addRunde(5);
		spiel2.getRunden().forEach(runde -> runde.addWuerfe(15)); 
		spielRepository.save(spiel2);
		useCase.setSpielRepository(spielRepository);
	}
	
	@Test
	public void testPunkteEintragen() {
		
		useCase.punkteEintragen("Spiel Eins", 1, 5);
		
		assertEquals(5,useCase.spielRepository.findBySpielBez("Spiel Eins").getRunde(1).getWurf(15).getPunkte());
	}
	
	@Test
	public void testPunkteFuerWurfEintragen(){
		useCase.punkteEintragen("Spiel Zwei", 2, 3, 7);
		assertEquals(7, useCase.spielRepository.findBySpielBez("Spiel Zwei").getRunde(2).getWurf(3).getPunkte());
	}
	
}
