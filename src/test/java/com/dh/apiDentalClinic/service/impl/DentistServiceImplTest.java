package com.dh.apiDentalClinic.service.impl;

import com.dh.apiDentalClinic.DTO.DentistDTO;
import com.dh.apiDentalClinic.service.IDentistService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class DentistServiceImplTest {

    @Autowired
    IDentistService dentistService;

    @Test
    public void testAddDentist() {

        DentistDTO dentistDTO = new DentistDTO();
        dentistDTO.setName("Test1");
        dentistDTO.setLastName("Test2");
        dentistService.saveDentist(dentistDTO);

        DentistDTO dentistTest = dentistService.findDentistById(1L);

        assertNotNull(dentistTest);
    }

}