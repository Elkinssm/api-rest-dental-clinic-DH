package com.dh.apiDentalClinic.service;

import com.dh.apiDentalClinic.DTO.TurnDTO;
import com.dh.apiDentalClinic.DTO.TurnResponseDTO;

import java.util.Collection;


public interface ITurnService {

    Collection<TurnResponseDTO> findAllTurns();

    TurnDTO findTurnById(Long id);

    void saveTurn(TurnDTO newTurnDTO);

    void deleteTurn(Long id);

    void updateTurn(TurnDTO newTurnDTO);

}
