package com.ipartek.controlador;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.modelo.DB_Helper;

@WebServlet("/PrestadoBorrar")
public class PrestadoBorrar extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
    public PrestadoBorrar() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// 1. Obtener los datos
		String idPrestado = "";
		int idPrestadoNumerico = 0;
		if(request.getParameter("idPrestado")!=null)
		{
			idPrestado = (String)request.getParameter("idPrestado");
			idPrestadoNumerico = Integer.parseInt(idPrestado);
		}
		
		// 2. Maquetar los datos
				
		// 3. Conectar a la BD
		DB_Helper db = new DB_Helper();
		Connection con = db.conectar();
				
		// 4. DO THINGS
		db.borrarPrestados(con, idPrestadoNumerico);
			
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
