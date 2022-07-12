package com.dh.apiDentalClinic.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


import javax.persistence.*;

@ToString
@Setter
@Getter
@Entity
@Table(name="address")

@JsonIgnoreProperties(value={"hibernateLazyInitializer"})
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String street;
    private String number;
    private String locality;
    private String province;

}
