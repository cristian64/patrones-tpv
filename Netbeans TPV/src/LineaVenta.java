public class LineaVenta
{
	private Producto producto;
	private int cantidad;
        private boolean descuento;
	
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

        public void setDescuento(boolean descuento)
        {
            this.descuento = descuento;
        }
}

