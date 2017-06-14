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
@Table(name = "is_ped_integrados_paf")//item 6
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "IsPedIntegradosPaf.findAll", query = "SELECT i FROM IsPedIntegradosPaf i")
    , @NamedQuery(name = "IsPedIntegradosPaf.findById", query = "SELECT i FROM IsPedIntegradosPaf i WHERE i.id = :id")
    , @NamedQuery(name = "IsPedIntegradosPaf.findByEmpresaDesenvolvedora", query = "SELECT i FROM IsPedIntegradosPaf i WHERE i.empresaDesenvolvedora = :empresaDesenvolvedora")
    , @NamedQuery(name = "IsPedIntegradosPaf.findByCnpj", query = "SELECT i FROM IsPedIntegradosPaf i WHERE i.cnpj = :cnpj")
    , @NamedQuery(name = "IsPedIntegradosPaf.findByDenominacao", query = "SELECT i FROM IsPedIntegradosPaf i WHERE i.denominacao = :denominacao")
    , @NamedQuery(name = "IsPedIntegradosPaf.findByNomeSistema", query = "SELECT i FROM IsPedIntegradosPaf i WHERE i.nomeSistema = :nomeSistema")})
public class IsPedIntegradosPaf implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 2147483647)
    @Column(name = "empresa_desenvolvedora")
    private String empresaDesenvolvedora;
    @Size(max = 2147483647)
    @Column(name = "cnpj")
    private String cnpj;
    @Size(max = 2147483647)
    @Column(name = "denominacao")
    private String denominacao;
    @Size(max = 2147483647)
    @Column(name = "nome_sistema")
    private String nomeSistema;
    @OneToMany(mappedBy = "isPedIntegradosId")
    private List<PafEcf> pafEcfList;
    @JoinColumn(name = "paf_ecf_id", referencedColumnName = "id")
    @ManyToOne
    private PafEcf pafEcfId;
    @OneToMany(mappedBy = "isPedIntegradosPafId")
    private List<IsPedIntegradosPafArquivos> isPedIntegradosPafArquivosList;

    public IsPedIntegradosPaf() {
    }

    public IsPedIntegradosPaf(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmpresaDesenvolvedora() {
        return empresaDesenvolvedora;
    }

    public void setEmpresaDesenvolvedora(String empresaDesenvolvedora) {
        this.empresaDesenvolvedora = empresaDesenvolvedora;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getDenominacao() {
        return denominacao;
    }

    public void setDenominacao(String denominacao) {
        this.denominacao = denominacao;
    }

    public String getNomeSistema() {
        return nomeSistema;
    }

    public void setNomeSistema(String nomeSistema) {
        this.nomeSistema = nomeSistema;
    }

    @XmlTransient
    public List<PafEcf> getPafEcfList() {
        return pafEcfList;
    }

    public void setPafEcfList(List<PafEcf> pafEcfList) {
        this.pafEcfList = pafEcfList;
    }

    public PafEcf getPafEcfId() {
        return pafEcfId;
    }

    public void setPafEcfId(PafEcf pafEcfId) {
        this.pafEcfId = pafEcfId;
    }

    @XmlTransient
    public List<IsPedIntegradosPafArquivos> getIsPedIntegradosPafArquivosList() {
        return isPedIntegradosPafArquivosList;
    }

    public void setIsPedIntegradosPafArquivosList(List<IsPedIntegradosPafArquivos> isPedIntegradosPafArquivosList) {
        this.isPedIntegradosPafArquivosList = isPedIntegradosPafArquivosList;
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
        if (!(object instanceof IsPedIntegradosPaf)) {
            return false;
        }
        IsPedIntegradosPaf other = (IsPedIntegradosPaf) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.uft.homologadora.model.IsPedIntegradosPaf[ id=" + id + " ]";
    }
    
}
