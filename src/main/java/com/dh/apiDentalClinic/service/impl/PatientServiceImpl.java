package com.dh.apiDentalClinic.service.impl;

import com.dh.apiDentalClinic.DTO.AddressDTO;
import com.dh.apiDentalClinic.DTO.PatientDTO;
import com.dh.apiDentalClinic.entity.Address;
import com.dh.apiDentalClinic.entity.Patient;
import com.dh.apiDentalClinic.exception.ResourceNotFoundException;
import com.dh.apiDentalClinic.repository.IAddressRepository;
import com.dh.apiDentalClinic.repository.IPatientRepository;
import com.dh.apiDentalClinic.service.IPatientService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class PatientServiceImpl implements IPatientService {

    @Autowired
    private IPatientRepository patientRepository;

    @Autowired
    private IAddressRepository addressRepository;

    @Autowired
    ObjectMapper mapper;

    public void saveMethod(PatientDTO patientDTO) {
        AddressDTO addressdto = patientDTO.getAddress();
        Patient patient = mapper.convertValue(patientDTO, Patient.class);
        Address address = mapper.convertValue(addressdto, Address.class);
        address.setId(patient.getId());
        if (patient.getAddress() == null) {
            patient.setAddress(address);
        } else if (patientDTO == null || patientDTO.getAddress() == null) {
            throw new ResourceNotFoundException("Patient", "id", "id not found: " + patient.getId());
        }
        patientRepository.save(patient);
    }


    @Override
    public Collection<PatientDTO> findAllPatients() {
        List<Patient> patients = patientRepository.findAll();
        Set<PatientDTO> patientsDTO = new HashSet<>();
        for (Patient patient : patients) {
            Address address = addressRepository.findById(patient.getId()).get();

            if (address != null) {
                patient.setAddress(address);
            }

            patientsDTO.add(mapper.convertValue(patient, PatientDTO.class));
        }
        return patientsDTO;

    }

    @Override
    public PatientDTO findPatientById(Long id) {

        Patient patient = patientRepository.findById(id).get();
        PatientDTO patientDTO = null;
        if (patient != null) {
            patientDTO = mapper.convertValue(patient, PatientDTO.class);
        }
        return patientDTO;
    }

    @Override
    public void savePatient(PatientDTO newPatientDTO) {
        saveMethod(newPatientDTO);
    }

    @Override
    public void deletePatient(Long id) {
        Patient patient = patientRepository.findById(id).get();
        patientRepository.deleteById(id);
    }

    @Override
    public void updatePatient(PatientDTO newPatientDTO) {
        saveMethod(newPatientDTO);
    }
}
