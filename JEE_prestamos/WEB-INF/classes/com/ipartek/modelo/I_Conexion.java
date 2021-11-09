package com.ipartek.modelo;

import java.sql.Connection;
import java.util.List;

import com.ipartek.modelo.dto.Amigo;
import com.ipartek.modelo.dto.AmigoLibro;
import com.ipartek.modelo.dto.Libro;
import com.ipartek.modelo.dto.LibroPrestado;

public interface I_Conexion {
	
	//Constantes 	
	String DRIVER = "com.mysql.jdbc.Driver";
	String BD = "db_prestamos";
	String USER = "root";
	String PASS = "admin";
	String CONEXION = "jdbc:mysql://localhost:3306/" + BD;
				
	// Datos de los DTO
	String TABLA_AMIGOS = "amigos";
	String AMIGOS_ID = "id";
	String AMIGOS_NOMBRE = "nombre";
	String AMIGOS_APELLIDOS = "apellidos";
	
	String TABLA_LIBROS = "libros";
	String LIBROS_ID = "id";
	String LIBROS_TITULO = "titulo";
	
	String TABLA_AMIGOS_LIBROS = "amigos_libros";
	String AMIGOS_LIBROS_ID = "id";
	String AMIGOS_LIBROS_FECHA = "fecha";
	String AMIGOS_LIBROS_FK_AMIGO = "FK_amigo";
	String AMIGOS_LIBROS_FK_LIBRO = "FK_libros";
	
	String TABLA_LIBROS_PRESTADOS = "vi_libros_prestados";
	String LIBROS_PRESTADOS_ID = "id";
	String LIBROS_PRESTADOS_NOMBRE = "nombre";
	String LIBROS_PRESTADOS_APELLIDOS = "apellidos";
	String LIBROS_PRESTADOS_TITULO = "titulo";
	String LIBROS_PRESTADOS_FECHA = "fecha";
				
	//Definiciones
	public Connection conectar();
	public void desconectar(Connection con);
	
	List<LibroPrestado> obtenerLibrosPrestados(Connection con);
	List<Amigo> obtenerAmigos(Connection con);
	List<Libro> obtenerLibros(Connection con);
	void borrarPrestados (Connection con, int idPrestado);
	void agregarLibroPrestado (Connection con, AmigoLibro amigoLibro);
	
	void borrarAmigos (Connection con, int idAmigo);
	List<Amigo> obtenerAmigosId(Connection con, int idAmigo);
	void modificarAmigos (Connection con, Amigo amigo);
	void agregarAmigos (Connection con, Amigo amigo);
	
	List<Amigo> filtrarAmigos(Connection con, String texto);
	List<Libro> filtrarLibros(Connection con, String texto);
	
	void borrarLibros (Connection con, int idLibro);
	List<Libro> obtenerLibrosId(Connection con, int idLibro);
	void modificarLibros (Connection con, Libro libro);
	void agregarLibros (Connection con, Libro libro);
	

}
