package pe.com.oh.business.port;

import java.util.List;

import pe.com.oh.domain.Venta;

public interface IVentaService {

	public String registrarVenta(int idCliente, String detalleVenta);
	public List<Venta> obtenerVentasPorId(int id);
	public List<Venta> obtenerVentasPorFechas(String fechaInicio, String fechaFin);
	
}
