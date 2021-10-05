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
			actualizarProveedor(request,response);
		}
		
		if(btnBorrar != null)
		{
			eliminarProveedor(request,response);
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
				request.getRequestDispatcher("/proveedorescrear.jsp").forward(request, response);
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
	
	public void eliminarProveedor(HttpServletRequest request, HttpServletResponse response) {
		Long id= Long.parseLong(request.getParameter("txtNit"));			
		int respuesta=0;
		try {
		   respuesta = ProveedoresJSON.deleteJSON(id);
		   PrintWriter write = response.getWriter();
		   if (respuesta==200) {
			   request.getRequestDispatcher("/proveedoreseliminar.jsp").forward(request, response);
		   } else {
			write.println("Error: " +  respuesta);
		   }
		      write.close();
		   } catch (Exception e) {
			e.printStackTrace();
		   }	
		}
		
	public void actualizarProveedor(HttpServletRequest request, HttpServletResponse response) {
			
		Proveedores proveedor = new Proveedores();
		proveedor.setNombre_proveedores(request.getParameter("txtNombre"));
		proveedor.setNitproveedor_proveedores(Long.parseLong(request.getParameter("txtNit")));
		proveedor.setTelefono_proveedores(request.getParameter("txtTelefono"));
		proveedor.setDireccion_proveedores(request.getParameter("txtDireccion"));
		proveedor.setCiudad_proveedores(request.getParameter("txtCiudad"));
		int respuesta = 0;
			
		try {
			respuesta = ProveedoresJSON.putJSON(proveedor,proveedor.getNitproveedor_proveedores());
			PrintWriter write = response.getWriter();
					
			if (respuesta==200) {
				request.getRequestDispatcher("/proveedoresactualizar.jsp").forward(request, response);
			} else {
				write.println("Error: " +  respuesta);
			}
			write.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	
	public void listarProveedores(HttpServletRequest request, HttpServletResponse response) {
		try {
			long txtNIT = Long.parseLong(request.getParameter("txtNit"));
			String txtNombre = request.getParameter("txtNombre");
			String txtTelefono = request.getParameter("txtTelefono");
			String txtCiudad = request.getParameter("txtCiudad");
			String txtDireccion = request.getParameter("txtDireccion");
			int error = 0;
			ArrayList<Proveedores> lista = ProveedoresJSON.getJSON();
			String pagina = "/proveedoresconsulta.jsp";
			
			for (Proveedores proveedor:lista){
				if (proveedor.getNitproveedor_proveedores() == txtNIT)
				{
					txtNIT  = proveedor.getNitproveedor_proveedores();
					txtNombre = proveedor.getNombre_proveedores();
					txtTelefono = proveedor.getTelefono_proveedores();
					txtCiudad = proveedor.getCiudad_proveedores();
					txtDireccion = proveedor.getDireccion_proveedores();
					error = 1;
					break;
				}
			}
			
			request.setAttribute("txtNit",txtNIT);
			request.setAttribute("txtNombre",txtNombre);
			request.setAttribute("txtTelefono",txtTelefono);
			request.setAttribute("txtCiudad",txtCiudad);
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
