package hu.storagehamster.www.controller;


import hu.storagehamster.www.Exception.ShelfOutOfCapacityException;
import hu.storagehamster.www.entity.Inflow;
import hu.storagehamster.www.entity.Product;
import hu.storagehamster.www.entity.Shelf;
import hu.storagehamster.www.service.InflowHandler;
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
@RequestMapping("/inflow")
public class InflowController {

	private static final Logger log = LoggerFactory.getLogger(InflowController.class);
	private final InflowHandler inflowHandler;

	@Autowired
	public InflowController(InflowHandler inflowHandler) {
		this.inflowHandler = inflowHandler;
	}

	@GetMapping
	public String getInflow(@ModelAttribute("inflow") Inflow inflow, Model model) {

		List<Product> productList = inflowHandler.findAllProduct();
		model.addAttribute("ProductsfromDB", productList);

		List<Shelf> shelfList = inflowHandler.findAllShelf();
		model.addAttribute("shelvesFromDB", shelfList);

		return "inflow";
	}

	@PostMapping
	public String addPallet(@ModelAttribute("inflow") @Valid Inflow inflow, BindingResult bindingResult) throws ShelfOutOfCapacityException {
		log.debug("inflow{}", inflow);

		inflowHandler.handleInflow(inflow);
		return "inflow";
	}


}
