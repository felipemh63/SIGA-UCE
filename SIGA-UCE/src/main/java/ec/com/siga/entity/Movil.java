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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Stalin
 */
@Entity
@Table(name = "movil")
public class Movil implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue
    @NotNull
    @Column(name = "MOVIL_ID")
    private Integer movilId;
    @Size(max = 25)
    @Column(name = "TOKEN_UNIQUE")
    private String tokenUnique;
    @JoinColumn(name = "USER_ID", referencedColumnName = "USER_ID")
    @ManyToOne
    private User userId;
    @JoinColumn(name = "AUDITOR_ID", referencedColumnName = "AUDITOR_ID")
    @ManyToOne
    private Auditor auditorId;

    public Integer getMovilId() {
		return movilId;
	}

	public void setMovilId(Integer movilId) {
		this.movilId = movilId;
	}

	public String getTokenUnique() {
		return tokenUnique;
	}

	public void setTokenUnique(String tokenUnique) {
		this.tokenUnique = tokenUnique;
	}

	public User getUserId() {
		return userId;
	}

	public void setUserId(User userId) {
		this.userId = userId;
	}

	public Auditor getAuditorId() {
		return auditorId;
	}

	public void setAuditorId(Auditor auditorId) {
		this.auditorId = auditorId;
	}

	public Movil(Integer movilId, String tokenUnique, User userId, Auditor auditorId) {
		super();
		this.movilId = movilId;
		this.tokenUnique = tokenUnique;
		this.userId = userId;
		this.auditorId = auditorId;
	}

	public Movil() {
    }

    
    
}
