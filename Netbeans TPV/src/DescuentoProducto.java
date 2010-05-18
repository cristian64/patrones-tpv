/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author jorge
 */
public class DescuentoProducto implements EstrategiaDescuento {

    public Producto producto;
    public int descuento;

	public Producto getProducto()
	{
		return producto;
	}

	public void setProducto(Producto producto)
	{
		this.producto = producto;
	}

	public int getDescuento()
	{
		return descuento;
	}

	public void setDescuento(int descuento)
	{
		this.descuento = descuento;
	}

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
                      linea.setPrecioLinea(linea.getPrecioLinea()-linea.getProducto().getPrecio());
					  linea.setOferta(true);
                      articulos -= descuento;
                      acumulado += linea.getProducto().getPrecio();
                  }
            }
        }

        return acumulado;
    }
    

}
