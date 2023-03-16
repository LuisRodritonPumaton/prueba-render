package com.gestion.apigestionentidad.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "usuario")
public class Usuario {
    @Id
    @GeneratedValue (strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name= "usuario_seq", sequenceName="usuario_seq", allocationSize = 1)
    @Column(name = "idUsuario")
    Long idUsuario;
    @Column(name = "nombre_usuario")
    String nombreUsuario;
    @Column(name = "email")
    String email;
    @Column(name = "password")
    String password;
}

