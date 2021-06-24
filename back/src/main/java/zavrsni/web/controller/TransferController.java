package zavrsni.web.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import zavrsni.model.Transfer;
import zavrsni.service.TransferService;
import zavrsni.support.TransferDtoToTransfer;
import zavrsni.support.TransferToTransferDto;
import zavrsni.web.dto.TransferDTO;

@RestController
@RequestMapping(value = "/api/transferi", produces = MediaType.APPLICATION_JSON_VALUE)
public class TransferController {

	@Autowired
	private TransferService transferService;
	
	@Autowired
	private TransferDtoToTransfer toTransfer;
	
	@Autowired
	private TransferToTransferDto toTransferDto;
	
	@PreAuthorize("hasRole('KORISNIK')")
	@GetMapping("/{id}")
	public ResponseEntity<TransferDTO> getOne(@PathVariable Long id) {
		Transfer transfer = transferService.findOne(id);
		
		if(transfer != null) {
			return new ResponseEntity<>(toTransferDto.convert(transfer), HttpStatus.OK);
		} 
		
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);	
				
	}
	
	@PreAuthorize("hasRole('ADMIN')")
	 @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	    public ResponseEntity<TransferDTO> create(@Valid @RequestBody TransferDTO transferDTO){
		 Transfer transfer = toTransfer.convert(transferDTO);

	        if(transfer.getKlub() == null) {
	            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	        }
	        
	        if(transfer.getIgrac() == null) {
	        	return new ResponseEntity<TransferDTO>(HttpStatus.BAD_REQUEST);
	        }
	        
	        if(transfer.getKlub().getBudzet() < transfer.getCenaTransfera()) {
	        	return new ResponseEntity<TransferDTO>(HttpStatus.BAD_REQUEST);
	        }
	        
	        
	        Transfer sacuvanTransfer= transferService.save(transfer);

	        return new ResponseEntity<>(toTransferDto.convert(sacuvanTransfer), HttpStatus.CREATED);
	    }	
	
	
}
