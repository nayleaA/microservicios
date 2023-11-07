package com.tudu.tareas.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity( name = "usuarios")
@Data
public class Usuario {
    @Id
    @GeneratedValue( strategy = GenerationType.AUTO)

    private long idUsuario;
    private String usuario;
    private String password;
}
