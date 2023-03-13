package com.gestion.apigestionentidad.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gestion.apigestionentidad.model.TipoContribuyente;

public interface TipoContribuyenteRepository extends JpaRepository<TipoContribuyente, Long> {
    TipoContribuyente getByNombre(String nombre) throws Exception;
}
