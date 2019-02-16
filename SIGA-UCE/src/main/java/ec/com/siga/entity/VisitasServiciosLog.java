/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.com.siga.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Stalin
 */
@Entity
@Table(name = "visitas_servicios_log")
public class VisitasServiciosLog implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue
    @NotNull
    @Column(name = "VISITAS_SERVICIOS_LOG_ID")
    private Integer visitasServiciosLogId;
    @Size(max = 100)
    @Column(name = "DETALLE")
    private String detalle;

    public Integer getVisitasServiciosLogId() {
		return visitasServiciosLogId;
	}

	public void setVisitasServiciosLogId(Integer visitasServiciosLogId) {
		this.visitasServiciosLogId = visitasServiciosLogId;
	}

	public String getDetalle() {
		return detalle;
	}

	public void setDetalle(String detalle) {
		this.detalle = detalle;
	}

	public VisitasServiciosLog(Integer visitasServiciosLogId, String detalle) {
		super();
		this.visitasServiciosLogId = visitasServiciosLogId;
		this.detalle = detalle;
	}

	public VisitasServiciosLog() {
    }

    
}
