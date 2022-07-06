package com.exampe.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.exampe.entity.Product;
import com.exampe.forms.ProductForm;
import com.exampe.service.ProductService;

@Controller
@RequestMapping("/product")

public class ProductController {

	private final ProductService productService;

	@Autowired
	public ProductController(ProductService productService) {
		this.productService = productService;	
	}


	@GetMapping("/index")
	public String index(Model model){
		List<Product> productList = productService.findAll();
		model.addAttribute("productList", productList);
		return "products/index";
	}

	@GetMapping("/show/{id}")
	public String show(@PathVariable Integer id, Model model) {
		model.addAttribute("product",productService.findById(id));
		return "products/show";
	}

	@GetMapping("/create")
	public String create(ProductForm productForm) {
		return "products/create";
	}

	@PostMapping("/create")
	public String createBack(ProductForm productForm) {
		return "products/create";
	}

	@PostMapping("/create_confirm")
	public String create_confirm(@Validated ProductForm productForm,
			BindingResult result,
			Model model) {
		if(result.hasErrors()){
			return "products/create";
		}
		return "products/create_confirm";
	}

	@PostMapping("/insert")
	public String update(@Validated ProductForm productForm,
			BindingResult result,
			Model model,
			RedirectAttributes redirectAttributes) {
		if(result.hasErrors()) {
			return "product/create";
		}

		Product product = new Product();
		product.setCategory(productForm.getCategory());
		product.setName(productForm.getName());
		product.setPrice(productForm.getPrice());
		product.setDetail(productForm.getDetail());

		productService.save(product);
		redirectAttributes.addFlashAttribute("createComplete", "登録が完了しました");
		return "redirect:/product/index";

	}

	@GetMapping("/edit/{id}")
	public String edit(@PathVariable Integer id, Model model) {	
		model.addAttribute("productForm", productService.findById(id));
		return "products/edit";
	}

	@PostMapping("/edit/{id}")
	public String editBack(@PathVariable Integer id, Model model) {	
		model.addAttribute("productForm", productService.findById(id));
		return "products/edit";
	}

	@PostMapping("/edit_confirm/{id}")
	public String edit_confirm(@ModelAttribute @Validated ProductForm productForm,
			BindingResult result,
			Model model) {
		if(result.hasErrors()) {
			return "products/edit";
		}
		return "products/edit_confirm";
	}

	@PostMapping("/update/{id}")
	public String update(@PathVariable Integer id,
			ProductForm productForm,
			RedirectAttributes redirectAttributes) {

		Product product = new Product();
		product.setId(productForm.getId());
		product.setCategory(productForm.getCategory());
		product.setName(productForm.getName());
		product.setPrice(productForm.getPrice());
		product.setDetail(productForm.getDetail());	

		productService.save(product);
		redirectAttributes.addFlashAttribute("update", "更新が完了しました");
		return "redirect:/product/index";
	}

	@GetMapping("/delete/{id}")
	public String delete(@PathVariable Integer id, Model model) {
		model.addAttribute("productForm", productService.findById(id));
		return "products/delete_confirm";
	}

	@PostMapping("/delete_complete/{id}")
	public String delete_complete(@PathVariable Integer id,
			RedirectAttributes redirectAttributes,
			Model model) {

		productService.delete(id);
		redirectAttributes.addFlashAttribute("delete", "削除が完了しました");
		return "redirect:/product/index";
	}
}