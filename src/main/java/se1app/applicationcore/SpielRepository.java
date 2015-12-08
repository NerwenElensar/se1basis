package se1app.applicationcore;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpielRepository extends JpaRepository<Spiel, Integer> {
	public Spiel findByteamName(String teamName);
	
}
