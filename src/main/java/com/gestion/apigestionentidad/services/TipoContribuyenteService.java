package com.gestion.apigestionentidad.services;

import java.util.List;

import com.gestion.apigestionentidad.model.TipoContribuyente;

public interface TipoContribuyenteService {
    
    public TipoContribuyente registrarTipoContribuyente(TipoContribuyente tipoContribuyente) throws Exception;

    public List<TipoContribuyente> listarTipoContribuyente() throws Exception;

    public TipoContribuyente eliminarTipoContribuyente(Long id_tipo_contribuyente) throws Exception;

    public TipoContribuyente actualizarTipoContribuyente(TipoContribuyente tipoContribuyente) throws Exception;

    public TipoContribuyente obtenerTipoContribuyentePorId(Long id_tipo_contribuyente) throws Exception;
}
