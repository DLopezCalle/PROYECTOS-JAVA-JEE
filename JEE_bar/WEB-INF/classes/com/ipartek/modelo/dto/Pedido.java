package com.ipartek.modelo.dto;

public class Pedido {
	
	private int idProducto;
	private String nombre;
	private String imagen;
	private double precio;
	private int cantidad;
	private int idTicket;
	
	public Pedido(int idProducto, String nombre, String imagen, double precio, int cantidad, int idTicket) {
		super();
		this.idProducto = idProducto;
		this.nombre = nombre;
		this.imagen = imagen;
		this.precio = precio;
		this.cantidad = cantidad;
		this.idTicket = idTicket;
	}
	
	public Pedido() {
		super();
		this.idProducto = 0;
		this.nombre = "";
		this.imagen = "";
		this.precio = 0.0;
		this.cantidad = 0;
		this.idTicket = 0;
	}

	public int getIdProducto() {
		return idProducto;
	}
	public void setIdProducto(int idProducto) {
		this.idProducto = idProducto;
	}

	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getImagen() {
		return imagen;
	}
	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public int getIdTicket() {
		return idTicket;
	}
	public void setIdTicket(int idTicket) {
		this.idTicket = idTicket;
	}

	@Override
	public String toString() {
		return "Pedido [idProducto=" + idProducto + ", nombre=" + nombre + ", imagen=" + imagen + ", precio=" + precio
				+ ", cantidad=" + cantidad + ", idTicket=" + idTicket + "]";
	}

}
