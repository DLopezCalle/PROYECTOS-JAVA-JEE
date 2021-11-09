package com.ipartek.modelo.dto;

public class Libro {
	
	private int id;
	private String titulo;
	
	public Libro(int id, String titulo) {
		super();
		this.id = id;
		this.titulo = titulo;
	}
	
	public Libro() {
		super();
		this.id = 0;
		this.titulo = "";
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	@Override
	public String toString() {
		return "Libro [id=" + id + ", titulo=" + titulo + "]";
	}

}
