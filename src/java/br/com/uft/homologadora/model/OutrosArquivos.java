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
@Table(name = "outros_arquivos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OutrosArquivos.findAll", query = "SELECT o FROM OutrosArquivos o")
    , @NamedQuery(name = "OutrosArquivos.findById", query = "SELECT o FROM OutrosArquivos o WHERE o.id = :id")
    , @NamedQuery(name = "OutrosArquivos.findByNome", query = "SELECT o FROM OutrosArquivos o WHERE o.nome = :nome")
    , @NamedQuery(name = "OutrosArquivos.findByMd5", query = "SELECT o FROM OutrosArquivos o WHERE o.md5 = :md5")})
public class OutrosArquivos implements Serializable {

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
    @OneToMany(mappedBy = "outrosArquivosId")
    private List<PafEcfOutrosArquivos> pafEcfOutrosArquivosList;

    public OutrosArquivos() {
    }

    public OutrosArquivos(Integer id) {
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
    public List<PafEcfOutrosArquivos> getPafEcfOutrosArquivosList() {
        return pafEcfOutrosArquivosList;
    }

    public void setPafEcfOutrosArquivosList(List<PafEcfOutrosArquivos> pafEcfOutrosArquivosList) {
        this.pafEcfOutrosArquivosList = pafEcfOutrosArquivosList;
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
        if (!(object instanceof OutrosArquivos)) {
            return false;
        }
        OutrosArquivos other = (OutrosArquivos) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.uft.homologadora.model.OutrosArquivos[ id=" + id + " ]";
    }
    
}
