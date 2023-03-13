package com.gestion.apigestionentidad.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.gestion.apigestionentidad.model.Usuario;
import com.gestion.apigestionentidad.repository.UsuarioRepository;

@Service
public class UserDetailServiceImpl implements UserDetailsService{

    @Autowired 
    private UsuarioRepository usuarioRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Usuario usuario = usuarioRepository.findOneByEmail(email).orElseThrow(() -> new UsernameNotFoundException("El usuario con el correo " + email +" no se encontro" ));
        return new UserDetailsImpl(usuario);
    }
    
}
