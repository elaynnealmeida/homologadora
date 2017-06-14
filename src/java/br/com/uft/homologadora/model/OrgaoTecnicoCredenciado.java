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
@Table(name = "orgao_tecnico_credenciado")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OrgaoTecnicoCredenciado.findAll", query = "SELECT o FROM OrgaoTecnicoCredenciado o")
    , @NamedQuery(name = "OrgaoTecnicoCredenciado.findById", query = "SELECT o FROM OrgaoTecnicoCredenciado o WHERE o.id = :id")
    , @NamedQuery(name = "OrgaoTecnicoCredenciado.findByIdentificacao", query = "SELECT o FROM OrgaoTecnicoCredenciado o WHERE o.identificacao = :identificacao")
    , @NamedQuery(name = "OrgaoTecnicoCredenciado.findByCnpj", query = "SELECT o FROM OrgaoTecnicoCredenciado o WHERE o.cnpj = :cnpj")
    , @NamedQuery(name = "OrgaoTecnicoCredenciado.findByEndereco", query = "SELECT o FROM OrgaoTecnicoCredenciado o WHERE o.endereco = :endereco")
    , @NamedQuery(name = "OrgaoTecnicoCredenciado.findByPeriodoInicial", query = "SELECT o FROM OrgaoTecnicoCredenciado o WHERE o.periodoInicial = :periodoInicial")
    , @NamedQuery(name = "OrgaoTecnicoCredenciado.findByPeriodoFinal", query = "SELECT o FROM OrgaoTecnicoCredenciado o WHERE o.periodoFinal = :periodoFinal")})
public class OrgaoTecnicoCredenciado implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 2147483647)
    @Column(name = "identificacao")
    private String identificacao;
    @Size(max = 2147483647)
    @Column(name = "cnpj")
    private String cnpj;
    @Size(max = 2147483647)
    @Column(name = "endereco")
    private String endereco;
    @Size(max = 2147483647)
    @Column(name = "periodo_inicial")
    private String periodoInicial;
    @Size(max = 2147483647)
    @Column(name = "periodo_final")
    private String periodoFinal;
    @JoinColumn(name = "usuario_id", referencedColumnName = "id")
    @ManyToOne
    private Usuario usuarioId;
    @OneToMany(mappedBy = "orgaoTecnicoCredenciado")
    private List<Laudo> laudoList;

    public OrgaoTecnicoCredenciado() {
    }

    public OrgaoTecnicoCredenciado(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getIdentificacao() {
        return identificacao;
    }

    public void setIdentificacao(String identificacao) {
        this.identificacao = identificacao;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getPeriodoInicial() {
        return periodoInicial;
    }

    public void setPeriodoInicial(String periodoInicial) {
        this.periodoInicial = periodoInicial;
    }

    public String getPeriodoFinal() {
        return periodoFinal;
    }

    public void setPeriodoFinal(String periodoFinal) {
        this.periodoFinal = periodoFinal;
    }

    public Usuario getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Usuario usuarioId) {
        this.usuarioId = usuarioId;
    }

    @XmlTransient
    public List<Laudo> getLaudoList() {
        return laudoList;
    }

    public void setLaudoList(List<Laudo> laudoList) {
        this.laudoList = laudoList;
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
        if (!(object instanceof OrgaoTecnicoCredenciado)) {
            return false;
        }
        OrgaoTecnicoCredenciado other = (OrgaoTecnicoCredenciado) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.uft.homologadora.model.OrgaoTecnicoCredenciado[ id=" + id + " ]";
    }
    
}
