package zavrsni.support;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import zavrsni.model.Transfer;
import zavrsni.service.IgracService;
import zavrsni.service.KlubService;
import zavrsni.service.TransferService;
import zavrsni.web.dto.TransferDTO;

@Component
public class TransferDtoToTransfer implements Converter<TransferDTO, Transfer>{

	@Autowired
	private TransferService transferService;
	
	@Autowired
	private IgracService igracService;
	
	@Autowired
	private KlubService klubService;
	
	@Override
	public Transfer convert(TransferDTO dto) {
		Transfer transfer;
		
		if(dto.getId() == null) {
			transfer = new Transfer();
		} else {
			transfer = transferService.findOne(dto.getId());
		}
		
		if(transfer != null) {
			transfer.setIgrac(igracService.findOne(dto.getIgracDTO().getId()));
			transfer.setKlub(klubService.findOne(dto.getKlubDTO().getId()));
			transfer.setCenaTransfera(dto.getCenaTransfera());
		}
		
		return transfer;
	}

}
