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
 * Servlet implementation class ClientesServlet
 */
@WebServlet("/ClientesServlet")
public class ClientesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ClientesServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		/*
		long cedula_clientes = Long.parseLong(request.getParameter("txtCedula"));
		String telefono_clientes = request.getParameter("txtTelefono");
		String nombre_clientes = request.getParameter("txtNombre");
		String email_clientes = request.getParameter("txtCorreo");
		String direccion_clientes = request.getParameter("txtDireccion");
		*/
		
		String btnConsultar = request.getParameter("btnConsultar");	
		String btnCrear = request.getParameter("btnCrear");	
		String btnActualizar = request.getParameter("btnActualizar");	
		String btnBorrar = request.getParameter("btnBorrar");
		
		if(btnConsultar != null)
		{
			listarClientes(request,response);
		}
		
		if(btnCrear != null)
		{
			crearCliente(request,response);
		}
		
		if(btnActualizar != null)
		{
			
		}
		
		if(btnBorrar != null)
		{
			
		}
		
	}
	
	public void crearCliente(HttpServletRequest request, HttpServletResponse response) {
		Clientes cliente = new Clientes();
		cliente.setNombre_clientes(request.getParameter("txtNombre"));
		cliente.setCedula_clientes(Long.parseLong(request.getParameter("txtCedula")));
		cliente.setEmail_clientes(request.getParameter("txtCorreo"));
		cliente.setTelefono_clientes(request.getParameter("txtTelefono"));
		cliente.setDireccion_clientes(request.getParameter("txtDireccion"));
		int respuesta = 0;
		
		try {
			respuesta = ClientesJSON.postJSON(cliente);
			PrintWriter writer = response.getWriter();
			if (respuesta == 200)
			{
				request.getRequestDispatcher("/clientes.jsp").forward(request, response);
			}
			else 
			{
				writer.println("Error: " + respuesta);
			}
			writer.close();
		}catch(IOException | ServletException e){
			e.printStackTrace();
		}
	}
	
	public void listarClientes(HttpServletRequest request, HttpServletResponse response) {
		try {
			ArrayList<Clientes> lista = ClientesJSON.getJSON();
			String pagina = "/listadoclientes.jsp";
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
