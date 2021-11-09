package com.ipartek.modelo.dto;

public class Contacto {
	
	// Atributos
	private int id;
	private String telefono;
	private String nombre;
	private String apellidos;
	
	// Constructor
	public Contacto(int id, String telefono, String nombre, String apellidos) {
		super();
		this.id = id;
		this.telefono = telefono;
		this.nombre = nombre;
		this.apellidos = apellidos;
	}
	
	// Constructor vacío
	public Contacto() {
		super();
		this.id = 0;
		this.telefono = "";
		this.nombre = "";
		this.apellidos = "";
	}

	// ----------------------------------------
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	// ----------------------------------------
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	// ----------------------------------------
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	// ----------------------------------------
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	@Override
	public String toString() {
		return "Contacto [id=" + id + ", telefono=" + telefono + ", nombre=" + nombre + ", apellidos=" + apellidos + "]";
	}
}
