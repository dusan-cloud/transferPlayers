package zavrsni.support;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import zavrsni.model.Igrac;
import zavrsni.service.IgracService;
import zavrsni.service.KlubService;
import zavrsni.web.dto.IgracDTO;

@Component
public class IgracDtoToIgrac implements Converter<IgracDTO, Igrac>{

	@Autowired
	private IgracService igracService;
	
	@Autowired
	private KlubService klubService;
	
	@Override
	public Igrac convert(IgracDTO dto) {
		Igrac igrac;
		
		if(dto.getId() == null) {
			igrac = new Igrac();
		} else {
			igrac = igracService.findOne(dto.getId());
		}
		
		if(igrac != null) {
			igrac.setImeIPrezime(dto.getImeIPrezime());
			igrac.setPozicija(dto.getPozicija());
			igrac.setBrojDresa(dto.getBrojDresa());
			igrac.setDatumRodjenja(getLocalDate(dto.getDatumRodjenja()));
			igrac.setNaProdaju(dto.isNaProdaju());
			igrac.setKlub(klubService.findOne(dto.getKlubDTO().getId()));	
			
		}
		
		return igrac;
	}

	private LocalDate getLocalDate(String datumFestival) throws DateTimeParseException {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate datum = LocalDate.parse(datumFestival, formatter);
        return datum;
    }
	
}
