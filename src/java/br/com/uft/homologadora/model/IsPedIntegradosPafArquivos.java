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
@Table(name = "is_ped_integrados_paf_arquivos")//item 6.1
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "IsPedIntegradosPafArquivos.findAll", query = "SELECT i FROM IsPedIntegradosPafArquivos i")
    , @NamedQuery(name = "IsPedIntegradosPafArquivos.findById", query = "SELECT i FROM IsPedIntegradosPafArquivos i WHERE i.id = :id")
    , @NamedQuery(name = "IsPedIntegradosPafArquivos.findByNome", query = "SELECT i FROM IsPedIntegradosPafArquivos i WHERE i.nome = :nome")
    , @NamedQuery(name = "IsPedIntegradosPafArquivos.findByFuncao", query = "SELECT i FROM IsPedIntegradosPafArquivos i WHERE i.funcao = :funcao")
    , @NamedQuery(name = "IsPedIntegradosPafArquivos.findByMd5", query = "SELECT i FROM IsPedIntegradosPafArquivos i WHERE i.md5 = :md5")})
public class IsPedIntegradosPafArquivos implements Serializable {

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
    @Column(name = "funcao")
    private String funcao;
    @Size(max = 2147483647)
    @Column(name = "md5")
    private String md5;
    @JoinColumn(name = "is_ped_integrados_paf_id", referencedColumnName = "id")
    @ManyToOne
    private IsPedIntegradosPaf isPedIntegradosPafId;

    public IsPedIntegradosPafArquivos() {
    }

    public IsPedIntegradosPafArquivos(Integer id) {
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

    public String getFuncao() {
        return funcao;
    }

    public void setFuncao(String funcao) {
        this.funcao = funcao;
    }

    public String getMd5() {
        return md5;
    }

    public void setMd5(String md5) {
        this.md5 = md5;
    }

    public IsPedIntegradosPaf getIsPedIntegradosPafId() {
        return isPedIntegradosPafId;
    }

    public void setIsPedIntegradosPafId(IsPedIntegradosPaf isPedIntegradosPafId) {
        this.isPedIntegradosPafId = isPedIntegradosPafId;
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
        if (!(object instanceof IsPedIntegradosPafArquivos)) {
            return false;
        }
        IsPedIntegradosPafArquivos other = (IsPedIntegradosPafArquivos) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.uft.homologadora.model.IsPedIntegradosPafArquivos[ id=" + id + " ]";
    }
    
}
