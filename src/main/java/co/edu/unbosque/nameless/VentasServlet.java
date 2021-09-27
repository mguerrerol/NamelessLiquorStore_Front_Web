package co.edu.unbosque.nameless;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

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
		
		//String nombre_clientes = request.getParameter("txtCliente");
		
		
		long codigo_productos1 = Long.parseLong(request.getParameter("txtCodProd1"));
		String nombre_productos1 = request.getParameter("txtNomProd1");
		
		long codigo_productos2 = Long.parseLong(request.getParameter("txtCodProd2"));
		String nombre_productos2 = request.getParameter("txtNomProd2");
	
		
		long codigo_productos3 = Long.parseLong(request.getParameter("txtCodProd3"));
		String nombre_productos3 = request.getParameter("txtNomProd3");

		
		double venta_total = Double.parseDouble(request.getParameter("txtTotalVenta"));
		double total_iva = Double.parseDouble(request.getParameter("txtTotalIva"));
		double total_venta = Double.parseDouble(request.getParameter("txtTotalConIva"));
		
		String btnConsultar_clientes = request.getParameter("btnConsultar");
		
		String btnConsultar1_productos = request.getParameter("btnConsultar1");
		String btnConsultar2_productos = request.getParameter("btnConsultar2");
		String btnConsultar3_productos = request.getParameter("btnConsultar3");
		
		String btnConfirmar_ventas = request.getParameter("btnConfirmar");
		
		if(btnConsultar1_productos != null)
		{
			
		}
		
		if(btnConsultar2_productos != null)
		{
	
		}
		
		if(btnConsultar3_productos != null)
		{

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

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
