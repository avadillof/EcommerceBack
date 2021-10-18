package com.freelandsite.back.model.jpa;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="cyca_productosfabricacion")
public class Cyca_ProductosFabricacion {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String codigo;
	private String descripcion;	
	private int material;
	
	
	@Column(name="`Precio Coste Material`")
	private double preciocostemateria;
	
	@Column(name="`Precio Coste Mecanizado`")
	private double preciocostemecanizado;
	
	public double getPreciocostemecanizado() {
		return preciocostemecanizado;
	}
	public void setPreciocostemecanizado(double preciocostemecanizado) {
		this.preciocostemecanizado = preciocostemecanizado;
	}
	public double getPreciocostemateria() {
		return preciocostemateria;
	}
	public void setPreciocostemateria(double preciocostemateria) {
		this.preciocostemateria = preciocostemateria;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public int getMaterial() {
		return material;
	}
	public void setMaterial(int material) {
		this.material = material;
	}
	
	
}
