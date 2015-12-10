package se1app.applicationcore;

import static org.junit.Assert.*;

import java.util.List;

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
public class SpielRepositoryTest {

	@Autowired
	private SpielRepository spielRepository;
	
	@Before
	public void setUp() throws Exception {
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
	public void testFindAll() {
		List<Spiel> spiele = spielRepository.findAll();
		assertEquals(2, spiele.size());;
	}
	
	@Test
	public void testFindByTeamname(){
		Spiel spiel = spielRepository.findByteamName("HeimSpiel");
		assertEquals("HeimSpiel", spiel.getTeamname());
		assertTrue(spiel.getAllSpieler().contains(new Teilnehmer("Luke")));
		spiel.getAllSpieler().remove(new Teilnehmer("Luke"));
		assertFalse(spiel.getAllSpieler().contains(new Teilnehmer("Luke")));
		assertFalse(spiel.getAllSpieler().contains(new Teilnehmer("Imperator")));
	}
	
	@Test
	public void testFindBySpielBez(){
		Spiel spiel = spielRepository.findBySpielBez("Spiel Zwei");
		assertTrue(spiel.getAllSpieler().contains(new Teilnehmer("Imperator")));
	}
	
	@Test
	public void testFindTeilnehmer() {
		Spiel spiel = spielRepository.findByteamName("GastSpiel");
		assertTrue(spiel.getAllSpieler().contains(new Teilnehmer("Darth Vader")));
		assertTrue(spiel.getAllSpieler().contains(new Teilnehmer("Imperator")));
	}

}
