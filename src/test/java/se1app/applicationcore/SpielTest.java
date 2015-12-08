package se1app.applicationcore;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class SpielTest {
	
	private Spiel spiel;

	@Before
	public void setUp() throws Exception {
		spiel = new Spiel("KlassenTreff", "normal");
	}

	@Test
	public void testAddSpieler() {
		assertEquals(0, spiel.getAllSpieler().size());
		for(int i = 0; i<10; i++){
			spiel.addTeilnehmer(new Teilnehmer("Hugo" + i));
		}
		assertEquals(10, spiel.getAllSpieler().size());
		Teilnehmer teilnehmer = new Teilnehmer("Lea"); 
		spiel.addTeilnehmer(teilnehmer);
		assertTrue(spiel.getAllSpieler().contains(teilnehmer));
	}

	
	
	@Test
	public void testRemoveSpieler(){
		Teilnehmer teilnehmer = new Teilnehmer("Lea"); 
		spiel.addTeilnehmer(teilnehmer);
		assertTrue(spiel.getAllSpieler().contains(teilnehmer));
		spiel.removeTeilnehmer(teilnehmer);
		assertFalse(spiel.getAllSpieler().contains(teilnehmer));
		
	}
}
