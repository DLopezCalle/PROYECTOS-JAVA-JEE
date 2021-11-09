<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.ipartek.modelo.dto.Producto" %>
<%@ page import="com.ipartek.modelo.dto.Pedido" %>
<% 

HttpSession sesion = request.getSession();

List<Producto> listaProductos = new ArrayList<Producto>();
if(request.getAttribute("listaProductos")!=null)
{
	listaProductos = (List<Producto>)request.getAttribute("listaProductos");
}

List<Pedido> listaPedido = new ArrayList<Pedido>();
if(request.getAttribute("listaPedido")!=null)
{
	listaPedido = (List<Pedido>)request.getAttribute("listaPedido");
}

int numTicket = 0;
if(sesion.getAttribute("numTicket")!=null)
{
	numTicket = (int)sesion.getAttribute("numTicket");
}

%> 
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<link rel="stylesheet" href="css/style.css">
		<title>Pedido</title>
	</head>
	<body>
		<header>
			<a href="VolverInicio"><img alt="B" src="imagenes/icono.png"></a>
			<h1>tuBar</h1>
			<a href="InicioWeb"><img alt="B" src="imagenes/plus.png"></a>
			<a href="MostrarEmpleados"><img alt="B" src="imagenes/empleado.png"></a>
			<a href="MostrarTicket?idTicket=<%= numTicket %>"><img alt="C" src="imagenes/pedido.png" id="imgpedido"></a>
			
		</header>
		
		<section id="articulos">
		
			<% for(Producto producto : listaProductos) { %>
			
			<form action="AgregarProductoPedido" method="GET" id="formulario<%= producto.getId() %>" class="articulo">
				
				<a href="javascript:{}" onclick="document.getElementById('formulario<%= producto.getId() %>').submit();">				
				
					<img alt="" src="imagenes/<%= producto.getImagen() %>" class="imgproducto">
					<div class="atributos"><%= producto.getNombre() %></div>
					<div class="atributos"><%= producto.getPrecio() %> euros</div>	
				
				</a>
				
				<input type="text" name="idProducto" value="<%= producto.getId() %>" hidden="">
				<label for="cantidad">Cantidad</label>
				<input type="number" name="cantidad" value="1" min="1" class="cantidad">
				
			</form>
			
			<% } %>
			
		</section>
		
	</body>
</html>