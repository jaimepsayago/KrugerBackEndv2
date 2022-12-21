package com.kruger.mvc.service;

import org.springframework.stereotype.Component;

@Component("miServicioSimple")
public class MiServicio implements IServicio {
	
	
	public String operacion() {
		return "ejecuntando algun proceso importante";
	}

}
