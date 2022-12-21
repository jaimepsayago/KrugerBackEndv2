package com.kruger.poo.interfaces;

public class Comensal {
	String nombre;
	double monto;
	int mesa;
	
	public Comensal() {
	}

	public Comensal(String nombre, double monto, int mesa) {
		super();
		this.nombre = nombre;
		this.monto = monto;
		this.mesa = mesa;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public double getMonto() {
		return monto;
	}

	public void setMonto(double monto) {
		this.monto = monto;
	}

	public int getMesa() {
		return mesa;
	}

	public void setMesa(int mesa) {
		this.mesa = mesa;
	}
	
	
	
}
