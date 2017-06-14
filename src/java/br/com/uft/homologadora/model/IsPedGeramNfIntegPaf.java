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
@Table(name = "is_ped_geram_nf_integ_paf")//item 7
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "IsPedGeramNfIntegPaf.findAll", query = "SELECT i FROM IsPedGeramNfIntegPaf i")
    , @NamedQuery(name = "IsPedGeramNfIntegPaf.findById", query = "SELECT i FROM IsPedGeramNfIntegPaf i WHERE i.id = :id")
    , @NamedQuery(name = "IsPedGeramNfIntegPaf.findByEmpresaDesenvolvedora", query = "SELECT i FROM IsPedGeramNfIntegPaf i WHERE i.empresaDesenvolvedora = :empresaDesenvolvedora")
    , @NamedQuery(name = "IsPedGeramNfIntegPaf.findByCnpj", query = "SELECT i FROM IsPedGeramNfIntegPaf i WHERE i.cnpj = :cnpj")
    , @NamedQuery(name = "IsPedGeramNfIntegPaf.findByDenominacao", query = "SELECT i FROM IsPedGeramNfIntegPaf i WHERE i.denominacao = :denominacao")
    , @NamedQuery(name = "IsPedGeramNfIntegPaf.findByNomeSistema", query = "SELECT i FROM IsPedGeramNfIntegPaf i WHERE i.nomeSistema = :nomeSistema")})
public class IsPedGeramNfIntegPaf implements Serializable {

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
    @JoinColumn(name = "paf_ecf_id", referencedColumnName = "id")
    @ManyToOne
    private PafEcf pafEcfId;
    @OneToMany(mappedBy = "isPedGeramNfIntegPafId")
    private List<IsPedGeramNfIntegPafArq> isPedGeramNfIntegPafArqList;
    @OneToMany(mappedBy = "isPedGeramNfIntegradosId")
    private List<PafEcf> pafEcfList;

    public IsPedGeramNfIntegPaf() {
    }

    public IsPedGeramNfIntegPaf(Integer id) {
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

    public PafEcf getPafEcfId() {
        return pafEcfId;
    }

    public void setPafEcfId(PafEcf pafEcfId) {
        this.pafEcfId = pafEcfId;
    }

    @XmlTransient
    public List<IsPedGeramNfIntegPafArq> getIsPedGeramNfIntegPafArqList() {
        return isPedGeramNfIntegPafArqList;
    }

    public void setIsPedGeramNfIntegPafArqList(List<IsPedGeramNfIntegPafArq> isPedGeramNfIntegPafArqList) {
        this.isPedGeramNfIntegPafArqList = isPedGeramNfIntegPafArqList;
    }

    @XmlTransient
    public List<PafEcf> getPafEcfList() {
        return pafEcfList;
    }

    public void setPafEcfList(List<PafEcf> pafEcfList) {
        this.pafEcfList = pafEcfList;
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
        if (!(object instanceof IsPedGeramNfIntegPaf)) {
            return false;
        }
        IsPedGeramNfIntegPaf other = (IsPedGeramNfIntegPaf) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.uft.homologadora.model.IsPedGeramNfIntegPaf[ id=" + id + " ]";
    }
    
}
