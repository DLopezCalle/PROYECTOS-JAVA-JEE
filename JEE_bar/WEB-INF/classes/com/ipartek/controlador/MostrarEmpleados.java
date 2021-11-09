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
import com.ipartek.modelo.dto.Empleado;

@WebServlet("/MostrarEmpleados")
public class MostrarEmpleados extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public MostrarEmpleados() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		DB_Helper db = new DB_Helper();
		Connection con = db.conectar();
		
		List<Empleado> listaEmpleados = db.obtenerEmpleados(con);
		
		db.desconectar(con);
		
		request.setAttribute("listaEmpleados", listaEmpleados);
		//request.setAttribute("numTicket", idTicketNumerico);
		
		request.getRequestDispatcher("empleado.jsp").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
