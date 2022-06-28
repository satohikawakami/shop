package com.exampe.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exampe.entity.Inquiry;
import com.exampe.repository.InquiryRepository;

@Service
public class InquiryService {
	private final InquiryRepository inquiryRepository;
	
	@Autowired
	public InquiryService(InquiryRepository inquiryRepository) {
		this.inquiryRepository = inquiryRepository;
	}
	
	public Inquiry save(Inquiry inquiry) {
		return inquiryRepository.save(inquiry);
	}
	
	
}