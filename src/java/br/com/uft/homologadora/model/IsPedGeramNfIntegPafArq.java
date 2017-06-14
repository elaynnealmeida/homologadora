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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author UFT
 */
@Entity
@Table(name = "is_ped_geram_nf_integ_paf_arq")//item 7.1
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "IsPedGeramNfIntegPafArq.findAll", query = "SELECT i FROM IsPedGeramNfIntegPafArq i")
    , @NamedQuery(name = "IsPedGeramNfIntegPafArq.findById", query = "SELECT i FROM IsPedGeramNfIntegPafArq i WHERE i.id = :id")
    , @NamedQuery(name = "IsPedGeramNfIntegPafArq.findByNome", query = "SELECT i FROM IsPedGeramNfIntegPafArq i WHERE i.nome = :nome")
    , @NamedQuery(name = "IsPedGeramNfIntegPafArq.findByMd5", query = "SELECT i FROM IsPedGeramNfIntegPafArq i WHERE i.md5 = :md5")})
public class IsPedGeramNfIntegPafArq implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 2147483647)
    @Column(name = "nome")
    private String nome;
    @Size(max = 2147483647)
    @Column(name = "md5")
    private String md5;
    @JoinColumn(name = "is_ped_geram_nf_integ_paf_id", referencedColumnName = "id")
    @ManyToOne
    private IsPedGeramNfIntegPaf isPedGeramNfIntegPafId;

    public IsPedGeramNfIntegPafArq() {
    }

    public IsPedGeramNfIntegPafArq(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getMd5() {
        return md5;
    }

    public void setMd5(String md5) {
        this.md5 = md5;
    }

    public IsPedGeramNfIntegPaf getIsPedGeramNfIntegPafId() {
        return isPedGeramNfIntegPafId;
    }

    public void setIsPedGeramNfIntegPafId(IsPedGeramNfIntegPaf isPedGeramNfIntegPafId) {
        this.isPedGeramNfIntegPafId = isPedGeramNfIntegPafId;
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
        if (!(object instanceof IsPedGeramNfIntegPafArq)) {
            return false;
        }
        IsPedGeramNfIntegPafArq other = (IsPedGeramNfIntegPafArq) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.uft.homologadora.model.IsPedGeramNfIntegPafArq[ id=" + id + " ]";
    }
    
}
