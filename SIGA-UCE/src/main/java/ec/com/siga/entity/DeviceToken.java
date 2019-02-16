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
@Table(name = "device_token")
public class DeviceToken implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue
    @NotNull
    @Column(name = "TOKEN_ID")
    private Integer tokenId;
    @Size(max = 25)
    @Column(name = "TOKEN")
    private String token;
    @JoinColumn(name = "AUDITOR_ID", referencedColumnName = "AUDITOR_ID")
    @ManyToOne
    private Auditor auditorId;

    public Integer getTokenId() {
		return tokenId;
	}

	public void setTokenId(Integer tokenId) {
		this.tokenId = tokenId;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public Auditor getAuditorId() {
		return auditorId;
	}

	public void setAuditorId(Auditor auditorId) {
		this.auditorId = auditorId;
	}

	public DeviceToken(Integer tokenId, String token, Auditor auditorId) {
		super();
		this.tokenId = tokenId;
		this.token = token;
		this.auditorId = auditorId;
	}

	public DeviceToken() {
    }

    
    
}
