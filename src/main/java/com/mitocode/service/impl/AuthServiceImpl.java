package com.mitocode.service.impl;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl {

	public boolean tieneAcceso(String path) {
		
		boolean rpta = false;

		String metodoRol = "";

		/* Aca se deberia agregar una logica que recupere de tabla los roles
		 * del usuario y parametrizar funcion/rol_usr */
		
		/* logica ejemplo para mostrar la implementacion */
		switch (path) {
		case "listar":				// viene por esta opcion.
			metodoRol = "ADMIN";
			break;

		case "listarId":
			metodoRol = "ADMIN,USER,DBA";
			break;
		}
		/* Fin - logica roles de usuarios en tabla */
		
		/* 
		 * Otra idea es recuperar el path desde donde se realiza la peticion,
		 * y parametrizar por servicio/rol_usr */
		
		String metodoRoles[] = metodoRol.split(",");
		
		Authentication usuarioLogueado = SecurityContextHolder.getContext().getAuthentication();

		System.out.println(usuarioLogueado.getName());

		for (GrantedAuthority auth : usuarioLogueado.getAuthorities()) {
			String rolUser = auth.getAuthority();
			System.out.println(rolUser);

			for (String rolMet : metodoRoles) {
				if (rolUser.equalsIgnoreCase(rolMet)) {
					rpta = true;
				}
			}
		}
		
		return rpta;
	}
}
