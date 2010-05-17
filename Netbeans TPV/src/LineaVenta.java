public class LineaVenta
{
	private Producto producto;
	private int cantidad;
	
	public LineaVenta()
	{
		producto = null;
		cantidad = 0;
	}
	
	public Producto getProducto()
	{
		return producto;
	}
	
	public int getCantidad()
	{
		return cantidad;
	}
	
	public void setProducto(Producto producto)
	{
		this.producto = producto;
	}
	
	public void setCantidad(int cantidad)
	{
		this.cantidad = cantidad;
	}
}

