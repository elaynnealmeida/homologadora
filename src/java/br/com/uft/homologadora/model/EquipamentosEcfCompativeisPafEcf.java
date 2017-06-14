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
@Table(name = "equipamentos_ecf_compativeis_paf_ecf")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EquipamentosEcfCompativeisPafEcf.findAll", query = "SELECT e FROM EquipamentosEcfCompativeisPafEcf e")
    , @NamedQuery(name = "EquipamentosEcfCompativeisPafEcf.findById", query = "SELECT e FROM EquipamentosEcfCompativeisPafEcf e WHERE e.id = :id")
    , @NamedQuery(name = "EquipamentosEcfCompativeisPafEcf.findByMarca", query = "SELECT e FROM EquipamentosEcfCompativeisPafEcf e WHERE e.marca = :marca")
    , @NamedQuery(name = "EquipamentosEcfCompativeisPafEcf.findByModelo", query = "SELECT e FROM EquipamentosEcfCompativeisPafEcf e WHERE e.modelo = :modelo")
    , @NamedQuery(name = "EquipamentosEcfCompativeisPafEcf.findByUtilizado", query = "SELECT e FROM EquipamentosEcfCompativeisPafEcf e WHERE e.utilizado = :utilizado")})
public class EquipamentosEcfCompativeisPafEcf implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 2147483647)
    @Column(name = "marca")
    private String marca;
    @Size(max = 2147483647)
    @Column(name = "modelo")
    private String modelo;
    @Column(name = "utilizado")
    private Boolean utilizado;
    @JoinColumn(name = "paf_ecf_id", referencedColumnName = "id")
    @ManyToOne
    private PafEcf pafEcfId;

    public EquipamentosEcfCompativeisPafEcf() {
    }

    public EquipamentosEcfCompativeisPafEcf(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public Boolean getUtilizado() {
        return utilizado;
    }

    public void setUtilizado(Boolean utilizado) {
        this.utilizado = utilizado;
    }

    public PafEcf getPafEcfId() {
        return pafEcfId;
    }

    public void setPafEcfId(PafEcf pafEcfId) {
        this.pafEcfId = pafEcfId;
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
        if (!(object instanceof EquipamentosEcfCompativeisPafEcf)) {
            return false;
        }
        EquipamentosEcfCompativeisPafEcf other = (EquipamentosEcfCompativeisPafEcf) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.uft.homologadora.model.EquipamentosEcfCompativeisPafEcf[ id=" + id + " ]";
    }
    
}
