package com.gestion.apigestionentidad.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gestion.apigestionentidad.model.TipoDocumento;

public interface TipoDocumentoRepository extends JpaRepository<TipoDocumento, Long>{
    TipoDocumento getByNombre(String nombre) throws Exception;
}
