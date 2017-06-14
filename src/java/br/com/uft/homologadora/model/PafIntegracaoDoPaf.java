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
@Table(name = "paf_integracao_do_paf")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PafIntegracaoDoPaf.findAll", query = "SELECT p FROM PafIntegracaoDoPaf p")
    , @NamedQuery(name = "PafIntegracaoDoPaf.findById", query = "SELECT p FROM PafIntegracaoDoPaf p WHERE p.id = :id")})
public class PafIntegracaoDoPaf implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @JoinColumn(name = "integracao_paf_id", referencedColumnName = "id")
    @ManyToOne
    private IntegracaoPaf integracaoPafId;
    @JoinColumn(name = "paf_id", referencedColumnName = "id")
    @ManyToOne
    private PafEcf pafId;

    public PafIntegracaoDoPaf() {
    }

    public PafIntegracaoDoPaf(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public IntegracaoPaf getIntegracaoPafId() {
        return integracaoPafId;
    }

    public void setIntegracaoPafId(IntegracaoPaf integracaoPafId) {
        this.integracaoPafId = integracaoPafId;
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
        if (!(object instanceof PafIntegracaoDoPaf)) {
            return false;
        }
        PafIntegracaoDoPaf other = (PafIntegracaoDoPaf) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.uft.homologadora.model.PafIntegracaoDoPaf[ id=" + id + " ]";
    }
    
}
