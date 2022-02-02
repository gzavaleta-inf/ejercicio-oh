package pe.com.oh.business.port;

import java.util.List;

import pe.com.oh.domain.Producto;

public interface IProductoService {

	public String registrarProducto(String nombre, String precio);
	public String actualizarProducto(int id, String nombre, String precio);
	public List<Producto> obtenerProductos();
	public String eliminarProducto(int id);
	
}
