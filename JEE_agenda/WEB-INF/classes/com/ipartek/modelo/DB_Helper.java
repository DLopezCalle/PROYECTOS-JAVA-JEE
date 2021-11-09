package com.ipartek.modelo;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ipartek.modelo.dto.Contacto;

public class DB_Helper implements I_Conexion {
	
	@Override
	public Connection conectar () {		
		
		Connection con = null;
		try 
		{
			Class.forName(DRIVER);
			con = DriverManager.getConnection(CONEXION,USER,PASS);
			// System.out.println("Conexión OK");
			
		} catch (ClassNotFoundException e) 
		{
			System.out.println("NO SE ENCONTRÓ EL JAR");
			
		} catch (SQLException e) 
		{
			System.out.println("NO SE PUDO CONECTAR");
		}		
		
		return con;
		
	}
	
	// ------------------------------------------------------
	@Override
	public void desconectar (Connection con) {
		
		try 
		{
			con.close();
			// System.out.println("Conexión OK");
			
		} catch (SQLException e) 
		{
			System.out.println("NO SE PUEDO DESCONECTAR");
		}
		
	}
	
	// ------------------------------------------------------
	@Override
	public List<Contacto> obtenerContactos (Connection con) {
		
		List<Contacto> listado= new ArrayList<Contacto>();
		
		try {
			
			String sql="call pa_contacto_mostrar_todos ()";
			CallableStatement cStmt = con.prepareCall(sql);
			ResultSet rs = cStmt.executeQuery();
			
			while ( rs.next() ) {
				
				Contacto contacto = new Contacto();
				
				contacto.setId(rs.getInt(CONTACTOS_ID));
				contacto.setTelefono(rs.getString(CONTACTOS_TELEFONO));
				contacto.setNombre(rs.getString(CONTACTOS_NOMBRE));
				contacto.setApellidos(rs.getString(CONTACTOS_APELLIDOS));
				
				listado.add(contacto);
				
			}
	
		} catch (SQLException e) {
			
			System.out.println("NO SE HA ENCONTRADO CONTACTOS");
			return new ArrayList<Contacto>();
			
		}
		
		return listado;
		
	}
	
	// ------------------------------------------------------
	@Override
	public int borrarContacto (Connection con, int idContacto) {
					
		try {
			
			String sql = "call pa_contacto_borrar (?)";
			CallableStatement cStmt = con.prepareCall(sql);	
			
			cStmt.setInt(1, idContacto);
			
			cStmt.execute();
			
		} catch (SQLException e) {
			
			System.out.println("ERROR AL BORRAR");
			return 0;
			
		}
		
		return 1;
			
	}
	
	// ------------------------------------------------------
	@Override
	public int agregarContacto (Connection con, Contacto contacto) {
					
		try {
			
			String sql = "call pa_contacto_agregar (?, ?, ?)";
			CallableStatement cStmt = con.prepareCall(sql);	
			
			cStmt.setString(1, contacto.getTelefono());
			cStmt.setString(2, contacto.getNombre());
			cStmt.setString(3, contacto.getApellidos());
			
			cStmt.execute();
			
		} catch (SQLException e) {
			
			System.out.println("ERROR AL AGREGAR");
			return 0;
			
		}
		
		return 1;
			
	}
}
