package com.dh.apiDentalClinic.service;

import com.dh.apiDentalClinic.DTO.AddressDTO;
import com.dh.apiDentalClinic.DTO.TurnDTO;
import com.dh.apiDentalClinic.entity.Address;
import com.dh.apiDentalClinic.entity.Patient;
import com.dh.apiDentalClinic.entity.Turn;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;
import java.util.Set;



public interface IAddressService {

    Collection<AddressDTO> findAllAddress();

    AddressDTO findAddressById(Long id);

    void saveAdrress(AddressDTO newAddressDTO);

    void deleteAdrress(Long id);

    void updateAdrress(AddressDTO newAddressDTO);
}
