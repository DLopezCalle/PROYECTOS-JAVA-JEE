<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.ipartek.modelo.dto.Contacto" %>

<%

List<Contacto> listaContactos = new ArrayList<Contacto>();
if(request.getAttribute("listaContactos")!=null)
{
	listaContactos = (List<Contacto>)request.getAttribute("listaContactos");
}

%>

<!DOCTYPE html>
<html>
	<head>
	
		<meta charset="ISO-8859-1">
		<link rel="stylesheet" href="css/style.css">
		<link rel="stylesheet" href="css/index.css">
		<title>Agenda de contactos</title>
		
	</head>
	<body>
		<header>
			
			<h1>Agenda de contactos</h1>
			
		</header>		
		<nav>
		
			<a href="InicioWeb?irAdmin=1" id="enlaceCabecera">Vista de administrador</a>	
						
		</nav>
		<main>
		
			<!-- Tabla donde se mostrarán todos los contactos -->
			<table>
				<thead>
					<tr>
					
						<th>Teléfono</th>
						<th>Nombre completo</th>
						
					</tr>
				</thead>
				<tbody>
				
					<% for( Contacto contacto : listaContactos ) { %>					
						<tr>					
							
							<td><%= contacto.getTelefono() %></td>
							<td><%= contacto.getNombre() %> <%= contacto.getApellidos() %></td>
							
						</tr>						
					<% } %>
				</tbody>
			</table>
		
		</main>		
	</body>
</html>