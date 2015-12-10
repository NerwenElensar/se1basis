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

		spielRepository.save(spiel);
		
		Spiel spiel2 = new Spiel("Spiel Zwei","GastSpiel", "normal");
		spiel2.addTeilnehmer(new Teilnehmer("Darth Vader"));
		spiel2.addTeilnehmer(new Teilnehmer("Imperator"));

		spielRepository.save(spiel2);
	}
	
	@Test
	public void testPunkteEintragen() {
		
//		useCase.punkteEintragen("Spiel Eins", "Luke", 0, 5);
//		assertEquals(5,useCase.rundeRepository.findOne(0).getWurf(0));
	}
	
}
