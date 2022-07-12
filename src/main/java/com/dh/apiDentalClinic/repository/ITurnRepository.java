package com.dh.apiDentalClinic.repository;

import com.dh.apiDentalClinic.entity.Turn;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITurnRepository extends JpaRepository<Turn, Long> {
}
