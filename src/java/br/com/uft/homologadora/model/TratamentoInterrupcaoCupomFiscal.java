/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.uft.homologadora.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author UFT
 */
@Entity
@Table(name = "tratamento_interrupcao_cupom_fiscal")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TratamentoInterrupcaoCupomFiscal.findAll", query = "SELECT t FROM TratamentoInterrupcaoCupomFiscal t")
    , @NamedQuery(name = "TratamentoInterrupcaoCupomFiscal.findById", query = "SELECT t FROM TratamentoInterrupcaoCupomFiscal t WHERE t.id = :id")
    , @NamedQuery(name = "TratamentoInterrupcaoCupomFiscal.findByDescricao", query = "SELECT t FROM TratamentoInterrupcaoCupomFiscal t WHERE t.descricao = :descricao")})
public class TratamentoInterrupcaoCupomFiscal implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 2147483647)
    @Column(name = "descricao")
    private String descricao;
   // @OneToMany(mappedBy = "tratamentoInterrupcaoId")
    @ManyToMany(cascade=CascadeType.REMOVE)
    @JoinTable(name = "paf_tratamento_interrupcao_decf",
            joinColumns = @JoinColumn(name = "tratamento_interrupcao_id"),
            inverseJoinColumns = @JoinColumn(name = "paf_id"))
    private List<PafTratamentoInterrupcaoDecf> pafTratamentoInterrupcaoDecfList;

    public TratamentoInterrupcaoCupomFiscal() {
    }

    public TratamentoInterrupcaoCupomFiscal(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @XmlTransient
    public List<PafTratamentoInterrupcaoDecf> getPafTratamentoInterrupcaoDecfList() {
        return pafTratamentoInterrupcaoDecfList;
    }

    public void setPafTratamentoInterrupcaoDecfList(List<PafTratamentoInterrupcaoDecf> pafTratamentoInterrupcaoDecfList) {
        this.pafTratamentoInterrupcaoDecfList = pafTratamentoInterrupcaoDecfList;
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
        if (!(object instanceof TratamentoInterrupcaoCupomFiscal)) {
            return false;
        }
        TratamentoInterrupcaoCupomFiscal other = (TratamentoInterrupcaoCupomFiscal) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.uft.homologadora.model.TratamentoInterrupcaoCupomFiscal[ id=" + id + " ]";
    }
    
}
