package pe.com.oh.business.usecase;

import java.util.List;
import java.lang.reflect.Type;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import pe.com.oh.business.port.IVentaService;
import pe.com.oh.controller.util.Utils;
import pe.com.oh.domain.DetalleVenta;
import pe.com.oh.domain.Venta;
import pe.com.oh.repository.IPersistenceDetalleVenta;
import pe.com.oh.repository.IPersistenceVenta;

@Service
public class VentaServiceImpl implements IVentaService {
	
	@Autowired
	private IPersistenceVenta persistenceVenta;
	
	@Autowired
	private IPersistenceDetalleVenta persistenceDetalleVenta;

	@Override
	public String registrarVenta(int idCliente, String detalleVenta) {
		
		var venta = new Venta();
		
		try {
			ZonedDateTime dateTime = ZonedDateTime.now();
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
			
			venta = persistenceVenta.save(
					Venta.builder()
					.idCliente(idCliente)
					.fecha(dateTime.format(formatter))
					.build());
			
			Type listType = new TypeToken<ArrayList<DetalleVenta>>(){}.getType();
			List<DetalleVenta> listaDetalleVenta = new Gson().fromJson(detalleVenta, listType);
			
			listaDetalleVenta.stream().forEach(item -> {
				var datalle = new DetalleVenta();
				
				datalle = persistenceDetalleVenta.save(
						DetalleVenta.builder()
						.idVenta(item.getIdVenta())
						.idProducto(item.getIdProducto())
						.cantidad(item.getCantidad())
						.build()
						);
			});			
		}
		catch (Exception ex){
			return Utils.MENSAJE_ERROR + ex.getMessage();
		}
		
		return Utils.MENSAJE_CREATE + new Gson().toJson(venta);
		
	}
	
	@Override
	public List<Venta> obtenerVentasPorId(int id) {
		
		List<Venta> listaVentas = new ArrayList<>();
		
		try {
			listaVentas = (List<Venta>) persistenceVenta.findById(id).orElseThrow();
		}
		catch (Exception ex){
			Utils.generateException(
					Utils.MENSAJE_ERROR + ex.getMessage(), 
					null);		
		}
		
		return listaVentas;
	}
	
	@Override
	public List<Venta> obtenerVentasPorFechas(String fechaInicio, String fechaFin) {
		
		List<Venta> listaVentas = new ArrayList<>();
		
		try {
			listaVentas = (List<Venta>) persistenceVenta.findAll();
		}
		catch (Exception ex){
			Utils.generateException(
					Utils.MENSAJE_ERROR + ex.getMessage(), 
					null);		
		}
		
		return listaVentas;
	}

}
