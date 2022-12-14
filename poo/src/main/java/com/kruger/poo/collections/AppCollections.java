package com.kruger.poo.collections;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class AppCollections {
	
	public static void main(String[] args) {
	
		Collections arrayCollection = new Collections();
		arrayCollection.printArrays();
		
		//buscar\
		int ubicacion = arrayCollection.buscar(3);
		System.out.println("dato encontrado: " + ubicacion);
		
		//lectura de arrays con diferentes metodos
		Estado estado1;
		ArrayList<Estado> estados = new ArrayList<>();
		//agregar datos a objeto estado y a la lista
		estado1 = new Estado(1, "Espania", 343434343);
		estados.add(estado1);
		estado1 = new Estado(2, "Portugal", 453333333);
		estados.add(estado1);
		estado1 = new Estado(3, "Francia", 543333333);
		estados.add(estado1);
		estado1 = new Estado(4, "Italia", 99944343);
		estados.add(estado1);
		estado1 = new Estado(5, "Alemania", 88434343);
		estados.add(estado1);
		estado1 = new Estado(6, "Holanda", 6664343);
		estados.add(estado1);
		//recorrido
		//for
		System.out.println("-------------------recorrido for: ");
		Estado estado2;
		for (int i=0;i<estados.size();i++) {
			estado2 =estados.get(i);
			System.out.println("id: " + estado2.getIdEstado());
			System.out.println("nombre: " + estado2.getNombre());
			System.out.println("habitantes: " + estado2.getNumeroHabitantes());
		}
			
		//for each
		System.out.println("-------------------recorrido for each: ");
		for (Estado estado3:estados) {
			System.out.println("id: " + estado3.getIdEstado());
			System.out.println("nombre: " + estado3.getNombre());
			System.out.println("habitantes: " + estado3.getNumeroHabitantes());
		}
		//iterator
		System.out.println("-------------------recorrido iterator: ");
		Estado estado4;
		Iterator<Estado> iteratorEstado = estados.iterator();
		while(iteratorEstado.hasNext()) {
			estado4=iteratorEstado.next();
			System.out.println("id: " + estado4.getIdEstado());
			System.out.println("nombre: " + estado4.getNombre());
			System.out.println("habitantes: " + estado4.getNumeroHabitantes());
		}
		
		//enumerator
		System.out.println("-------------------recorrido enumeration: ");
		Estado estado5;
		Enumeration<Estado> enumeratorEstado = java.util.Collections.enumeration(estados);
		while(enumeratorEstado.hasMoreElements()) {
			estado5=enumeratorEstado.nextElement();
			System.out.println("id: " + estado5.getIdEstado());
			System.out.println("nombre: " + estado5.getNombre());
			System.out.println("habitantes: " + estado5.getNumeroHabitantes());
		}
		//object
		System.out.println("-------------------recorrido OBJECT array: ");
		//convertir estados en array y agregarlos al objeto array
		Object[] arrayEstado = estados.toArray();
		for(int i=0; i <arrayEstado.length; i++) {
			System.out.println("id: " + ((Estado)arrayEstado[i]).getIdEstado());
			System.out.println("nombre: " + ((Estado)arrayEstado[i]).getNombre());
			System.out.println("habitantes: " + ((Estado)arrayEstado[i]).getNumeroHabitantes());
		}
		
		
		//lambdalist
		lambdaList();
		
		//lambdamap
		lambdaMap();
		
	}
	
	public static void lambdaList() {
		var stringList = List.of("uno", "dos","tres");
		//stringList.forEach(element-> System.out.println(element));
		stringList.forEach(System.out::println);
	}
	public static void lambdaMap() {
		Map<String,Integer> stringMap = Map.of("one",1,"two",2,"three",3);
		stringMap.forEach((k,v)-> System.out.println(k + ": " + v));
	}
	
	

}
