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

import pe.com.oh.business.port.IVentaService;

import pe.com.oh.domain.Venta;

@RestController
@RequestMapping (path="/venta")
@Api(tags = { "Venta" }, value = "/api", produces = "application/json")
public class VentaController {
	
	@Autowired
	private IVentaService ventaService;

	@GetMapping(path="/registrar")
	@ApiOperation(value = "Agregar venta")
	public ResponseEntity<String> agregarVenta(
			@RequestParam(value = "idCliente") int idCliente,
			@RequestParam(value = "detalleVenta") String detalleVenta
			) {
			
		return new ResponseEntity<>(ventaService.registrarVenta(idCliente, detalleVenta), HttpStatus.OK);
	}
	
	@GetMapping(path="/obtener-id")
	@ApiOperation(value = "Obtener ventas por ID")
	public ResponseEntity<List<Venta>> obtenerVentasPorId(@RequestParam(value = "id") int id) {
		return new ResponseEntity<>(ventaService.obtenerVentasPorId(id), HttpStatus.OK);
	}
	
	@GetMapping(path="/obtener-fechas")
	@ApiOperation(value = "Obtener ventas por fecha")
	public ResponseEntity<List<Venta>> obtenerVentasPorFechas(
			@RequestParam(value = "fechaInicio") String fechaInicio,
			@RequestParam(value = "fechaFin") String fechaFin) {
		return new ResponseEntity<>(ventaService.obtenerVentasPorFechas(fechaInicio, fechaFin), HttpStatus.OK);
	}
	
}
