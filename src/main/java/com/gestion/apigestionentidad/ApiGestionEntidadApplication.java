package com.gestion.apigestionentidad;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ApiGestionEntidadApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(ApiGestionEntidadApplication.class, args);

		// Usuario user = new Usuario();
        // user.setEmail("admin");
        // user.setNombreUsuario("admin");
        // user.setIdUsuario(Long.parseLong("1"));
        // user.setPassword(new BCryptPasswordEncoder().encode("admin"));
		// ApplicationContext ctx = SpringApplication.run(ApiGestionEntidadApplication.class, args);

		// UsuarioRepository usuarioRepository = ctx.getBean(UsuarioRepository.class);
		// usuarioRepository.save(user);

	}



}
