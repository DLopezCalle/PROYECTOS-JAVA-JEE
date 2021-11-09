package com.ipartek.controlador;

import java.io.IOException;
import java.sql.Connection;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ipartek.modelo.DB_Helper;
import com.ipartek.modelo.dto.Producto;

@WebServlet("/InicioWeb")
public class InicioWeb extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public InicioWeb() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 1. Obtener los datos
		String idEmpleado = "";
		int idEmpleadoNumerico = 1;
		if(request.getParameter("idEmpleado")!=null)
		{
			idEmpleado = (String)request.getParameter("idEmpleado");
			idEmpleadoNumerico = Integer.parseInt(idEmpleado);
		}
		
		// 2. Maquetar los datos
		
		// 3. Conectar a la BD
		DB_Helper db = new DB_Helper();
		Connection con = db.conectar();
		
		// 4. DO THINGS
		List<Producto> listaProductos = db.obtenerProductos(con);
		int numTicket = db.obtenerNumeroTicket(con);
		
		// 5. Desconectar de la BD
		db.desconectar(con);
		
		// 6. Mochila
		HttpSession sesion = request.getSession();
		sesion.setAttribute("idEmpleado", idEmpleadoNumerico);
		sesion.setAttribute("numTicket", numTicket);
		request.setAttribute("listaProductos", listaProductos);
		
		// 7. Redirigir
		request.getRequestDispatcher("inicio.jsp").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
