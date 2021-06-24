package zavrsni.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import zavrsni.model.Klub;
import zavrsni.repository.KlubRepository;
import zavrsni.service.KlubService;

@Service
public class JpaKlubService implements KlubService{

	@Autowired
	private KlubRepository klubRepository;
	
	
	@Override
	public Klub findOne(Long id) {
		// TODO Auto-generated method stub
		return klubRepository.findOneById(id);
	}


	@Override
	public List<Klub> findAll() {
		// TODO Auto-generated method stub
		return klubRepository.findAll();
	}


	@Override
	public Klub findOne(String nazivKluba) {
		// TODO Auto-generated method stub
		return klubRepository.findByNazivIgnoreCaseContains(nazivKluba);
	}


	@Override
	public Klub save(Klub klub) {
		// TODO Auto-generated method stub
		return klubRepository.save(klub);
	}

}
