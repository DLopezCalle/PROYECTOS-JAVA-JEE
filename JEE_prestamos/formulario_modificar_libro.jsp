<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.ipartek.modelo.dto.LibroPrestado" %> 
<%@ page import="com.ipartek.modelo.dto.Libro" %>    

<%

List<Libro> listaLibros = new ArrayList<Libro>();
if(request.getAttribute("listaLibros")!=null)
{
	listaLibros = (List<Libro>)request.getAttribute("listaLibros");
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
				
		<main>
		
			<% for(Libro libro : listaLibros) { %>
			
				<h3>Modificar libro con id <%= libro.getId() %></h3>			
				<form action="LibroModificar" method="GET">
				
					<input type="hidden" name="idLibro" value="<%= libro.getId() %>">
					<label for="titulo">Nombre </label><br>
					<input type="text" name="titulo" value="<%= libro.getTitulo() %>"><br><br>
					<input type="submit" value="Modificar">
				
				</form>				
			<% } %>			
		</main>	
	</body>
</html>