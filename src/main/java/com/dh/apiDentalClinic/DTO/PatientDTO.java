package com.dh.apiDentalClinic.DTO;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter

public class PatientDTO {

    private Long id;
    private String name;
    private String lastName;
    private String DNI;
    private String admissionsDate;
    private AddressDTO address;

}
