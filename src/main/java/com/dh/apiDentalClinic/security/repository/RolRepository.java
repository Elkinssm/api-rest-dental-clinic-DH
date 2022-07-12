package com.dh.apiDentalClinic.security.repository;

import com.dh.apiDentalClinic.security.entity.Rol;
import com.dh.apiDentalClinic.security.enums.NameRol;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RolRepository extends JpaRepository<Rol, Long> {
    Optional<Rol> findByNameRol(NameRol nameRol);
}
