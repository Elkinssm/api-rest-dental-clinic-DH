package com.dh.apiDentalClinic;

import org.apache.log4j.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class ApiDentalClinicApplication {

    public static void main(String[] args) {
        PropertyConfigurator.configure("log4j.properties");
        SpringApplication.run(ApiDentalClinicApplication.class, args);
    }

}
