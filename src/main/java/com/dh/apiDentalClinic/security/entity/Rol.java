package com.dh.apiDentalClinic.security.entity;

import com.dh.apiDentalClinic.security.enums.NameRol;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;


@Getter
@Setter
@Entity
@Table(name = "roles")
public class Rol {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private NameRol nameRol;

    public Rol() {
    }

    public Rol(NameRol nameRol) {
        this.nameRol = nameRol;
    }
}
