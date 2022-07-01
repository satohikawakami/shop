package com.exampe.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.exampe.entity.Review;
import com.exampe.entity.ReviewForm;
import com.exampe.service.ReviewService;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/review")
@RequiredArgsConstructor

public class ReviewController {
	
	private final ReviewService reviewService;
	
	@GetMapping("form/{id}")
	public String form(@PathVariable Integer id,
			ReviewForm reviewForm,
			Model model){
		model.addAttribute("product", reviewService.findById(id));
		return "shops/reviewForm";
	}
	
	@PostMapping("reviewConfirm")
	public String reviewConfirm(@Validated ReviewForm reviewForm,
			BindingResult result,
			Model model) {
		if(result.hasErrors()) {
			return "shops/reviewForm";
		}
			return "shops/reviewConfirm";
		}
	
	@PostMapping("reviewComplete")
	public String reviewComplete(@Validated ReviewForm reviewForm,
			BindingResult result,
			RedirectAttributes redirectAttributes) {
		if(result.hasErrors()) {
			return "shops/index";
		}
		
			Review review = new Review();
			review.setId(reviewForm.getId());
			review.setName(reviewForm.getUserName());
			review.setDate(reviewForm.getDate());
			review.setContents(reviewForm.getContents());
			
			reviewService.saveAndFlush(review);
			redirectAttributes.addFlashAttribute("reviewComplete", "レビューを受け付けました。ご協力ありがとうございました。");
			return "redirect:/shop/index";
		}
	
	
}


