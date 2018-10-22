package hu.storagehamster.www.repository;

import hu.storagehamster.www.entity.Pallet;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.validation.Valid;

public interface PalletReposirory extends JpaRepository<Pallet, Long> {
	Pallet saveAndFlush(@Valid Pallet palletTosave);
}
