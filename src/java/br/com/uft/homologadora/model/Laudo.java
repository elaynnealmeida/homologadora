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
@Table(name = "laudo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Laudo.findAll", query = "SELECT l FROM Laudo l")
    , @NamedQuery(name = "Laudo.findById", query = "SELECT l FROM Laudo l WHERE l.id = :id")
    , @NamedQuery(name = "Laudo.findByComentariosObservacoes", query = "SELECT l FROM Laudo l WHERE l.comentariosObservacoes = :comentariosObservacoes")
    , @NamedQuery(name = "Laudo.findByVersaoRoteiroAnalise", query = "SELECT l FROM Laudo l WHERE l.versaoRoteiroAnalise = :versaoRoteiroAnalise")
    , @NamedQuery(name = "Laudo.findByVersaoRoteiroAnaliseMesAno", query = "SELECT l FROM Laudo l WHERE l.versaoRoteiroAnaliseMesAno = :versaoRoteiroAnaliseMesAno")
    , @NamedQuery(name = "Laudo.findByErPafEcfVersao", query = "SELECT l FROM Laudo l WHERE l.erPafEcfVersao = :erPafEcfVersao")
    , @NamedQuery(name = "Laudo.findByLocalEmissao", query = "SELECT l FROM Laudo l WHERE l.localEmissao = :localEmissao")
    , @NamedQuery(name = "Laudo.findByDataEmissao", query = "SELECT l FROM Laudo l WHERE l.dataEmissao = :dataEmissao")
    , @NamedQuery(name = "Laudo.findByNomeTeste", query = "SELECT l FROM Laudo l WHERE l.nomeTeste = :nomeTeste")
    , @NamedQuery(name = "Laudo.findByCargoTeste", query = "SELECT l FROM Laudo l WHERE l.cargoTeste = :cargoTeste")
    , @NamedQuery(name = "Laudo.findByCpf", query = "SELECT l FROM Laudo l WHERE l.cpf = :cpf")
    , @NamedQuery(name = "Laudo.findByNomeRelatorio", query = "SELECT l FROM Laudo l WHERE l.nomeRelatorio = :nomeRelatorio")
    , @NamedQuery(name = "Laudo.findByCargoRelatorio", query = "SELECT l FROM Laudo l WHERE l.cargoRelatorio = :cargoRelatorio")
    , @NamedQuery(name = "Laudo.findByCpfRelatorio", query = "SELECT l FROM Laudo l WHERE l.cpfRelatorio = :cpfRelatorio")
    , @NamedQuery(name = "Laudo.findByNaoConformidade", query = "SELECT l FROM Laudo l WHERE l.naoConformidade = :naoConformidade")
    , @NamedQuery(name = "Laudo.findByNumero", query = "SELECT l FROM Laudo l WHERE l.numero = :numero")})
