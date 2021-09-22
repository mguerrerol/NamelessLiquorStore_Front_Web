<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Nameless Liquor Store</title>
		<link href="https://fonts.googleapis.com/css2?family=Anton&family=Ubuntu&display=swap" rel="stylesheet">
		<link rel="stylesheet" type="text/css" href="CSS/estilo.css">
	</head>
	<body>
		<header>
			<img class= "header" src="IMG/titulo.png" alt="Nameless Liquor Store">
		</header>
		<ul class="menu">
			<li><a href="usuarios.jsp">Usuarios</a></li>
			<li><a href="clientes.jsp">Clientes</a></li>
			<li><a href="proveedores.jsp">Proveedores</a></li>
			<li><a href="productos.jsp">Productos</a></li>
			<li><a href="ventas.jsp">Ventas</a></li>
			<li><a href="reportes.jsp">Reportes</a></li>
			<li><a href="index.jsp">Salir</a></li>
		</ul>
		<form class="formulario" method="get" action="./productosServlet">
			<div>
				<br><br>
				<br><br>
				<br><br>
				<br>
				<center>
					<td><label><b>Nombre del Archivo </b></label> </td>
					<td><input class="texto1" type="text" maxlength="200" name="txtArchivo" id="txtArchivo" size ="100" placeholder="Digite la ruta del archivo"></td>
					<td><input class="button" type="submit" name="btnExaminar" id="btnExaminar" value="Examinar"></td>
				</center>
				<br><br>
				<center>
		    		<td><input type="submit" name="btnCargar" id="btnCargar" value="Cargar" class="button"></td>
				</center>
			</div>
		</form>
		<footer>
			<img class="footer" src="IMG/footer.png" alt="Nameless Liquor Store">
		</footer>
	</body>
</html>
