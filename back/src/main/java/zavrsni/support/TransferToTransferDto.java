package zavrsni.support;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import zavrsni.model.Transfer;
import zavrsni.web.dto.TransferDTO;

@Component
public class TransferToTransferDto implements Converter<Transfer, TransferDTO>{

	@Autowired
	private IgracToIgracDto toIgracDto;
	
	@Autowired
	private KlubToKlubDto toKlubDto;
	
	@Override
	public TransferDTO convert(Transfer transfer) {
		TransferDTO transferDTO = new TransferDTO();
		transferDTO.setId(transfer.getId());
		transferDTO.setIgracDTO(toIgracDto.convert(transfer.getIgrac()));
		transferDTO.setKlubDTO(toKlubDto.convert(transfer.getKlub()));
		transferDTO.setCenaTransfera(transfer.getCenaTransfera());
		
		
		return transferDTO;
	}
	public List<TransferDTO> convert(List<Transfer> transferi) {
		List<TransferDTO> transferDTO = new ArrayList<>();
		
		for (Transfer transfer : transferi) {
			transferDTO.add(convert(transfer));
		}
		
		return transferDTO;
	}
	
}
