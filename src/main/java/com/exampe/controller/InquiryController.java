package com.exampe.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.exampe.entity.Inquiry;
import com.exampe.forms.InquiryForm;
import com.exampe.service.InquiryService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Controller 
@RequestMapping("/contact")
public class InquiryController {

	private final InquiryService inquiryService;	

	@GetMapping("/inquiry")
	public String inquiry(InquiryForm inquiryForm) {
		return "inquirys/inquiryForm";
	}

	@PostMapping("/inquiry")
	public String inquiryBack(InquiryForm inquiryForm) {
		return "inquirys/inquiryForm";
	}

	@PostMapping("/inquiryConfirm")
	public String inquiryConfirm(@Validated InquiryForm inquiryForm,
			BindingResult result,
			Model model) {
		if(result.hasErrors()) {
			return "inquirys/inquiryForm";
		}
		return "inquirys/inquiryConfirm";
	}

	@PostMapping("/inquiryComplete")
	public String inquirComplete(@Validated InquiryForm inquiryForm,
			BindingResult result,
			Model model,
			RedirectAttributes redirectAttributes) {
		if(result.hasErrors()) {
			return "inquirys/inquiryForm";
		}

		Inquiry inquiry = new Inquiry();
		inquiry.setName(inquiryForm.getName());
		inquiry.setKana(inquiryForm.getKana());
		inquiry.setEmail(inquiryForm.getEmail());
		inquiry.setComment(inquiryForm.getComment());

		inquiryService.save(inquiry);	
		redirectAttributes.addFlashAttribute("inquiryComplete", "お問い合わせありがとうございました。");
		return "redirect:/contact/inquiry";
	}
}