package com.study.sample.service.impl;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.study.sample.dto.AdminDTO;
import com.study.sample.dto.BookDTO;
import com.study.sample.dto.BookManagerDTO;
import com.study.sample.dto.ManagerDTO;
import com.study.sample.dto.UserDTO;
import com.study.sample.models.Book;
import com.study.sample.models.BookManager;
import com.study.sample.models.User;
import com.study.sample.repository.BookManagerRepository;
import com.study.sample.repository.BookRepository;
import com.study.sample.repository.UserRepository;
import com.study.sample.service.Mapper;
import com.study.sample.service.SampleService;

@Service
public class SampleServiceImpl implements SampleService{

    private final BookRepository bookRepository;
    private final UserRepository userRepository;
    private final BookManagerRepository bookManagerRepository;

    private final Mapper mapper;

    public SampleServiceImpl(BookRepository bookRepository, UserRepository userRepository, BookManagerRepository bookManagerRepository,Mapper mapper){
        this.bookRepository = bookRepository;
        this.userRepository = userRepository;
        this.bookManagerRepository = bookManagerRepository;
        this.mapper = mapper; 
    }

    @Override
    public void insertBook(BookDTO bookDTO) {
        Book book = mapper.toBook(bookDTO);
        bookRepository.save(book);
    }

    @Override
    public void insertUser(UserDTO userDTO) {
        User user = mapper.toUser(userDTO);
        userRepository.save(user);
    }

    @Override
    public void insertAdmin(AdminDTO adminDTO) {
        User user = mapper.toAdmin(adminDTO);
        userRepository.save(user);
    }

    @Override
    public void insertManager(ManagerDTO managerDTO) {
        User user = mapper.toManager(managerDTO);
        userRepository.save(user);
    }

    @Override
    public void insertBookManager(BookManagerDTO bookManagerDTO) {
        Optional<Book> book = bookRepository.findById(bookManagerDTO.getBook());
        Optional<User> user = userRepository.findById(bookManagerDTO.getUser());
        if (book.isPresent() && user.isPresent()) {
            BookManager bookManager = mapper.toBookManager(book, user);
            bookManagerRepository.save(bookManager);
        }
        else{
            throw new IllegalArgumentException("Error");
        }
        
    }

    @Override
    public User getUserById(Long id) {
        User user = userRepository.findById(id).get();
        return user;
    }

    

}
