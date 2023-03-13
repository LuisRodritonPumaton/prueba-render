package com.gestion.apigestionentidad.services.impl;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gestion.apigestionentidad.model.TipoDocumento;
import com.gestion.apigestionentidad.repository.TipoDocumentoRepository;
import com.gestion.apigestionentidad.services.TipoDocumentoService;

@Service
public class TipoDocumentoServiceImpl implements TipoDocumentoService{

    //INJECTANDO REPOSITORY
    @Autowired 
    private TipoDocumentoRepository tipoDocumentoRepository; 

    @Override
    public TipoDocumento registrarTipoDocumento(TipoDocumento tipoDocumento) throws Exception {
        TipoDocumento tipoDocumentoLocal = tipoDocumentoRepository.getByNombre(tipoDocumento.getNombre());
        if(tipoDocumentoLocal == null){
            tipoDocumentoRepository.save(tipoDocumento);
            return tipoDocumento;
        }else{
            throw new Exception("El tipo de documento con el nombre: " + tipoDocumento.getNombre() + " ya existe");
        }
    }

    @Override
    public List<TipoDocumento> listarTipoDocumento() throws Exception {
        
        List<TipoDocumento> lista_local = tipoDocumentoRepository.findAll().stream().filter(tipoDocumento -> tipoDocumento.getEstado()==true).sorted(Comparator.comparing(TipoDocumento::getNombre)).collect(Collectors.toList());
        if(lista_local.size()==0){
            throw new Exception("No existen registros de documentos");
        }else{
            return lista_local;
        }

    }

    @Override
    public TipoDocumento eliminarTipoDocumento(Long id_tipo_documento) throws Exception {
        TipoDocumento tipoDocumentoLocal = obtenerTipoDocumentoPorId(id_tipo_documento);
        tipoDocumentoLocal.setEstado(false);
        tipoDocumentoRepository.save(tipoDocumentoLocal);
        return tipoDocumentoLocal;
    }

    @Override
    public TipoDocumento actualizarTipoDocumento(TipoDocumento tipoDocumento) throws Exception {
        TipoDocumento tipoDocumentoLocal = obtenerTipoDocumentoPorId(tipoDocumento.getIdTipoDocumento());
        tipoDocumentoLocal.setCodigo(tipoDocumento.getCodigo());
        tipoDocumentoLocal.setNombre(tipoDocumento.getNombre());
        tipoDocumentoLocal.setDescripcion(tipoDocumento.getDescripcion());
        tipoDocumentoLocal.setEstado(tipoDocumento.getEstado());
        tipoDocumentoRepository.save(tipoDocumento);
        return tipoDocumentoLocal;
    }

    @Override
    public TipoDocumento obtenerTipoDocumentoPorId(Long id_tipo_documento) throws Exception {
        Optional<TipoDocumento> tipoDocumentoLocal = tipoDocumentoRepository.findById(id_tipo_documento);
        if(tipoDocumentoLocal.isPresent()){
            return tipoDocumentoLocal.get();
        }else{
            throw new Exception("No se encontró el documento con el id:" +id_tipo_documento);
        }
    }


}
