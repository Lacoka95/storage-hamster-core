package hu.storagehamster.www.controller;

import hu.storagehamster.www.entity.Product;
import hu.storagehamster.www.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.List;


@Controller
@RequestMapping("/management/product")
public class ProductController {

	private final Logger log = LoggerFactory.getLogger(ProductController.class);
	private final ProductService productService;

	@Autowired
	public ProductController(ProductService productService) {
		this.productService = productService;
	}

	@GetMapping("/insert")
	public String producthtml(@ModelAttribute("productForm") Product product) {
		log.info("GET management/product");
		return "management/product/productinsert";
	}

	@PostMapping("/insert")
	public String saveSubmitedProductToDataBase(@ModelAttribute("productForm") @Valid Product product,
																							BindingResult bindingResult, Model model) {
		log.debug("POST management/product");
		if (bindingResult.hasErrors()) {
			bindingResult.reject("management.product.inclompeteInput");
			return "management/product/productinsert";
		} else {
			try {
				productService.save(product);
			} catch (Exception e) {
				bindingResult.reject("product.error.duplicate");
			}
			return "management/product/productinsert";
		}
	}

	@GetMapping("/update")
	public String getUpdateProduct(@ModelAttribute("productForm") Product product, Model model) {
		List<Product> productList = productService.findall();
		model.addAttribute("ProductsfromDB", productList);

		return "management/product/updateproduct";
	}

	@PostMapping("/update")
	public String changeProductInDB(@ModelAttribute("productForm") @Valid Product product, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			bindingResult.reject("management.product.inclompeteInput");
			return "management/product/updateproduct";
		} else {
			productService.save(product);
			return "management/product/updateproduct";
		}
	}

	@GetMapping("/delete")
	public String getDelete(@ModelAttribute("productForm") Product product, Model model) {
		List<Product> productList = productService.findall();
		model.addAttribute("ProductsfromDB", productList);

		return "management/product/productdelete";
	}

	@PostMapping("/delete")
	public String deleteProductFromDB(@ModelAttribute("productForm") Product product) {
		productService.deleteById(product.getId());
		return "management/product/productdelete";

	}
//	@ExceptionHandler(DataIntegrityViolationException.class)
//	public String handleDuplicateException(Model model){
//		model.addAttribute("productFrom");
//
//		return "management/product/productinsert";
//	}
}
