public class Main
{
	public static void main(String[] args)
	{
		ControladorFachada controladorFachada = new ControladorFachada();
		controladorFachada.inicializar();
		while (controladorFachada.crearNuevaVenta())
		{
			while (controladorFachada.introducirProducto())
			{

			}
			controladorFachada.realizarPago();
			controladorFachada.terminarVenta();
		}
	}
}
