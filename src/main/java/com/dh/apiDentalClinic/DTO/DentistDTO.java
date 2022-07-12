package com.dh.apiDentalClinic.DTO;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class DentistDTO {
    private Long id;
    private String name;
    private String lastName;
    private String registrationNumber;
}
