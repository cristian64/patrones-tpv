import java.util.ArrayList;

public class DescuentoCompuesto implements EstrategiaDescuento
{
	ArrayList<EstrategiaDescuento> descuentos;

	public DescuentoCompuesto()
	{
		descuentos = new ArrayList<EstrategiaDescuento>();
	}

	public void anadirDescuento(EstrategiaDescuento descuento)
	{
		descuentos.add(descuento);
	}

	public double calcularDescuento(Venta venta)
	{
		double acumulado = 0;

		for (EstrategiaDescuento d : descuentos)
		{
			//Calcula el descuento de cada descuento base
			acumulado += d.calcularDescuento(venta);
		}

		return acumulado;
	}
}
