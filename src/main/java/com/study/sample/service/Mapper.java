package com.study.sample.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.study.sample.dto.AdminDTO;
import com.study.sample.dto.BookDTO;
import com.study.sample.dto.ManagerDTO;
import com.study.sample.dto.UserDTO;
import com.study.sample.models.Book;
import com.study.sample.models.BookManager;
import com.study.sample.models.User;

@Service
public class Mapper {

    public Book toBook(BookDTO bookDTO){

        Book book = new Book();
        book.setTitle(bookDTO.getTitle());
        book.setAuthor(bookDTO.getAuthor());
        book.setPublisher(bookDTO.getPublisher());
        book.setPublished_on(bookDTO.getPublished_on());
        book.setQuantity(bookDTO.getQuantity());
        return book;

    }

    public User toUser(UserDTO userDTO){

        User user = new User();
        user.setEmail(userDTO.getEmail());
        user.setName(userDTO.getName());
        user.setPassword(userDTO.getPassword());
        user.setRole(userDTO.getRole());
        return user;
    }

    public User toAdmin(AdminDTO userDTO){

        User user = new User();
        user.setEmail(userDTO.getEmail());
        user.setName(userDTO.getName());
        user.setPassword(userDTO.getPassword());
        user.setRole(userDTO.getRole());
        return user;
    }

    public User toManager(ManagerDTO userDTO){

        User user = new User();
        user.setEmail(userDTO.getEmail());
        user.setName(userDTO.getName());
        user.setPassword(userDTO.getPassword());
        user.setRole(userDTO.getRole());
        return user;
    }

    public BookManager toBookManager(Optional<Book> book, Optional<User> user){
        BookManager bookManager = new BookManager();
        bookManager.setBook(book.get());
        bookManager.setUser(user.get());
        return bookManager;
    }
    
}
