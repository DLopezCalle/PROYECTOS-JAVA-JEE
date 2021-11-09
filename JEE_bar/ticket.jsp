<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.ipartek.modelo.dto.Pedido" %>
<%@ page import="com.ipartek.modelo.dto.Empleado" %>

<% 
HttpSession sesion = request.getSession();

List<Pedido> listaPedido = new ArrayList<Pedido>();
if(request.getAttribute("listaPedido")!=null)
{
	listaPedido = (List<Pedido>)request.getAttribute("listaPedido");
}

List<Empleado> listaEmpleados = new ArrayList<Empleado>();
if(request.getAttribute("listaEmpleados")!=null)
{
	listaEmpleados = (List<Empleado>)request.getAttribute("listaEmpleados");
}

int idEmpleado = 0;
if(sesion.getAttribute("idEmpleado")!=null)
{
	idEmpleado = (int)sesion.getAttribute("idEmpleado");
}

double total = 0.0;

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
			<a href="MostrarTicket"><img alt="C" src="imagenes/pedido.png" id="imgpedido"></a>
		</header>
		
		<section id="seccionTabla">
		
			<table>
				<thead>
					<tr>
					
						<th>idProducto</th>
						<th>Nombre</th>
						<th>Imagen</th>
						<th>Precio</th>
						<th>Cantidad</th>
						<th>idTicket</th>
						<th>Borrar</th>
						
					</tr>
				</thead>
				<tbody>
					<% for(Pedido pedido : listaPedido) { %>	
						<tr>
						
							<td><%= pedido.getIdProducto() %></td>
							<td><%= pedido.getNombre() %></td>
							<td class="cuadroImagen"><img alt="" src="imagenes/<%= pedido.getImagen() %>" class="imgproducto"></td>
							<td><%= pedido.getPrecio() %> euros</td>
							<td><%= pedido.getCantidad() %></td>
							<td><%= pedido.getIdTicket() %></td>
							<td class="cuadroImagen">
								<a href="BorrarProductoPedido?idProducto=<%= pedido.getIdProducto() %>">
									<img src="imagenes/borrar.png">
								</a>
							</td>
							
						</tr>
						
						<% total = total + ( pedido.getPrecio() * pedido.getCantidad()); %>
						
					<% } %>	
					
					
					
				</tbody>
			</table>
			</section>
			<section id="finalizar">
			
				<div id="total">TOTAL: <%= total %> euros</div>
				
				<form action="FinalizarPedido" method="GET">
					
					<label for="idEmpleado">Empleado: </label>
					<select name="idEmpleado">			
						<% for(Empleado empleado : listaEmpleados) { %>	
							<% if (empleado.getId() == idEmpleado) { %>
							
								<option selected value="<%= empleado.getId() %>"><%= empleado.getNombre() %></option>
							
							<% } else { %>	
						
								<option value="<%= empleado.getId() %>"><%= empleado.getNombre() %></option>
							
							<% } %>	
						<% } %>	
					</select>
					
					<input type="submit" value="Finalizar pedido">
					
				</form>
				
				
			
			</section>
	</body>
</html>