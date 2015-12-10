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
public class WurfRepositoryTest {
	
	@Autowired
	private WurfRepository wurfRepository;
	
	@Before
	public void setUp() throws Exception {
		
		for(int i = 0; i< 20; i++){
			wurfRepository.save(new Wurf(1 +i));
		}
		
	}
	
	@Test
	public void testFindAll() {
		List<Wurf> wuerfe = wurfRepository.findAll();
		assertEquals(20, wuerfe.size());
		
	}
	
	@Test
	public void testWurfValue(){
		List<Wurf> wuerfe = wurfRepository.findAll();
		assertEquals(1, wuerfe.get(0).getPunkte());
		assertEquals(10, wuerfe.get(9).getPunkte());
		assertEquals(15, wuerfe.get(14).getPunkte());
		assertEquals(20, wuerfe.get(19).getPunkte());
	}
	
}
