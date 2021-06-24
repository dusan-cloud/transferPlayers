package zavrsni.support;

import java.util.ArrayList;
import java.util.List;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import zavrsni.model.Klub;
import zavrsni.web.dto.KlubDTO;

@Component
public class KlubToKlubDto implements Converter<Klub, KlubDTO>{

	
	
	@Override
	public KlubDTO convert(Klub klub) {
		KlubDTO KlubDTO = new KlubDTO();
		KlubDTO.setId(klub.getId());
		KlubDTO.setNaziv(klub.getNaziv());
		KlubDTO.setBudzet(klub.getBudzet());
		
		return KlubDTO;
	}

	
	public List<KlubDTO> convert(List<Klub> klubovi) {
		List<KlubDTO> klubDTO = new ArrayList<>();
		
		for (Klub klub : klubovi) {
			klubDTO.add(convert(klub));
		}
		
		return klubDTO;
	}
}
