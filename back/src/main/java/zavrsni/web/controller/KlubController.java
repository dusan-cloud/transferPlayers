package zavrsni.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import zavrsni.model.Klub;
import zavrsni.service.KlubService;
import zavrsni.support.KlubToKlubDto;
import zavrsni.web.dto.KlubDTO;

@RestController
@RequestMapping(value = "/api/klubovi", produces = MediaType.APPLICATION_JSON_VALUE)
public class KlubController {

	@Autowired
	private KlubService klubService;
	
	@Autowired
	private KlubToKlubDto toKlubDto;
	
	@GetMapping
	public ResponseEntity<List<KlubDTO>> getAll() {
		
		List<Klub> klub = klubService.findAll();
		
		return new ResponseEntity<>(toKlubDto.convert(klub), HttpStatus.OK);
	}
	
}
