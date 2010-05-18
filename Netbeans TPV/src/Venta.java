import java.util.ArrayList;
import java.util.Iterator;

public class Venta
{
	private ArrayList<LineaVenta> lineasVenta;
	private TipoCliente tipoCliente;
	private ArrayList<AlgoritmoImpuestos> algoritmosImpuestos;
	private ArrayList<EstrategiaDescuento> estrategiasDescuento;
	private double precioTotal;
	private double precioFinal;
	private double precioNeto;
	
	public Venta()
	{
		lineasVenta = new ArrayList<LineaVenta>();
		tipoCliente = null;
		algoritmosImpuestos = new ArrayList<AlgoritmoImpuestos>();
		estrategiasDescuento = new ArrayList<EstrategiaDescuento>();
		precioTotal = 0;
		precioFinal = 0;
		precioNeto = 0;
	}

	public Venta(Venta venta)
	{
		lineasVenta = new ArrayList<LineaVenta>();
		for (LineaVenta i : venta.lineasVenta)
		{
			lineasVenta.add(new LineaVenta(i));
		}

		tipoCliente = venta.tipoCliente;
		algoritmosImpuestos = new ArrayList<AlgoritmoImpuestos>(venta.algoritmosImpuestos);
		estrategiasDescuento = new ArrayList<EstrategiaDescuento>(venta.estrategiasDescuento);
		precioTotal = venta.precioTotal;
		precioFinal = venta.precioFinal;
		precioNeto = venta.precioNeto;
	}
	
	public ArrayList<LineaVenta> getLineasVenta()
	{
		return lineasVenta;
	}

	public void anadirEstrategiaDescuento(EstrategiaDescuento descuento)
	{
		estrategiasDescuento.add(descuento);
	}

	public void anadirAlgoritmoImpuestos(AlgoritmoImpuestos algoritmoImpuestos)
	{
		algoritmosImpuestos.add(algoritmoImpuestos);
	}
	
	public void anadirProducto(Producto producto, int cantidad)
	{
		LineaVenta nuevaLineaVenta = new LineaVenta();
		nuevaLineaVenta.setProducto(producto);
		nuevaLineaVenta.setCantidad(cantidad);
		nuevaLineaVenta.setPrecioLinea(producto.getPrecio()*cantidad);
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
					lineaVentaActual.setPrecioLinea(lineaVentaActual.getPrecioLinea() - cantidad * lineaVentaActual.getProducto().getPrecio());
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

	/**
	 * Obtiene el precio neto de la venta (después de aplicar el descuento pero sin incluir los impuestos).
	 * Este valor se calcula al invocar "actualizarPrecio" desde la venta.
	 * @return Devuelve un valor real con el precio neto de la venta.
	 */
	public double getPrecioNeto()
	{
		return precioNeto;
	}

	/**
	 * Actualiza el precio total y precio final de la venta (el precio final tiene en cuenta el máximo descuento aplicable).
	 * Además, si el descuento máximo se consigue con un descuento por producto, modifica las líneas de la venta.
	 */
	public void actualizarPrecios()
	{
		// Se actualiza el precio total.
		precioTotal = 0.0;
		for (LineaVenta i : lineasVenta)
		{
			precioTotal += i.getCantidad() * i.getProducto().getPrecio();
		}

		// Se actualiza el precio final (y se actualiza la venta si se ha modificado).
		double descuentoMaximo = Double.MIN_VALUE;
		Venta copiaVenta = this;
		for (EstrategiaDescuento i : estrategiasDescuento)
		{
			Venta copiaVentaAux = new Venta(this);
			double descuentoMaximoAux = i.calcularDescuento(copiaVentaAux);
			if (descuentoMaximoAux > descuentoMaximo)
			{
				copiaVenta = copiaVentaAux;
				descuentoMaximo = descuentoMaximoAux;
			}
		}
		precioFinal = precioTotal - descuentoMaximo;
		this.lineasVenta = copiaVenta.lineasVenta;

		// Se actualiza el precio neto.
		precioNeto = precioFinal;
		for (AlgoritmoImpuestos i : algoritmosImpuestos)
		{
			precioNeto -= i.calcularImpuestos(this);
		}
	}
}
