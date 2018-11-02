package hu.storagehamster.www.controller;

import hu.storagehamster.www.entity.Shelf;
import hu.storagehamster.www.service.ShelfService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("management/shelf")
public class ShelfController {
	private final Logger log = LoggerFactory.getLogger(ProductController.class);

	private final ShelfService shelfService;

	@Autowired
	public ShelfController(ShelfService shelfService) {
		this.shelfService = shelfService;
	}

	@GetMapping("insert")
	public String getShelfHtml(@ModelAttribute("shelfForm") Shelf shelf) {
		log.debug("GET:management/shelf");
		return "management/shelf/shelfinsert";
	}

	@PostMapping("insert")
	public String saveSubmitedShelfToDB(@ModelAttribute("shelfForm") @Valid Shelf shelf,
																			BindingResult bindingResult) {
		log.debug("POST:management/shelf/insert");
		if (bindingResult.hasErrors()) {
			bindingResult.reject("management.shelf.inclompeteInput");
			return "management/shelf/shelfinsert";
		} else {
			shelfService.save(shelf);
			return "management/shelf/shelfinsert";
		}
	}

	@GetMapping("update")
	public String getShelfUpdate(@ModelAttribute("shelfForm") Shelf shelf, Model model) {
		List<Shelf> shelfList = shelfService.findall();
		model.addAttribute("shelvesFromDB", shelfList);
		return "management/shelf/shelfupdate";

	}

	@PostMapping("update")
	public String changeShelfInDB(@ModelAttribute("shelfForm") @Valid Shelf shelf, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			bindingResult.reject("management.shelf.inclompeteInput");
			return "management/shelf/shelfupdate";
		} else {
			shelfService.save(shelf);
			return "management/shelf/shelfupdate";
		}
	}

	@GetMapping("delete")
	public String getShelfDelete(@ModelAttribute("shelfForm") Shelf shelf, Model model) {
		List<Shelf> shelfList = shelfService.findall();
		model.addAttribute("shelvesFromDB", shelfList);
		return "management/shelf/shelfdelete";

	}

	@PostMapping("delete")
	@Transactional
	public String deleteShelfInDB(@ModelAttribute("shelfForm") Shelf shelf) {
		log.debug("shelf{}", shelf);
		shelfService.deleteByLoco(shelf.getLoco());
		return "management/shelf/shelfdelete";
	}

}

