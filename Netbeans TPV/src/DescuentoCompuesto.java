import java.util.ArrayList;

public class DescuentoCompuesto implements Descuento
{
	ArrayList<Descuento> descuentos;

	public DescuentoCompuesto()
	{
		descuentos = new ArrayList<Descuento>();
	}

	public void anadirDescuento(Descuento descuento)
	{
		descuentos.add(descuento);
	}

	public double calcularDescuento(Venta venta)
	{
		double acumulado = 0;

		for (Descuento d : descuentos)
		{
			//Calcula el descuento de cada descuento base
			acumulado += d.calcularDescuento(venta);
		}

		return acumulado;
	}
}
