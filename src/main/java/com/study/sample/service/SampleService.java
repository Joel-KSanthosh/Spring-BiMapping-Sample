package com.study.sample.service;

import com.study.sample.dto.AdminDTO;
import com.study.sample.dto.BookDTO;
import com.study.sample.dto.BookManagerDTO;
import com.study.sample.dto.ManagerDTO;
import com.study.sample.dto.UserDTO;
import com.study.sample.models.User;

public interface SampleService {

    void insertBook(BookDTO bookDTO);
    void insertUser(UserDTO userDTO);
    void insertAdmin(AdminDTO adminDTO);
    void insertManager(ManagerDTO managerDTO);
    void insertBookManager(BookManagerDTO bookManagerDTO);

    User getUserById(Long id);

}
