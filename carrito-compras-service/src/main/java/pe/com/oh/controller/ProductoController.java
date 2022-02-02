package pe.com.oh.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import pe.com.oh.business.port.IProductoService;

import pe.com.oh.domain.Producto;

@RestController
@RequestMapping (path="/producto")
@Api(tags = { "Producto" }, value = "/api", produces = "application/json")
public class ProductoController {
	
	@Autowired
	private IProductoService productoService;

	@GetMapping(path="/registrar")
	@ApiOperation(value = "Agregar producto")
	public ResponseEntity<String> agregarProducto(
			@RequestParam(value = "nombre") String nombre,
			@RequestParam(value = "precio") String precio
			) {
			
		return new ResponseEntity<>(productoService.registrarProducto(nombre, precio), HttpStatus.OK);
	}
	
	@GetMapping(path="/actualizar")
	@ApiOperation(value = "Actualizar producto")
	public ResponseEntity<String> actualizarProducto(
			@RequestParam(value = "id") int id,
			@RequestParam(value = "nombre") String nombre,
			@RequestParam(value = "precio") String precio
			) {
		
		return new ResponseEntity<>(productoService.actualizarProducto(id, nombre, precio), HttpStatus.OK);
	}
	
	@GetMapping(path="/obtener")
	@ApiOperation(value = "Obtener productos")
	public ResponseEntity<List<Producto>> obtenerProductos() {
		return new ResponseEntity<>(productoService.obtenerProductos(), HttpStatus.OK);
	}
	
	@GetMapping(path="/eliminar")
	@ApiOperation(value = "Eliminar producto")
	public ResponseEntity<String> eliminarProducto(@RequestParam(value = "id") int id) {
		return new ResponseEntity<>(productoService.eliminarProducto(id), HttpStatus.OK);
	}
	
}
