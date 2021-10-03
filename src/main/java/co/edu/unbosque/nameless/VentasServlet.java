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
 * Servlet implementation class VentaServlet
 */
@WebServlet("/VentasServlet")
public class VentasServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VentasServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: Entre al servlet").append(request.getContextPath());
			
		String btnConsultarCliente = request.getParameter("btnConsultarCliente");
		
		String btnConsultarProducto1 = request.getParameter("btnConsultarProducto1");
		String btnConsultarProducto2 = request.getParameter("btnConsultarProducto2");
		String btnConsultarProducto3 = request.getParameter("btnConsultarProducto3");
	
		String btnConfirmar_ventas = request.getParameter("btnConfirmar");
		
		if(btnConsultarCliente  != null)
		{
			consultaClientes(request,response);
		}
		
		if(btnConsultarProducto1 != null)
		{
			consultaProductos(request,response); 
		}
		
		if(btnConsultarProducto2 != null)
		{
			consultaProductos(request, response);
		}
		
		if(btnConsultarProducto3 != null)
		{
			consultaProductos(request, response);
		}
		if(btnConfirmar_ventas != null)
		{
			registrarVenta(request,response);
		}
		
		
	}
	
	public void registrarVenta(HttpServletRequest request, HttpServletResponse response) {
		
		long codigo_ventas = Long.parseLong(request.getParameter("txtConsecutivo"));
		
		double iva = 0.19;
		
		//int cantidad_detalle1 = Integer.parseInt(request.getParameter("txtCantidad1"));
		//double valor_producto1 = Double.parseDouble(request.getParameter("txtValProd1"));
		long codigo_productos1 = Long.parseLong(request.getParameter("txtCodProd1"));
		int cantidad_producto_detalle_ventas1 = Integer.parseInt(request.getParameter("txtCantidad1"));	
		double valor_total1 = Integer.parseInt(request.getParameter("txtCantidad1")) * Double.parseDouble(request.getParameter("txtValProd1"));
		double valoriva_detalle_ventas1 = valor_total1 * iva;
		double valor_total_detalle_ventas1 = valor_total1 + valoriva_detalle_ventas1;
		
		DetalleVentas detalleVenta1 = new DetalleVentas();
		detalleVenta1.setCodigo_ventas(codigo_ventas);
		detalleVenta1.setCodigo_productos(codigo_productos1);
		detalleVenta1.setCantidad_producto_detalle_ventas(cantidad_producto_detalle_ventas1);
		detalleVenta1.setValor_venta_detalle_ventas(valoriva_detalle_ventas1);
		detalleVenta1.setValor_total_detalle_ventas(valor_total_detalle_ventas1);
		int respuestaDetalleVenta1 = 0;
		
		
		//int cantidad_detalle2 = Integer.parseInt(request.getParameter("txtCantidad2"));
		//double valor_producto2 = ;
		long codigo_productos2 = Long.parseLong(request.getParameter("txtCodProd2"));
		int cantidad_producto_detalle_ventas2 = Integer.parseInt(request.getParameter("txtCantidad2"));
		double valor_total2 = Integer.parseInt(request.getParameter("txtCantidad2"))* Double.parseDouble(request.getParameter("txtValProd2"));
		double valoriva_detalle_ventas2 = valor_total2 * iva;
		double valor_total_detalle_ventas2 = valor_total2 + valoriva_detalle_ventas2;
		
		DetalleVentas detalleVenta2 = new DetalleVentas();
		detalleVenta2.setCodigo_ventas(codigo_ventas);
		detalleVenta2.setCodigo_productos(codigo_productos2);
		detalleVenta2.setCantidad_producto_detalle_ventas(cantidad_producto_detalle_ventas2);
		detalleVenta2.setValor_venta_detalle_ventas(valoriva_detalle_ventas2);
		detalleVenta2.setValor_total_detalle_ventas(valor_total_detalle_ventas2);
		int respuestaDetalleVenta2 = 0;
		
		
		//int cantidad_detalle3 = Integer.parseInt(request.getParameter("txtCantidad3"));
		//double valor_producto3 = Double.parseDouble(request.getParameter("txtValProd3"));
		long codigo_productos3 = Long.parseLong(request.getParameter("txtCodProd3"));
		int cantidad_producto_detalle_ventas3 = Integer.parseInt(request.getParameter("txtCantidad3"));
		double valor_total3 = Integer.parseInt(request.getParameter("txtCantidad3")) * Double.parseDouble(request.getParameter("txtValProd3"));
		double valoriva_detalle_ventas3 = valor_total3 * iva;
		double valor_total_detalle_ventas3 = valor_total3 + valoriva_detalle_ventas3;
		
		DetalleVentas detalleVenta3 = new DetalleVentas();
		detalleVenta3.setCodigo_ventas(codigo_ventas);
		detalleVenta3.setCodigo_productos(codigo_productos3);
		detalleVenta3.setCantidad_producto_detalle_ventas(cantidad_producto_detalle_ventas3);
		detalleVenta3.setValor_venta_detalle_ventas(valoriva_detalle_ventas3);
		detalleVenta3.setValor_total_detalle_ventas(valor_total_detalle_ventas3);
		int respuestaDetalleVenta3 = 0;
		
		
		double subtotal = valor_total1 + valor_total2 + valor_total3 ;
		double valor_iva = subtotal * iva;
		double total_final = subtotal + valor_iva;
 			
		Ventas venta = new Ventas();
		venta.setCedula_clientes(Long.parseLong(request.getParameter("txtCedula")));
		venta.setCedula_usuarios(Long.parseLong(request.getParameter("txtCedula")));
		venta.setIvaventa_ventas(valor_iva);
		venta.setValor_venta_ventas(subtotal);
		venta.setTotal_venta_ventas(total_final);
		int respuestaVentas = 0;
		
		
		try {
			respuestaVentas = VentasJSON.postJSON(venta);
			//respuestaDetalleVenta1 = DetalleVentasJSON.postJSON(detalleVenta1);
			//respuestaDetalleVenta2 = DetalleVentasJSON.postJSON(detalleVenta2);
			//respuestaDetalleVenta3 = DetalleVentasJSON.postJSON(detalleVenta3);
			
			PrintWriter writer = response.getWriter();
			//if (respuestaVentas == 200 && respuestaDetalleVenta1 == 200 && respuestaDetalleVenta2 == 200 && respuestaDetalleVenta3 == 200)
			if (respuestaVentas == 200)
			{
				request.getRequestDispatcher("/ventas.jsp").forward(request, response);
			}
			else 
			{
				writer.println("Error: " + respuestaVentas);
			}
			writer.close();
		}catch(IOException | ServletException e){
			e.printStackTrace();
		}
	}
	
	public void consultaClientes(HttpServletRequest request, HttpServletResponse response) throws IOException {
		try {
			long txtCedula = Long.parseLong(request.getParameter("txtCedula"));
			String txtNombre = "";
			
			long txtCodProd1 = 0;
			String txtNomProd1 = " ";
			double txtValProd1 = 0;
	    	int txtCantidad1 = 0;
	    	double txtValorTotal1 = 0;
			
	    	long txtCodProd2 = 0;
			String txtNomProd2 = " ";
			double txtValProd2 = 0;
	    	int txtCantidad2 = 0;
	    	double txtValorTotal2 = 0;
	    	
	    	long txtCodProd3 = 0;
			String txtNomProd3 = " ";
			double txtValProd3 = 0;
	    	int txtCantidad3 = 0;
	    	double txtValorTotal3 = 0;
	    	
	    	double txtTotalIva = 0;
	    	double txtTotalVenta = 0;
	    	double txtTotalConIva = 0;
			
			ArrayList<Clientes> lista = ClientesJSON.getJSON();
			String pagina = "/ventasconsultas.jsp";
			
			for (Clientes cliente: lista){
				if (txtCedula == cliente.getCedula_clientes())
				{
					txtCedula = cliente.getCedula_clientes();
					txtNombre = (String) cliente.getNombre_clientes();
					break;
				}
			}
			
			request.setAttribute("txtCedula",txtCedula);
			request.setAttribute("txtNombre",txtNombre);
			
			request.setAttribute("txtCodProd1",txtCodProd1);
			request.setAttribute("txtNomProd1",txtNomProd1);
			request.setAttribute("txtValProd1",txtValProd1);
			request.setAttribute("txtCantidad1",txtCantidad1);
			request.setAttribute("txtValorTotal1",txtValorTotal1);
			
			request.setAttribute("txtCodProd2",txtCodProd2);
			request.setAttribute("txtNomProd2",txtNomProd2);
			request.setAttribute("txtValProd2",txtValProd2);
			request.setAttribute("txtCantidad2",txtCantidad2);
			request.setAttribute("txtValorTotal2",txtValorTotal2);
			
			request.setAttribute("txtCodProd3",txtCodProd3);
			request.setAttribute("txtNomProd3",txtNomProd3);
			request.setAttribute("txtValProd3",txtValProd3);
			request.setAttribute("txtCantidad3",txtCantidad3);
			request.setAttribute("txtValorTotal3",txtValorTotal3);
			
			request.setAttribute("txtTotalIva",txtTotalIva);
			request.setAttribute("txtTotalVenta",txtTotalVenta);
			request.setAttribute("txtTotalConIva",txtTotalConIva);
			
			
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(pagina);
			dispatcher.forward(request, response);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void consultaProductos(HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.getWriter().append("Served at: Entre al metodo de consultas").append(request.getContextPath());
		try {
			long txtCedula = Long.parseLong(request.getParameter("txtCedula"));
			String txtNombre = request.getParameter("txtNombre");
			
			long txtCodProd1 = Long.parseLong(request.getParameter("txtCodProd1"));
			String txtNomProd1 = request.getParameter("txtNomProd1");
			double txtValProd1 = 0;
	    	int txtCantidad1 = Integer.parseInt(request.getParameter("txtCantidad1"));
	    	double txtValorTotal1 = 0;
			
	    	long txtCodProd2 = Long.parseLong(request.getParameter("txtCodProd2"));
			String txtNomProd2 = "";
			double txtValProd2 = 0;
	    	int txtCantidad2 = Integer.parseInt(request.getParameter("txtCantidad2"));
	    	double txtValorTotal2 = 0;
	    	
	    	long txtCodProd3 = Long.parseLong(request.getParameter("txtCodProd3"));
			String txtNomProd3 = "";
			double txtValProd3 = 0;
	    	int txtCantidad3 = Integer.parseInt(request.getParameter("txtCantidad3"));
	    	double txtValorTotal3 = 0;
	    	
	    	double txtTotalIva = 0;
	    	double txtTotalVenta = 0;
	    	double txtTotalConIva = 0;
	    	
	    	double iva = 0.19;
	    	
			
			ArrayList<Clientes> listaClientes = ClientesJSON.getJSON();
			ArrayList<Productos> listaProductos = ProductosJSON.getJSON();
			String pagina = "/ventasconsultas.jsp";
			
			for (Clientes cliente:listaClientes){
				if (cliente.getCedula_clientes() == txtCedula)
				{
					txtCedula = cliente.getCedula_clientes();
					txtNombre = cliente.getNombre_clientes();
					break;
				}
			}
			
			for (Productos producto:listaProductos){
				if (producto.getCodigo_productos() == txtCodProd1)
				{
					txtValProd1 = producto.getPrecio_venta_productos();
					txtNomProd1 = producto.getNombre_productos();
					break;
				}
			}
			
			for (Productos producto:listaProductos){
				if (producto.getCodigo_productos() == txtCodProd2)
				{
					txtValProd2 = producto.getPrecio_venta_productos();
					txtNomProd2 = producto.getNombre_productos();
					break;
				}
			}
			
			for (Productos producto:listaProductos){
				if (producto.getCodigo_productos() == txtCodProd3)
				{
					txtValProd3 = producto.getPrecio_venta_productos();
					txtNomProd3 = producto.getNombre_productos();
					break;
				}
			}
			
			txtValorTotal1 = txtCantidad1 * txtValProd1;
			txtValorTotal2 = txtCantidad2 * txtValProd2;
			txtValorTotal3 = txtCantidad3 * txtValProd3;
			txtTotalVenta = txtValorTotal1 + txtValorTotal2 + txtValorTotal3;
			txtTotalIva = txtTotalVenta * iva;
			txtTotalConIva = txtTotalVenta + txtTotalIva;
			
			request.setAttribute("txtCedula",txtCedula);
			request.setAttribute("txtNombre",txtNombre);
			
			request.setAttribute("txtCodProd1",txtCodProd1);
			request.setAttribute("txtNomProd1",txtNomProd1);
			request.setAttribute("txtValProd1",txtValProd1);
			request.setAttribute("txtCantidad1",txtCantidad1);
			request.setAttribute("txtValorTotal1",txtValorTotal1);
			
			request.setAttribute("txtCodProd2",txtCodProd2);
			request.setAttribute("txtNomProd2",txtNomProd2);
			request.setAttribute("txtValProd2",txtValProd2);
			request.setAttribute("txtCantidad2",txtCantidad2);
			request.setAttribute("txtValorTotal2",txtValorTotal2);
			
			request.setAttribute("txtCodProd3",txtCodProd3);
			request.setAttribute("txtNomProd3",txtNomProd3);
			request.setAttribute("txtValProd3",txtValProd3);
			request.setAttribute("txtCantidad3",txtCantidad3);
			request.setAttribute("txtValorTotal3",txtValorTotal3);
			
			request.setAttribute("txtTotalIva",txtTotalIva);
			request.setAttribute("txtTotalVenta",txtTotalVenta);
			request.setAttribute("txtTotalConIva",txtTotalConIva);
			
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
