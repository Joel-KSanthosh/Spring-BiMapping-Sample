package com.study.sample.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.study.sample.models.Book;

public interface BookRepository extends JpaRepository<Book, Long>{

}
