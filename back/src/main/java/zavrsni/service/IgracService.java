package zavrsni.service;

import org.springframework.data.domain.Page;

import zavrsni.model.Igrac;

public interface IgracService {

	Igrac findOne(Long id);

	Igrac delete(Long id);

	Page<Igrac> findAll(String pozicija, Long klubId, int pageNo);

	Igrac update(Igrac igrac);

	Igrac save(Igrac igrac);

}
