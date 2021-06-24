package zavrsni.service;

import java.util.List;

import zavrsni.model.Klub;

public interface KlubService {

	Klub findOne(Long id);

	List<Klub> findAll();

	Klub findOne(String nazivKluba);

	Klub save(Klub klub);

}
