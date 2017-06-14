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
@Table(name = "perfil_requisito_paf-ecf")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PerfilRequisitoPafEcf.findAll", query = "SELECT p FROM PerfilRequisitoPafEcf p")
    , @NamedQuery(name = "PerfilRequisitoPafEcf.findById", query = "SELECT p FROM PerfilRequisitoPafEcf p WHERE p.id = :id")
    , @NamedQuery(name = "PerfilRequisitoPafEcf.findByPerfil", query = "SELECT p FROM PerfilRequisitoPafEcf p WHERE p.perfil = :perfil")
    , @NamedQuery(name = "PerfilRequisitoPafEcf.findByUnidadeFederacao", query = "SELECT p FROM PerfilRequisitoPafEcf p WHERE p.unidadeFederacao = :unidadeFederacao")
    , @NamedQuery(name = "PerfilRequisitoPafEcf.findByDescricao", query = "SELECT p FROM PerfilRequisitoPafEcf p WHERE p.descricao = :descricao")})
public class PerfilRequisitoPafEcf implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 1)
    @Column(name = "perfil")
    private String perfil;
    @Size(max = 2147483647)
    @Column(name = "unidade_federacao")
    private String unidadeFederacao;
    @Size(max = 2147483647)
    @Column(name = "descricao")
    private String descricao;

    public PerfilRequisitoPafEcf() {
    }

    public PerfilRequisitoPafEcf(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPerfil() {
        return perfil;
    }

    public void setPerfil(String perfil) {
        this.perfil = perfil;
    }

    public String getUnidadeFederacao() {
        return unidadeFederacao;
    }

    public void setUnidadeFederacao(String unidadeFederacao) {
        this.unidadeFederacao = unidadeFederacao;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
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
        if (!(object instanceof PerfilRequisitoPafEcf)) {
            return false;
        }
        PerfilRequisitoPafEcf other = (PerfilRequisitoPafEcf) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.uft.homologadora.model.PerfilRequisitoPafEcf[ id=" + id + " ]";
    }
    
}
