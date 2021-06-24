package zavrsni.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import zavrsni.model.Transfer;

@Repository
public interface TransferRepository extends JpaRepository<Transfer, Long>{

	Transfer findOneById(Long id);

}
