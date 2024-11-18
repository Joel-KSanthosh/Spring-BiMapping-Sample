package com.study.sample.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.study.sample.models.BookManager;

public interface BookManagerRepository extends JpaRepository<BookManager, Long>{

    
} 