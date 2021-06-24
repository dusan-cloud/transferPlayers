package zavrsni.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import zavrsni.model.Klub;

@Repository
public interface KlubRepository extends JpaRepository<Klub, Long>{

	Klub findOneById(Long id);

	Klub findByNazivIgnoreCaseContains(String nazivKluba);

}
