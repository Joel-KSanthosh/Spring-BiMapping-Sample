package com.study.sample.dto;

import java.sql.Date;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BorrowDTO {

    private Long id;

    private String title;

    private String username;
    
    private Date borrowed_on;

    private Date returned_on;

}
