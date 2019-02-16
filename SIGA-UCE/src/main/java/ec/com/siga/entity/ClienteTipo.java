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

/**
 *
 * @author Stalin
 */
@Entity
@Table(name = "cliente_tipo")
public class ClienteTipo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue
    @NotNull
    @Column(name = "CLIENTE_TIPO_ID")
    private Integer clienteTipoId;
    @Size(max = 50)
    @Column(name = "CLIENTE_TIPO_DESCRIPCION")
    private String clienteTipoDescripcion;
    @OneToMany(mappedBy = "clienteTipoId")
    private List<Cliente> clienteList;

    public Integer getClienteTipoId() {
		return clienteTipoId;
	}

	public void setClienteTipoId(Integer clienteTipoId) {
		this.clienteTipoId = clienteTipoId;
	}

	public String getClienteTipoDescripcion() {
		return clienteTipoDescripcion;
	}

	public void setClienteTipoDescripcion(String clienteTipoDescripcion) {
		this.clienteTipoDescripcion = clienteTipoDescripcion;
	}

	public List<Cliente> getClienteList() {
		return clienteList;
	}

	public void setClienteList(List<Cliente> clienteList) {
		this.clienteList = clienteList;
	}

	public ClienteTipo(Integer clienteTipoId, String clienteTipoDescripcion, List<Cliente> clienteList) {
		super();
		this.clienteTipoId = clienteTipoId;
		this.clienteTipoDescripcion = clienteTipoDescripcion;
		this.clienteList = clienteList;
	}

	public ClienteTipo() {
    }

    
    
}
