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
@Table(name = "paf_tratamento_interrupcao_decf")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PafTratamentoInterrupcaoDecf.findAll", query = "SELECT p FROM PafTratamentoInterrupcaoDecf p")
    , @NamedQuery(name = "PafTratamentoInterrupcaoDecf.findById", query = "SELECT p FROM PafTratamentoInterrupcaoDecf p WHERE p.id = :id")})
public class PafTratamentoInterrupcaoDecf implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @JoinColumn(name = "paf_id", referencedColumnName = "id")
    @ManyToOne
    private PafEcf pafId;
    @JoinColumn(name = "tratamento_interrupcao_id", referencedColumnName = "id")
    @ManyToOne
    private TratamentoInterrupcaoCupomFiscal tratamentoInterrupcaoId;

    public PafTratamentoInterrupcaoDecf() {
    }

    public PafTratamentoInterrupcaoDecf(Integer id) {
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

    public TratamentoInterrupcaoCupomFiscal getTratamentoInterrupcaoId() {
        return tratamentoInterrupcaoId;
    }

    public void setTratamentoInterrupcaoId(TratamentoInterrupcaoCupomFiscal tratamentoInterrupcaoId) {
        this.tratamentoInterrupcaoId = tratamentoInterrupcaoId;
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
        if (!(object instanceof PafTratamentoInterrupcaoDecf)) {
            return false;
        }
        PafTratamentoInterrupcaoDecf other = (PafTratamentoInterrupcaoDecf) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.uft.homologadora.model.PafTratamentoInterrupcaoDecf[ id=" + id + " ]";
    }
    
}
