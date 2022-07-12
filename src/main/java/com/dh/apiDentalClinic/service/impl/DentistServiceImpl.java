package com.dh.apiDentalClinic.service.impl;

import com.dh.apiDentalClinic.DTO.DentistDTO;
import com.dh.apiDentalClinic.entity.Dentist;
import com.dh.apiDentalClinic.exception.ResourceNotFoundException;
import com.dh.apiDentalClinic.repository.IDentistRepository;
import com.dh.apiDentalClinic.service.IDentistService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class DentistServiceImpl implements IDentistService {

    @Autowired
    private IDentistRepository dentistRepository;

    @Autowired
    ObjectMapper mapper;

    public void saveMethod(DentistDTO dentistDTO) {
        if (dentistDTO != null) {
            Dentist dentist = mapper.convertValue(dentistDTO, Dentist.class);
            dentistRepository.save(dentist);
        } else {
            throw new ResourceNotFoundException("Dentist", "id", "id not found: " + dentistDTO.getId());
        }

    }

    @Override
    public Collection<DentistDTO> findAllDentist() {
        List<Dentist> dentists = dentistRepository.findAll();
        Set<DentistDTO> dentistDTO = new HashSet<>();

        for (Dentist dentist : dentists) {
            dentistDTO.add(mapper.convertValue(dentist, DentistDTO.class));
        }
        return dentistDTO;

    }

    @Override
    public DentistDTO findDentistById(Long id) {
        Dentist dentist = dentistRepository.findById(id).get();
        DentistDTO dentistDTO = null;
        if (dentist != null) {
            dentistDTO = mapper.convertValue(dentist, DentistDTO.class);
        }
        return dentistDTO;
    }

    @Override
    public void saveDentist(DentistDTO newDentistDTO) {
        saveMethod(newDentistDTO);
    }

    @Override
    public void deleteDentist(Long id) {
        Dentist dentist = dentistRepository.findById(id).get();
        dentistRepository.deleteById(id);


    }

    @Override
    public void updateDentist(DentistDTO newDentistDTO) {
        saveMethod(newDentistDTO);
    }
}
