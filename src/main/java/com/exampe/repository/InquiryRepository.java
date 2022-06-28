package com.exampe.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.exampe.entity.Inquiry;

@Repository
public interface InquiryRepository extends JpaRepository<Inquiry, Integer>{
	
}
