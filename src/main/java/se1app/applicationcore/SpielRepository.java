/**
 * SE1 Aufgabe 11
 * @author Robert Scheffel, Jennifer Momsen
 * @date 05.12.2015
 */
package se1app.applicationcore;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpielRepository extends JpaRepository<Spiel, Integer> {
	
	public Spiel findByteamName(String teamName);
	
	public Spiel findBySpielBez(String spielBez);
	
}
