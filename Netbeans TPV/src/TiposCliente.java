import java.util.ArrayList;

public class TiposCliente
{
	private ArrayList<TipoCliente> tiposCliente;
	
	private static TiposCliente instancia;

	public static TiposCliente getInstancia()
	{
		if (instancia == null)
			instancia = new TiposCliente();
		return instancia;
	}
	
	private TiposCliente()
	{
		tiposCliente = new ArrayList<TipoCliente>();
	}
	
	public TipoCliente obtenerTipoCliente(String nombre)
	{
		for (TipoCliente i : tiposCliente)
		{
			if (i.getNombre().equals(nombre))
				return i;
		}
		return null;
	}
	
	public void anadirTipoCliente(TipoCliente tipoCliente)
	{
		tiposCliente.add(tipoCliente);
	}
}

