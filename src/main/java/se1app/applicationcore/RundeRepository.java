/**
 * SE1 Aufgabe 11
 * @author Robert Scheffel, Jennifer Momsen
 * @date 08.12.2015
 */
package se1app.applicationcore;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RundeRepository extends JpaRepository<Runde, Integer> {
	
	public Runde findByName(String name);

}
