package co.edu.unbosque.nameless;

public class DetalleVentas {
	
	private long codigo_detalle_ventas;
	private int cantidad_producto_detalle_ventas;
	private long codigo_productos;
	private long codigo_ventas;
	private double valor_total_detalle_ventas;
	private double valor_venta_detalle_ventas;
	private double valoriva_detalle_ventas;
	
	public long getCodigo_detalle_ventas() {
		return codigo_detalle_ventas;
	}
	
	public void setCodigo_detalle_ventas(long codigo_detalle_ventas) {
		this.codigo_detalle_ventas = codigo_detalle_ventas;
	}
	
	public int getCantidad_producto_detalle_ventas() {
		return cantidad_producto_detalle_ventas;
	}
	
	public void setCantidad_producto_detalle_ventas(int cantidad_producto_detalle_ventas) {
		this.cantidad_producto_detalle_ventas = cantidad_producto_detalle_ventas;
	}
	
	public long getCodigo_productos() {
		return codigo_productos;
	}
	
	public void setCodigo_productos(long codigo_productos) {
		this.codigo_productos = codigo_productos;
	}
	
	public long getCodigo_ventas() {
		return codigo_ventas;
	}
	
	public void setCodigo_ventas(long codigo_ventas) {
		this.codigo_ventas = codigo_ventas;
	}
	
	public double getValor_total_detalle_ventas() {
		return valor_total_detalle_ventas;
	}
	
	public void setValor_total_detalle_ventas(double valor_total_detalle_ventas) {
		this.valor_total_detalle_ventas = valor_total_detalle_ventas;
	}
	
	public double getValor_venta_detalle_ventas() {
		return valor_venta_detalle_ventas;
	}
	
	public void setValor_venta_detalle_ventas(double valor_venta_detalle_ventas) {
		this.valor_venta_detalle_ventas = valor_venta_detalle_ventas;
	}
	
	public double getValoriva_detalle_ventas() {
		return valoriva_detalle_ventas;
	}
	
	public void setValoriva_detalle_ventas(double valoriva_detalle_ventas) {
		this.valoriva_detalle_ventas = valoriva_detalle_ventas;
	}
		
}
