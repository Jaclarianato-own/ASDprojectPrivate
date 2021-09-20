package com.asdproject.models;

import javax.persistence.*;


@Entity
@Table(name = "persona")
public class Persona {
	
	@Id
	@Column(unique = true, nullable = false) 
	private String id_documento;
	
	@Column(nullable = false) 
	private String nombre;

	/**
	 * @return the id
	 */
	public String getId_documento() {
		return id_documento;
	}

	/**
	 * @param id the id to set
	 */
	public void setId_documento(String id) {
		this.id_documento = id;
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


}
