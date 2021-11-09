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

@WebServlet("/BorrarProductoPedido")
public class BorrarProductoPedido extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public BorrarProductoPedido() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession sesion = request.getSession();
		int idTicketNumerico = 0;
		if(sesion.getAttribute("numTicket")!=null)
		{
			idTicketNumerico = (int)sesion.getAttribute("numTicket");
		}
		
		String idProducto = "";
		int idProductoNumerico = 0;
		if(request.getParameter("idProducto")!=null)
		{
			idProducto = (String)request.getParameter("idProducto");
			idProductoNumerico = Integer.parseInt(idProducto);
		}
		
		DB_Helper db = new DB_Helper();
		Connection con = db.conectar();
		
		db.borrarProductoPedido(con, idTicketNumerico, idProductoNumerico);
		List<Pedido> listaPedido = db.obtenerPedidos(con, idTicketNumerico);
		List<Empleado> listaEmpleados = db.obtenerEmpleados(con);
		
		
		db.desconectar(con);
		
		// Me llevo el id del ticket para seguir agregando productos sobre el mismo
		request.setAttribute("listaPedido", listaPedido);
		request.setAttribute("listaEmpleados", listaEmpleados);
		
		request.getRequestDispatcher("ticket.jsp").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
