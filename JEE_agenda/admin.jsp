<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.ipartek.modelo.dto.Contacto" %>

<%

/* Recibir lista de todos los contactos */
List<Contacto> listaContactos = new ArrayList<Contacto>();
if(request.getAttribute("listaContactos")!=null)
{
	listaContactos = (List<Contacto>)request.getAttribute("listaContactos");
}

/* Saber si se ha borrado o agregado en caso de hacerlo previamente */
int borrado = 0;
if( request.getAttribute("borrado") != null)
{
	borrado = (int)request.getAttribute("borrado");
}

int agregado = 0;
if( request.getAttribute("agregado") != null)
{
	agregado = (int)request.getAttribute("agregado");
}

%>

<!DOCTYPE html>
<html>
	<head>
	
		<meta charset="ISO-8859-1">
		<link rel="stylesheet" href="css/style.css">
		 <link rel="stylesheet" href="css/admin.css">
		<title>Agenda de contactos</title>
		
	</head>
	<header>
			
			<h1>Agenda de contactos</h1>
			
		</header>		
		<nav>
		
			<a href="InicioWeb?irAdmin=0" id="enlaceCabecera">Vista normal</a>	
						
		</nav>
	<body>		
		<main>
			
			<section id="seccionCrud">
				
				<!-- Mensajes informativos -->
				<% if ( borrado == 1 ) { %>
					<h3>El contacto se borró correctamente</h3>
				<% } %>
				
				<% if ( agregado == 1 ) { %>
					<h3>El contacto se agregó correctamente</h3>
				<% } %>
				
				<!-- Tabla donde se mostrarán todos los contactos -->
				<table>
					<thead>
						<tr>
						
							<th>Teléfono</th>
							<th>Nombre completo</th>
							<th>Borrar</th>
							
						</tr>
					</thead>
					<tbody>
					
						<% for( Contacto contacto : listaContactos ) { %>					
							<tr>					
								
								<td><%= contacto.getTelefono() %></td>
								<td><%= contacto.getNombre() %> <%= contacto.getApellidos() %></td>
								<td class="tdImagen">
								
									<a href="BorrarContacto?idContacto=<%= contacto.getId() %>">
										<img alt="Borrar" src="imagenes/borrar.png">
									</a>
									
								</td>								
							</tr>						
						<% } %>
					</tbody>
				</table>
			</section>
			<section id="seccionAgregar">
				
				<form action="AgregarContacto" method="GET">
					
					<h2>Agregar nuevo contacto</h2>
				
					<label for="telefono">Número telefónico: </label>
					<input type="text" name="telefono" placeholder="123 45 67 89" pattern="[0-9]{9}" required>
					
					<label for="nombre">Nombre del contacto: </label>
					<input type="text" name="nombre" placeholder="Diego" required>
					
					<label for="apellidos">Apellidos del contacto: </label>
					<input type="text" name="apellidos" placeholder="López" required>
					
					<input type="submit" value="Agregar contacto" id="boton" required>
					
				</form>				
			</section>			
		</main>		
	</body>
</html>