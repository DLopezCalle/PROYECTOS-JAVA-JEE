<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.ipartek.modelo.dto.Empleado" %>
<% 

HttpSession sesion = request.getSession();
int numTicket = 0;
if(sesion.getAttribute("numTicket")!=null)
{
	numTicket = (int)sesion.getAttribute("numTicket");
}

List<Empleado> listaEmpleados = new ArrayList<Empleado>();
if(request.getAttribute("listaEmpleados")!=null)
{
	listaEmpleados = (List<Empleado>)request.getAttribute("listaEmpleados");
}

%> 

<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<link rel="stylesheet" href="css/style.css">
		<title>Usuario</title>
	</head>
	<body>
		<header>
			<a href="VolverInicio"><img alt="B" src="imagenes/icono.png"></a>			
			<h1>tuBar</h1>
			<a href="InicioWeb"><img alt="B" src="imagenes/plus.png"></a>
			<a href="MostrarEmpleados"><img alt="B" src="imagenes/empleado.png"></a>
			<a href="MostrarTicket?idTicket=<%= numTicket %>"><img alt="C" src="imagenes/pedido.png" id="imgpedido"></a>
		</header>
		
		<form action="InicioWeb" method="GET">
			<label for="idEmpleado">Empleado: </label>
			<select name="idEmpleado">			
				<% for(Empleado empleado : listaEmpleados) { %>	
										
					<option value="<%= empleado.getId() %>"><%= empleado.getNombre() %></option>	
											
				<% } %>	
			</select>
			<input type="submit" value="Logear">
		</form>	

	</body>
</html>