import java.util.ArrayList;
import java.util.Iterator;

public class Venta
{
	private ArrayList<LineaVenta> lineasVenta;
	private TipoCliente tipoCliente;
	private ArrayList<AlgoritmoImpuestos> algoritmosImpuestos;
	private double precioTotal;
	private double precioFinal;
	
	public Venta()
	{
		lineasVenta = new ArrayList<LineaVenta>();
		tipoCliente = null;
		algoritmosImpuestos = new ArrayList<AlgoritmoImpuestos>();
		precioTotal = 0;
		precioFinal = 0;
	}

	public Venta(Venta venta)
	{
		lineasVenta = new ArrayList<LineaVenta>(venta.lineasVenta);
		tipoCliente = venta.tipoCliente;
		algoritmosImpuestos = new ArrayList<AlgoritmoImpuestos>(venta.algoritmosImpuestos);
		precioTotal = venta.precioTotal;
		precioFinal = venta.precioFinal;
	}
	
	public ArrayList<LineaVenta> getLineasVenta()
	{
		return lineasVenta;
	}
	
	public void anadirProducto(Producto producto, int cantidad)
	{
		LineaVenta nuevaLineaVenta = new LineaVenta();
		nuevaLineaVenta.setProducto(producto);
		nuevaLineaVenta.setCantidad(cantidad);
		lineasVenta.add(nuevaLineaVenta);
	}
	
	public void quitarProducto(Producto producto, int cantidad)
	{
		Iterator<LineaVenta> i = lineasVenta.iterator();
		while (i.hasNext() && cantidad > 0)
		{
			LineaVenta lineaVentaActual = i.next();
			
			if (lineaVentaActual.getProducto().getId() == producto.getId())
			{
				if (lineaVentaActual.getCantidad() > cantidad)
				{
					// Si en la línea actual hay más cantidad que la que se quiere sustraer, se decrementa.
					lineaVentaActual.setCantidad(lineaVentaActual.getCantidad() - cantidad);
					cantidad = 0;
				}
				else
				{
					// Si hay menos cantidad, se debe eliminar la línea y continuar la búsqueda del producto en otra línea.
					cantidad -= lineaVentaActual.getCantidad();
					i.remove();
				}
			}
		}
	}
	
	public void setTipoCliente(TipoCliente tipoCliente)
	{
		this.tipoCliente = tipoCliente;
	}
	
	public TipoCliente getTipoCliente()
	{
		return tipoCliente;
	}

	/**
	 * Obtiene el precio total de la venta (sin considerar descuentos).
	 * Este valor se calcula al invocar "actualizarPrecio" desde la venta.
	 * @return Devuelve un valor real con el precio total de la venta.
	 */
	public double getPrecioTotal()
	{
		return precioTotal;
	}

	/**
	 * Obtiene el precio final de la venta (después de aplicar el descuento).
	 * Este valor se calcula al invocar "actualizarPrecio" desde la venta.
	 * @return Devuelve un valor real con el precio final de la venta.
	 */
	public double getPrecioFinal()
	{
		return precioFinal;
	}
	
	public Double calcularImpuestos()
	{
		double acumulado = 0.0;
		for (AlgoritmoImpuestos i : algoritmosImpuestos)//TODO podria haber una serie de algoritmos diferentes, no?
		{
			acumulado += i.calcularImpuestos(new Venta(this));
		}
		return acumulado;
	}

	/**
	 * Actualiza el precio total y precio final de la venta (el precio final tiene en cuenta el máximo descuento aplicable).
	 * Además, si el descuento máximo se consigue con un descuento por producto, modifica las líneas de la venta.
	 */
	public void actualizarPrecio()
	{
		precioTotal = 0.0;
		for (LineaVenta i : lineasVenta)
		{
			precioTotal += i.getCantidad() * i.getProducto().getPrecio();
		}

		//TODO calcular precio final con descuentos y tal, pero Venta todavia no esta relacionada con DescuentoBlabla.
	}
}
