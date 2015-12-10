package se1app.applicationcore;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WurfRepository extends JpaRepository<Wurf, Integer>{

}
