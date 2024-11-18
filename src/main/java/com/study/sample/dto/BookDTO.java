package com.study.sample.dto;

import java.sql.Date;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookDTO {

    @NotBlank(message = "title is mandatory")
    private String title;

    @NotBlank(message = "author is mandatory")
    private String author;

    @NotBlank(message = "publisher is mandatory")
    private String publisher;

    @NotNull(message = "published_on is mandatory")
    private Date published_on;

    @NotNull(message = "quantity is mandatory")
    private Long quantity;
    
}
