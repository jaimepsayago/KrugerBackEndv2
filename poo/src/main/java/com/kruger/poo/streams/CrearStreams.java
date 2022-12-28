package com.kruger.poo.streams;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CrearStreams {

	public static void main(String[] args) {
		Stream<String> stream1 = Stream.of("intro java functional");
		stream1.forEach(n-> System.out.println(n));

		Stream<String> stream2 = Stream.of("intro java functional 2", "dato 1", "dato2");
		stream2.forEach(System.out::println);
		
		//crearlo desde un array
		String[] arr = {"JAva", "Stream","API"};
		Stream<String> stream3 = Arrays.stream(arr);
		System.out.println(Arrays.toString(stream3.toArray()));
		
		Stream<Estudiante> streamE= Stream.<Estudiante>builder()
				.add(new Estudiante(1, "juan", "calle",20))
				.add(new Estudiante(1, "patricio", "flores",10))
				.add(new Estudiante(1, "ana", "rosales",30))
				.build();

		streamE.forEach(estudiante -> System.out.println(estudiante.getNombre()));
		
		//filtros
		//contar cadenas vaicas 
		List<String> strList = Arrays.asList("abc", "bcd", "", "adaefg", "", "jk");
		long count = strList.stream()
							.filter(x-> x.isEmpty())
							.count();
		
		System.out.println("filter: "+count);
		//maps
		long count1 = strList.stream()
					.filter(x-> x.startsWith("a"))
					.count();
		System.out.println("filter: "+count1);
		
		List<String> filtered = strList.stream()
					.filter(x-> !x.isEmpty())
					.collect(Collectors.toList());
		System.out.println("filter: "+filtered);
		
		//converit una cadena en mayusculas y luego unirlas comas 
		List<String> G7 = Arrays.asList("USA","Frace","Germany","italy");
		
		String gyCountries= G7.stream()
				.map(x-> x.toUpperCase())
				.collect(Collectors.joining(", "));
		System.out.println("collector: "+gyCountries);
		
		//creasr una lista del cuadrado de todos los numeros distintos
		List<Integer> numbers = Arrays.asList(9,5,3,4,7,3,4);
		List<Integer> distinct = numbers.stream()
										.map(i-> i*i)
										.distinct()
										.collect(Collectors.toList());
		System.out.println("collector: "+distinct);
		
		//ejemplo de estadisticos como el maximo el minimo suma y media de los numeros
		IntSummaryStatistics stats = numbers.stream()
											.mapToInt((x)->x)
											.summaryStatistics();
		System.out.println("maximo: " + stats.getMax());
		System.out.println("estadisticas: " + stats);
	}

}
