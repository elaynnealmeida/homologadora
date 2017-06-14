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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "isgrepmra_paf_ecf_arquivos")//item 5.2
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "IsgrepmraPafEcfArquivos.findAll", query = "SELECT i FROM IsgrepmraPafEcfArquivos i")
    , @NamedQuery(name = "IsgrepmraPafEcfArquivos.findById", query = "SELECT i FROM IsgrepmraPafEcfArquivos i WHERE i.id = :id")
    , @NamedQuery(name = "IsgrepmraPafEcfArquivos.findByNomeArquivo", query = "SELECT i FROM IsgrepmraPafEcfArquivos i WHERE i.nomeArquivo = :nomeArquivo")
    , @NamedQuery(name = "IsgrepmraPafEcfArquivos.findByMd5", query = "SELECT i FROM IsgrepmraPafEcfArquivos i WHERE i.md5 = :md5")})
public class IsgrepmraPafEcfArquivos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 2147483647)
    @Column(name = "nome_arquivo")
    private String nomeArquivo;
    @Size(max = 2147483647)
    @Column(name = "md5")
    private String md5;
    @OneToMany(mappedBy = "isgrepmraPafEcfArquivoId")
    private List<IsgrepmraPafEcfRequisito> isgrepmraPafEcfRequisitoList;
    @JoinColumn(name = "isgrepmra_paf_ecf_id", referencedColumnName = "id")
    @ManyToOne
    private IsgrepmraPafEcf isgrepmraPafEcfId;

    public IsgrepmraPafEcfArquivos() {
    }

    public IsgrepmraPafEcfArquivos(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNomeArquivo() {
        return nomeArquivo;
    }

    public void setNomeArquivo(String nomeArquivo) {
        this.nomeArquivo = nomeArquivo;
    }

    public String getMd5() {
        return md5;
    }

    public void setMd5(String md5) {
        this.md5 = md5;
    }

    @XmlTransient
    public List<IsgrepmraPafEcfRequisito> getIsgrepmraPafEcfRequisitoList() {
        return isgrepmraPafEcfRequisitoList;
    }

    public void setIsgrepmraPafEcfRequisitoList(List<IsgrepmraPafEcfRequisito> isgrepmraPafEcfRequisitoList) {
        this.isgrepmraPafEcfRequisitoList = isgrepmraPafEcfRequisitoList;
    }

    public IsgrepmraPafEcf getIsgrepmraPafEcfId() {
        return isgrepmraPafEcfId;
    }

    public void setIsgrepmraPafEcfId(IsgrepmraPafEcf isgrepmraPafEcfId) {
        this.isgrepmraPafEcfId = isgrepmraPafEcfId;
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
        if (!(object instanceof IsgrepmraPafEcfArquivos)) {
            return false;
        }
        IsgrepmraPafEcfArquivos other = (IsgrepmraPafEcfArquivos) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.uft.homologadora.model.IsgrepmraPafEcfArquivos[ id=" + id + " ]";
    }
    
}
