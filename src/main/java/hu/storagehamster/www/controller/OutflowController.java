package hu.storagehamster.www.controller;

import hu.storagehamster.www.entity.OutflowWrapper;
import hu.storagehamster.www.entity.Product;
import hu.storagehamster.www.service.OutFlowHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.List;

@Controller
public class OutflowController {
	private static final Logger log = LoggerFactory.getLogger(OutflowController.class);
	private final OutFlowHandler outFlowHandler;

	@Autowired
	public OutflowController(OutFlowHandler outFlowHandler) {
		this.outFlowHandler = outFlowHandler;
	}

	@GetMapping("/outflow")
	public String getOutflow(@ModelAttribute("outflowWrapper") OutflowWrapper outflowWrapper, Model model) {
		List<Product> productList = outFlowHandler.findAllProducts();
		model.addAttribute("productsFromDB", productList);
		return "outflow";
	}

	@PostMapping("/outflow")
	public String handleOutflow(@ModelAttribute("outflowWrapper") @Valid OutflowWrapper outflowWrapper, Model model) throws Exception {
		log.debug("outflowWrapper = {}", outflowWrapper);

		outFlowHandler.handleOutflow(outflowWrapper);
		return "outflow";
	}
}
