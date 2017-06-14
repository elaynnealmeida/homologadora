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
@Table(name = "equipamento_ecf_utilizado_analise")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EquipamentoEcfUtilizadoAnalise.findAll", query = "SELECT e FROM EquipamentoEcfUtilizadoAnalise e")
    , @NamedQuery(name = "EquipamentoEcfUtilizadoAnalise.findById", query = "SELECT e FROM EquipamentoEcfUtilizadoAnalise e WHERE e.id = :id")
    , @NamedQuery(name = "EquipamentoEcfUtilizadoAnalise.findByMarca", query = "SELECT e FROM EquipamentoEcfUtilizadoAnalise e WHERE e.marca = :marca")
    , @NamedQuery(name = "EquipamentoEcfUtilizadoAnalise.findByModelo", query = "SELECT e FROM EquipamentoEcfUtilizadoAnalise e WHERE e.modelo = :modelo")})
public class EquipamentoEcfUtilizadoAnalise implements Serializable {

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
    @JoinColumn(name = "laudo_id", referencedColumnName = "id")
    @ManyToOne
    private Laudo laudoId;

    public EquipamentoEcfUtilizadoAnalise() {
    }

    public EquipamentoEcfUtilizadoAnalise(Integer id) {
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

    public Laudo getLaudoId() {
        return laudoId;
    }

    public void setLaudoId(Laudo laudoId) {
        this.laudoId = laudoId;
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
        if (!(object instanceof EquipamentoEcfUtilizadoAnalise)) {
            return false;
        }
        EquipamentoEcfUtilizadoAnalise other = (EquipamentoEcfUtilizadoAnalise) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.uft.homologadora.model.EquipamentoEcfUtilizadoAnalise[ id=" + id + " ]";
    }
    
}
