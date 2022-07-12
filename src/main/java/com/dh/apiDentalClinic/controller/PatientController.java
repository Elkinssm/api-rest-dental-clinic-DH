package com.dh.apiDentalClinic.controller;


import com.dh.apiDentalClinic.DTO.PatientDTO;
import com.dh.apiDentalClinic.service.IPatientService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

import static io.swagger.v3.oas.annotations.enums.ParameterIn.HEADER;


@Tag(name = "Patients", description = "Operations about patients")
@RestController
@RequestMapping("/patient")
public class PatientController {
    @Autowired
    IPatientService patientService;

    @Operation(summary = "Find all patients")
    @PreAuthorize("hasRole('ADMIN') or hasRole('USER')")
    @GetMapping("/all")
    public ResponseEntity<Collection<PatientDTO>> getAllPatients() {
        return new ResponseEntity<>(patientService.findAllPatients(), HttpStatus.OK);
    }

    @Operation(summary = "Find patient by id")
    @PreAuthorize("hasRole('ADMIN') or hasRole('USER')")
    @GetMapping("/{id}")
    public ResponseEntity<?> getPatient(@PathVariable Long id) {
        PatientDTO patientDTO = patientService.findPatientById(id);
        return new ResponseEntity<>(patientDTO, HttpStatus.OK);
    }

    @Operation(summary = "Add new patient to the dental clinic",
            parameters = @Parameter(name = "Authorization", in = HEADER, description = "Json web token required", required = true),
            security = @SecurityRequirement(name = "jwtAuth"))
    @PreAuthorize("hasRole('ADMIN') or hasRole('USER')")
    @PostMapping("/add")
    public ResponseEntity<?> savePatient(@RequestBody PatientDTO patientDTO) {
        patientService.savePatient(patientDTO);
        return new ResponseEntity<>("Patient added successfully!!", HttpStatus.CREATED);
    }

    @Operation(summary = "Update an existing patient",
            parameters = @Parameter(name = "Authorization", in = HEADER, description = "Json web token required", required = true),
            security = @SecurityRequirement(name = "jwtAuth"))
    @PreAuthorize("hasRole('ADMIN') or hasRole('USER')")
    @PutMapping("/update")
    public ResponseEntity<?> updatePatient(@RequestBody PatientDTO patientDTO) {
        ResponseEntity<String> response;
        if (patientService.findPatientById(patientDTO.getId()) != null) {
            patientService.updatePatient(patientDTO);
            response = new ResponseEntity<>("Update patient", HttpStatus.CREATED);
        } else {
            response = new ResponseEntity<>("Failed to update address, check sent values and id", HttpStatus.BAD_REQUEST);
        }
        return response;

    }

    @Operation(summary = "Delete a existing patient",
            parameters = @Parameter(name = "Authorization", in = HEADER, description = "Json web token required", required = true),
            security = @SecurityRequirement(name = "jwtAuth")
    )
    @PreAuthorize("hasRole('ADMIN') ")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deletePatient(@PathVariable Long id) {
        ResponseEntity<String> response;
        if (patientService.findPatientById(id) != null) {
            patientService.deletePatient(id);
            response = new ResponseEntity<>("Deleted patient with id: " + id, HttpStatus.OK);
        } else {
            response = new ResponseEntity<>("It is not find the patient with the id: " + id, HttpStatus.NOT_FOUND);
        }

        return response;
    }

}
