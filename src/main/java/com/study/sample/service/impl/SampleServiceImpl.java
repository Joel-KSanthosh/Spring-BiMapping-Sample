package com.study.sample.service.impl;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.study.sample.dto.AdminDTO;
import com.study.sample.dto.BookDTO;
import com.study.sample.dto.BookManagerDTO;
import com.study.sample.dto.BorrowDTO;
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

    @Transactional
    @Override
    public void borrowBook(BookManagerDTO bookManagerDTO) {
        Book book = bookRepository.findById(bookManagerDTO.getBook()).get();
        User user = userRepository.findById(bookManagerDTO.getUser()).get();
        if (book != null && user != null) {
            book.setQuantity(validateQuantityAndDecrement(book.getQuantity()));
            List<BookManager> check = bookManagerRepository.findAllByUserAndBook(user, book);
            BookManager val = check.get(check.size()-1);
            if(val.getReturned_on() == null){
                throw new IllegalArgumentException("You have already borrowed the same book and not returned");
            }
            BookManager bookManager = mapper.toBookManager(book, user);
            bookRepository.save(book);
            bookManagerRepository.save(bookManager);
        }
        else{
            throw new IllegalArgumentException("Error");
        }
        
    }

    @Override
    public UserDTO getUserById(Long id) {
        UserDTO user = mapper.toUserDTO(userRepository.findById(id).get());
        return user;
    }

    public List<BorrowDTO> getUsersBorrowListById(Long id){
        List<BookManager> bookManagers = bookManagerRepository.findAllByUserId(id);
        List<BorrowDTO> borrows = new ArrayList<>();
        for(BookManager book : bookManagers){
            borrows.add(mapper.toBorrowDTO(book));
        }
        return borrows;
    }

    private Long validateQuantityAndDecrement(Long quantity){
        if(quantity < 1){
            throw new IllegalArgumentException("Selected Book is current unavailable");
        }
        return --quantity;
    }

    private Long incrementAndGet(Long quantity){
        return ++quantity;
    }

    public String returnBook(Long userId, Long bookId){
        BookManager bookManager = bookManagerRepository.findFirstByUserIdAndBookIdOrderByIdDesc(userId, bookId);
        if(bookManager.getReturned_on() !=null ){
            throw new IllegalArgumentException("You have not borrowed the given book or already returned");
        }
        Book book = bookManager.getBook();
        book.setQuantity(incrementAndGet(book.getQuantity()));
        Date returnDate = new Date(Calendar.getInstance().getTime().getTime());
        bookManager.setReturned_on(returnDate);
        bookManagerRepository.save(bookManager);
        bookRepository.save(book);
        return "Successfully Returned Book with name "+ bookManager.getBook().getTitle();
    }
    

}
