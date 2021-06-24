package zavrsni.support;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import zavrsni.model.Igrac;
import zavrsni.web.dto.IgracDTO;

@Component
public class IgracToIgracDto implements Converter<Igrac, IgracDTO>{

	@Autowired
	private KlubToKlubDto toKlubDto;
	
	@Override
	public IgracDTO convert(Igrac igrac) {
		IgracDTO igracDTO = new IgracDTO();
		igracDTO.setId(igrac.getId());
		igracDTO.setImeIPrezime(igrac.getImeIPrezime());
		igracDTO.setPozicija(igrac.getPozicija());
		igracDTO.setBrojDresa(igrac.getBrojDresa());
		igracDTO.setDatumRodjenja(igrac.getDatumRodjenja().toString());
		igracDTO.setNaProdaju(igrac.isNaProdaju());
		igracDTO.setKlubDTO(toKlubDto.convert(igrac.getKlub()));
		
		return igracDTO;
	}

	
	public List<IgracDTO> convert(List<Igrac> igraci) {
		List<IgracDTO> igracDTO = new ArrayList<>();
		
		for (Igrac igrac : igraci) {
			igracDTO.add(convert(igrac));
		}
		
		return igracDTO;
	}
}
