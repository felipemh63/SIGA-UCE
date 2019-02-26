/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.com.siga.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 *
 * @author Stalin
 */
@Entity
@Table(name = "direccion_tipo")
public class DireccionTipo implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	@NotNull
	@Column(name = "DIRECCION_TIPO_ID")
	private Integer direccionTipoId;
	@Size(max = 15)
	@Column(name = "DESCRIPCION_DIRECCION_TIPO")
	private String descripcionDireccionTipo;
	@OneToMany(mappedBy = "direccionTipoId")
	@JsonIgnore
	private List<Direccion> direccionList;

	public Integer getDireccionTipoId() {
		return direccionTipoId;
	}

	public void setDireccionTipoId(Integer direccionTipoId) {
		this.direccionTipoId = direccionTipoId;
	}

	public String getDescripcionDireccionTipo() {
		return descripcionDireccionTipo;
	}

	public void setDescripcionDireccionTipo(String descripcionDireccionTipo) {
		this.descripcionDireccionTipo = descripcionDireccionTipo;
	}

	public List<Direccion> getDireccionList() {
		return direccionList;
	}

	public void setDireccionList(List<Direccion> direccionList) {
		this.direccionList = direccionList;
	}

	public DireccionTipo(Integer direccionTipoId, String descripcionDireccionTipo, List<Direccion> direccionList) {
		super();
		this.direccionTipoId = direccionTipoId;
		this.descripcionDireccionTipo = descripcionDireccionTipo;
		this.direccionList = direccionList;
	}

	public DireccionTipo() {

	}

}
