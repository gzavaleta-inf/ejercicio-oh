package pe.com.oh.business.usecase;

import java.util.List;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;

import pe.com.oh.business.port.IClienteService;
import pe.com.oh.controller.util.Utils;
import pe.com.oh.domain.Cliente;
import pe.com.oh.repository.IPersistenceCliente;

@Service
public class ClienteServiceImpl implements IClienteService {
	
	@Autowired
	private IPersistenceCliente persistence;

	@Override
	public List<Cliente> obtenerClientes() {
		
		List<Cliente> listaClientes = new ArrayList<>();
		
		try {
			listaClientes = (List<Cliente>) persistence.findAll();
		}
		catch (Exception ex){
			Utils.generateException(
					Utils.MENSAJE_ERROR + ex.getMessage(), 
					null);		
		}
		
		return listaClientes;
	}

	@Override
	public String registrarCliente(String nombres, String apellidos, String dni, String telefono, String email) {
		
		var cliente = new Cliente();
		
		try {
			cliente = persistence.save(
					Cliente.builder()
					.nombres(nombres)
					.apellidos(apellidos)
					.dni(dni)
					.telefono(telefono)
					.email(email)
					.build());
		}
		catch (Exception ex){
			return Utils.MENSAJE_ERROR + ex.getMessage();
		}
		
		return Utils.MENSAJE_CREATE + new Gson().toJson(cliente);
		
	}
}
