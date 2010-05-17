public class ImpuestoFijo implements AlgoritmoImpuestos
{
	private static final double porcentaje = 16;

	public double calcularImpuestos(Venta venta)
	{
		return (venta.getPrecioFinal() / (1 + porcentaje/100)) * (porcentaje/100);
	}
}
