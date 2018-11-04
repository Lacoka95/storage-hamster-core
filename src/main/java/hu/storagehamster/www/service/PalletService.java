package hu.storagehamster.www.service;

import hu.storagehamster.www.Exception.NotEnughPalletsException;
import hu.storagehamster.www.entity.Pallet;
import hu.storagehamster.www.repository.PalletReposirory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PalletService {
	@Autowired
	PalletReposirory palletReposirory;

	public void save(Pallet pallet) {

		palletReposirory.save(pallet);
	}

	public Page<Pallet> findByproduct_id(Long id, Pageable pageable) throws NotEnughPalletsException {

		Page<Pallet> pallets = palletReposirory.findByProduct_id(id, pageable);

		if (pallets.getTotalElements() < pageable.getPageSize()) {
			throw new NotEnughPalletsException("could not find requested member of pallets");
		}
		return pallets;
	}
	public void deletePallets(List<Pallet> pallets){
		palletReposirory.deleteInBatch(pallets);
	}
}
