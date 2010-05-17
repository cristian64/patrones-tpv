/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author jorge
 */
public class DescuentoProducto implements Descuento {

    public Producto producto;
    public int descuento;
    
    public double calcularDescuento(Venta venta) {
        int articulos = 0;
        double acumulado = 0;

        for(LineaVenta linea : venta.getLineasVenta())
        {
            if(linea.producto.getId() == producto.getId())
            {
                  articulos += linea.cantidad;
                  while(articulos >= descuento)
                  {
                      linea.cantidad--;
                      articulos -= descuento;
                      acumulado += linea.producto.getPrecio();
                      linea.descuento = true;
                  }
            }
        }

        return acumulado;
    }
    

}
