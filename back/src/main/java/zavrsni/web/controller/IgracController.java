package zavrsni.web.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import zavrsni.model.Igrac;
import zavrsni.service.IgracService;
import zavrsni.support.IgracDtoToIgrac;
import zavrsni.support.IgracToIgracDto;
import zavrsni.web.dto.IgracDTO;

@RestController
@RequestMapping(value = "/api/igraci", produces = MediaType.APPLICATION_JSON_VALUE)
public class IgracController {

	@Autowired
	private IgracService igracService;
	
	@Autowired
	private IgracDtoToIgrac toIgrac;
	
	@Autowired
	private IgracToIgracDto toIgracDto;
	
	
	@PreAuthorize("hasRole('ADMIN')")
	 @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	    public ResponseEntity<IgracDTO> create(@Valid @RequestBody IgracDTO igracDTO){
		 Igrac igrac = toIgrac.convert(igracDTO);

	        if(igrac.getKlub() == null) {
	            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	        }
	        
	        
	        Igrac sacuvanIgrac= igracService.save(igrac);

	        return new ResponseEntity<>(toIgracDto.convert(sacuvanIgrac), HttpStatus.CREATED);
	    }
	
	@PreAuthorize("hasRole('ADMIN')")
	 @PutMapping(value= "/{id}",consumes = MediaType.APPLICATION_JSON_VALUE)
	    public ResponseEntity<IgracDTO> update(@PathVariable Long id, @Valid @RequestBody IgracDTO igracDTO){

	        if(!id.equals(igracDTO.getId())) {
	            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	        }

	        Igrac igrac = toIgrac.convert(igracDTO);

	        if(igrac.getKlub() == null) {
	            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	        }

	        Igrac sacuvanIgrac = igracService.update(igrac);

	        return new ResponseEntity<>(toIgracDto.convert(sacuvanIgrac),HttpStatus.OK);
	    }
	
	@GetMapping
	public ResponseEntity<List<IgracDTO>> getAll(
			@RequestParam (required = false) String pozicija,
			@RequestParam (required = false) Long klubId,
			@RequestParam (value = "pageNo", defaultValue = "0") int pageNo) {
		
		
		Page<Igrac> page = igracService.findAll(pozicija, klubId, pageNo);
		
		HttpHeaders headers = new HttpHeaders();
        headers.add("Total-Pages", Integer.toString(page.getTotalPages()));
		
		return new ResponseEntity<>(toIgracDto.convert(page.getContent()), headers, HttpStatus.OK);
		
	}
	
	
	@GetMapping("/{id}")
	public ResponseEntity<IgracDTO> getOne(@PathVariable Long id) {
		Igrac igrac = igracService.findOne(id);
		
		if(igrac != null) {
			return new ResponseEntity<>(toIgracDto.convert(igrac), HttpStatus.OK);
		} 
		
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);	
				
	}
	
	@PreAuthorize("hasRole('ADMIN')")
	@DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
		Igrac obrisanIgrac = igracService.delete(id);

        if(obrisanIgrac != null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
