package pe.com.oh.business.port;

import java.util.List;

import pe.com.oh.domain.Cliente;

public interface IClienteService {

	public List<Cliente> obtenerClientes();
	public String registrarCliente(String nombres, String apellidos, String dni, String telefono, String email);
	
}
