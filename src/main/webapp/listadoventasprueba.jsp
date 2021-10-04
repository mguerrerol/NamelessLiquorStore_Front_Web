<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ page import='java.util.Date'%>
<%@ page import='co.edu.unbosque.nameless.Ventas'%>
<%@ page import='java.util.ArrayList'%>
<html>
<head>
<meta charset="UTF-8">
<link rel="shortcut icon" href="IMG/favicon.png" type="image/x-icon" />
<title>Nameless LS - Listado Clientes</title>
<link href="https://fonts.googleapis.com/css2?family=Anton&family=Ubuntu&display=swap" rel="stylesheet">
<link rel="stylesheet" type="text/css" href="CSS/estiloreportes.css">
</head>
<body>
	<header>
		<img class="header" src="IMG/titulo.png" alt="Nameless Liquor Store">
	</header>
	<ul class="menu">
		<li><a href="usuarios.jsp">Usuarios</a></li>
		<li><a href="clientes.jsp">Clientes</a></li>
		<li><a href="proveedores.jsp">Proveedores</a></li>
		<li><a href="productos.jsp">Productos</a></li>
		<li><a href="productoindividual.jsp">Producto Individual</a></li>
		<li><a href="ventas.jsp">Ventas</a></li>
		<li><a href="reportes.jsp" class="active">Reportes</a></li>
		<li><a href="index.jsp">Salir</a></li>
	</ul>
	<form class="formulario">
		<br>
		<center>
			<h1>Listado de Ventas</h1>
			<h4>
				Hora servidor:
				<%= new Date() %></h4>
			<table border="5">
				<tr>
					<td>Codigo</td>
					<td>Cedula cliente</td>
					<td>cedula Usuario</td>
					<td>Valor IVA</td>
					<td>Valor Venta</td>
					<td>Total Venta</td>
				</tr>
				<% ArrayList<Ventas> lista= (ArrayList<Ventas>) request.getAttribute("lista");
					for (Ventas venta:lista){
					%>
				<tr>
					<td><%=venta.getCodigo_ventas()%></td>
					<td><%=venta.getCedula_clientes()%></td>
					<td><%=venta.getCedula_usuarios()%></td>
					<td><%=venta.getIvaventa_ventas()%></td>
					<td><%=venta.getValor_venta_ventas()%></td>
					<td><%=venta.getTotal_venta_ventas()%></td>
				</tr>
				<%}%>
			</table>
		</center>
		<br>
		<br>
	</form>
	<footer>
		<img class="footer" src="IMG/footer.png" alt="Nameless Liquor Store">
	</footer>
</body>
</html>
