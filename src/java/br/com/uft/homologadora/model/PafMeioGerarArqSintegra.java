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
@Table(name = "paf_meio_gerar_arq_sintegra")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PafMeioGerarArqSintegra.findAll", query = "SELECT p FROM PafMeioGerarArqSintegra p")
    , @NamedQuery(name = "PafMeioGerarArqSintegra.findById", query = "SELECT p FROM PafMeioGerarArqSintegra p WHERE p.id = :id")})
public class PafMeioGerarArqSintegra implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @JoinColumn(name = "meio_gerar_arq_sintegra_id", referencedColumnName = "id")
    @ManyToOne
    private MeioGeracaoArqSintegra meioGerarArqSintegraId;
    @JoinColumn(name = "paf_id", referencedColumnName = "id")
    @ManyToOne
    private PafEcf pafId;

    public PafMeioGerarArqSintegra() {
    }

    public PafMeioGerarArqSintegra(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public MeioGeracaoArqSintegra getMeioGerarArqSintegraId() {
        return meioGerarArqSintegraId;
    }

    public void setMeioGerarArqSintegraId(MeioGeracaoArqSintegra meioGerarArqSintegraId) {
        this.meioGerarArqSintegraId = meioGerarArqSintegraId;
    }

    public PafEcf getPafId() {
        return pafId;
    }

    public void setPafId(PafEcf pafId) {
        this.pafId = pafId;
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
        if (!(object instanceof PafMeioGerarArqSintegra)) {
            return false;
        }
        PafMeioGerarArqSintegra other = (PafMeioGerarArqSintegra) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.uft.homologadora.model.PafMeioGerarArqSintegra[ id=" + id + " ]";
    }
    
}
