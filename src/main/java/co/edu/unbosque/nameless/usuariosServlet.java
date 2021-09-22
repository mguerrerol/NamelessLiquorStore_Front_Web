package co.edu.unbosque.nameless;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class usuariosServlet
 */
@WebServlet("/usuariosServlet")
public class usuariosServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public usuariosServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		/*String cedula_usuarios = request.getParameter("txtCedula");
		String usuario_usuarios = request.getParameter("txtUsuario");
		String nombre_usuarios = request.getParameter("txtNombre");
		String password_usuarios = request.getParameter("txtPassword");
		String email_usuarios = request.getParameter("txtCorreo");
		*/
		String btnConsultar = request.getParameter("btnConsultar");	
		String btnCrear = request.getParameter("btnCrear");	
		String btnActualizar = request.getParameter("btnActualizar");	
		String btnBorrar = request.getParameter("btnBorrar");
		
		PrintWriter writer = response.getWriter();
		writer.println("=======================");
		writer.println("Entre al Servlet");
		
		if(btnConsultar != null)
		{
			writer.println("Entre al consultar");
			listarUsuarios(request,response);
		}
		
		if(btnCrear != null)
		{
			writer.println("Entre al crear");
			crearUsuario(request,response);
		}
		
		if(btnActualizar != null)
		{
			
		}
		
		if(btnBorrar != null)
		{
			
		}
		
	}
	
	public void crearUsuario(HttpServletRequest request, HttpServletResponse response) {
		Usuarios usuario = new Usuarios();
		usuario.setNombre_usuarios(request.getParameter("txtNombre"));
		usuario.setCedula_usuarios(Long.parseLong(request.getParameter("txtCedula")));
		usuario.setEmail_usuarios(request.getParameter("txtCorreo"));
		usuario.setUsuario_usuarios(request.getParameter("txtUsuario"));
		usuario.setPassword_usuarios(request.getParameter("txtPassword"));
		int respuesta = 0;
		
		try {
			respuesta = TestJSON.postJSON(usuario);
			PrintWriter writer = response.getWriter();
			if (respuesta == 200)
			{
				writer.println("Registro Agreado!");
			}
			else 
			{
				writer.println("Error: " + respuesta);
			}
			writer.close();
		}catch(IOException e){
			e.printStackTrace();
		}
	}
	
	public void listarUsuarios(HttpServletRequest request, HttpServletResponse response) {
		try {
			ArrayList<Usuarios> lista = TestJSON.getJSON();
			String pagina = "/listadousuarios.jsp";
			request.setAttribute("lista",lista);
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(pagina);
			dispatcher.forward(request, response);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
