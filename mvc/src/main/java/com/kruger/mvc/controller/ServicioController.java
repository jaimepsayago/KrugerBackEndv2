package com.kruger.mvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.kruger.mvc.service.IServicio;
import com.kruger.mvc.service.MiServicio;

@Controller
public class ServicioController {
	
	//@Autowired
	//MiServicio servicio;
	//noesta fuertemente acoplado
	@Autowired
	@Qualifier("miServicioSimple")
	IServicio servicio; //objeto a partir de interfaz
	
	
	//agregandi di  en el constructor

	/*
	 * public ServicioController(IServicio servicio) { this.servicio = servicio; }
	 */
	
	@GetMapping("/servicio")
	public String index(Model model) {
	model.addAttribute("objeto", servicio.operacion());
	return "servicio";
	}


	
	//aplicando el autowired en un metodo
	//@Autowired
	//public void setServicio(IServicio servicio) {
		//this.servicio=servicio;
	//}
	


}
