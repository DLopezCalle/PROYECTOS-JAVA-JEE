package com.ipartek.controlador;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.modelo.DB_Helper;
import com.ipartek.modelo.dto.Amigo;

@WebServlet("/AmigoAgregar")
public class AmigoAgregar extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
    public AmigoAgregar() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 1. Obtener los datos
		String nombre = "";
		if(request.getParameter("nombre")!=null)
		{
			nombre = (String)request.getParameter("nombre");
		}
		
		String apellidos = "";
		if(request.getParameter("apellidos")!=null)
		{
			apellidos = (String)request.getParameter("apellidos");
		}
		
		// 2. Maquetar los datos
		Amigo amigo = new Amigo (0, nombre, apellidos);
					
		// 3. Conectar a la BD
		DB_Helper db = new DB_Helper();
		Connection con = db.conectar();
						
		// 4. DO THINGS
		db.agregarAmigos(con, amigo);
						
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
