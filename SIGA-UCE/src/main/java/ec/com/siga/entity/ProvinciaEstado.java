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
@Table(name = "provincia_estado")
public class ProvinciaEstado implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	@NotNull
	@Column(name = "PROVINCIA_ID")
	private Integer provinciaId;
	@Size(max = 35)
	@Column(name = "PROVINCIA")
	private String provincia;
	@JoinColumn(name = "PAIS_ID", referencedColumnName = "PAIS_ID")
	@ManyToOne(fetch = FetchType.EAGER)
	@JsonIgnore
	private Pais paisId;
	@OneToMany(mappedBy = "provinciaId", fetch = FetchType.EAGER)
	@JsonIgnore
	private List<Canton> cantonList;
	public Integer getProvinciaId() {
		return provinciaId;
	}
	public void setProvinciaId(Integer provinciaId) {
		this.provinciaId = provinciaId;
	}
	public String getProvincia() {
		return provincia;
	}
	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}
	public Pais getPaisId() {
		return paisId;
	}
	public void setPaisId(Pais paisId) {
		this.paisId = paisId;
	}
	public List<Canton> getCantonList() {
		return cantonList;
	}
	public void setCantonList(List<Canton> cantonList) {
		this.cantonList = cantonList;
	}
	public ProvinciaEstado(Integer provinciaId, String provincia, Pais paisId, List<Canton> cantonList) {
		super();
		this.provinciaId = provinciaId;
		this.provincia = provincia;
		this.paisId = paisId;
		this.cantonList = cantonList;
	}
	public ProvinciaEstado() {
	}


}