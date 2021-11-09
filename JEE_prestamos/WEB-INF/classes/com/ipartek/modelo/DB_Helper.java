package com.ipartek.modelo;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ipartek.modelo.dto.Amigo;
import com.ipartek.modelo.dto.AmigoLibro;
import com.ipartek.modelo.dto.Libro;
import com.ipartek.modelo.dto.LibroPrestado;

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
	public List<LibroPrestado> obtenerLibrosPrestados(Connection con) {
		
		List<LibroPrestado> listado = new ArrayList<LibroPrestado>();
		
		try {
			
			String sql="call pa_prestados_mostrar()";
			CallableStatement cStmt = con.prepareCall(sql);
			ResultSet rs=cStmt.executeQuery();
			
			while(rs.next())
			{
				LibroPrestado libroPrestado = new LibroPrestado();
				
				libroPrestado.setId(rs.getInt(LIBROS_PRESTADOS_ID));
				libroPrestado.setNombre(rs.getString(LIBROS_PRESTADOS_NOMBRE));
				libroPrestado.setApellidos(rs.getString(LIBROS_PRESTADOS_APELLIDOS));
				libroPrestado.setTitulo(rs.getString(LIBROS_PRESTADOS_TITULO));
				libroPrestado.setFecha(rs.getString(LIBROS_PRESTADOS_FECHA));
				
				listado.add(libroPrestado);				
			}
	
		} catch (SQLException e) 
		{
			return new ArrayList<LibroPrestado>();
		}
		return listado;
	}
	
	@Override
	public List<Amigo> obtenerAmigos(Connection con) {
		
		List<Amigo> listado = new ArrayList<Amigo>();
		
		try {
			
			String sql="call pa_amigos_mostrar()";
			CallableStatement cStmt = con.prepareCall(sql);
			ResultSet rs=cStmt.executeQuery();
			
			while(rs.next())
			{
				Amigo amigo = new Amigo();
				
				amigo.setId(rs.getInt(AMIGOS_ID));
				amigo.setNombre(rs.getString(AMIGOS_NOMBRE));
				amigo.setApellidos(rs.getString(AMIGOS_APELLIDOS));
				
				listado.add(amigo);				
			}
	
		} catch (SQLException e) 
		{
			return new ArrayList<Amigo>();
		}
		return listado;
	}
	
	@Override
	public List<Libro> obtenerLibros(Connection con) {
		
		List<Libro> listado = new ArrayList<Libro>();
		
		try {
			
			String sql="call pa_libros_mostrar()";
			CallableStatement cStmt = con.prepareCall(sql);
			ResultSet rs=cStmt.executeQuery();
			
			while(rs.next())
			{
				Libro libro = new Libro();
				
				libro.setId(rs.getInt(LIBROS_ID));
				libro.setTitulo(rs.getString(LIBROS_TITULO));
				
				listado.add(libro);				
			}
	
		} catch (SQLException e) 
		{
			return new ArrayList<Libro>();
		}
		return listado;
	}
	
	@Override
	public void borrarPrestados (Connection con, int idPrestado) {
					
		try {
			
			String sql = "call pa_prestados_borrar(?)";
			CallableStatement cStmt = con.prepareCall(sql);	
			
			cStmt.setInt(1, idPrestado);
			
			cStmt.execute();
			
		} catch (SQLException e) {
			System.out.println("ERROR AL BORRAR");
		}
			
	}
	
	@Override
	public void agregarLibroPrestado (Connection con, AmigoLibro amigoLibro) {
					
		try {
			
			String sql = "call pa_prestados_agregar (?, ?, ?)";
			CallableStatement cStmt = con.prepareCall(sql);	
			
			cStmt.setString(1, amigoLibro.getFecha());
			cStmt.setInt(2, amigoLibro.getFK_amigo());
			cStmt.setInt(3, amigoLibro.getFK_libro());
			
			cStmt.execute();
			
		} catch (SQLException e) {
			System.out.println("ERROR AL AGREGAR EL LIBRO PRESTADO");
		}
			
	}
	
	@Override
	public void borrarAmigos (Connection con, int idAmigo) {
					
		try {
			
			String sql = "call pa_amigos_borrar(?)";
			CallableStatement cStmt = con.prepareCall(sql);	
			
			cStmt.setInt(1, idAmigo);
			
			cStmt.execute();
			
		} catch (SQLException e) 
		{
			System.out.println("ERROR AL BORRAR EL AMIGO");
		}
			
	}
	
	@Override
	public List<Amigo> obtenerAmigosId(Connection con, int idAmigo) {
		
		List<Amigo> listado = new ArrayList<Amigo>();
		
		try {
			
			String sql="call pa_amigos_mostrar_id(?)";
			CallableStatement cStmt = con.prepareCall(sql);
			
			cStmt.setInt(1, idAmigo);
			
			ResultSet rs=cStmt.executeQuery();
			
			while(rs.next())
			{
				Amigo amigo = new Amigo();
				
				amigo.setId(rs.getInt(AMIGOS_ID));
				amigo.setNombre(rs.getString(AMIGOS_NOMBRE));
				amigo.setApellidos(rs.getString(AMIGOS_APELLIDOS));
				
				listado.add(amigo);				
			}
	
		} catch (SQLException e) 
		{
			return new ArrayList<Amigo>();
		}
		return listado;
	}
	
	@Override
	public void modificarAmigos (Connection con, Amigo amigo) {
					
		try {
			
			String sql = "call pa_amigos_modificar(?, ?, ?)";
			CallableStatement cStmt = con.prepareCall(sql);	
			
			cStmt.setInt(1, amigo.getId());
			cStmt.setString(2, amigo.getNombre());
			cStmt.setString(3, amigo.getApellidos());
			
			cStmt.execute();
			
		} catch (SQLException e) 
		{
			System.out.println("ERROR AL MODIFICAR EL AMIGO");
		}
			
	}
	
	@Override
	public void agregarAmigos (Connection con, Amigo amigo) {
					
		try {
			
			String sql = "call pa_amigos_agregar(?, ?)";
			CallableStatement cStmt = con.prepareCall(sql);	
			
			cStmt.setString(1, amigo.getNombre());
			cStmt.setString(2, amigo.getApellidos());
			
			cStmt.execute();
			
		} catch (SQLException e) 
		{
			System.out.println("ERROR AL AGREGAR EL AMIGO");
		}
			
	}
	
	@Override
	public List<Amigo> filtrarAmigos(Connection con, String texto) {
		
		List<Amigo> listado = new ArrayList<Amigo>();
		
		try {
			
			String sql="call pa_amigos_filtrar(?)";
			CallableStatement cStmt = con.prepareCall(sql);
			
			cStmt.setString(1, texto);
			
			ResultSet rs = cStmt.executeQuery();
			
			while(rs.next())
			{
				Amigo amigo = new Amigo();
				
				amigo.setId(rs.getInt(AMIGOS_ID));
				amigo.setNombre(rs.getString(AMIGOS_NOMBRE));
				amigo.setApellidos(rs.getString(AMIGOS_APELLIDOS));
				
				listado.add(amigo);				
			}
	
		} catch (SQLException e) 
		{
			System.out.println("ERROR AL FILTRAR AMIGOS");
			return new ArrayList<Amigo>();
		}
		return listado;
	}
	
	@Override
	public List<Libro> filtrarLibros(Connection con, String texto) {
		
		List<Libro> listado = new ArrayList<Libro>();
		
		try {
			
			String sql="call pa_libros_filtrar(?)";
			CallableStatement cStmt = con.prepareCall(sql);
			
			cStmt.setString(1, texto);
			
			ResultSet rs = cStmt.executeQuery();
			
			while(rs.next())
			{
				Libro libro = new Libro();
				
				libro.setId(rs.getInt(LIBROS_ID));
				libro.setTitulo(rs.getString(LIBROS_TITULO));
				
				listado.add(libro);				
			}
	
		} catch (SQLException e) 
		{
			System.out.println("ERROR AL FILTRAR LIBROS");
			return new ArrayList<Libro>();
		}
		return listado;
	}
	
	//-----------------------------------------------LIBROS------------------------------------------------
	
	@Override
	public void borrarLibros (Connection con, int idLibro) {
					
		try {
			
			String sql = "call pa_libros_borrar(?)";
			CallableStatement cStmt = con.prepareCall(sql);	
			
			cStmt.setInt(1, idLibro);
			
			cStmt.execute();
			
		} catch (SQLException e) 
		{
			System.out.println("ERROR AL BORRAR EL LIBRO");
		}
			
	}
	
	@Override
	public List<Libro> obtenerLibrosId(Connection con, int idLibro) {
		
		List<Libro> listado = new ArrayList<Libro>();
		
		try {
			
			String sql="call pa_libros_mostrar_id(?)";
			CallableStatement cStmt = con.prepareCall(sql);
			
			cStmt.setInt(1, idLibro);
			
			ResultSet rs = cStmt.executeQuery();
			
			while(rs.next())
			{
				Libro libro = new Libro();
				
				libro.setId(rs.getInt(LIBROS_ID));
				libro.setTitulo(rs.getString(LIBROS_TITULO));
				
				listado.add(libro);				
			}
	
		} catch (SQLException e) 
		{
			return new ArrayList<Libro>();
		}
		return listado;
	}
	
	@Override
	public void modificarLibros (Connection con, Libro libro) {
					
		try {
			
			String sql = "call pa_libros_modificar(?, ?)";
			CallableStatement cStmt = con.prepareCall(sql);	
			
			cStmt.setInt(1, libro.getId());
			cStmt.setString(2, libro.getTitulo());
			
			cStmt.execute();
			
		} catch (SQLException e) 
		{
			System.out.println("ERROR AL MODIFICAR EL LIBRO");
		}
			
	}
	
	@Override
	public void agregarLibros (Connection con, Libro libro) {
					
		try {
			
			String sql = "call pa_libros_agregar(?)";
			CallableStatement cStmt = con.prepareCall(sql);	
			
			cStmt.setString(1, libro.getTitulo());
			
			cStmt.execute();
			
		} catch (SQLException e) 
		{
			System.out.println("ERROR AL AGREGAR EL LIBRO");
		}
			
	}

}
