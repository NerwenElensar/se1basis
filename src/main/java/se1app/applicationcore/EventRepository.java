package se1app.applicationcore;

import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<Event, Integer> {
	Event findBydatum(Date datum);
}
