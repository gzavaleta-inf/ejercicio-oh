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
import pe.com.oh.business.port.IClienteService;

import pe.com.oh.domain.Cliente;

@RestController
@RequestMapping (path="/cliente")
@Api(tags = { "Cliente" }, value = "/api", produces = "application/json")
public class ClienteController {
	
	@Autowired
	private IClienteService clienteService;

	@GetMapping(path="/obtener")
	@ApiOperation(value = "Obtener clientes")
	public ResponseEntity<List<Cliente>> obtenerClientes() {
		return new ResponseEntity<>(clienteService.obtenerClientes(), HttpStatus.OK);
	}
	
	@GetMapping(path="/registrar")
	@ApiOperation(value = "Agregar cliente")
	public ResponseEntity<String> agregarCliente(
			@RequestParam(value = "nombres") String nombres,
			@RequestParam(value = "apellidos") String apellidos,
			@RequestParam(value = "dni") String dni,
			@RequestParam(value = "telefono") String telefono,
			@RequestParam(value = "email") String email
			) {
			
		return new ResponseEntity<>(clienteService.registrarCliente(nombres, apellidos, dni, telefono, email), HttpStatus.OK);
	}

}
