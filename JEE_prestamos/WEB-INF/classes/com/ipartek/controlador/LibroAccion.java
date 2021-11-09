package com.ipartek.controlador;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.modelo.DB_Helper;

@WebServlet("/LibroAccion")
public class LibroAccion extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
    public LibroAccion() {
        super();
    }
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
    	// 1. Obtener los datos
 		String accion = "";
 		if(request.getParameter("accion")!=null)
 		{
 			accion = (String)request.getParameter("accion");
 		}
 		
 		String idLibro = "";
 		int idLibroNumerico = 0;
 		if(request.getParameter("idLibro")!=null)
 		{
 			idLibro = (String)request.getParameter("idLibro");
 			idLibroNumerico = Integer.parseInt(idLibro);
 		}
 		
 		String ruta = "";
 		
 		if (accion.equalsIgnoreCase("modificar")) 
 		{
 			request.setAttribute("idAmigo", idLibroNumerico);
 			ruta = "LibroFormularioModificar";
 			
 		} else 
 		{
 			// 2. Maquetar los datos
 			
 			// 3. Conectar a la BD
 			DB_Helper db = new DB_Helper();
 			Connection con = db.conectar();
 							
 			// 4. DO THINGS
 			db.borrarLibros(con, idLibroNumerico);
 							
 			// 5. Desconectar de la BD
 			db.desconectar(con);
 							
 			// 6. Mochila
 							
 			// 7. Redirigir
 			ruta = "InicioAjustes";
 		}
 		
 		request.getRequestDispatcher(ruta).forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
