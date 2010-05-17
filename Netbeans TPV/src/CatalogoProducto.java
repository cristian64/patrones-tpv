import java.util.ArrayList;

public class CatalogoProducto
{
	private ArrayList<Producto> productos;
	private static CatalogoProducto instancia;
	
	public static CatalogoProducto getInstancia()
	{
		if (instancia == null)
			instancia = new CatalogoProducto();
		return instancia;
	}
	
	private CatalogoProducto()
	{
		productos = new ArrayList<Producto>();
	}
	
	public Producto obtenerProducto(int id)
	{
		for (Producto i : productos)
		{
			if (i.getId() == id)
				return i;
		}

                return null;
	}
	
	public void anadirProducto(Producto producto)
	{
		productos.add(producto);
	}
}

