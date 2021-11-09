package com.ipartek.modelo.dto;

public class TicketProducto {
	
	private int id;
	private int cantidad;
	private int idProducto;
	private int idTicket;
	
	public TicketProducto(int id, int cantidad, int idProducto, int idTicket) {
		super();
		this.id = id;
		this.cantidad = cantidad;
		this.idProducto = idProducto;
		this.idTicket = idTicket;
	}
	
	public TicketProducto() {
		super();
		this.id = 0;
		this.cantidad = 0;
		this.idProducto = 0;
		this.idTicket = 0;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public int getIdProducto() {
		return idProducto;
	}
	public void setIdProducto(int idProducto) {
		this.idProducto = idProducto;
	}

	public int getIdTicket() {
		return idTicket;
	}
	public void setIdTicket(int idTicket) {
		this.idTicket = idTicket;
	}

	@Override
	public String toString() {
		return "TicketProducto [id=" + id + ", cantidad=" + cantidad + ", idProducto=" + idProducto + ", idTicket="
				+ idTicket + "]";
	}

}
