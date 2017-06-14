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
import javax.persistence.Lob;
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
@Table(name = "relacao_executaveis_realizam_requisitos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RelacaoExecutaveisRealizamRequisitos.findAll", query = "SELECT r FROM RelacaoExecutaveisRealizamRequisitos r")
    , @NamedQuery(name = "RelacaoExecutaveisRealizamRequisitos.findById", query = "SELECT r FROM RelacaoExecutaveisRealizamRequisitos r WHERE r.id = :id")
    , @NamedQuery(name = "RelacaoExecutaveisRealizamRequisitos.findByNome", query = "SELECT r FROM RelacaoExecutaveisRealizamRequisitos r WHERE r.nome = :nome")
    , @NamedQuery(name = "RelacaoExecutaveisRealizamRequisitos.findByMd5", query = "SELECT r FROM RelacaoExecutaveisRealizamRequisitos r WHERE r.md5 = :md5")})
public class RelacaoExecutaveisRealizamRequisitos implements Serializable {

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
    @Lob
    @Column(name = "arquivo")
    private byte[] arquivo;
    @OneToMany(mappedBy = "arquivoExecutavelId")
    private List<PafEcfArquivosExecutaveis> pafEcfArquivosExecutaveisList;

    public RelacaoExecutaveisRealizamRequisitos() {
    }

    public RelacaoExecutaveisRealizamRequisitos(Integer id) {
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

    public byte[] getArquivo() {
        return arquivo;
    }

    public void setArquivo(byte[] arquivo) {
        this.arquivo = arquivo;
    }

    @XmlTransient
    public List<PafEcfArquivosExecutaveis> getPafEcfArquivosExecutaveisList() {
        return pafEcfArquivosExecutaveisList;
    }

    public void setPafEcfArquivosExecutaveisList(List<PafEcfArquivosExecutaveis> pafEcfArquivosExecutaveisList) {
        this.pafEcfArquivosExecutaveisList = pafEcfArquivosExecutaveisList;
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
        if (!(object instanceof RelacaoExecutaveisRealizamRequisitos)) {
            return false;
        }
        RelacaoExecutaveisRealizamRequisitos other = (RelacaoExecutaveisRealizamRequisitos) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.uft.homologadora.model.RelacaoExecutaveisRealizamRequisitos[ id=" + id + " ]";
    }
    
}
