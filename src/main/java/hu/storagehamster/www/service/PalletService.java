package hu.storagehamster.www.service;

import hu.storagehamster.www.entity.Pallet;
import hu.storagehamster.www.repository.PalletReposirory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PalletService {
	@Autowired
	PalletReposirory palletReposirory;

	public void save(Pallet pallet) {
		palletReposirory.saveAndFlush(pallet);
	}

}
