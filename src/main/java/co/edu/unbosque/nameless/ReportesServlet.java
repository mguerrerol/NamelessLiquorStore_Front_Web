package co.edu.unbosque.nameless;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ReportesServlet
 */
@WebServlet("/ReportesServlet")
public class ReportesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReportesServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		String btnListadoUsuarios = request.getParameter("btnListadoUsuarios");
		String btnListadoClientes = request.getParameter("btnListadoClientes");
		String btnVentasCliente = request.getParameter("btnVentasCliente");

		if (btnListadoUsuarios != null) {
			request.getRequestDispatcher("/listadousuarios.jsp").forward(request, response);
		}
		
		if (btnListadoClientes != null) {
			request.getRequestDispatcher("/listadoclientes.jsp").forward(request, response);
		}
		
		if (btnVentasCliente != null) {
			request.getRequestDispatcher("/ventascliente.jsp").forward(request, response);
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
