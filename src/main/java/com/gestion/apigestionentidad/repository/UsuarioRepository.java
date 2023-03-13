package com.gestion.apigestionentidad.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gestion.apigestionentidad.model.Usuario;


public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
    Optional<Usuario> findOneByEmail(String email);
}
