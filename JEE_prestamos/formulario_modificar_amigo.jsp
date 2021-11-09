<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.ipartek.modelo.dto.LibroPrestado" %>    
<%@ page import="com.ipartek.modelo.dto.Amigo" %>

<%

List<Amigo> listaAmigos = new ArrayList<Amigo>();
if(request.getAttribute("listaAmigos")!=null)
{
	listaAmigos = (List<Amigo>)request.getAttribute("listaAmigos");
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
		
			<% for(Amigo amigo : listaAmigos) { %>
			
				<h3>Modificar amigo con id <%= amigo.getId() %></h3>			
				<form action="AmigoModificar" method="GET">
				
					<input type="hidden" name="idAmigo" value="<%= amigo.getId() %>">
					<label for="nombre">Nombre </label><br>
					<input type="text" name="nombre" value="<%= amigo.getNombre() %>"><br><br>
					<label for="apellidos">Apellidos </label><br>
					<input type="text" name="apellidos" value="<%= amigo.getApellidos() %>"><br><br>
					<input type="submit" value="Modificar">
				
				</form>				
			<% } %>			
		</main>	
	</body>
</html>