package ec.com.siga.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "pais")
public class Pais implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@NotNull
	@Column(name = "PAIS_ID")
	private Integer paisId;
	@Size(max = 45)
	@Column(name = "PAIS")
	private String pais;
	@OneToMany(mappedBy = "paisId", fetch = FetchType.EAGER)
	@JsonIgnore
	private List<ProvinciaEstado> provinciaEstadoList;

	public Integer getPaisId() {
		return paisId;
	}

	public void setPaisId(Integer paisId) {
		this.paisId = paisId;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public List<ProvinciaEstado> getProvinciaEstadoList() {
		return provinciaEstadoList;
	}

	public void setProvinciaEstadoList(List<ProvinciaEstado> provinciaEstadoList) {
		this.provinciaEstadoList = provinciaEstadoList;
	}

	public Pais(Integer paisId, String pais, List<ProvinciaEstado> provinciaEstadoList) {
		super();
		this.paisId = paisId;
		this.pais = pais;
		this.provinciaEstadoList = provinciaEstadoList;
	}

	public Pais() {
	}

	@Override
	public String toString() {
		return "Pais [paisId=" + paisId + ", pais=" + pais + ", provinciaEstadoList=" + provinciaEstadoList + "]";
	}
	

}
