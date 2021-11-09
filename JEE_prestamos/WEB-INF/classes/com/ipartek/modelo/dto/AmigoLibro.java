package com.ipartek.modelo.dto;

public class AmigoLibro {
	
	private int id;
	private String fecha;
	private int FK_amigo;
	private int FK_libro;
	
	public AmigoLibro(int id, String fecha, int fK_amigo, int fK_libro) {
		super();
		this.id = id;
		this.fecha = fecha;
		FK_amigo = fK_amigo;
		FK_libro = fK_libro;
	}
	
	public AmigoLibro() {
		super();
		this.id = 0;
		this.fecha = "";
		FK_amigo = 0;
		FK_libro = 0;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public int getFK_amigo() {
		return FK_amigo;
	}
	public void setFK_amigo(int fK_amigo) {
		FK_amigo = fK_amigo;
	}

	public int getFK_libro() {
		return FK_libro;
	}
	public void setFK_libro(int fK_libro) {
		FK_libro = fK_libro;
	}

	@Override
	public String toString() {
		return "AmigoLibro [id=" + id + ", fecha=" + fecha + ", FK_amigo=" + FK_amigo + ", FK_libro=" + FK_libro + "]";
	}
}
