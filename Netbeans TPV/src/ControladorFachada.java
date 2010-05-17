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
		entradaSalida.LeerDescuentoVolumen(CatalogoProducto.getInstancia());
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
