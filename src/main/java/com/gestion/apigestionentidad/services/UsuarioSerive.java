package com.gestion.apigestionentidad.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gestion.apigestionentidad.model.Usuario;
import com.gestion.apigestionentidad.repository.UsuarioRepository;

@Service
public class UsuarioSerive {
    
    @Autowired 
    private UsuarioRepository usuarioRepository;

    public Usuario registrarUsuario(Usuario entidad) throws Exception {
        usuarioRepository.save(entidad);
        return entidad;
    }

}
