package com.ipartek.controlador;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ipartek.modelo.DB_Helper;

@WebServlet("/FinalizarPedido")
public class FinalizarPedido extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public FinalizarPedido() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession sesion = request.getSession();
		int idTicketNumerico = 0;
		if(sesion.getAttribute("numTicket")!=null)
		{
			idTicketNumerico = (int)sesion.getAttribute("numTicket");
		}
		
		String idEmpleado = "";
		int idEmpleadoNumerico = 0;
		if(request.getParameter("idEmpleado")!=null)
		{
			idEmpleado = (String)request.getParameter("idEmpleado");
			idEmpleadoNumerico = Integer.parseInt(idEmpleado);
		}
		
		System.out.println("empleado: "+idEmpleadoNumerico);
		
		DB_Helper db = new DB_Helper();
		Connection con = db.conectar();
		
		db.finalizarPedido(con, idTicketNumerico, idEmpleadoNumerico);
		
		db.desconectar(con);
		sesion.invalidate();
		
		request.getRequestDispatcher("InicioWeb").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
