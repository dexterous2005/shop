package ru.eastmarket.controller.category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ru.eastmarket.entity.category.Category;
import ru.eastmarket.entity.category.CategoryService;

import java.util.List;

/**
 * @author Dmitry Dobrin.
 * @created 11.09.2018.
 */
@RestController
@RequestMapping("category")
public class CategoryController {

	private final CategoryService categoryService;

	@Autowired
	public CategoryController(CategoryService categoryService) {
		this.categoryService = categoryService;
	}

	@RequestMapping(value = "/get", method = RequestMethod.GET)
	public List<Category> getCategories() {
		return categoryService.getCategories();
	}
}
