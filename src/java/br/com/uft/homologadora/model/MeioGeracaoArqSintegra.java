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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = "meio_geracao_arq_sintegra")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MeioGeracaoArqSintegra.findAll", query = "SELECT m FROM MeioGeracaoArqSintegra m")
    , @NamedQuery(name = "MeioGeracaoArqSintegra.findById", query = "SELECT m FROM MeioGeracaoArqSintegra m WHERE m.id = :id")
    , @NamedQuery(name = "MeioGeracaoArqSintegra.findByDescricao", query = "SELECT m FROM MeioGeracaoArqSintegra m WHERE m.descricao = :descricao")})
public class MeioGeracaoArqSintegra implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 2147483647)
    @Column(name = "descricao")
    private String descricao;
    @OneToMany(mappedBy = "meioGerarArqSintegraId")
    private List<PafMeioGerarArqSintegra> pafMeioGerarArqSintegraList;

    public MeioGeracaoArqSintegra() {
    }

    public MeioGeracaoArqSintegra(Integer id) {
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
    public List<PafMeioGerarArqSintegra> getPafMeioGerarArqSintegraList() {
        return pafMeioGerarArqSintegraList;
    }

    public void setPafMeioGerarArqSintegraList(List<PafMeioGerarArqSintegra> pafMeioGerarArqSintegraList) {
        this.pafMeioGerarArqSintegraList = pafMeioGerarArqSintegraList;
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
        if (!(object instanceof MeioGeracaoArqSintegra)) {
            return false;
        }
        MeioGeracaoArqSintegra other = (MeioGeracaoArqSintegra) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.uft.homologadora.model.MeioGeracaoArqSintegra[ id=" + id + " ]";
    }
    
}
