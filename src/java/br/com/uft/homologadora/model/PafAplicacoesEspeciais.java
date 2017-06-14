/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.uft.homologadora.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author UFT
 */
@Entity
@Table(name = "paf_aplicacoes_especiais")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PafAplicacoesEspeciais.findAll", query = "SELECT p FROM PafAplicacoesEspeciais p")
    , @NamedQuery(name = "PafAplicacoesEspeciais.findById", query = "SELECT p FROM PafAplicacoesEspeciais p WHERE p.id = :id")})
public class PafAplicacoesEspeciais implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @JoinColumn(name = "aplicacoes_especiais_id", referencedColumnName = "id")
    @ManyToOne
    private AplicacoesEspeciais aplicacoesEspeciaisId;
    @JoinColumn(name = "paf_id", referencedColumnName = "id")
    @ManyToOne
    private PafEcf pafId;

    public PafAplicacoesEspeciais() {
    }

    public PafAplicacoesEspeciais(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public AplicacoesEspeciais getAplicacoesEspeciaisId() {
        return aplicacoesEspeciaisId;
    }

    public void setAplicacoesEspeciaisId(AplicacoesEspeciais aplicacoesEspeciaisId) {
        this.aplicacoesEspeciaisId = aplicacoesEspeciaisId;
    }

    public PafEcf getPafId() {
        return pafId;
    }

    public void setPafId(PafEcf pafId) {
        this.pafId = pafId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PafAplicacoesEspeciais)) {
            return false;
        }
        PafAplicacoesEspeciais other = (PafAplicacoesEspeciais) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.uft.homologadora.model.PafAplicacoesEspeciais[ id=" + id + " ]";
    }
    
}
