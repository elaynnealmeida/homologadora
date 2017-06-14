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
@Table(name = "relatorio_nao_conformidade")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RelatorioNaoConformidade.findAll", query = "SELECT r FROM RelatorioNaoConformidade r")
    , @NamedQuery(name = "RelatorioNaoConformidade.findById", query = "SELECT r FROM RelatorioNaoConformidade r WHERE r.id = :id")
    , @NamedQuery(name = "RelatorioNaoConformidade.findByItemRequisito", query = "SELECT r FROM RelatorioNaoConformidade r WHERE r.itemRequisito = :itemRequisito")
    , @NamedQuery(name = "RelatorioNaoConformidade.findByDescricaoDoMotivo", query = "SELECT r FROM RelatorioNaoConformidade r WHERE r.descricaoDoMotivo = :descricaoDoMotivo")})
public class RelatorioNaoConformidade implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 2147483647)
    @Column(name = "item_requisito")
    private String itemRequisito;
    @Size(max = 2147483647)
    @Column(name = "descricao_do_motivo")
    private String descricaoDoMotivo;
    @JoinColumn(name = "laudo_id", referencedColumnName = "id")
    @ManyToOne
    private Laudo laudoId;

    public RelatorioNaoConformidade() {
    }

    public RelatorioNaoConformidade(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getItemRequisito() {
        return itemRequisito;
    }

    public void setItemRequisito(String itemRequisito) {
        this.itemRequisito = itemRequisito;
    }

    public String getDescricaoDoMotivo() {
        return descricaoDoMotivo;
    }

    public void setDescricaoDoMotivo(String descricaoDoMotivo) {
        this.descricaoDoMotivo = descricaoDoMotivo;
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
        if (!(object instanceof RelatorioNaoConformidade)) {
            return false;
        }
        RelatorioNaoConformidade other = (RelatorioNaoConformidade) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.uft.homologadora.model.RelatorioNaoConformidade[ id=" + id + " ]";
    }
    
}
