package com.ipartek.modelo.dto;

public class LibroPrestado {
	
	private int id;
	private String nombre;
	private String apellidos;
	private String titulo;
	private String fecha;
	
	public LibroPrestado(int id, String nombre, String apellidos, String titulo, String fecha) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.titulo = titulo;
		this.fecha = fecha;
	}
	
	public LibroPrestado() {
		super();
		this.id = 0;
		this.nombre = "";
		this.apellidos = "";
		this.titulo = "";
		this.fecha = "";
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

	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	
	

}
