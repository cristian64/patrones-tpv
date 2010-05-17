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
            if(linea.getProducto().getId() == producto.getId())
            {
                  articulos += linea.getCantidad();

                  //Comprueba que haya suficientes productos para el descuento
                  while(articulos >= descuento)
                  {
                      linea.setCantidad(linea.getCantidad()-1);
                      articulos -= descuento;
                      acumulado += linea.getProducto().getPrecio();
                      linea.setDescuento(true);
                  }
            }
        }

        return acumulado;
    }
    

}
