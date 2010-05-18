
import java.io.BufferedReader;
import java.io.FileReader;
import java.text.DecimalFormat;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author jorge
 */
public class ESTexto implements EntradaSalida {

	public void LeerCatalogo(CatalogoProducto catalogo) {
		try {
			BufferedReader bf = new BufferedReader(new FileReader("CatalogoProductos.properties"));

			String s = "";
			while ((s = bf.readLine())!=null) {
				String linea[] = s.split("\\t");

				int id = Integer.parseInt(linea[0]);
				double precio = Double.parseDouble(linea[1].replaceAll(",", "."));

				Producto p = new Producto();
				p.setId(id);
				p.setPrecio(precio);
				p.setDescripcion(linea[2]);

				catalogo.anadirProducto(p);

			}
		} catch (Exception ex) {
		}
	}

	public void LeerCatalogoIVA(CatalogoProducto catalogo) {
		try {
			BufferedReader bf = new BufferedReader(new FileReader("CatalogoIVA.properties"));

			String s = "";
			while ((s = bf.readLine())!=null) {
				String[] linea = s.split("[\\t|\\p{Space}+]");

				int id = Integer.parseInt(linea[0]);
				double impuesto = Double.parseDouble(linea[1].replaceAll(",", "."));

				Producto p = catalogo.obtenerProducto(id);
				p.setImpuesto(impuesto);

			}
		} catch (Exception ex) {
		}
	}

	public void LeerReglasPrecios(TiposCliente tiposCliente) {
		try {
			BufferedReader bf = new BufferedReader(new FileReader("ReglasPrecios.properties"));

			String s = "";
			while ((s = bf.readLine())!=null) {
				String linea[] = s.split("\\p{Space}*=\\p{Space}*");

				double descuento = Double.parseDouble(linea[1].replaceAll(",", "."));
				
				TipoCliente cliente = new TipoCliente();
				cliente.setNombre(linea[0]);
				cliente.setDescuento(descuento);

				tiposCliente.anadirTipoCliente(cliente);
			}
		} catch (Exception ex) {

		}
	}

	public void LeerDescuentoVolumen(Venta venta) {
		try {
			BufferedReader bf = new BufferedReader(new FileReader("DescuentoVolumen.properties"));

			String s = "";
			DescuentoCompuesto compuesto = new DescuentoCompuesto();
			venta.anadirEstrategiaDescuento(compuesto);
			
			while ((s = bf.readLine())!=null) {
				String[] linea = s.split("[\\t|\\p{Space}+]");

				int id = Integer.parseInt(linea[0]);
				int descuento = Integer.parseInt(linea[1]);
				DescuentoProducto dp = new DescuentoProducto();

				dp.setDescuento(descuento);
				dp.setProducto(CatalogoProducto.getInstancia().obtenerProducto(id));

				compuesto.anadirDescuento(dp);
			}

		} catch (Exception ex) {
		}
	}

	public void LeerVenta(Venta venta) {
		try {
			BufferedReader bf = new BufferedReader(new FileReader("Venta.txt"));

			String s = "";
			while ((s = bf.readLine())!=null) {
				String linea[] = s.split("\\t");

				if(linea.length == 3)
				{
					int id = Integer.parseInt(linea[1]);
					int cantidad = Integer.parseInt(linea[2]);

					Producto p = CatalogoProducto.getInstancia().obtenerProducto(id);

					if(linea[0].equals("+"))
					{
						venta.anadirProducto(p, cantidad);
					}
					else
					{
						venta.quitarProducto(p, cantidad);
					}
				}
				else
				{
					venta.setTipoCliente( TiposCliente.getInstancia().obtenerTipoCliente(linea[1]));
				}

			}
		} catch (Exception ex) {
		}
	}

	public void EscribirVenta(Venta venta)
	{
		DecimalFormat formateador = new DecimalFormat ("#########.##");

		String salida = "";
		for (LineaVenta i : venta.getLineasVenta())
		{
			salida += i.getProducto().getDescripcion() + " " + i.getCantidad() + " " + formateador.format(i.getProducto().getPrecio()) + "E " + formateador.format(i.getPrecioLinea()) + "E";
			if(i.getDescuentoAplicado() != 0.0)
				salida += " *";
			salida+= "\n";
		}
		salida += "Total: " + formateador.format(venta.getPrecioTotal()) + "E\n";
		salida += "Dcto: " + formateador.format((venta.getPrecioTotal() - venta.getPrecioFinal())) + "E\n";
		salida += "Precio final: " + formateador.format(venta.getPrecioFinal()) + "E\n";
		salida += "Impuestos: " + formateador.format((venta.getPrecioFinal() - venta.getPrecioNeto())) + "E\n";

		System.out.println(salida);
	}

	public void LeerTPV(Venta venta) {
		try {
			BufferedReader bf = new BufferedReader(new FileReader("TPV.properties"));

			String s = "";
			while ((s = bf.readLine())!=null) {
				String[] lineas = s.split("[\\t|\\p{Space}+]");

				if(lineas[1].equals("IVAPorProducto"))
				{
					venta.anadirAlgoritmoImpuestos(new ImpuestoPorProducto());
				}
				else
				{
					venta.anadirAlgoritmoImpuestos(new ImpuestoFijo());
				}

			}
		} catch (Exception ex) {

		}
	}
}
