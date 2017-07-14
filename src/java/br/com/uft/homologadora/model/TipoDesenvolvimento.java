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
@Table(name = "tipo_desenvolvimento")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoDesenvolvimento.findAll", query = "SELECT t FROM TipoDesenvolvimento t")
    , @NamedQuery(name = "TipoDesenvolvimento.findById", query = "SELECT t FROM TipoDesenvolvimento t WHERE t.id = :id")
    , @NamedQuery(name = "TipoDesenvolvimento.findByDescricao", query = "SELECT t FROM TipoDesenvolvimento t WHERE t.descricao = :descricao")})
public class TipoDesenvolvimento implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 2147483647)
    @Column(name = "descricao")
    private String descricao;
    //@OneToMany(mappedBy = "tpDesenvolvimentoId")
    @ManyToMany(cascade=CascadeType.REMOVE)
    @JoinTable(name="paf_tipo_desenvolvimento", 
               joinColumns=  @JoinColumn( name = "tp_desenvolvimento_id" ), 
               inverseJoinColumns= @JoinColumn(name = "paf_ecf_id") )
    private List<PafTipoDesenvolvimento> pafTipoDesenvolvimentoList;

    public TipoDesenvolvimento() {
    }

    public TipoDesenvolvimento(Integer id) {
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
    public List<PafTipoDesenvolvimento> getPafTipoDesenvolvimentoList() {
        return pafTipoDesenvolvimentoList;
    }

    public void setPafTipoDesenvolvimentoList(List<PafTipoDesenvolvimento> pafTipoDesenvolvimentoList) {
        this.pafTipoDesenvolvimentoList = pafTipoDesenvolvimentoList;
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
        if (!(object instanceof TipoDesenvolvimento)) {
            return false;
        }
        TipoDesenvolvimento other = (TipoDesenvolvimento) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.uft.homologadora.model.TipoDesenvolvimento[ id=" + id + " ]";
    }
    
}
