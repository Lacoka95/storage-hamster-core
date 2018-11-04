package hu.storagehamster.www.service;

import hu.storagehamster.www.entity.Product;
import hu.storagehamster.www.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepository;


	public void save(Product product) {
		productRepository.save(product);
	}

	public List<Product> findall() {
		return productRepository.findAll();
	}

	public Product findById(long id) {
		return productRepository.findById(id);
	}

	public void deleteById(long id) {
		productRepository.deleteById(id);
	}
}
