package co.edu.unbosque.nameless;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.csvreader.CsvReader;

/**
 * Servlet implementation class ProductosServlet
 */
@WebServlet("/ProductosServlet")
public class ProductosServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductosServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		String btnCargar = request.getParameter("btnCargar");	
		response.getWriter().append("entre al boton"+ btnCargar).append(request.getContextPath());

		if(btnCargar != null)
		{
			response.getWriter().append("entre al boton"+ btnCargar).append(request.getContextPath());
			importarCSV(request,response);
		}
		
	}
	
	public void importarCSV (HttpServletRequest request, HttpServletResponse response) {
		String pagina = "/productos.jsp";
		List<Productos> productos = new ArrayList<Productos>();
		
		try {
			CsvReader leerProductos = new CsvReader(request.getParameter("file-upload"));
			leerProductos.readHeaders();
			
			while (leerProductos.readRecord()) 
			{
				long codigo_productos = Long.parseLong(leerProductos.get(0));
				double ivacompra_productos = Double.parseDouble(leerProductos.get(1));
				long nitproveedor_proveedores = Long.parseLong(leerProductos.get(2));
				String nombre_productos = leerProductos.get(3);
				double precio_compra_productos = Double.parseDouble(leerProductos.get(4));
				double precio_venta_productos = Double.parseDouble(leerProductos.get(5));
				
				Productos producto = new Productos();
				producto.setCodigo_productos(codigo_productos);
				producto.setIvacompra_productos(ivacompra_productos);
				producto.setNitproveedor_proveedores(nitproveedor_proveedores);
				producto.setNombre_productos(nombre_productos);
				producto.setPrecio_compra_productos(precio_compra_productos);
				producto.setPrecio_venta_productos(precio_venta_productos );
				int respuesta = 0;
				int verificador = 0;
				
				ArrayList<Productos> listaproductos = ProductosJSON.getJSON();
				for(Productos productoverificar : listaproductos) {
					if(productoverificar.getCodigo_productos() == codigo_productos) {
						verificador = 1;
						break;
					}
				}
					
				if(verificador == 0) 
				{
					respuesta = ProductosJSON.postJSON(producto);
					PrintWriter writer = response.getWriter();
					if (respuesta == 200)
					{
						request.getRequestDispatcher("/productoscargado.jsp").forward(request, response);
					}
					else 
					{
						writer.println("Error: " + respuesta);
					}
					writer.close();
				}
				else 
				{
					request.getRequestDispatcher("/productoerroryaexiste.jsp").forward(request, response);
				}
			}
			leerProductos.close();	
		}catch(IOException | ServletException e){
			e.printStackTrace();
		}catch(Exception e){
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
