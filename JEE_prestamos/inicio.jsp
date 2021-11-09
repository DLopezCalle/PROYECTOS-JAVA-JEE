<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.ipartek.modelo.dto.LibroPrestado" %>    
<%@ page import="com.ipartek.modelo.dto.Amigo" %>    
<%@ page import="com.ipartek.modelo.dto.Libro" %>    

<%
	
List<LibroPrestado> listaPrestados = new ArrayList<LibroPrestado>();
if(request.getAttribute("listaPrestados")!=null)
{
	listaPrestados = (List<LibroPrestado>)request.getAttribute("listaPrestados");
}

List<Amigo> listaAmigos = new ArrayList<Amigo>();
if(request.getAttribute("listaAmigos")!=null)
{
	listaAmigos = (List<Amigo>)request.getAttribute("listaAmigos");
}

List<Libro> listaLibros = new ArrayList<Libro>();
if(request.getAttribute("listaLibros")!=null)
{
	listaLibros = (List<Libro>)request.getAttribute("listaLibros");
}

String fecha = "";
if(request.getAttribute("fecha")!=null)
{
	fecha = (String)request.getAttribute("fecha");
}

%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<link rel="stylesheet" href="css/style.css">
		<link rel="stylesheet" href="css/inicio.css">
		<title>Prestamos</title>
	</head>
	<body>		
		
		<%@include file="cabecera.jsp" %>
			
		<div id="agregar">
		
			<h3>Agregar libro prestado: </h3>
			<form action="PrestadoAgregar" method="GET">		
							
				<select name="idAmigo" required>
					<option value="0">Selecciona el amigo</option>
					
					<% for(Amigo amigo : listaAmigos) { %>
						<option value="<%= amigo.getId() %>"><%= amigo.getNombre() %> <%= amigo.getApellidos() %></option>
					<% } %>
					
				</select>
				
				<select name="idLibro" required>
					<option value="0">Selecciona el libro</option>
					
					<% for(Libro libro : listaLibros) { %>
						<option value="<%= libro.getId() %>"><%= libro.getTitulo() %></option>
					<% } %>
					
				</select>
				
				<label for="fecha">Fecha: </label>
				<input type="date" name="fecha" value="<%= fecha %>">
				
				<input type="submit" value="Agregar">
										
			</form>
		</div>
		<main>
			<table>
				<thead>
					<tr>
					
						<th>idPrestamo</th>
						<th>Amigo</th>
						<th>Título del libro</th>
						<th>Fecha</th>
						<th>Borrar</th>
						
					</tr>
				</thead>
				<tbody>
					<% for(LibroPrestado libroPrestado : listaPrestados) { %>
						<tr>
						
							<td><%= libroPrestado.getId() %></td>
							<td><%= libroPrestado.getNombre() %> <%= libroPrestado.getApellidos() %></td>
							<td><%= libroPrestado.getTitulo() %></td>
							<td><%= libroPrestado.getFecha() %></td>
							<td class="imagen"><a href="PrestadoBorrar?idPrestado=<%= libroPrestado.getId() %>"><img src="imagenes/borrar.png"></a></td>
							
						</tr>
					<% } %>
				</tbody>
			</table>
		</main>	
	</body>
</html>