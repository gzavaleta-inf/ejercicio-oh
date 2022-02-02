package pe.com.oh.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import pe.com.oh.domain.Venta;

@Repository
public interface IPersistenceVenta extends CrudRepository<Venta, Integer>{

}
