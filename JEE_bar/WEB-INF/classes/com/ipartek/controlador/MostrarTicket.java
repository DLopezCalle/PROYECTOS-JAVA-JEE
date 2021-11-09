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
import com.ipartek.modelo.dto.Empleado;
import com.ipartek.modelo.dto.Pedido;

@WebServlet("/MostrarTicket")
public class MostrarTicket extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public MostrarTicket() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession sesion = request.getSession();
		int idTicketNumerico = 0;
		if(sesion.getAttribute("numTicket")!=null)
		{
			idTicketNumerico = (int)sesion.getAttribute("numTicket");
		}
		
		DB_Helper db = new DB_Helper();
		Connection con = db.conectar();
		
		List<Pedido> listaPedido = db.obtenerPedidos(con, idTicketNumerico);
		List<Empleado> listaEmpleados = db.obtenerEmpleados(con);
		
		db.desconectar(con);
		
		request.setAttribute("listaPedido", listaPedido);
		request.setAttribute("listaEmpleados", listaEmpleados);
		//request.setAttribute("numTicket", idTicketNumerico);
		
		request.getRequestDispatcher("ticket.jsp").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
