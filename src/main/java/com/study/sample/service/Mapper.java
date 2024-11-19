package com.study.sample.service;


import org.springframework.stereotype.Service;

import com.study.sample.dto.AdminDTO;
import com.study.sample.dto.BookDTO;
import com.study.sample.dto.BorrowDTO;
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

    public BookManager toBookManager(Book book, User user){
        BookManager bookManager = new BookManager();
        bookManager.setBook(book);
        bookManager.setUser(user);
        return bookManager;
    }

    public UserDTO toUserDTO(User user){
        UserDTO userDTO = new UserDTO();
        userDTO.setEmail(user.getEmail());
        userDTO.setName(user.getName());
        userDTO.setPassword(user.getPassword());
        userDTO.setRole(user.getRole());

        return userDTO;
    }

    public BorrowDTO toBorrowDTO(BookManager bookManager){
        BorrowDTO borrow = new BorrowDTO();
        borrow.setId(bookManager.getId());
        borrow.setTitle(bookManager.getBook().getTitle());
        borrow.setBorrowed_on(bookManager.getBorrowed_on());
        borrow.setReturned_on(bookManager.getReturned_on());
        borrow.setUsername(bookManager.getUser().getName());

        return borrow;
    }
    
}
