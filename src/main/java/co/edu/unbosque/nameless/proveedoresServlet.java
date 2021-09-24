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
 * Servlet implementation class ProveedoresServlet
 */
@WebServlet("/ProveedoresServlet")
public class ProveedoresServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProveedoresServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		/*long nitproveedor_proveedores = Long.parseLong(request.getParameter("txtNit"));
		String telefono_proveedores = request.getParameter("txtTelefono");
		String nombre_proveedores = request.getParameter("txtNombre");
		String ciudad_proveedores = request.getParameter("txtCiudad");
		String direccion_proveedores = request.getParameter("txtDireccion");
		*/
		
		String btnConsultar = request.getParameter("btnConsultar");	
		String btnCrear = request.getParameter("btnCrear");	
		String btnActualizar = request.getParameter("btnActualizar");	
		String btnBorrar = request.getParameter("btnBorrar");
		
		if(btnConsultar != null)
		{
			listarProveedores(request,response);
		}
		
		if(btnCrear != null)
		{
			crearProveedores(request,response);
		}
		
		if(btnActualizar != null)
		{
			
		}
		
		if(btnBorrar != null)
		{
			
		}
	
	}
	
	
	public void crearProveedores(HttpServletRequest request, HttpServletResponse response) {
		Proveedores proveedor = new Proveedores();
		proveedor.setNombre_proveedores(request.getParameter("txtNombre"));
		proveedor.setNitproveedor_proveedores(Long.parseLong(request.getParameter("txtNit")));
		proveedor.setTelefono_proveedores(request.getParameter("txtTelefono"));
		proveedor.setDireccion_proveedores(request.getParameter("txtDireccion"));
		proveedor.setCiudad_proveedores(request.getParameter("txtCiudad"));
		int respuesta = 0;
		
		try {
			respuesta = ProveedoresJSON.postJSON(proveedor);
			PrintWriter writer = response.getWriter();
			if (respuesta == 200)
			{
				request.getRequestDispatcher("/proveedores.jsp").forward(request, response);
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
	
	public void listarProveedores(HttpServletRequest request, HttpServletResponse response) {
		try {
			ArrayList<Proveedores> lista = ProveedoresJSON.getJSON();
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
