package hu.storagehamster.www.service;

import hu.storagehamster.www.Exception.ShelfOutOfCapacityException;
import hu.storagehamster.www.entity.Inflow;
import hu.storagehamster.www.entity.Pallet;
import hu.storagehamster.www.entity.Product;
import hu.storagehamster.www.entity.Shelf;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InflowHandler {


	private final ProductService productService;
	private final ShelfService shelfService;
	private final PalletService palletService;

	@Autowired
	public InflowHandler(ProductService productService, ShelfService shelfService, PalletService palletService) {
		this.productService = productService;
		this.shelfService = shelfService;
		this.palletService = palletService;
	}

	public void handleInflow(Inflow inflow) throws ShelfOutOfCapacityException {

		Shelf shelf = shelfService.findByLoco(inflow.getShelfId());

		Product product = productService.findById(inflow.getProductId());

		Pallet pallet = new Pallet(inflow.getQuantity(), product);
		palletService.save(pallet);

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

