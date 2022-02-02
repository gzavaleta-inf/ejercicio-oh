package pe.com.oh.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import pe.com.oh.domain.DetalleVenta;

@Repository
public interface IPersistenceDetalleVenta extends CrudRepository<DetalleVenta, Integer>{

}
