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
@Table(name = "tipo_funcionamento")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoFuncionamento.findAll", query = "SELECT t FROM TipoFuncionamento t")
    , @NamedQuery(name = "TipoFuncionamento.findById", query = "SELECT t FROM TipoFuncionamento t WHERE t.id = :id")
    , @NamedQuery(name = "TipoFuncionamento.findByDescricao", query = "SELECT t FROM TipoFuncionamento t WHERE t.descricao = :descricao")})
public class TipoFuncionamento implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 2147483647)
    @Column(name = "descricao")
    private String descricao;
    //@OneToMany(mappedBy = "tpFuncionamentoId")
    @ManyToMany(cascade=CascadeType.REMOVE)
    @JoinTable(name="paf_tp_funcionamento", 
               joinColumns=  @JoinColumn( name = "tp_funcionamento_id" ), 
               inverseJoinColumns= @JoinColumn(name = "paf_id")) 
    private List<PafTpFuncionamento> pafTpFuncionamentoList;

    public TipoFuncionamento() {
    }

    public TipoFuncionamento(Integer id) {
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
    public List<PafTpFuncionamento> getPafTpFuncionamentoList() {
        return pafTpFuncionamentoList;
    }

    public void setPafTpFuncionamentoList(List<PafTpFuncionamento> pafTpFuncionamentoList) {
        this.pafTpFuncionamentoList = pafTpFuncionamentoList;
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
        if (!(object instanceof TipoFuncionamento)) {
            return false;
        }
        TipoFuncionamento other = (TipoFuncionamento) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.uft.homologadora.model.TipoFuncionamento[ id=" + id + " ]";
    }
    
}
