package com.ipartek.controlador;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.modelo.DB_Helper;
import com.ipartek.modelo.dto.AmigoLibro;

@WebServlet("/PrestadoAgregar")
public class PrestadoAgregar extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public PrestadoAgregar() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 1. Obtener los datos
		String fecha = "";
		if(request.getParameter("fecha")!=null)
		{
			fecha = (String)request.getParameter("fecha");
		}
		
		String idAmigo = "";
		int idAmigoNumerico = 0;
		if(request.getParameter("idAmigo")!=null)
		{
			idAmigo = (String)request.getParameter("idAmigo");
			idAmigoNumerico = Integer.parseInt(idAmigo);
		}
		
		String idLibro = "";
		int idLibroNumerico = 0;
		if(request.getParameter("idLibro")!=null)
		{
			idLibro = (String)request.getParameter("idLibro");
			idLibroNumerico = Integer.parseInt(idLibro);
		}
		
		// 2. Maquetar los datos
		AmigoLibro amigoLibro = new AmigoLibro(0, fecha, idAmigoNumerico, idLibroNumerico);
				
		// 3. Conectar a la BD
		DB_Helper db = new DB_Helper();
		Connection con = db.conectar();
		
		// 4. DO THINGS
		db.agregarLibroPrestado (con, amigoLibro);
		
		// 5. Desconectar de la BD
		db.desconectar(con);
		
		// 6. Mochila
				
		// 7. Redirigir
		request.getRequestDispatcher("InicioWeb").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
