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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Stalin
 */
@Entity
@Table(name = "canton")
public class Canton implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	@NotNull
	@Column(name = "CANTON_ID")
	private Integer cantonId;
	@Size(max = 35)
	@Column(name = "CANTON")
	private String canton;
	@OneToMany(mappedBy = "cantonId")
	private List<Parroquia> parroquiaList;
	@JoinColumn(name = "PROVINCIA_ID", referencedColumnName = "PROVINCIA_ID")
	@ManyToOne
	private ProvinciaEstado provinciaId;

	public Integer getCantonId() {
		return cantonId;
	}

	public void setCantonId(Integer cantonId) {
		this.cantonId = cantonId;
	}

	public String getCanton() {
		return canton;
	}

	public void setCanton(String canton) {
		this.canton = canton;
	}

	public List<Parroquia> getParroquiaList() {
		return parroquiaList;
	}

	public void setParroquiaList(List<Parroquia> parroquiaList) {
		this.parroquiaList = parroquiaList;
	}

	public ProvinciaEstado getProvinciaId() {
		return provinciaId;
	}

	public void setProvinciaId(ProvinciaEstado provinciaId) {
		this.provinciaId = provinciaId;
	}

	public Canton(Integer cantonId, String canton, List<Parroquia> parroquiaList, ProvinciaEstado provinciaId) {
		super();
		this.cantonId = cantonId;
		this.canton = canton;
		this.parroquiaList = parroquiaList;
		this.provinciaId = provinciaId;
	}

	public Canton() {

	}

}
