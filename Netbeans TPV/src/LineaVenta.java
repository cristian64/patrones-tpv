public class LineaVenta
{
	private Producto producto;
	private int cantidad;
	private double precioLinea;
	
	public LineaVenta()
	{
		producto = null;
		cantidad = 0;
		precioLinea = 0;
	}
	
	public Producto getProducto()
	{
		return producto;
	}
	
	public int getCantidad()
	{
		return cantidad;
	}

	public double getPrecioLinea()
	{
		return precioLinea;
	}
	
	public void setProducto(Producto producto)
	{
		this.producto = producto;
	}
	
	public void setCantidad(int cantidad)
	{
		this.cantidad = cantidad;
	}

	public void setPrecioLinea(double precioLinea)
	{
		this.precioLinea = precioLinea;
	}

	public double getDescuentoAplicado() {
		return (precioLinea - (producto.getPrecio()*cantidad));
	}
}

