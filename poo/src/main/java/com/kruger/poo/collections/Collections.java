package com.kruger.poo.collections;

import java.util.Arrays;

public class Collections {
	//definir 3 arrays
	private int intArray[] = {1,2,3,4,5};
	private double doubleArray[] = {8.9,2.7,8.3,4.7,5.5};
	//declarar un array vacio
	private int llenadoArray[];
	private int copiadoArray[];
	
	public Collections() {
		//creasr un objeto con 10 elementos
		llenadoArray = new int[10];
		copiadoArray = new int[intArray.length];
		
		//llenadio de los dastos
		//metodo fill poara llenar array con cierta cantidad de datos
		Arrays.fill(llenadoArray, 7); //llena el array con el valor de 7
		//necesito ordenarla de manera ascendete
		//metodo sort
		Arrays.sort(doubleArray);
		
		//copiado de arrays
		System.arraycopy(intArray, 0, copiadoArray, 0, intArray.length);
	}
	
	//metodos para imprimir todos los arrays que acabmos de construir
	public void printArrays() {
		System.out.println("double array");
		for(double d:doubleArray)
			System.out.print(d);
		System.out.println();
		System.out.println("int array");
		for(int i:intArray)
			System.out.print(i);
		System.out.println();
		
		System.out.println("llenado array");
		for(int la:llenadoArray)
			System.out.print(la);
		System.out.println();
		
		System.out.println("copiado array");
		for(int ca:copiadoArray)
			System.out.print(ca);
		System.out.println();
		
		
	}
	
	//metodo para buscar en un array
	public int buscar(int value) {
		return Arrays.binarySearch(intArray, value);
	}
}
