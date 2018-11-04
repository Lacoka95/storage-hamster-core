package hu.storagehamster.www.service;

import hu.storagehamster.www.Exception.ShelfOutOfCapacityException;
import hu.storagehamster.www.entity.Pallet;
import hu.storagehamster.www.entity.Shelf;
import hu.storagehamster.www.repository.ShelfRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShelfService {
	@Autowired
	ShelfRepository shelfRepository;

	public void save(Shelf shelf) {
		shelfRepository.save(shelf);
	}

	public List<Shelf> findall() {
		return shelfRepository.findAll();
	}

	public Shelf findByLoco(String loco) {
		return shelfRepository.findByLoco(loco);
	}

	public void deleteByLoco(String loco) {
		shelfRepository.deleteByLoco(loco);
	}

	public void storePallet(Pallet pallet, Shelf shelf) throws ShelfOutOfCapacityException {
		if (shelf.getCapacity() >= 1) {
			shelf.addPallet(pallet);
			shelf.setCapacity(shelf.getCapacity() - 1);

		} else {
			throw new ShelfOutOfCapacityException("shelf has no more free space");
		}
	}
}
