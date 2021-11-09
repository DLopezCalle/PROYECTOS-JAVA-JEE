package com.ipartek.modelo;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ipartek.modelo.dto.Empleado;
import com.ipartek.modelo.dto.Pedido;
import com.ipartek.modelo.dto.Producto;
import com.ipartek.modelo.dto.Ticket;

public class DB_Helper implements I_Conexion {
	
	@Override
	public Connection conectar() {		
		
		Connection con = null;
		try {
			Class.forName(DRIVER);
			con = DriverManager.getConnection(CONEXION,USER,PASS);
			System.out.println("Conexión OK");
			
		} catch (ClassNotFoundException e) {
			System.out.println("NO SE ENCONTRÓ EL JAR");
			
		} catch (SQLException e) {
			System.out.println("NO SE PUDO CONECTAR");
		}		
		
		return con;
		
	}

	@Override
	public void desconectar(Connection con) {
		
		try {
			con.close();
		} catch (SQLException e) {
			System.out.println("NO SE PUEDO DESCONECTAR");
		}
		
	}
	
	@Override
	public List<Producto> obtenerProductos(Connection con) {
		
		List<Producto> listado= new ArrayList<Producto>();
		
		try {
			String sql="call pa_productos_mostrar()";
			CallableStatement cStmt = con.prepareCall(sql);
			ResultSet rs=cStmt.executeQuery();
			
			while(rs.next())
			{
				Producto producto = new Producto();
				producto.setId(rs.getInt(PRODUCTOS_ID));
				producto.setNombre(rs.getString(PRODUCTOS_NOMBRE));
				producto.setImagen(rs.getString(PRODUCTOS_IMAGEN));
				producto.setPrecio(rs.getDouble(PRODUCTOS_PRECIO));
				
				listado.add(producto);
				
			}
	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			return new ArrayList<Producto>();
		}
		return listado;
	}
	
	@Override
	public int obtenerNumeroTicket(Connection con) {
		
		List<Ticket> listado= new ArrayList<Ticket>();
		
		int numTicket = 0;
		
		try {
			String sql="call pa_ticket_numero()";
			CallableStatement cStmt = con.prepareCall(sql);
			ResultSet rs=cStmt.executeQuery();
			
			while(rs.next())
			{
				Ticket ticket = new Ticket();
				ticket.setId(rs.getInt(TICKETS_ID));
				ticket.setIdEmpleado(rs.getInt(TICKETS_FK_EMPLEADO));
				
				numTicket = ticket.getId() + 1;
				
				listado.add(ticket);
				
			}
	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			return 8;
		}
		return numTicket;
	}
	
	@Override
	public void insertarProductoPedido (Connection con, int cantidad, int idTicket, int idProducto) {
					
		try {
			
			String sql = "call pa_pedido_insertar(?, ?, ?)";
			CallableStatement cStmt = con.prepareCall(sql);	
			
			cStmt.setInt(1, cantidad);
			cStmt.setInt(2, idTicket);
			cStmt.setInt(3, idProducto);
			
			cStmt.execute();
			
		} catch (SQLException e) {
			System.out.println("ERROR AL INSERTAR");
		}
			
	}
	
	@Override
	public List<Pedido> obtenerPedidos(Connection con, int idTicket) {
		
		List<Pedido> listado= new ArrayList<Pedido>();
		
		try {
			String sql="call pa_pedidos_mostrar(?)";
			CallableStatement cStmt = con.prepareCall(sql);
			cStmt.setInt(1, idTicket);
			ResultSet rs=cStmt.executeQuery();
			
			while(rs.next())
			{
				Pedido pedido = new Pedido();
				pedido.setIdProducto(rs.getInt(VI_PEDIDOS_ID_PRODUCTO));
				pedido.setNombre(rs.getString(VI_PEDIDOS_NOMBRE));
				pedido.setImagen(rs.getString(VI_PEDIDOS_IMAGEN));
				pedido.setPrecio(rs.getDouble(VI_PEDIDOS_PRECIO));
				pedido.setCantidad(rs.getInt(VI_PEDIDOS_CANTIDAD));
				pedido.setIdTicket(rs.getInt(VI_PEDIDOS_ID_TICKET));
				
				listado.add(pedido);
				
			}
	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			return new ArrayList<Pedido>();
		}
		return listado;
	}
	
	@Override
	public List<Empleado> obtenerEmpleados(Connection con) {
		
		List<Empleado> listado= new ArrayList<Empleado>();
		
		try {
			String sql="call pa_empleados_mostrar()";
			CallableStatement cStmt = con.prepareCall(sql);
			ResultSet rs=cStmt.executeQuery();
			
			while(rs.next())
			{
				Empleado empleado = new Empleado();
				empleado.setId(rs.getInt(EMPLEADOS_ID));
				empleado.setNombre(rs.getString(EMPLEADOS_NOMBRE));
				
				listado.add(empleado);
				
			}
	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			return new ArrayList<Empleado>();
		}
		return listado;
	}
	
	@Override
	public void finalizarPedido (Connection con, int idTicket, int idEmpleado) {
					
		try {
			
			String sql = "call pa_pedido_finalizar(?, ?)";
			CallableStatement cStmt = con.prepareCall(sql);	
			
			cStmt.setInt(1, idTicket);
			cStmt.setInt(2, idEmpleado);
			
			cStmt.execute();
			
		} catch (SQLException e) {
			System.out.println("ERROR AL FINALIZAR EL PEDIDO");
		}
			
	}
	
	@Override
	public void borrarProductoPedido (Connection con, int idTicket, int idProducto) {
					
		try {
			
			String sql = "call pa_pedido_borrar(?, ?)";
			CallableStatement cStmt = con.prepareCall(sql);	
			
			cStmt.setInt(1, idTicket);
			cStmt.setInt(2, idProducto);
			
			cStmt.execute();
			
		} catch (SQLException e) {
			System.out.println("ERROR AL BORRAR");
		}
			
	}

}
