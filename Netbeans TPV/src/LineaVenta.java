public class LineaVenta
{
	private Producto producto;
	private int cantidad;
	private double precioLinea;
	private boolean descuento;
	
	public LineaVenta()
	{
		producto = null;
		cantidad = 0;
		precioLinea = 0;
		descuento = false;
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

	/**
	 * Comprueba si la línea ha sufrido un descuento.
	 * @return Devuelve verdadero si la línea ha sufrido un descuento o falso en caso contrario.
	 */
	public boolean getDescuento()
	{
		return descuento;
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

	public void setDescuento(boolean descuento)
	{
		this.descuento = descuento;
	}
}