public class Laudo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 2147483647)
    @Column(name = "comentarios_observacoes")
    private String comentariosObservacoes;
    @Size(max = 2147483647)
    @Column(name = "versao_roteiro_analise")
    private String versaoRoteiroAnalise;
    @Size(max = 2147483647)
    @Column(name = "versao_roteiro_analise_mes_ano")
    private String versaoRoteiroAnaliseMesAno;
    @Size(max = 2147483647)
    @Column(name = "er_paf_ecf_versao")
    private String erPafEcfVersao;
    @Size(max = 2147483647)
    @Column(name = "local_emissao")
    private String localEmissao;
    @Size(max = 2147483647)
    @Column(name = "data_emissao")
    private String dataEmissao;
    @Size(max = 2147483647)
    @Column(name = "nome_teste")
    private String nomeTeste;
    @Size(max = 2147483647)
    @Column(name = "cargo_teste")
    private String cargoTeste;
    @Size(max = 2147483647)
    @Column(name = "cpf")
    private String cpf;
    @Size(max = 2147483647)
    @Column(name = "nome_relatorio")
    private String nomeRelatorio;
    @Size(max = 2147483647)
    @Column(name = "cargo_relatorio")
    private String cargoRelatorio;
    @Size(max = 2147483647)
    @Column(name = "cpf_relatorio")
    private String cpfRelatorio;
    @Column(name = "nao_conformidade")
    private Boolean naoConformidade;
    @Size(max = 2147483647)
    @Column(name = "numero")
    private String numero;
    @OneToMany(mappedBy = "laudoId")
    private List<EquipamentoEcfUtilizadoAnalise> equipamentoEcfUtilizadoAnaliseList;
    @OneToMany(mappedBy = "laudoId")
    private List<RelatorioNaoConformidade> relatorioNaoConformidadeList;
    @JoinColumn(name = "empresa_requerente", referencedColumnName = "id")
    @ManyToOne
    private EmpresaRequerente empresaRequerente;
    @JoinColumn(name = "orgao_tecnico_credenciado", referencedColumnName = "id")
    @ManyToOne
    private OrgaoTecnicoCredenciado orgaoTecnicoCredenciado;
    @JoinColumn(name = "paf_ecf", referencedColumnName = "id")
    @ManyToOne
    private PafEcf pafEcf;
    @JoinColumn(name = "parecer_conclusivo", referencedColumnName = "id")
    @ManyToOne
    private ParecerConclusivo parecerConclusivo;

    public Laudo() {
    }

    public Laudo(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getComentariosObservacoes() {
        return comentariosObservacoes;
    }

    public void setComentariosObservacoes(String comentariosObservacoes) {
        this.comentariosObservacoes = comentariosObservacoes;
    }

    public String getVersaoRoteiroAnalise() {
        return versaoRoteiroAnalise;
    }

    public void setVersaoRoteiroAnalise(String versaoRoteiroAnalise) {
        this.versaoRoteiroAnalise = versaoRoteiroAnalise;
    }

    public String getVersaoRoteiroAnaliseMesAno() {
        return versaoRoteiroAnaliseMesAno;
    }

    public void setVersaoRoteiroAnaliseMesAno(String versaoRoteiroAnaliseMesAno) {
        this.versaoRoteiroAnaliseMesAno = versaoRoteiroAnaliseMesAno;
    }

    public String getErPafEcfVersao() {
        return erPafEcfVersao;
    }

    public void setErPafEcfVersao(String erPafEcfVersao) {
        this.erPafEcfVersao = erPafEcfVersao;
    }

    public String getLocalEmissao() {
        return localEmissao;
    }

    public void setLocalEmissao(String localEmissao) {
        this.localEmissao = localEmissao;
    }

    public String getDataEmissao() {
        return dataEmissao;
    }

    public void setDataEmissao(String dataEmissao) {
        this.dataEmissao = dataEmissao;
    }

    public String getNomeTeste() {
        return nomeTeste;
    }

    public void setNomeTeste(String nomeTeste) {
        this.nomeTeste = nomeTeste;
    }

    public String getCargoTeste() {
        return cargoTeste;
    }

    public void setCargoTeste(String cargoTeste) {
        this.cargoTeste = cargoTeste;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNomeRelatorio() {
        return nomeRelatorio;
    }

    public void setNomeRelatorio(String nomeRelatorio) {
        this.nomeRelatorio = nomeRelatorio;
    }

    public String getCargoRelatorio() {
        return cargoRelatorio;
    }

    public void setCargoRelatorio(String cargoRelatorio) {
        this.cargoRelatorio = cargoRelatorio;
    }

    public String getCpfRelatorio() {
        return cpfRelatorio;
    }

    public void setCpfRelatorio(String cpfRelatorio) {
        this.cpfRelatorio = cpfRelatorio;
    }

    public Boolean getNaoConformidade() {
        return naoConformidade;
    }

    public void setNaoConformidade(Boolean naoConformidade) {
        this.naoConformidade = naoConformidade;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    @XmlTransient
    public List<EquipamentoEcfUtilizadoAnalise> getEquipamentoEcfUtilizadoAnaliseList() {
        return equipamentoEcfUtilizadoAnaliseList;
    }

    public void setEquipamentoEcfUtilizadoAnaliseList(List<EquipamentoEcfUtilizadoAnalise> equipamentoEcfUtilizadoAnaliseList) {
        this.equipamentoEcfUtilizadoAnaliseList = equipamentoEcfUtilizadoAnaliseList;
    }

    @XmlTransient
    public List<RelatorioNaoConformidade> getRelatorioNaoConformidadeList() {
        return relatorioNaoConformidadeList;
    }

    public void setRelatorioNaoConformidadeList(List<RelatorioNaoConformidade> relatorioNaoConformidadeList) {
        this.relatorioNaoConformidadeList = relatorioNaoConformidadeList;
    }

    public EmpresaRequerente getEmpresaRequerente() {
        return empresaRequerente;
    }

    public void setEmpresaRequerente(EmpresaRequerente empresaRequerente) {
        this.empresaRequerente = empresaRequerente;
    }

    public OrgaoTecnicoCredenciado getOrgaoTecnicoCredenciado() {
        return orgaoTecnicoCredenciado;
    }

    public void setOrgaoTecnicoCredenciado(OrgaoTecnicoCredenciado orgaoTecnicoCredenciado) {
        this.orgaoTecnicoCredenciado = orgaoTecnicoCredenciado;
    }

    public PafEcf getPafEcf() {
        return pafEcf;
    }

    public void setPafEcf(PafEcf pafEcf) {
        this.pafEcf = pafEcf;
    }

    public ParecerConclusivo getParecerConclusivo() {
        return parecerConclusivo;
    }

    public void setParecerConclusivo(ParecerConclusivo parecerConclusivo) {
        this.parecerConclusivo = parecerConclusivo;
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
        if (!(object instanceof Laudo)) {
            return false;
        }
        Laudo other = (Laudo) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.uft.homologadora.model.Laudo[ id=" + id + " ]";
    }
    
}
