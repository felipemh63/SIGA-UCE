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
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "parroquia")
public class Parroquia implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue
    @NotNull
    @Column(name = "PARROQUIA_ID")
    private Integer parroquiaId;
    @Size(max = 45)
    @Column(name = "PARROQUIA")
    private String parroquia;
    @OneToMany(mappedBy = "parroquiaId" , fetch = FetchType.EAGER)
    @JsonIgnore
    private List<Direccion> direccionList;
    @JoinColumn(name = "CANTON_ID", referencedColumnName = "CANTON_ID")
    @ManyToOne(fetch = FetchType.EAGER)
    @JsonIgnore
    private Canton cantonId;
	public Integer getParroquiaId() {
		return parroquiaId;
	}
	public void setParroquiaId(Integer parroquiaId) {
		this.parroquiaId = parroquiaId;
	}
	public String getParroquia() {
		return parroquia;
	}
	public void setParroquia(String parroquia) {
		this.parroquia = parroquia;
	}
	public List<Direccion> getDireccionList() {
		return direccionList;
	}
	public void setDireccionList(List<Direccion> direccionList) {
		this.direccionList = direccionList;
	}
	public Canton getCantonId() {
		return cantonId;
	}
	public void setCantonId(Canton cantonId) {
		this.cantonId = cantonId;
	}
	public Parroquia(Integer parroquiaId, String parroquia, List<Direccion> direccionList, Canton cantonId) {
		super();
		this.parroquiaId = parroquiaId;
		this.parroquia = parroquia;
		this.direccionList = direccionList;
		this.cantonId = cantonId;
	}
	public Parroquia() {
		
	}

    
    
}
