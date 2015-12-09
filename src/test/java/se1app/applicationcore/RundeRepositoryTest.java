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
public class RundeRepositoryTest {
	
	@Autowired
	private RundeRepository rundeRepository;
	
	
	@Before
	public void setUp() throws Exception {
	Runde runde1 = new Runde("Runde Eins");
	runde1.addWurf(5);
	rundeRepository.save(runde1);
	
	Runde runde2 = new Runde("Runde zwei");
	runde2.addWurf(25);
	rundeRepository.save(runde2);
	
	Runde runde3 = new Runde("Runde drei");
	runde3.addWurf(15);
	rundeRepository.save(runde3);
	
	
	}
	
	@Test
	public void testFindAll() {
		List<Runde> runde = rundeRepository.findAll();
		assertEquals(3, runde.size());
	}
	
	@Test
	public void testFindByName(){
		Runde runde = rundeRepository.findByName("Runde drei");
		assertEquals("Runde drei", runde.getName());
	}
	
}
