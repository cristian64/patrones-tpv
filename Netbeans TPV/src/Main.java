public class Main
{
	public static void main(String[] args)
	{
		ControladorFachada controladorFachada = new ControladorFachada();
		controladorFachada.inicializar();
		controladorFachada.crearNuevaVenta();
		controladorFachada.introducirProductos();
		controladorFachada.realizarPago();
		controladorFachada.terminarVenta();
	}
}
