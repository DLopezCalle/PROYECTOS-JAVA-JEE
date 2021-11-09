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
import com.ipartek.modelo.dto.Amigo;
import com.ipartek.modelo.dto.Libro;

@WebServlet("/InicioAjustes")
public class InicioAjustes extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public InicioAjustes() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 1. Obtener los datos
				
		// 2. Maquetar los datos
				
		// 3. Conectar a la BD
		DB_Helper db = new DB_Helper();
		Connection con = db.conectar();
				
		// 4. DO THINGS
		List<Amigo> listaAmigos = db.obtenerAmigos(con);
		List<Libro> listaLibros = db.obtenerLibros(con);
				
		// 5. Desconectar de la BD
		db.desconectar(con);
				
		// 6. Mochila
		request.setAttribute("listaAmigos", listaAmigos);
		request.setAttribute("listaLibros", listaLibros);
				
		// 7. Redirigir
		request.getRequestDispatcher("ajustes.jsp").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
