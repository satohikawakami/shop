package com.exampe.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.exampe.entity.Review;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Integer>{

}
