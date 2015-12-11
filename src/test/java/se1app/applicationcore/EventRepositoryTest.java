package se1app.applicationcore;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.fail;

import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
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
public class EventRepositoryTest {
	
	@Autowired
	private EventRepository eventRepository;
	
	private Date date = (new GregorianCalendar()).getTime();

	@Before
	public void setUp() throws Exception {
		Event event = new Event(date);
		List<String> list = Arrays.asList("Luke,Lea,Han,DarthVader".split(","));
		list.forEach(t -> {
			event.teilnehmerHinzufuegen(new Teilnehmer(t));
		});
		
		eventRepository.save(event);

	}

	@Test
	public void testFindAll() {
		Event eventTeilnehmer = eventRepository.findBydatum(date);
		assertThat(eventTeilnehmer.getEventTeilnehmer()).hasSize(4);
		
	}

}
