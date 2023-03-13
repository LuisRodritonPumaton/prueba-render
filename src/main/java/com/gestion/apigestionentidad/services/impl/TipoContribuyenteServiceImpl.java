package com.gestion.apigestionentidad.services.impl;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gestion.apigestionentidad.model.TipoContribuyente;
import com.gestion.apigestionentidad.repository.TipoContribuyenteRepository;
import com.gestion.apigestionentidad.services.TipoContribuyenteService;

@Service
public class TipoContribuyenteServiceImpl implements TipoContribuyenteService{

    //INJECTANDO REPOSITORY
    @Autowired
    private TipoContribuyenteRepository tipoContribuyenteRepository;

    @Override
    public TipoContribuyente registrarTipoContribuyente(TipoContribuyente tipoContribuyente) throws Exception {
        TipoContribuyente tipoContribuyenteLocal = tipoContribuyenteRepository.getByNombre(tipoContribuyente.getNombre());
        if(tipoContribuyenteLocal == null){
            tipoContribuyenteRepository.save(tipoContribuyente);
            return tipoContribuyente;
        }else{
            throw new Exception("El tipo de contribuyente con el nombre " + tipoContribuyente.getNombre()+ " ya existe");
        }
    }

    @Override
    public List<TipoContribuyente> listarTipoContribuyente() throws Exception {
        List<TipoContribuyente> lista_local = tipoContribuyenteRepository.findAll().stream().filter(tipoContri -> tipoContri.getEstado()==true).sorted(Comparator.comparing(TipoContribuyente::getNombre)).collect(Collectors.toList());
        if(lista_local.size()==0){
            throw new Exception("No existe registros de tipos de documentos");
        }else{
            return lista_local;
        }
    }

    @Override
    public TipoContribuyente eliminarTipoContribuyente(Long id_tipo_contribuyente) throws Exception {
        TipoContribuyente tipoContribuyenteLocal = obtenerTipoContribuyentePorId(id_tipo_contribuyente);
        tipoContribuyenteLocal.setEstado(false);
        tipoContribuyenteRepository.save(tipoContribuyenteLocal);
        return tipoContribuyenteLocal;
    }

    @Override
    public TipoContribuyente actualizarTipoContribuyente(TipoContribuyente tipoContribuyente) throws Exception {
        TipoContribuyente tipoContribuyenteLocal = obtenerTipoContribuyentePorId(tipoContribuyente.getIdTipoContribuyente());
        tipoContribuyenteLocal.setNombre(tipoContribuyente.getNombre());
        tipoContribuyenteLocal.setEstado(tipoContribuyente.getEstado());
        tipoContribuyenteRepository.save(tipoContribuyenteLocal);
        return tipoContribuyenteLocal;
    }

    @Override
    public TipoContribuyente obtenerTipoContribuyentePorId(Long id_tipo_contribuyente) throws Exception {
        Optional<TipoContribuyente> tipoContribuyenteLocal = tipoContribuyenteRepository.findById(id_tipo_contribuyente);
        if(tipoContribuyenteLocal.isPresent()){
            return tipoContribuyenteLocal.get();
        }else{
            throw new Exception("No se encontró el contribuyente con el id: " + id_tipo_contribuyente);
        }
    }
    
    
}
