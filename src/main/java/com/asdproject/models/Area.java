package com.asdproject.models;


import javax.persistence.*;


@Entity
@Table(name = "area")
public class Area {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique = true, nullable = false) 
	private Long id;
	
	@Column(unique = true, nullable = false) 
	private String nombre;
	
	@OneToOne(cascade= CascadeType.ALL)
	@JoinColumn(unique = true, name = "ciudad.id", nullable = false)
	private Ciudad ciudad;

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * @return the ciudad
	 */
	public Ciudad getCiudad() {
		return ciudad;
	}

	/**
	 * @param ciudad the ciudad to set
	 */
	public void setCiudad(Ciudad ciudad) {
		this.ciudad = ciudad;
	}
	
	
	
}
