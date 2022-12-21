package com.kruger.mvc.model;

public class ItemFactura {
	private Producto producto;
	private Integer cantidad;
	
	//un constructor vacio
	public ItemFactura() {
		
	}
	
	//un constructor con datos
	public ItemFactura(Producto producto, Integer cantidad) {
		this.producto = producto;
		this.cantidad = cantidad;
	}
	
	public Producto getProducto() {
		return producto;
	}
	public void setProducto(Producto producto) {
		this.producto = producto;
	}
	public Integer getCantidad() {
		return cantidad;
	}
	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}
	
	

}
