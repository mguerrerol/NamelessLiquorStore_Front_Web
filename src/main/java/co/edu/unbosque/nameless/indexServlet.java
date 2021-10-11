package co.edu.unbosque.nameless;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class IndexServlet
 */
@WebServlet("/IndexServlet")
public class IndexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IndexServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    public void validarUsuarios(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			ArrayList<Usuarios> lista = UsuariosJSON.getJSON();
			request.setAttribute("lista", lista);
			String usua = request.getParameter("txtUsuario");
			String pass = request.getParameter("txtPassword");
			int respuesta = 0;
			for (Usuarios usuario : lista) {
				if (usuario.getUsuario_usuarios().equals(usua) && usuario.getPassword_usuarios().equals(pass)) {
					request.setAttribute("usuario", usuario);
					request.getRequestDispatcher("/menu.jsp").forward(request, response);
					respuesta = 1;
				}

			}

			if (respuesta == 0) {
				request.getRequestDispatcher("/indexError.jsp").forward(request, response);
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		String btnAceptar = request.getParameter("btnAceptar");

		if (btnAceptar.equals("Aceptar")) {
			this.validarUsuarios(request, response);
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
