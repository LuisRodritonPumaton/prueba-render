package com.gestion.apigestionentidad.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gestion.apigestionentidad.model.Entidad;

public interface EntidadRepository extends JpaRepository<Entidad, Long>{
    Entidad getByNroDocumento(String nro_documento) throws Exception;
}
