package com.gestion.apigestionentidad.services.impl;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gestion.apigestionentidad.model.Entidad;
import com.gestion.apigestionentidad.repository.EntidadRepository;
import com.gestion.apigestionentidad.services.EntidadService;

@Service
public class EntidadServiceImpl implements EntidadService{

    //INJECTANDO REPOSITORY
    @Autowired
    private EntidadRepository entidadRepository;

    @Override
    public Entidad registrarEntidad(Entidad entidad) throws Exception {
        Entidad entidadLocal = entidadRepository.getByNroDocumento(entidad.getNroDocumento());
        if(entidadLocal == null){
            entidadRepository.save(entidad);
            return entidad;
        }else{
            throw new Exception("La entidad con el número de documento " + entidad.getNroDocumento()+ " ya existe");
        }
    }

    @Override
    public List<Entidad> listarEntidad() throws Exception {
        
        List<Entidad> lista_local = entidadRepository.findAll().stream().filter(entidad -> entidad.getEstado()==true && entidad.getTipoContribuyente().getEstado()==true && entidad.getTipoDocumento().getEstado()==true).sorted(Comparator.comparing(Entidad::getRazonSocial)).collect(Collectors.toList());
        if(lista_local.size()==0){
            throw new Exception("No existe registros de entidades");
        }else{
            return lista_local;
        }
        
    }

    @Override
    public Entidad eliminarEntidad(Long id_entidad) throws Exception {
        Entidad entidadLocal = obtenerEntidadPorId(id_entidad);
        entidadLocal.setEstado(false);
        entidadRepository.save(entidadLocal);
        return entidadLocal;
    }

    @Override
    public Entidad actualizarEntidad(Entidad entidad) throws Exception {
        Entidad entidadLocal = obtenerEntidadPorId(entidad.getIdEntidad());
        entidadLocal.setTipoDocumento(entidad.getTipoDocumento());
        entidadLocal.setNroDocumento(entidad.getNroDocumento());
        entidadLocal.setRazonSocial(entidad.getRazonSocial());
        entidadLocal.setNombreComercial(entidad.getNombreComercial());
        entidadLocal.setTipoContribuyente(entidad.getTipoContribuyente());
        entidadLocal.setDireccion(entidad.getDireccion());
        entidadLocal.setTelefono(entidad.getTelefono());
        entidadLocal.setEstado(entidad.getEstado());
        entidadRepository.save(entidadLocal);
        return entidadLocal;
    }

    @Override
    public Entidad obtenerEntidadPorId(Long id_entidad) throws Exception {
        Optional<Entidad> entidadLocal = entidadRepository.findById(id_entidad);
        if(entidadLocal.isPresent()){
            return entidadLocal.get();
        }else{
            throw new Exception("No se encontró a la entidad con el id:" +id_entidad);
        }
    }
    
}
