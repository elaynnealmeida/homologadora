/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.uft.homologadora.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author UFT
 */
@Entity
@Table(name = "estado")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Estado.findAll", query = "SELECT e FROM Estado e")
    , @NamedQuery(name = "Estado.findByEstadoId", query = "SELECT e FROM Estado e WHERE e.estadoId = :estadoId")
    , @NamedQuery(name = "Estado.findBySigla", query = "SELECT e FROM Estado e WHERE e.sigla = :sigla")})
public class Estado implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "estado_id")
    private Integer estadoId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "sigla")
    private String sigla;
    @OneToMany(mappedBy = "unidadeFederacao")
    private List<PerfilRequisitoPafEcf> perfilRequisitoPafEcfList;

    public Estado() {
    }

    public Estado(Integer estadoId) {
        this.estadoId = estadoId;
    }

    public Estado(Integer estadoId, String sigla) {
        this.estadoId = estadoId;
        this.sigla = sigla;
    }

    public Integer getEstadoId() {
        return estadoId;
    }

    public void setEstadoId(Integer estadoId) {
        this.estadoId = estadoId;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    @XmlTransient
    public List<PerfilRequisitoPafEcf> getPerfilRequisitoPafEcfList() {
        return perfilRequisitoPafEcfList;
    }

    public void setPerfilRequisitoPafEcfList(List<PerfilRequisitoPafEcf> perfilRequisitoPafEcfList) {
        this.perfilRequisitoPafEcfList = perfilRequisitoPafEcfList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (estadoId != null ? estadoId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Estado)) {
            return false;
        }
        Estado other = (Estado) object;
        if ((this.estadoId == null && other.estadoId != null) || (this.estadoId != null && !this.estadoId.equals(other.estadoId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.uft.homologadora.model.Estado[ estadoId=" + estadoId + " ]";
    }
    
}
