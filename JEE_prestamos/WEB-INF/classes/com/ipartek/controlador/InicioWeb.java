package com.ipartek.controlador;

import java.io.IOException;
import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.modelo.DB_Helper;
import com.ipartek.modelo.dto.Amigo;
import com.ipartek.modelo.dto.Libro;
import com.ipartek.modelo.dto.LibroPrestado;

@WebServlet("/InicioWeb")
public class InicioWeb extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public InicioWeb() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 1. Obtener los datos
		Date fecha = new Date();
		SimpleDateFormat ft = new SimpleDateFormat ("yyyy-MM-dd");
		String hoy = ft.format(fecha);
		
		// 2. Maquetar los datos
		
		// 3. Conectar a la BD
		DB_Helper db = new DB_Helper();
		Connection con = db.conectar();
		
		// 4. DO THINGS
		List<LibroPrestado> listaPrestados = db.obtenerLibrosPrestados(con);
		List<Amigo> listaAmigos = db.obtenerAmigos(con);
		List<Libro> listaLibros = db.obtenerLibros(con);
		
		// 5. Desconectar de la BD
		db.desconectar(con);
		
		// 6. Mochila
		request.setAttribute("listaPrestados", listaPrestados);
		request.setAttribute("listaAmigos", listaAmigos);
		request.setAttribute("listaLibros", listaLibros);
		request.setAttribute("fecha", hoy);
		
		// 7. Redirigir
		request.getRequestDispatcher("inicio.jsp").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
