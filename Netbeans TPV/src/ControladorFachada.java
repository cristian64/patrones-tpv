public class ControladorFachada
{
	private EntradaSalida entradaSalida;
	private Venta venta;

	public void inicializar()
	{
		entradaSalida = new ESTexto();
	}

	public void crearNuevaVenta()
	{
		venta = new Venta();
	}

	public void introducirProductos()
	{
		entradaSalida.LeerVenta(venta);
	}

	public void realizarPago()
	{

	}

	public void terminarVenta()
	{
		entradaSalida.EscribirVenta(venta);
	}
}
