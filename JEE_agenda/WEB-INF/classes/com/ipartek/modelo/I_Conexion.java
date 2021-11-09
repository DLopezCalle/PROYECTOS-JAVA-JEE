package com.ipartek.modelo;

import java.sql.Connection;
import java.util.List;

import com.ipartek.modelo.dto.Contacto;

public interface I_Conexion {
	
	//Constantes 	
	String DRIVER = "com.mysql.jdbc.Driver";
	String BD = "db_agenda";
	String USER = "root";
	String PASS = "admin";
	String CONEXION = "jdbc:mysql://localhost:3306/" + BD;
				
	// Datos de los DTO
	String TABLA_CONTACTOS = "contactos";
	String CONTACTOS_ID = "id";
	String CONTACTOS_TELEFONO = "telefono";
	String CONTACTOS_NOMBRE = "nombre";
	String CONTACTOS_APELLIDOS = "apellidos";
				
	//Definiciones
	public Connection conectar();
	public void desconectar(Connection con);
	
	List<Contacto> obtenerContactos (Connection con);
	int borrarContacto (Connection con, int idContacto);
	int agregarContacto (Connection con, Contacto contacto);

}
