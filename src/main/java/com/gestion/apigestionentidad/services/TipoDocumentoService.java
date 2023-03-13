package com.gestion.apigestionentidad.services;

import java.util.List;

import com.gestion.apigestionentidad.model.TipoDocumento;

public interface TipoDocumentoService {
    public TipoDocumento registrarTipoDocumento(TipoDocumento tipoDocumento) throws Exception;

    public List<TipoDocumento> listarTipoDocumento() throws Exception;

    public TipoDocumento eliminarTipoDocumento(Long id_tipo_documento) throws Exception;

    public TipoDocumento actualizarTipoDocumento(TipoDocumento tipoDocumento) throws Exception;

    public TipoDocumento obtenerTipoDocumentoPorId(Long id_tipo_documento) throws Exception;
}
