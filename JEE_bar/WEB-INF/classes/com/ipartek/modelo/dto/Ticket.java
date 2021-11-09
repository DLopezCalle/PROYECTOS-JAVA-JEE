package com.ipartek.modelo.dto;

public class Ticket {
	
	private int id;
	private int idEmpleado;
	
	public Ticket(int id, int idEmpleado) {
		super();
		this.id = id;
		this.idEmpleado = idEmpleado;
	}
	
	public Ticket() {
		super();
		this.id = 0;
		this.idEmpleado = 0;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public int getIdEmpleado() {
		return idEmpleado;
	}
	public void setIdEmpleado(int idEmpleado) {
		this.idEmpleado = idEmpleado;
	}

	@Override
	public String toString() {
		return "Ticket [id=" + id + ", idEmpleado=" + idEmpleado + "]";
	}

}
