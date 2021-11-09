package com.ipartek.controlador;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.modelo.DB_Helper;

@WebServlet("/BorrarContacto")
public class BorrarContacto extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public BorrarContacto() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// Recibir parámetros
		String idContacto = "";
		int idContactoNumerico = 0;
				
		if ( request.getParameter("idContacto") != null )
		{
			idContacto = (String)request.getParameter("idContacto");
			idContactoNumerico = Integer.parseInt(idContacto);
		}
		
		// Conectar a la BD
		DB_Helper db = new DB_Helper();
		Connection con = db.conectar();
				
		// Borrar los datos del contacto con el id recibido
		int borrado = db.borrarContacto(con, idContactoNumerico);
				
		// Desconectar de la BD
		db.desconectar(con);
				
		// Guardar "borrado" para informar si se ha borrado correctamente el contacto
		request.setAttribute("borrado", borrado);
		request.setAttribute("irAdmin", 1);
				
		// Redirigir
		request.getRequestDispatcher("InicioWeb").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
