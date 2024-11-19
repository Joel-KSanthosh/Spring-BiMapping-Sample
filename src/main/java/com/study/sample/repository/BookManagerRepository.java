package com.study.sample.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.study.sample.models.Book;
import com.study.sample.models.BookManager;
import com.study.sample.models.User;

public interface BookManagerRepository extends JpaRepository<BookManager, Long>{

   List<BookManager> findAllByUserId(Long id);
   List<BookManager> findAllByUserAndBook(User user, Book book);
   BookManager findFirstByUserIdAndBookIdOrderByIdDesc(Long userId, Long bookId);

} 