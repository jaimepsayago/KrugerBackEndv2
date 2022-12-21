package com.kruger.mvc;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

import com.kruger.mvc.model.ItemFactura;
import com.kruger.mvc.model.Producto;
import com.kruger.mvc.service.IServicio;
import com.kruger.mvc.service.MiServicio;

@Configuration
@PropertySources({
	@PropertySource("classpath:textos.properties")
})
public class TextosPropertiesConfig {
	
	/*
	 * @Bean("miServicioSimple") public IServicio registrarMiServicio() { return new
	 * MiServicio(); }
	 */
	
	//registrar los iterms de la factura y de productos en la aplicacion
	@Bean("itemsFactura")
	public List<ItemFactura> registrarItems(){
		Producto p1 = new Producto("camara",  "100");
		Producto p3 = new Producto("biciclete",  "500");
		
		ItemFactura linea1 = new ItemFactura(p1,2);
		ItemFactura linea2 = new ItemFactura(p3,4);
		
		return Arrays.asList(linea1,linea2);
	}
	

	
	
	
	
}
