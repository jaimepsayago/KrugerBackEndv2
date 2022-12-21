package com.kruger.mvc.service;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Primary
@Component("miServicioComplejo")
public class MiServicio2 implements IServicio {

	@Override
	public String operacion() {
		
		return "ejecutando algun proceso importante complicado";
	}

}
