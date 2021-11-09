<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>   
<%@ page import="com.ipartek.modelo.dto.Amigo" %>    
<%@ page import="com.ipartek.modelo.dto.Libro" %>  

<% 

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

%>    

<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<link rel="stylesheet" href="css/style.css">
		<link rel="stylesheet" href="css/ajustes.css">
		<title>Prestamos</title>
	</head>
	<body>		
	
		<%@include file="cabecera.jsp" %>
		
		<div id="filtro">
			<form action="Filtrar" method="GET">		
							
				<label for="texto">Filtrar por nombre: </label>
				<input type="text" name="texto" placeholder="Amigo o libro">
				<input type="submit" value="Buscar">
										
			</form>
		</div>
		<main>				
			<section>			
				
				<h2>Amigos</h2>
				<article>
								
					<h3>AGREGAR AMIGO</h3>
					<form action="AmigoAgregar" method="GET">
					
						<label for="nombre">Nombre: </label><br>
						<input type="text" name="nombre"><br>
						<label for="apellidos">Apellidos: </label><br>
						<input type="text" name="apellidos"><br>
						<input type="submit" value="Agregar">
						
					</form>					
				</article>
				<article>					
					<table>
						<thead>
							<tr>
							
								<th>idAmigo</th>
								<th>Nombre</th>
								<th>Opciones</th>
								
							</tr>
						</thead>
						<tbody>
							<% for(Amigo amigo : listaAmigos) { %>
								<tr>
								
									<td><%= amigo.getId() %></td>
									<td><%= amigo.getNombre() %> <%= amigo.getApellidos() %></td>
									<td>
										
										<form action="AmigoAccion" method="GET">
											<input type="hidden" name="idAmigo" value="<%= amigo.getId() %>">
											<button type="submit" name="accion" value="borrar">Borrar</button>
											<button type="submit" name="accion" value="modificar">Modificar</button>
										</form>
										
									</td>
								</tr>
							<% } %>
						</tbody>
					</table>					
				</article>				
			</section>
			<section>
			
				<h2>Libros</h2>
				<article>
								
					<h3>AGREGAR LIBRO</h3><br>
					<form action="LibroAgregar" method="GET"><br>
					
						<label for="titulo">Titulo: </label><br>
						<input type="text" name="titulo"><br><br>
						<input type="submit" value="Agregar">
						
					</form>					
				</article>
				<article>					
					<table>
						<thead>
							<tr>
							
								<th>idLibros</th>
								<th>Titulo</th>
								<th>Opciones</th>
								
							</tr>
						</thead>
						<tbody>
							<% for(Libro libro : listaLibros) { %>
								<tr>
								
									<td><%= libro.getId() %></td>
									<td><%= libro.getTitulo() %></td>
									<td>
										
										<form action="LibroAccion" method="GET">
											<input type="hidden" name="idLibro" value="<%= libro.getId() %>">
											<button type="submit" name="accion" value="borrar">Borrar</button>
											<button type="submit" name="accion" value="modificar">Modificar</button>
										</form>
										
									</td>
								</tr>
							<% } %>
						</tbody>
					</table>					
				</article>
			</section>
			<!-- 
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
					<tr>
					
						<td>1</td>
						<td>Roberto Garcia</td>
						<td>Citas del Presidente Mao Tse-Tung</td>
						<td>2021-10-30</td>
						<td class="imagen"><a href=""><img src="imagenes/borrar.png"></a></td>
						
					</tr>
				</tbody>
			</table>
			 -->
		</main>	
	</body>
</html>