package com.gestion.apigestionentidad.services;

import java.util.List;

import com.gestion.apigestionentidad.model.Entidad;

public interface EntidadService {
    
    public Entidad registrarEntidad(Entidad entidad) throws Exception;

    public List<Entidad> listarEntidad() throws Exception;

    public Entidad eliminarEntidad(Long id_entidad) throws Exception;

    public Entidad actualizarEntidad(Entidad entidad) throws Exception;

    public Entidad obtenerEntidadPorId(Long id_entidad) throws Exception;
}
