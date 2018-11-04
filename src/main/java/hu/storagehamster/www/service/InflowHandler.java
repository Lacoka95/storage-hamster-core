package hu.storagehamster.www.service;

import hu.storagehamster.www.Exception.ShelfOutOfCapacityException;
import hu.storagehamster.www.entity.Inflow;
import hu.storagehamster.www.entity.Pallet;
import hu.storagehamster.www.entity.Product;
import hu.storagehamster.www.entity.Shelf;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.IntStream;

@Service
public class InflowHandler {

	private final ProductService productService;
	private final ShelfService shelfService;

	@Autowired
	public InflowHandler(ProductService productService, ShelfService shelfService) {
		this.productService = productService;
		this.shelfService = shelfService;
	}

	public void handleInflow(Inflow inflow) throws ShelfOutOfCapacityException {
		Shelf shelf = shelfService.findByLoco(inflow.getShelfId());
		Product product = productService.findById(inflow.getProductId());

		IntStream.rangeClosed(1, inflow.getNumberOfPallets())
						.forEach(i -> storeShelf(inflow, shelf, product));
	}

	private void storeShelf(Inflow inflow, Shelf shelf, Product product) {
		Pallet pallet = new Pallet(inflow.getNumberOfProductsOnPallet(), product);
		shelfService.storePallet(pallet, shelf);
		shelfService.save(shelf);
	}

	public List<Product> findAllProduct() {
		return productService.findall();
	}

	public List<Shelf> findAllShelf() {
		return shelfService.findall();
	}
}

