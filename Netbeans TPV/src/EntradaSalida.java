/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author jorge
 */
public interface EntradaSalida {
	public void LeerTPV(Venta venta);
	public void LeerCatalogo(CatalogoProducto catalogo);
	public void LeerCatalogoIVA(CatalogoProducto catalogo);
	public void LeerReglasPrecios(TiposCliente tiposCliente);
	public void LeerDescuentoVolumen(Venta venta);
	public void LeerVenta(Venta venta);
	public void EscribirVenta(Venta venta);
}

