package com.study.sample.controller;

import org.springframework.web.bind.annotation.RestController;

import com.study.sample.dto.AdminDTO;
import com.study.sample.dto.BookDTO;
import com.study.sample.dto.BookManagerDTO;
import com.study.sample.models.User;
import com.study.sample.service.SampleService;

import jakarta.validation.Valid;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;



@RestController
public class SampleController {

    private final SampleService sampleService;

    public SampleController(SampleService sampleService){
        this.sampleService = sampleService;
    }

    @PostMapping("/book")
    public ResponseEntity<?> insertBook(@Valid @RequestBody BookDTO book) {
        sampleService.insertBook(book);
        Map<String,String> response = new HashMap<>();
        response.put("message", "Successfully Inserted Book -> "+ book.getTitle());
        return new ResponseEntity<>(response,HttpStatus.CREATED);
    }


    @PostMapping("/admin")
    public ResponseEntity<?> insertAdmin(@Valid @RequestBody AdminDTO admin) {
        sampleService.insertAdmin(admin);
        Map<String, String> response = new HashMap<>();
        response.put("message", "Sucessfully Inserted Admin -> "+ admin.getEmail());
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
    
    @PostMapping("/borrow")
    public ResponseEntity<?> borrowBookManagerDTO(@Valid @RequestBody BookManagerDTO bookManagerDTO) {
        sampleService.insertBookManager(bookManagerDTO);
        Map<String, String> response = new HashMap<>();
        response.put("message", "Sucessfully Borrowed Book  "+ bookManagerDTO.getBook() +" by "+ bookManagerDTO.getUser());
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
    
    @GetMapping("/user")
    public ResponseEntity<?> getUser(@RequestParam Long id) {
        Map<String, User> response = new HashMap<>();
        response.put("message", sampleService.getUserById(id));
        return new ResponseEntity<>(response,HttpStatus.OK);
    }
    

}
