<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<link rel="shortcut icon" href="IMG/favicon.png" type="image/x-icon"/>
		<title>Nameless LS - Clientes</title>
		<link href="https://fonts.googleapis.com/css2?family=Anton&family=Ubuntu&display=swap" rel="stylesheet">
		<link rel="stylesheet" type="text/css" href="CSS/estilo.css">
	</head>
	<body>
		<header>
			<img class= "header" src="IMG/titulo.png" alt="Nameless Liquor Store">
		</header>
		<ul class="menu">
 			<li><a href="usuarios.jsp">Usuarios</a></li>
			<li><a href="clientes.jsp" class="active">Clientes</a></li>
			<li><a href="proveedores.jsp">Proveedores</a></li>
			<li><a href="productos.jsp">Productos</a></li>
			<li><a href="ventas.jsp">Ventas</a></li>
			<li><a href="reportes.jsp">Reportes</a></li>
			<li><a href="index.jsp">Salir</a></li>
		</ul>
		<form class="formulario" method="get" action="./ClientesServlet">
		<div>
			<br>
			<h2>Clientes</h2>
			<br>
			<center>
		     <table border = "0">
		       <tr><td><label>Cedula </label></td>
		 		   <td><input type="number" name="txtCedula" id="txtCedula" maxlength="20" size ="50" placeholder="Digite la cedula" required></td>

					<td><label>Tel�fono </label></td>
					<td><input type="number" name="txtTelefono" id="txtTelefono" maxlength="20" size ="50" placeholder="Digite el tel�fono"></td>
				</tr>
				<tr>
					<td><label>Nombre Completo </label></td>
					<td><input type="text" name="txtNombre" id="txtNombre" maxlength="50" size ="50" placeholder="Digite el nombre completo"></td>

		            <td><label>Correo Electr�nico </label></td>
					<td><input type="email" name="txtCorreo" id="txtCorreo"  maxlength="50" size ="50" placeholder="Digite el correo electr�nico"></td>
				</tr>
		        <tr>
					<td><label>Direcci�n </label></td>
					<td><input type="text" name="txtDireccion" id="txtDireccion" maxlength="50" size ="50" placeholder="Digite la direcci�n"></td>
		        </tr>
		    </table>
	       </center>

		<br><br><br>
				<center>
		      		<td><input type="submit" name="btnConsultar" id="btnConsultar" value="Consultar" class="button"></td>
		     		<td><input type="submit" name="btnCrear" id="btnCrear" value="Crear" class="button"></td>
		     		<td><input type="submit" name="btnActualizar" id="btnActualizar" value="Actualizar" class="button"></td>
		     		<td><input type="submit" name="btnBorrar" id="btnBorrar" value="Borrar" class="button"></td>
				</center>
		</div>
	</form>
	<footer>
			<img class="footer" src="IMG/footer.png" alt="Nameless Liquor Store">
	</footer>
	</body>
</html>
