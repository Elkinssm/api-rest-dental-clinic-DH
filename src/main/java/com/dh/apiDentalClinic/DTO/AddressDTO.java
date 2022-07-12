package com.dh.apiDentalClinic.DTO;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class AddressDTO {
    private Long id;
    private String street;
    private String number;
    private String locality;
    private String province;
}
