package com.kruger.poo.collections;

import java.util.LinkedHashMap;
import java.util.LinkedHashSet;

public class AppMapCollection {

	public static void main(String[] args) {
		//lectura de arrays con diferentes metodos
				Estado estado1;
				
				//map
				LinkedHashMap<Integer, Estado> estados = new LinkedHashMap<>();
				//hashset
				LinkedHashSet<Estado> listaEstadosHashSet= new LinkedHashSet<>();
				estado1 = new Estado(1, "Espania", 343434343);
				listaEstadosHashSet.add(estado1);
				estado1 = new Estado(2, "Portugal", 453333333);
				listaEstadosHashSet.add(estado1);
				estado1 = new Estado(3, "Francia", 543333333);
				listaEstadosHashSet.add(estado1);
				estado1 = new Estado(4, "Italia", 99944343);
				listaEstadosHashSet.add(estado1);
				estado1 = new Estado(5, "Alemania", 88434343);
				listaEstadosHashSet.add(estado1);
				estado1 = new Estado(6, "Holanda", 6664343);
				listaEstadosHashSet.add(estado1);
				

				//si existe algun dato duplicado o no existe el datos
				Estado estadoDuplicado = new Estado(2, "Portugal", 453333333);
				listaEstadosHashSet.add(estadoDuplicado);
				if (listaEstadosHashSet.contains(estadoDuplicado))
					System.out.println("ya existe este objeto en el set");
				
				//
				
				
	}

}
