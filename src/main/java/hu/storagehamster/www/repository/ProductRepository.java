package hu.storagehamster.www.repository;

import hu.storagehamster.www.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.validation.Valid;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {
			Product saveAndFlush(@Valid Product productTosave);

}
