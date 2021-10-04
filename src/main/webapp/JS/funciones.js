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

function cambiar(){
    var pdrs = document.getElementById('file-upload').files[0].name;
    document.getElementById('info').innerHTML = pdrs;
}

