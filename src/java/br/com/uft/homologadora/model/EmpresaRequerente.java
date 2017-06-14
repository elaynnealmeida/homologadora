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
@Table(name = "empresa_requerente")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EmpresaRequerente.findAll", query = "SELECT e FROM EmpresaRequerente e")
    , @NamedQuery(name = "EmpresaRequerente.findById", query = "SELECT e FROM EmpresaRequerente e WHERE e.id = :id")
    , @NamedQuery(name = "EmpresaRequerente.findByRazaoSocial", query = "SELECT e FROM EmpresaRequerente e WHERE e.razaoSocial = :razaoSocial")
    , @NamedQuery(name = "EmpresaRequerente.findByEndereco", query = "SELECT e FROM EmpresaRequerente e WHERE e.endereco = :endereco")
    , @NamedQuery(name = "EmpresaRequerente.findByTelefone", query = "SELECT e FROM EmpresaRequerente e WHERE e.telefone = :telefone")
    , @NamedQuery(name = "EmpresaRequerente.findByEmail", query = "SELECT e FROM EmpresaRequerente e WHERE e.email = :email")
    , @NamedQuery(name = "EmpresaRequerente.findByContato", query = "SELECT e FROM EmpresaRequerente e WHERE e.contato = :contato")
    , @NamedQuery(name = "EmpresaRequerente.findByCnpj", query = "SELECT e FROM EmpresaRequerente e WHERE e.cnpj = :cnpj")
    , @NamedQuery(name = "EmpresaRequerente.findByInscricaoEstadual", query = "SELECT e FROM EmpresaRequerente e WHERE e.inscricaoEstadual = :inscricaoEstadual")
    , @NamedQuery(name = "EmpresaRequerente.findByInscricaoMunicipal", query = "SELECT e FROM EmpresaRequerente e WHERE e.inscricaoMunicipal = :inscricaoMunicipal")
    , @NamedQuery(name = "EmpresaRequerente.findByRegistroJuntaComercialCartorio", query = "SELECT e FROM EmpresaRequerente e WHERE e.registroJuntaComercialCartorio = :registroJuntaComercialCartorio")
    , @NamedQuery(name = "EmpresaRequerente.findByResponsavelNome", query = "SELECT e FROM EmpresaRequerente e WHERE e.responsavelNome = :responsavelNome")
    , @NamedQuery(name = "EmpresaRequerente.findByResponsavelCpf", query = "SELECT e FROM EmpresaRequerente e WHERE e.responsavelCpf = :responsavelCpf")
    , @NamedQuery(name = "EmpresaRequerente.findByResponsavelRg", query = "SELECT e FROM EmpresaRequerente e WHERE e.responsavelRg = :responsavelRg")})
public class EmpresaRequerente implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 2147483647)
    @Column(name = "razao_social")
    private String razaoSocial;
    @Size(max = 2147483647)
    @Column(name = "endereco")
    private String endereco;
    @Size(max = 2147483647)
    @Column(name = "telefone")
    private String telefone;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="E-mail inválido")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 2147483647)
    @Column(name = "email")
    private String email;
    @Size(max = 2147483647)
    @Column(name = "contato")
    private String contato;
    @Size(max = 2147483647)
    @Column(name = "cnpj")
    private String cnpj;
    @Size(max = 2147483647)
    @Column(name = "inscricao_estadual")
    private String inscricaoEstadual;
    @Size(max = 2147483647)
    @Column(name = "inscricao_municipal")
    private String inscricaoMunicipal;
    @Size(max = 2147483647)
    @Column(name = "registro_junta_comercial_cartorio")
    private String registroJuntaComercialCartorio;
    @Size(max = 2147483647)
    @Column(name = "responsavel_nome")
    private String responsavelNome;
    @Size(max = 2147483647)
    @Column(name = "responsavel_cpf")
    private String responsavelCpf;
    @Size(max = 2147483647)
    @Column(name = "responsavel_rg")
    private String responsavelRg;
    @JoinColumn(name = "usuario", referencedColumnName = "id")
    @ManyToOne
    private Usuario usuario;

    public EmpresaRequerente() {
    }

    public EmpresaRequerente(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContato() {
        return contato;
    }

    public void setContato(String contato) {
        this.contato = contato;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getInscricaoEstadual() {
        return inscricaoEstadual;
    }

    public void setInscricaoEstadual(String inscricaoEstadual) {
        this.inscricaoEstadual = inscricaoEstadual;
    }

    public String getInscricaoMunicipal() {
        return inscricaoMunicipal;
    }

    public void setInscricaoMunicipal(String inscricaoMunicipal) {
        this.inscricaoMunicipal = inscricaoMunicipal;
    }

    public String getRegistroJuntaComercialCartorio() {
        return registroJuntaComercialCartorio;
    }

    public void setRegistroJuntaComercialCartorio(String registroJuntaComercialCartorio) {
        this.registroJuntaComercialCartorio = registroJuntaComercialCartorio;
    }

    public String getResponsavelNome() {
        return responsavelNome;
    }

    public void setResponsavelNome(String responsavelNome) {
        this.responsavelNome = responsavelNome;
    }

    public String getResponsavelCpf() {
        return responsavelCpf;
    }

    public void setResponsavelCpf(String responsavelCpf) {
        this.responsavelCpf = responsavelCpf;
    }

    public String getResponsavelRg() {
        return responsavelRg;
    }

    public void setResponsavelRg(String responsavelRg) {
        this.responsavelRg = responsavelRg;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
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
        if (!(object instanceof EmpresaRequerente)) {
            return false;
        }
        EmpresaRequerente other = (EmpresaRequerente) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.uft.homologadora.model.EmpresaRequerente[ id=" + id + " ]";
    }
    
}
