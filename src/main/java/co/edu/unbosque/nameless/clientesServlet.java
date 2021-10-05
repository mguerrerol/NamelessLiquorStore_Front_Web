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
			actualizarUsuario(request,response);
		}
		
		if(btnBorrar != null)
		{
			eliminarCliente(request,response);
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
				request.getRequestDispatcher("/clientescrear.jsp").forward(request, response);
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
	
	public void eliminarCliente(HttpServletRequest request, HttpServletResponse response) {
		Long id= Long.parseLong(request.getParameter("txtCedula"));			
		int respuesta=0;
		try {
		   respuesta = ClientesJSON.deleteJSON(id);
		   PrintWriter write = response.getWriter();
		   if (respuesta==200) {
			   request.getRequestDispatcher("/clienteseliminar.jsp").forward(request, response);
		   } else {
			write.println("Error: " +  respuesta);
		   }
		      write.close();
		   } catch (Exception e) {
			e.printStackTrace();
		   }	
		}
		
		public void actualizarUsuario(HttpServletRequest request, HttpServletResponse response) {
			
			Clientes cliente = new Clientes();
			cliente.setNombre_clientes(request.getParameter("txtNombre"));
			cliente.setCedula_clientes(Long.parseLong(request.getParameter("txtCedula")));
			cliente.setEmail_clientes(request.getParameter("txtCorreo"));
			cliente.setTelefono_clientes(request.getParameter("txtTelefono"));
			cliente.setDireccion_clientes(request.getParameter("txtDireccion"));
			int respuesta = 0;
			
			try {
				respuesta = ClientesJSON.putJSON(cliente,cliente.getCedula_clientes());
				PrintWriter write = response.getWriter();
					
				if (respuesta==200) {
					request.getRequestDispatcher("/clientesactualizar.jsp").forward(request, response);
				} else {
					write.println("Error: " +  respuesta);
				}
				write.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
		}
	
	public void listarClientes(HttpServletRequest request, HttpServletResponse response) {
		try {
			long txtCedula = Long.parseLong(request.getParameter("txtCedula"));
			String txtNombre = request.getParameter("txtNombre");
			String txtTelefono = request.getParameter("txtTelefono");
			String txtCorreo = request.getParameter("txtCorreo");
			String txtDireccion = request.getParameter("txtDireccion");
			int error = 0;
			ArrayList<Clientes> lista = ClientesJSON.getJSON();
			String pagina = "/clientesconsulta.jsp";
			
			for (Clientes cliente:lista){
				if (cliente.getCedula_clientes() == txtCedula)
				{
					txtCedula = cliente.getCedula_clientes();
					txtNombre = cliente.getNombre_clientes();
					txtCorreo = cliente.getEmail_clientes();
					txtTelefono = cliente.getTelefono_clientes();
					txtDireccion = cliente.getDireccion_clientes();
					error = 1;
					break;
				}
			}
			
			request.setAttribute("txtCedula",txtCedula);
			request.setAttribute("txtNombre",txtNombre);
			request.setAttribute("txtCorreo",txtCorreo);
			request.setAttribute("txtTelefono",txtTelefono);
			request.setAttribute("txtDireccion",txtDireccion);
			request.setAttribute("error",error);
		
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
