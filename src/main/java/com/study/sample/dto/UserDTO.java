package com.study.sample.dto;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.study.sample.models.Roles;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDTO {

    @NotBlank(message = "name is mandatory")
    private String name;

    @NotBlank(message = "email is mandatory")
    private String email;

    @NotBlank(message = "password is mandatory")
    private String password;

    @JsonIgnoreProperties
    private Roles role = Roles.USER;

}
