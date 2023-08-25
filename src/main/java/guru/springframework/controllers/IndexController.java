package guru.springframework.controllers;

import guru.springframework.domian.Category;
import guru.springframework.domian.UnitOfMeasure;
import guru.springframework.repositories.CategoryRepository;
import guru.springframework.repositories.UnitOfMeasureRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller
public class IndexController {

	private final CategoryRepository categoryRepository;
	private final UnitOfMeasureRepository unitOfMeasureRepository;

	public IndexController(CategoryRepository categoryRepository, UnitOfMeasureRepository unitOfMeasureRepository)
	{
		this.categoryRepository = categoryRepository;
		this.unitOfMeasureRepository = unitOfMeasureRepository;
	}

	@RequestMapping({"","/","/index"})
	public String getIndexPage(Model model){

		Optional<Category> category = categoryRepository.findByDescription("American");
		Optional<UnitOfMeasure> unitOfMeasure = unitOfMeasureRepository.findByDescription("Pinch");

		System.out.println("Category Id is:"+ category.get().getId());
		System.out.println("UnitOfMeasure Id is:"+ unitOfMeasure.get().getId());

		return "index";

	}
}
