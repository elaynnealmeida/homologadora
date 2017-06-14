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
@Table(name = "paf_ecf_perfis")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PafEcfPerfis.findAll", query = "SELECT p FROM PafEcfPerfis p")
    , @NamedQuery(name = "PafEcfPerfis.findById", query = "SELECT p FROM PafEcfPerfis p WHERE p.id = :id")})
public class PafEcfPerfis implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @JoinColumn(name = "pad_ecf_id", referencedColumnName = "id")
    @ManyToOne
    private PafEcf padEcfId;
    @JoinColumn(name = "perfil_id", referencedColumnName = "id")
    @ManyToOne
    private PerfilRequisitoPafEcf perfilId;

    public PafEcfPerfis() {
    }

    public PafEcfPerfis(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public PafEcf getPadEcfId() {
        return padEcfId;
    }

    public void setPadEcfId(PafEcf padEcfId) {
        this.padEcfId = padEcfId;
    }

    public PerfilRequisitoPafEcf getPerfilId() {
        return perfilId;
    }

    public void setPerfilId(PerfilRequisitoPafEcf perfilId) {
        this.perfilId = perfilId;
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
        if (!(object instanceof PafEcfPerfis)) {
            return false;
        }
        PafEcfPerfis other = (PafEcfPerfis) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.uft.homologadora.model.PafEcfPerfis[ id=" + id + " ]";
    }
    
}
