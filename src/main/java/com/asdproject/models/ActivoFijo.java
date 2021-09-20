package com.asdproject.models;


import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name = "activoFijo")
public class ActivoFijo {
	
	@Id
	@Column(unique = true, nullable = false)
	private String serial;//El tipo de datos será string teniendo en cuenta que un serial podría ser alfanumérico.
	
	@Column(nullable = false)
	private Long numeroInterno;
	
	@Column(nullable = false)
	private String tipo;
	
	@Column(nullable = false)
	private String descripcion;
	
	@Column(nullable = false)
	private float peso;
	
	@Column(nullable = false)
	private float alto;
	
	@Column(nullable = false)
	private float ancho;
	
	@Column(nullable = false)
	private float largo;
	
	@Column(nullable = false)
	private float valorCompra;
	
	@Column(nullable = false)
	private Date fechaCompra;
	
	@Column(nullable = true)
	private Date fechaBaja;
	
	@OneToOne()
	@JoinColumn(name = "estadoActivoFijo.id", nullable = false)
	private EstadoActivoFijo estadoActual;
	
	@OneToOne()
	@JoinColumn(name = "persona.id_documento", nullable = true)
	private Persona persona;
	
	@OneToOne()
	@JoinColumn(name = "area.id", nullable = true)
	private Area area;
	
	@Column(nullable = false)
	private String color;
	
	

	/**
	 * @return the tipo
	 */
	public String getTipo() {
		return tipo;
	}

	/**
	 * @param tipo the tipo to set
	 */
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	/**
	 * @return the descripcion
	 */
	public String getDescripcion() {
		return descripcion;
	}

	/**
	 * @param descripcion the descripcion to set
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	/**
	 * @return the serial
	 */
	public String getSerial() {
		return serial;
	}

	/**
	 * @param serial the serial to set
	 */
	public void setSerial(String serial) {
		this.serial = serial;
	}

	/**
	 * @return the numeroInterno
	 */
	public Long getNumeroInterno() {
		return numeroInterno;
	}

	/**
	 * @param numeroInterno the numeroInterno to set
	 */
	public void setNumeroInterno(Long numeroInterno) {
		this.numeroInterno = numeroInterno;
	}

	/**
	 * @return the peso
	 */
	public float getPeso() {
		return peso;
	}

	/**
	 * @param peso the peso to set
	 */
	public void setPeso(float peso) {
		this.peso = peso;
	}

	/**
	 * @return the alto
	 */
	public float getAlto() {
		return alto;
	}

	/**
	 * @param alto the alto to set
	 */
	public void setAlto(float alto) {
		this.alto = alto;
	}

	/**
	 * @return the ancho
	 */
	public float getAncho() {
		return ancho;
	}

	/**
	 * @param ancho the ancho to set
	 */
	public void setAncho(float ancho) {
		this.ancho = ancho;
	}

	/**
	 * @return the largo
	 */
	public float getLargo() {
		return largo;
	}

	/**
	 * @param largo the largo to set
	 */
	public void setLargo(float largo) {
		this.largo = largo;
	}

	/**
	 * @return the valorCompra
	 */
	public float getValorCompra() {
		return valorCompra;
	}

	/**
	 * @param valorCompra the valorCompra to set
	 */
	public void setValorCompra(float valorCompra) {
		this.valorCompra = valorCompra;
	}

	/**
	 * @return the fechaCompra
	 */
	public Date getFechaCompra() {
		return fechaCompra;
	}

	/**
	 * @param fechaCompra the fechaCompra to set
	 */
	public void setFechaCompra(Date fechaCompra) {
		this.fechaCompra = fechaCompra;
	}

	/**
	 * @return the fechaBaja
	 */
	public Date getFechaBaja() {
		return fechaBaja;
	}

	/**
	 * @param fechaBaja the fechaBaja to set
	 */
	public void setFechaBaja(Date fechaBaja) {
		this.fechaBaja = fechaBaja;
	}

	/**
	 * @return the estadoActual
	 */
	public EstadoActivoFijo getEstadoActual() {
		return estadoActual;
	}

	/**
	 * @param estadoActual the estadoActual to set
	 */
	public void setEstadoActual(EstadoActivoFijo estadoActual) {
		this.estadoActual = estadoActual;
	}

	/**
	 * @return the color
	 */
	public String getColor() {
		return color;
	}

	/**
	 * @param color the color to set
	 */
	public void setColor(String color) {
		this.color = color;
	}

	/**
	 * @return the persona
	 */
	public Persona getPersona() {
		return persona;
	}

	/**
	 * @param persona the persona to set
	 */
	public void setPersona(Persona persona) {
		this.persona = persona;
	}

	/**
	 * @return the area
	 */
	public Area getArea() {
		return area;
	}

	/**
	 * @param area the area to set
	 */
	public void setArea(Area area) {
		this.area = area;
	}
	
	
}
