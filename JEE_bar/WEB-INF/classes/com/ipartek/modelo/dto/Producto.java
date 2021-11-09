package com.ipartek.modelo.dto;

public class Producto {
	
	private int id;
	private String nombre;
	private String imagen;
	private double precio;
	
	public Producto(int id, String nombre, String imagen, double precio) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.imagen = imagen;
		this.precio = precio;
	}
	
	public Producto() {
		super();
		this.id = 0;
		this.nombre = "";
		this.imagen = "";
		this.precio = 0.0;
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

	@Override
	public String toString() {
		return "Producto [id=" + id + ", nombre=" + nombre + ", imagen=" + imagen + ", precio=" + precio + "]";
	}
}
