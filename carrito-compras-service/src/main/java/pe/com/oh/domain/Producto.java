package pe.com.oh.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="producto")
public class Producto {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id")
    private int id;
	
	@Column(name="nombre")
	private String nombre;
	
	@Column(name="precio")
	private String precio;
}
