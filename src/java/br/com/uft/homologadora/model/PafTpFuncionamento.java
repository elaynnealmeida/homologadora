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
@Table(name = "paf_tp_funcionamento")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PafTpFuncionamento.findAll", query = "SELECT p FROM PafTpFuncionamento p")
    , @NamedQuery(name = "PafTpFuncionamento.findById", query = "SELECT p FROM PafTpFuncionamento p WHERE p.id = :id")})
public class PafTpFuncionamento implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @JoinColumn(name = "paf_id", referencedColumnName = "id")
    @ManyToOne
    private PafEcf pafId;
    @JoinColumn(name = "tp_funcionamento_id", referencedColumnName = "id")
    @ManyToOne
    private TipoFuncionamento tpFuncionamentoId;

    public PafTpFuncionamento() {
    }

    public PafTpFuncionamento(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public PafEcf getPafId() {
        return pafId;
    }

    public void setPafId(PafEcf pafId) {
        this.pafId = pafId;
    }

    public TipoFuncionamento getTpFuncionamentoId() {
        return tpFuncionamentoId;
    }

    public void setTpFuncionamentoId(TipoFuncionamento tpFuncionamentoId) {
        this.tpFuncionamentoId = tpFuncionamentoId;
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
        if (!(object instanceof PafTpFuncionamento)) {
            return false;
        }
        PafTpFuncionamento other = (PafTpFuncionamento) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.uft.homologadora.model.PafTpFuncionamento[ id=" + id + " ]";
    }
    
}
