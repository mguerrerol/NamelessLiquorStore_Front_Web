/**
 * 
 */
 
 function login()
{

  var usuario = document.getElementById("txtUsuario").value;
  var password = document.getElementById("txtPassword").value;

  //if(usuario == "admininicial" && password == "admin123456")
  if(usuario == "1" && password == "1")
  {
	window.location="menu.jsp";
	alert("Bienvenido al sistema " + usuario);
    
  }
  else
  {
    alert("Credenciales invalidas, por favor revisar");
  }
}

function verPassword()
{
    var tipo = document.getElementById("txtPassword");
    if(tipo.type == "password")
    {
        tipo.type = "text";
    }
    else
    {
        tipo.type = "password";
    }
}
