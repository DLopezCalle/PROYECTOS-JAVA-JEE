package com.ipartek.controlador;

import java.io.IOException;
import java.sql.Connection;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.modelo.DB_Helper;
import com.ipartek.modelo.dto.Producto;

@WebServlet("/VolverInicio")
public class VolverInicio extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public VolverInicio() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 3. Conectar a la BD
		DB_Helper db = new DB_Helper();
		Connection con = db.conectar();
				
		// 4. DO THINGS
		List<Producto> listaProductos = db.obtenerProductos(con);
		
		// 5. Desconectar de la BD
		db.desconectar(con);
				
		// 6. Mochila
		request.setAttribute("listaProductos", listaProductos);
			
		// 7. Redirigir
		request.getRequestDispatcher("inicio.jsp").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
