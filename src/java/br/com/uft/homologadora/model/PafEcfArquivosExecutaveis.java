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
@Table(name = "paf_ecf_arquivos_executaveis")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PafEcfArquivosExecutaveis.findAll", query = "SELECT p FROM PafEcfArquivosExecutaveis p")
    , @NamedQuery(name = "PafEcfArquivosExecutaveis.findById", query = "SELECT p FROM PafEcfArquivosExecutaveis p WHERE p.id = :id")})
public class PafEcfArquivosExecutaveis implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @JoinColumn(name = "paf_ecf_id", referencedColumnName = "id")
    @ManyToOne
    private PafEcf pafEcfId;
    @JoinColumn(name = "arquivo_executavel_id", referencedColumnName = "id")
    @ManyToOne
    private RelacaoExecutaveisRealizamRequisitos arquivoExecutavelId;

    public PafEcfArquivosExecutaveis() {
    }

    public PafEcfArquivosExecutaveis(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public PafEcf getPafEcfId() {
        return pafEcfId;
    }

    public void setPafEcfId(PafEcf pafEcfId) {
        this.pafEcfId = pafEcfId;
    }

    public RelacaoExecutaveisRealizamRequisitos getArquivoExecutavelId() {
        return arquivoExecutavelId;
    }

    public void setArquivoExecutavelId(RelacaoExecutaveisRealizamRequisitos arquivoExecutavelId) {
        this.arquivoExecutavelId = arquivoExecutavelId;
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
        if (!(object instanceof PafEcfArquivosExecutaveis)) {
            return false;
        }
        PafEcfArquivosExecutaveis other = (PafEcfArquivosExecutaveis) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.uft.homologadora.model.PafEcfArquivosExecutaveis[ id=" + id + " ]";
    }
    
}
