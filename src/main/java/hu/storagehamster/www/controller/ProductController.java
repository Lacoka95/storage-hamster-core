package hu.storagehamster.www.controller;

import hu.storagehamster.www.entity.Product;
import hu.storagehamster.www.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;


@Controller("/management")
public class ProductController {

	private final Logger log = LoggerFactory.getLogger(ProductController.class);

	@Autowired
	ProductService productService;

	@GetMapping("management/product")
	public String producthtml(@ModelAttribute("productForm") Product product) {
		log.info("GET management/product");
		return "management/product";
	}

	@PostMapping("management/product")
	public String saveSubmitedProductToDataBase(@ModelAttribute("productForm") @Valid Product product,
																							BindingResult bindingResult) {
		log.debug("POST management/product");
		if (bindingResult.hasErrors()) {
			bindingResult.reject("management.product.inclompeteInput");
			return "management/product";
		} else {
			productService.save(product);
			return "management/product";
		}
	}

}
