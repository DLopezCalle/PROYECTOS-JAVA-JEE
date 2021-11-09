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
import com.ipartek.modelo.dto.Contacto;

@WebServlet("/InicioWeb")
public class InicioWeb extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public InicioWeb() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// Recibir parámetros
		String irAdmin = "";
		int irAdminNumerico = 0;
		
		if( request.getParameter("irAdmin") != null)
		{
			irAdmin = (String)request.getParameter("irAdmin");
			irAdminNumerico = Integer.parseInt(irAdmin);
		}
		
		/* En caso de que venga desde un servlet */
		if( request.getAttribute("irAdmin") != null)
		{
			irAdminNumerico = (int)request.getAttribute("irAdmin");
		}
		
		int borrado = 0;
		if( request.getAttribute("borrado") != null)
		{
			borrado = (int)request.getAttribute("borrado");
		}
		
		int agregado = 0;
		if( request.getAttribute("agregado") != null)
		{
			agregado = (int)request.getAttribute("agregado");
		}
		
		// Conectar a la BD
		DB_Helper db = new DB_Helper();
		Connection con = db.conectar();
		
		// Buscar todos los datos de contactos
		List<Contacto> listaContactos = db.obtenerContactos(con);
		
		// Desconectar de la BD
		db.desconectar(con);
		
		// Guardar la lista en la mochila
		request.setAttribute("listaContactos", listaContactos);
		request.setAttribute("borrado", borrado);
		request.setAttribute("agregado", agregado);
		
		// Redirigir a index o admin
		String ruta = "";		
		if ( irAdminNumerico == 1 ) { ruta = "admin.jsp";	} else { ruta = "index.jsp"; }
		
		request.getRequestDispatcher(ruta).forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
