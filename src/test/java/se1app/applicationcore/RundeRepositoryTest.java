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
	Runde runde1 = new Runde();
	runde1.addWuerfe(5);
	rundeRepository.save(runde1);
	
	Runde runde2 = new Runde();
	runde2.addWuerfe(25);
	rundeRepository.save(runde2);
	
	Runde runde3 = new Runde();
	runde3.addWuerfe(15);
	rundeRepository.save(runde3);
	
	
	}
	
	@Test
	public void testFindAll() {
		List<Runde> runde = rundeRepository.findAll();
		assertEquals(3, runde.size());
	}
	

	
}
