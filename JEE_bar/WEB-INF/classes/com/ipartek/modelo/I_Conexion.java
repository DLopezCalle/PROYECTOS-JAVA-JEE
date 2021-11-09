package com.ipartek.modelo;

import java.sql.Connection;
import java.util.List;

import com.ipartek.modelo.dto.Empleado;
import com.ipartek.modelo.dto.Pedido;
import com.ipartek.modelo.dto.Producto;

public interface I_Conexion {
	
	//Constantes 	
	String DRIVER = "com.mysql.jdbc.Driver";
	String BD = "db_bar";
	String USER = "root";
	String PASS = "admin";
	String CONEXION = "jdbc:mysql://localhost:3306/" + BD;
				
	// Datos de los DTO
	String TABLA_PRODUCTOS = "productos";
	String PRODUCTOS_ID = "id";
	String PRODUCTOS_NOMBRE = "nombre";
	String PRODUCTOS_IMAGEN = "imagen";
	String PRODUCTOS_PRECIO = "precio";
	
	String TABLA_EMPLEADOS = "empleados";
	String EMPLEADOS_ID = "id";
	String EMPLEADOS_NOMBRE = "nombre";
	
	String TABLA_TICKETS = "tickets";
	String TICKETS_ID = "id";
	String TICKETS_FK_EMPLEADO = "FK_empleado";
	
	String TABLA_TICKETS_PRODUCTOS = "tickets";
	String TICKETS_PRODUCTOS_ID = "id";
	String TICKETS_PRODUCTOS_CANTIDAD = "cantidad";
	String TICKETS_PRODUCTOS_FK_PRODUCTO = "FK_producto";
	String TICKETS_PRODUCTOS_FK_TICKET = "FK_ticket";
	
	String TABLA_VI_PEDIDOS = "vi_pedidos";
	String VI_PEDIDOS_ID_PRODUCTO ="idProducto";
	String VI_PEDIDOS_NOMBRE ="nombre";
	String VI_PEDIDOS_IMAGEN ="imagen";
	String VI_PEDIDOS_PRECIO ="precio";
	String VI_PEDIDOS_CANTIDAD ="cantidad";
	String VI_PEDIDOS_ID_TICKET ="idTicket";
				
	//Definiciones
	public Connection conectar();
	public void desconectar(Connection con);
	
	List<Producto> obtenerProductos(Connection con);
	int obtenerNumeroTicket(Connection con);
	void insertarProductoPedido (Connection con, int cantidad, int idTicket, int idProducto);
	List<Pedido> obtenerPedidos(Connection con, int idTicket);
	List<Empleado> obtenerEmpleados(Connection con);
	void finalizarPedido (Connection con, int idTicket, int idEmpleado);
	void borrarProductoPedido (Connection con, int idTicket, int idProducto);

}
