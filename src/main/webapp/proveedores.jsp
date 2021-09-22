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
		<form class="formulario" method="get" action="./proveedoresServlet">
		<div>
			<br><br>
			<br><br>
			<center>
		      <table border = "0">
		        <tr><td><label>NIT </label></td>
				    <td><input type="text" name="txtNit" id="txtNit" maxlength="20" size ="50" placeholder="Digite el NIT"></td>

					<td><label>Teléfono</label></td>
					<td><input type="text" name="txtTelefono" id="txtTelefono" maxlength="50" size ="50" placeholder="Digite el teléfono"></td>
				</tr>
				<tr>
					<td><label>Nombre del Proveedor </label></td>
					<td><input type="text" name="txtNombreProveedor" id="txtNombreProveedor" maxlength="50" size ="50" placeholder="Digite el nombre del proveedor"></td>
 	
 		            <td><label>Ciudad </label></td>
					<td><input type="text" name="txtCiudad" id="txtCiudad" maxlength="50" size ="50" placeholder="Digite la ciudad"></td>
				</tr>
		        <tr>
					<td><label>Dirección </label></td>
					<td><input type="text" name="txtDireccion" id="txtDireccion" maxlength="50" size ="50" placeholder="Digite la dirección"></td>
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
