package pe.com.oh.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import pe.com.oh.domain.Producto;

@Repository
public interface IPersistenceProducto extends CrudRepository<Producto, Integer>{

}
