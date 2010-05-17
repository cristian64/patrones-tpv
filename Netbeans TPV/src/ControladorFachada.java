public class ControladorFachada
{
	private EntradaSalida entradaSalida;
	private Venta venta;

	public void inicializar()
	{
		entradaSalida = new ESTexto();
		entradaSalida.LeerCatalogo(CatalogoProducto.getInstancia());
		entradaSalida.LeerCatalogoIVA(CatalogoProducto.getInstancia());
		entradaSalida.LeerReglasPrecios(TiposCliente.getInstancia());
	}

	public void crearNuevaVenta()
	{
		venta = new Venta();
		venta.anadirEstrategiaDescuento(new DescuentoCliente());
		entradaSalida.LeerDescuentoVolumen(venta);
		entradaSalida.LeerTPV(venta);
	}

	public void introducirProductos()
	{
		entradaSalida.LeerVenta(venta);
		venta.actualizarPrecios();
	}

	public void realizarPago()
	{
		venta.actualizarPrecios();
	}

	public void terminarVenta()
	{
		entradaSalida.EscribirVenta(venta);
	}
}
