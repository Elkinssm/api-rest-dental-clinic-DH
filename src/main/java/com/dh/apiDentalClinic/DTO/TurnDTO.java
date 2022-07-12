package com.dh.apiDentalClinic.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class TurnDTO {
    private Long id;
    private Long dentist_id;
    private Long patient_id;
    private String date;
}
