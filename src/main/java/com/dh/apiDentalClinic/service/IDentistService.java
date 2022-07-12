package com.dh.apiDentalClinic.service;

import com.dh.apiDentalClinic.DTO.DentistDTO;
import com.dh.apiDentalClinic.DTO.TurnDTO;
import com.dh.apiDentalClinic.entity.Dentist;
import com.dh.apiDentalClinic.entity.Turn;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;
import java.util.Set;


public interface IDentistService {

    Collection<DentistDTO> findAllDentist();
    DentistDTO findDentistById(Long id);

    void saveDentist(DentistDTO newDentistDTO);

    void deleteDentist(Long id);

    void updateDentist(DentistDTO newDentistDTO);
}
