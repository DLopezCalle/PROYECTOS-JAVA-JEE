package com.ipartek.controlador;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.modelo.DB_Helper;
import com.ipartek.modelo.dto.Contacto;

@WebServlet("/AgregarContacto")
public class AgregarContacto extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public AgregarContacto() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// Recibir parámetros
		String telefono = "";						
		if ( request.getParameter("telefono") != null )
		{
			telefono = (String)request.getParameter("telefono");
		}
		//------------------------------------------------------
		String nombre = "";						
		if ( request.getParameter("nombre") != null )
		{
			nombre = (String)request.getParameter("nombre");
		}
		//------------------------------------------------------
		String apellidos = "";						
		if ( request.getParameter("apellidos") != null )
		{
			apellidos = (String)request.getParameter("apellidos");
		}
		
		// Maquetar los parámetros en la DTO
		Contacto contacto = new Contacto (0, telefono, nombre, apellidos);
				
		// Conectar a la BD
		DB_Helper db = new DB_Helper();
		Connection con = db.conectar();
						
		// Agregar un nuevo contacto con los datos recibidos
		int agregado = db.agregarContacto(con, contacto);
						
		// Desconectar de la BD
		db.desconectar(con);
						
		// Guardar "agregado" para informar si se ha agregado correctamente el contacto
		request.setAttribute("agregado", agregado);
		request.setAttribute("irAdmin", 1);
						
		// Redirigir
		request.getRequestDispatcher("InicioWeb").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
