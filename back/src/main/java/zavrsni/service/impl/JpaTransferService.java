package zavrsni.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import zavrsni.model.Igrac;
import zavrsni.model.Klub;
import zavrsni.model.Transfer;
import zavrsni.repository.TransferRepository;
import zavrsni.service.IgracService;
import zavrsni.service.KlubService;
import zavrsni.service.TransferService;

@Service
public class JpaTransferService implements TransferService{

	@Autowired
	private TransferRepository transferRepository;
	
	@Autowired
	private KlubService klubService;
	
	@Autowired
	private IgracService igracService;
	
	@Override
	public Transfer findOne(Long id) {
		// TODO Auto-generated method stub
		return transferRepository.findOneById(id);
	}

	@Override
	public List<Transfer> findAll() {
		// TODO Auto-generated method stub
		return transferRepository.findAll();
	}

	@Override
	public Transfer save(Transfer transfer) {
		Igrac igrac = transfer.getIgrac();
		Klub klub = transfer.getKlub();
		igrac.setKlub(klub);
		double budzet = klub.getBudzet() - transfer.getCenaTransfera();
		klub.setBudzet(budzet);
		klub.getIgraci().add(igrac);
		klub.getTransferi().add(transfer);
		igrac.getTransferi().add(transfer);
		
		klub = klubService.save(klub);
		igrac = igracService.save(igrac);
						
		
		return transferRepository.save(transfer);
	}

}
