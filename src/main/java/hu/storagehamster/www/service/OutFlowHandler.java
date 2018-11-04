package hu.storagehamster.www.service;

import hu.storagehamster.www.entity.Outflow;
import hu.storagehamster.www.entity.OutflowWrapper;
import hu.storagehamster.www.entity.Pallet;
import hu.storagehamster.www.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class OutFlowHandler {
	private final ProductService productService;
	private final PalletService palletService;

	@Autowired
	public OutFlowHandler(ProductService productService, PalletService palletService) {
		this.productService = productService;
		this.palletService = palletService;
	}

	@Transactional
	public void handleOutflow(OutflowWrapper outflowWrapper){

		outflowWrapper.getOutflows()
						.stream()
						.map(this::queryTopNById)
						.forEach(this::deletePallets);
	}

	public List<Product> findAllProducts() {
		return productService.findall();
	}

	private List<Pallet> queryTopNById(Outflow outflow) {

		PageRequest request = PageRequest.of(0, outflow.getQuantity());
		Page<Pallet> pallets = palletService.findByproduct_id(outflow.getProductID(), request);
		return pallets.getContent();
	}

	private void deletePallets(List<Pallet> pallets){
		palletService.deletePallets(pallets);
	}
}
