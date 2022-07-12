package com.dh.apiDentalClinic.security.entity.DTO;


import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class LoginDTO {
    @NotBlank
    private String userName;

    @NotBlank
    private String password;

}
