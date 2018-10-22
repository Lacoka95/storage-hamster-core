package hu.storagehamster.www.repository;

import hu.storagehamster.www.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.validation.Valid;
import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
	Product saveAndFlush(@Valid Product productTosave);

	List<Product> findAll();

	Product findById(long id);
}
