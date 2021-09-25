package co.edu.unbosque.nameless;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class VentaServlet
 */
@WebServlet("/VentaServlet")
public class VentaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VentaServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		
		long cedula_clientes = Long.parseLong(request.getParameter("txtCedula"));
		String nombre_clientes = request.getParameter("txtCliente");
		String consecutivo_ventas = request.getParameter("txtConsecutivo");
		
		
		
		long codigo_productos2 = Long.parseLong(request.getParameter("txtCodProd2"));
		String nombre_productos2 = request.getParameter("txtNomProd2");
		int cantidad_detalle2 = Integer.parseInt(request.getParameter("txtCantidad2"));
		double valor_total2 = Double.parseDouble(request.getParameter("txtValorTotal2"));
		
		long codigo_productos3 = Long.parseLong(request.getParameter("txtCodProd3"));
		String nombre_productos3 = request.getParameter("txtNomProd3");
		int cantidad_detalle3 = Integer.parseInt(request.getParameter("txtCantidad3"));
		double valor_total3 = Double.parseDouble(request.getParameter("txtValorTotal3"));
		
		double venta_total = Double.parseDouble(request.getParameter("txttotalventa"));
		double total_iva = Double.parseDouble(request.getParameter("txttotaliva"));
		double total_venta = Double.parseDouble(request.getParameter("txttotalconiva"));
		
		String btnConsultar_clientes = request.getParameter("btnConsultar");
		
		String btnConsultar1_productos = request.getParameter("btnConsultar1");
		String btnConsultar2_productos = request.getParameter("btnConsultar2");
		String btnConsultar3_productos = request.getParameter("btnConsultar3");
		
		String btnConfirmar_ventas = request.getParameter("btnConfirma");
	}
	
	 public void ventaParcial1(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {
			try {
				double parcial1 = 0;
				double valor_producto1 = 0;
								
				long codigo_productos1 = Long.parseLong(request.getParameter("txtCodProd1"));
				String nombre_productos1 = request.getParameter("txtNomProd1");
				int cantidad_detalle1 = Integer.parseInt(request.getParameter("txtCantidad1"));
				double valor_total1 = Double.parseDouble(request.getParameter("txtValorTotal1"));
				
				parcial1 = cantidad_detalle1 * valor_producto1;
					
			} catch (Exception e) {
				// TODO: handle exception
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
