package hu.storagehamster.www.repository;

import hu.storagehamster.www.entity.Pallet;
import hu.storagehamster.www.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.validation.Valid;
import java.util.List;

public interface PalletReposirory extends JpaRepository<Pallet, Long> {
	Pallet save(@Valid Pallet palletTosave);
	Page<Pallet> findByProduct_id(Long id, Pageable pageable);
	void deleteInBatch(Iterable<Pallet> pallets);
}
