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
		<form class="formulario" method="get" action="./clientesServlet">
		<div>
			<br><br>
			<br><br>
			<center>
		     <table border = "0">
		       <tr><td><label>Cedula </label></td>
		 		   <td><input type="number" name="txtCedula" id="txtCedula" maxlength="20" size ="50" placeholder="Digite la cedula" required checked></td>

					<td><label>Teléfono </label></td>
					<td><input type="number" name="txtTelefono" id="txtTelefono" maxlength="20" size ="50" placeholder="Digite el teléfono" required></td>
				</tr>
				<tr>
					<td><label>Nombre Completo </label></td>
					<td><input type="text" name="txNnombre" id="txNnombre" maxlength="50" size ="50" placeholder="Digite el nombre completo" required></td>

		            <td><label>Correo Electrónico </label></td>
					<td><input type="email" name="txtCorreo" id="txtCorreo"  maxlength="50" size ="50" placeholder="Digite el correo electrónico" required></td>
				</tr>
		        <tr>
					<td><label>Dirección </label></td>
					<td><input type="text" name="txtDireccion" id="txtDireccion" maxlength="50" size ="50" placeholder="Digite la dirección" required></td>
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
