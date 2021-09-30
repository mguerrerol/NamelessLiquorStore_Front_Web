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
 * Servlet implementation class UsuariosServlet
 */
@WebServlet("/ProductoIndividualServlet")
public class ProductoIndividualServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductoIndividualServlet() {
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
			listarProductos(request,response);
		}
		
		if(btnCrear != null)
		{
			crearProductoIndividual(request,response);
		}
		
		if(btnActualizar != null)
		{
			actualizarProductoIndividual(request,response);
		}
		
		if(btnBorrar != null)
		{	
			eliminarProductoIndividual(request,response);
		}
		
	}
	
	public void crearProductoIndividual(HttpServletRequest request, HttpServletResponse response) {
		Productos producto = new Productos();
		producto.setCodigo_productos(Long.parseLong(request.getParameter("txtCodigo")));
		producto.setNombre_productos(request.getParameter("txtNombre"));
		producto.setNitproveedor_proveedores(Long.parseLong(request.getParameter("txtNIT")));
		producto.setIvacompra_productos(Double.parseDouble(request.getParameter("txtIVA")));
		producto.setPrecio_compra_productos(Double.parseDouble(request.getParameter("txtValorCompra")));
		producto.setPrecio_venta_productos(Double.parseDouble(request.getParameter("txtValorVenta")));
		int respuesta = 0;
		
		try {
			respuesta = ProductoIndividualJSON.postJSON(producto);
			PrintWriter writer = response.getWriter();
			if (respuesta == 200)
			{
				request.getRequestDispatcher("/productosindividual.jsp").forward(request, response);
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
	
	public void eliminarProductoIndividual(HttpServletRequest request, HttpServletResponse response) {
		Long id= Long.parseLong(request.getParameter("txtCodigo"));			
		int respuesta=0;
		try {
			respuesta = ProductoIndividualJSON.deleteJSON(id);
			PrintWriter write = response.getWriter();
			if (respuesta==200) {
				request.getRequestDispatcher("/productos.jsp").forward(request, response);
				} else {
				write.println("Error: " +  respuesta);
				}
			write.close();
		} catch (Exception e) {
			e.printStackTrace();
		}	
	}
	
	public void actualizarProductoIndividual(HttpServletRequest request, HttpServletResponse response) {
		
		Productos producto = new Productos();
		producto.setCodigo_productos(Long.parseLong(request.getParameter("txtCodigo")));
		producto.setNombre_productos(request.getParameter("txtNombre"));
		producto.setNitproveedor_proveedores(Long.parseLong(request.getParameter("txtNIT")));
		producto.setIvacompra_productos(Double.parseDouble(request.getParameter("txtIVA")));
		producto.setPrecio_compra_productos(Double.parseDouble(request.getParameter("txtValorCompra")));
		producto.setPrecio_venta_productos(Double.parseDouble(request.getParameter("txtValorVenta")));
		int respuesta = 0;
		try {
			respuesta = ProductoIndividualJSON.putJSON(producto,producto.getCodigo_productos());
			PrintWriter write = response.getWriter();
				
			if (respuesta==200) {
				request.getRequestDispatcher("/productoindividual.jsp").forward(request, response);
			} else {
				write.println("Error: " +  respuesta);
			}
			write.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
	}

	
	public void listarProductos(HttpServletRequest request, HttpServletResponse response) {
		try {
			ArrayList<Productos> lista = ProductosJSON.getJSON();
			String pagina = "/listadoproductos.jsp";
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
