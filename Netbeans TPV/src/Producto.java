public class Producto
{
	private int id;
	private String descripcion;
	private double precio;
	private double impuesto;
	
	public int getId()
	{
		return id;
	}
	
	public String getDescripcion()
	{
		return descripcion;
	}
	
	public double getPrecio()
	{
		return precio;
	}
	
	public double getImpuesto()
	{
		return impuesto;
	}
	
	public void setId(int id)
	{
		this.id = id;
	}
	
	public void setDescripcion(String descripcion)
	{
		this.descripcion = descripcion;
	}
	
	public void setPrecio(double precio)
	{
		this.precio = precio;	
	}
		
	public void setImpuesto(int impuesto)
	{
		this.impuesto = impuesto;
	}
}
