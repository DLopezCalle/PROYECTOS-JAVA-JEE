package com.ipartek.controlador;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.modelo.DB_Helper;
import com.ipartek.modelo.dto.Libro;

@WebServlet("/LibroAgregar")
public class LibroAgregar extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public LibroAgregar() {
        super();
    }
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
    	// 1. Obtener los datos
 		String titulo = "";
 		if(request.getParameter("titulo")!=null)
 		{
 			titulo = (String)request.getParameter("titulo");
 		}
 		
 		// 2. Maquetar los datos
 		Libro libro = new Libro (0, titulo);
 					
 		// 3. Conectar a la BD
 		DB_Helper db = new DB_Helper();
 		Connection con = db.conectar();
 						
 		// 4. DO THINGS
 		db.agregarLibros(con, libro);
 						
 		// 5. Desconectar de la BD
 		db.desconectar(con);
 						
 		// 6. Mochila
 						
 		// 7. Redirigir
 		request.getRequestDispatcher("InicioAjustes").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
