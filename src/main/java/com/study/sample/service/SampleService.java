package com.study.sample.service;

import java.util.List;

import com.study.sample.dto.AdminDTO;
import com.study.sample.dto.BookDTO;
import com.study.sample.dto.BookManagerDTO;
import com.study.sample.dto.BorrowDTO;
import com.study.sample.dto.ManagerDTO;
import com.study.sample.dto.UserDTO;

public interface SampleService {

    void insertBook(BookDTO bookDTO);
    void insertUser(UserDTO userDTO);
    void insertAdmin(AdminDTO adminDTO);
    void insertManager(ManagerDTO managerDTO);
    void borrowBook(BookManagerDTO bookManagerDTO);

    UserDTO getUserById(Long id);
    List<BorrowDTO> getUsersBorrowListById(Long id);
    String returnBook(Long userId, Long bookId);
    

}
