package hu.storagehamster.www.repository;

import hu.storagehamster.www.entity.Shelf;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.validation.Valid;
import java.util.List;

@Repository
public interface ShelfRepository extends JpaRepository<Shelf, String> {
	Shelf saveAndFlush(@Valid Shelf shelfToSave);

	List<Shelf> findAll();

	Shelf findByLoco(String loco);

	public void deleteByLoco(String loco);
}