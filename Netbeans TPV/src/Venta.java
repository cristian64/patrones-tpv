import java.util.ArrayList;
import java.util.Iterator;

public class Venta
{
	private ArrayList<LineaVenta> lineasVenta;
	private TipoCliente tipoCliente;
        private ArrayList<AlgoritmoImpuestos> algoritmosImpuestos;
	
	public Venta()
	{
		lineasVenta = new ArrayList<LineaVenta>();
		tipoCliente = null;		
	}

        public Venta(Venta venta)
        {
            //TODO Constructor de copia
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
					i.remove(); //TODO falta comprobar que se elimina bien con "remove", pero como no tengo netbeans ni siquiera sé si existe el método "remove" en el Iterator.				
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
	
	public Double calcularImpuestos()
	{
		double acumulado = 0.0;
		for (AlgoritmoImpuestos i : algoritmosImpuestos)//TODO podria haber una serie de algoritmos diferentes, no?
		{
			acumulado += i.calcularImpuestos(new Venta(this));
		}
		return acumulado;
	}
	
	public Double calcularPrecio()
	{
		double acumulado = 0.0;
		for (LineaVenta i : lineasVenta)
		{
			acumulado += i.getCantidad() * i.getProducto().getPrecio();
		}
		return acumulado;
	}
	
	public Double calcularDescuento()
	{
		return -123456.789;//TODO
	}
}

