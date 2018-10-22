package hu.storagehamster.www.controller;

import hu.storagehamster.www.entity.Shelf;
import hu.storagehamster.www.service.ShelfService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class ShelfController {
	private final Logger log = LoggerFactory.getLogger(ProductController.class);
	@Autowired
	ShelfService shelfService;

	@GetMapping("/management/shelf")
	public String getShelfHtml(@ModelAttribute("shelfForm") Shelf shelf) {
		log.debug("GET:management/shelf");
		return "management/shelf";
	}

	@PostMapping("/management/shelf")
	public String saveSubmitedShelfToDB(@ModelAttribute("shelfForm") @Valid Shelf shelf,
																			BindingResult bindingResult) {
		log.debug("POST:management/shelf");
		if (bindingResult.hasErrors()) {
			bindingResult.reject("management.shelf.inclompeteInput");
			return "management/shelf";
		} else {
			shelfService.save(shelf);
			return "management/shelf";
		}
	}
}
