package com.dh.apiDentalClinic.util;

import com.dh.apiDentalClinic.security.entity.Rol;
import com.dh.apiDentalClinic.security.enums.NameRol;
import com.dh.apiDentalClinic.security.service.RolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CreateRoles implements CommandLineRunner {

    @Autowired
    RolService rolService;


    @Override
    public void run(String... args) throws Exception {

        rolService.save( new Rol(NameRol.ROLE_ADMIN));
        rolService.save(new Rol(NameRol.ROLE_USER));

    }
}
