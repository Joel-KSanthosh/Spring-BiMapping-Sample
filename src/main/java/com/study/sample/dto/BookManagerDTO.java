package com.study.sample.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class BookManagerDTO {

    @NotNull(message = "user is mandatory")
    private Long user;

    @NotNull(message = "book is mandatory")
    private Long book;

}
