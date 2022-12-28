package com.kruger.poo.streams;

public class Estudiante {
	public int id;
	public String nombre,apellido;
	public double notas;
	
	public Estudiante()
	{
		
	}
	public Estudiante(int id, String nombre, String apellido, double notas) {
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.notas = notas;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public double getNotas() {
		return notas;
	}
	public void setNotas(double notas) {
		this.notas = notas;
	}
	
	

}
