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
@Table(name = "preguntas")
public class Preguntas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue
    @NotNull
    @Column(name = "PREGUNTAS_ID")
    private Integer preguntasId;
    @Size(max = 200)
    @Column(name = "PREGUNTAS")
    private String preguntas;
    @OneToMany(mappedBy = "preguntasId")
    private List<CheckList> checkListList;
    @JoinColumn(name = "SECCION_ID", referencedColumnName = "SECCION_ID")
    @ManyToOne
    private Seccion seccionId;
    @JoinColumn(name = "TIPO_AUDITORIA_ID", referencedColumnName = "TIPO_AUDITORIA_ID")
    @ManyToOne
    private TipoAuditoria tipoAuditoriaId;

    public Integer getPreguntasId() {
		return preguntasId;
	}

	public void setPreguntasId(Integer preguntasId) {
		this.preguntasId = preguntasId;
	}

	public String getPreguntas() {
		return preguntas;
	}

	public void setPreguntas(String preguntas) {
		this.preguntas = preguntas;
	}

	public List<CheckList> getCheckListList() {
		return checkListList;
	}

	public void setCheckListList(List<CheckList> checkListList) {
		this.checkListList = checkListList;
	}

	public Seccion getSeccionId() {
		return seccionId;
	}

	public void setSeccionId(Seccion seccionId) {
		this.seccionId = seccionId;
	}

	public TipoAuditoria getTipoAuditoriaId() {
		return tipoAuditoriaId;
	}

	public void setTipoAuditoriaId(TipoAuditoria tipoAuditoriaId) {
		this.tipoAuditoriaId = tipoAuditoriaId;
	}

	public Preguntas(Integer preguntasId, String preguntas, List<CheckList> checkListList, Seccion seccionId,
			TipoAuditoria tipoAuditoriaId) {
		super();
		this.preguntasId = preguntasId;
		this.preguntas = preguntas;
		this.checkListList = checkListList;
		this.seccionId = seccionId;
		this.tipoAuditoriaId = tipoAuditoriaId;
	}

	public Preguntas() {
    }

    
    
}
