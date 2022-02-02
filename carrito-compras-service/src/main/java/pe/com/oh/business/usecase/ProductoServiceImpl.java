package pe.com.oh.business.usecase;

import java.util.List;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;

import pe.com.oh.business.port.IProductoService;
import pe.com.oh.controller.util.Utils;
import pe.com.oh.domain.Producto;
import pe.com.oh.repository.IPersistenceProducto;

@Service
public class ProductoServiceImpl implements IProductoService {
	
	@Autowired
	private IPersistenceProducto persistence;

	@Override
	public String registrarProducto(String nombre, String precio) {
		
		var producto = new Producto();
		
		try {
			producto = persistence.save(
					Producto.builder()
					.nombre(nombre)
					.precio(precio)
					.build());
		}
		catch (Exception ex){
			return Utils.MENSAJE_ERROR + ex.getMessage();
		}
		
		return Utils.MENSAJE_CREATE + new Gson().toJson(producto);
		
	}
	
	@Override
	public String actualizarProducto(int id, String nombre, String precio) {
		
		var producto = new Producto();
		
		try {
			producto = persistence.findById(id).orElseThrow();
			
			producto = persistence.save(Producto.builder()
					.id(id)
					.nombre(nombre)
					.precio(precio)
					.build());
		}
		catch (Exception ex){
			return Utils.MENSAJE_ERROR + ex.getMessage();
		}
		
		return Utils.MENSAJE_UPDATE + new Gson().toJson(producto);
	}
	
	@Override
	public List<Producto> obtenerProductos() {
		
		List<Producto> listaPersona = new ArrayList<>();
		
		try {
			listaPersona = (List<Producto>) persistence.findAll();
		}
		catch (Exception ex){
			Utils.generateException(
					Utils.MENSAJE_ERROR + ex.getMessage(), 
					null);		
		}
		
		return listaPersona;
	}

	@Override
	public String eliminarProducto(int id) {
		
		try {
			persistence.deleteById(id);			
		}
		catch (Exception ex){
			return Utils.MENSAJE_ERROR + ex.getMessage();
		}
		
		return Utils.MENSAJE_DELETE;
	}
	
}
