
import java.util.ArrayList;


/**
 *
 * @author jorge
 */
public class DescuentoCompuesto implements Descuento {
    ArrayList<Descuento> descuentos;

    public void añadirDescuento(Descuento descuento)
    {
        descuentos.add(descuento);
    }

    public double calcularDescuento(Venta venta) {
        double acumulado = 0;

        for(Descuento d : descuentos)
        {
            acumulado += d.calcularDescuento(venta);
        }

        return acumulado;
    }
}
