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

@WebServlet("/LibroModificar")
public class LibroModificar extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public LibroModificar() {
        super();
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
    	// 1. Obtener los datos
 		String idLibro = "";
 		int idLibroNumerico = 0;
 		if(request.getParameter("idLibro")!=null)
 		{
 			idLibro = (String)request.getParameter("idLibro");
 			idLibroNumerico = Integer.parseInt(idLibro);
 		}
 		
 		String titulo = "";
 		if(request.getParameter("titulo")!=null)
 		{
 			titulo = (String)request.getParameter("titulo");
 		}
 		
 		// 2. Maquetar los datos
 		Libro libro = new Libro (idLibroNumerico, titulo);
 					
 		// 3. Conectar a la BD
 		DB_Helper db = new DB_Helper();
 		Connection con = db.conectar();
 						
 		// 4. DO THINGS
 		db.modificarLibros(con, libro);
 						
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
