package zavrsni.service;

import java.util.List;

import zavrsni.model.Transfer;

public interface TransferService {

	Transfer findOne(Long id);

	List<Transfer> findAll();

	Transfer save(Transfer transfer);

}
