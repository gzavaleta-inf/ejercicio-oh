package pe.com.oh.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import pe.com.oh.domain.Cliente;

@Repository
public interface IPersistenceCliente extends CrudRepository<Cliente, Integer>{

}
