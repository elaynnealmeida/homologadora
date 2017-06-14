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
@Table(name = "integracao_paf")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "IntegracaoPaf.findAll", query = "SELECT i FROM IntegracaoPaf i")
    , @NamedQuery(name = "IntegracaoPaf.findById", query = "SELECT i FROM IntegracaoPaf i WHERE i.id = :id")
    , @NamedQuery(name = "IntegracaoPaf.findByDescricao", query = "SELECT i FROM IntegracaoPaf i WHERE i.descricao = :descricao")})
public class IntegracaoPaf implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 2147483647)
    @Column(name = "descricao")
    private String descricao;
    @OneToMany(mappedBy = "integracaoPafId")
    private List<PafIntegracaoDoPaf> pafIntegracaoDoPafList;

    public IntegracaoPaf() {
    }

    public IntegracaoPaf(Integer id) {
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
    public List<PafIntegracaoDoPaf> getPafIntegracaoDoPafList() {
        return pafIntegracaoDoPafList;
    }

    public void setPafIntegracaoDoPafList(List<PafIntegracaoDoPaf> pafIntegracaoDoPafList) {
        this.pafIntegracaoDoPafList = pafIntegracaoDoPafList;
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
        if (!(object instanceof IntegracaoPaf)) {
            return false;
        }
        IntegracaoPaf other = (IntegracaoPaf) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.uft.homologadora.model.IntegracaoPaf[ id=" + id + " ]";
    }
    
}
