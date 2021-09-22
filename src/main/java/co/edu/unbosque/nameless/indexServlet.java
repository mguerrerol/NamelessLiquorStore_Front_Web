package co.edu.unbosque.nameless;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class indexServlet
 */
@WebServlet("/indexServlet")
public class indexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public indexServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		PrintWriter writer = response.getWriter(); 
		
		String usuario_usuarios = request.getParameter("txtUsuario");
		String password_usuarios = request.getParameter("txtPassword");
		String btnAceptar = request.getParameter("btnAceptar");	
	
		if (btnAceptar != null) 
		{
			if(usuario_usuarios != null &&  password_usuarios != null) 
			{
				if (usuario_usuarios == "ale" &&  password_usuarios == "123") 
				{
					writer.println("Bienvenido al sistema " + usuario_usuarios);
				}
				else
				{
					writer.println("Crendeciales invalidas para el ingreso al sistema " + usuario_usuarios +  password_usuarios);
				}
			}
			else
			{
				writer.println("Los campos usuario y Constraseña no puede estar vacios");
			}
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
