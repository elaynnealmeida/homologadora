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
import javax.persistence.Lob;
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
@Table(name = "paf_ecf")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PafEcf.findAll", query = "SELECT p FROM PafEcf p")
    , @NamedQuery(name = "PafEcf.findById", query = "SELECT p FROM PafEcf p WHERE p.id = :id")
    , @NamedQuery(name = "PafEcf.findByNomeComercial", query = "SELECT p FROM PafEcf p WHERE p.nomeComercial = :nomeComercial")
    , @NamedQuery(name = "PafEcf.findByVersao", query = "SELECT p FROM PafEcf p WHERE p.versao = :versao")
    , @NamedQuery(name = "PafEcf.findByNomeDoPrincipalArqExecutavelMd5", query = "SELECT p FROM PafEcf p WHERE p.nomeDoPrincipalArqExecutavelMd5 = :nomeDoPrincipalArqExecutavelMd5")
    , @NamedQuery(name = "PafEcf.findByNomeDoPrincipalArqExecutavel", query = "SELECT p FROM PafEcf p WHERE p.nomeDoPrincipalArqExecutavel = :nomeDoPrincipalArqExecutavel")
    , @NamedQuery(name = "PafEcf.findByNomeArqComRelacaoArqsExecutaveisQRealizamProcedimentos", query = "SELECT p FROM PafEcf p WHERE p.nomeArqComRelacaoArqsExecutaveisQRealizamProcedimentos = :nomeArqComRelacaoArqsExecutaveisQRealizamProcedimentos")
    , @NamedQuery(name = "PafEcf.findByNomeArqComRelArqsExecutaveisQRealizamProcedimentosMd5", query = "SELECT p FROM PafEcf p WHERE p.nomeArqComRelArqsExecutaveisQRealizamProcedimentosMd5 = :nomeArqComRelArqsExecutaveisQRealizamProcedimentosMd5")
    , @NamedQuery(name = "PafEcf.findByLinguagemDeProgramacao", query = "SELECT p FROM PafEcf p WHERE p.linguagemDeProgramacao = :linguagemDeProgramacao")
    , @NamedQuery(name = "PafEcf.findBySistemaOperacional", query = "SELECT p FROM PafEcf p WHERE p.sistemaOperacional = :sistemaOperacional")
    , @NamedQuery(name = "PafEcf.findByGerenciadorBancoDados", query = "SELECT p FROM PafEcf p WHERE p.gerenciadorBancoDados = :gerenciadorBancoDados")
    , @NamedQuery(name = "PafEcf.findByTamanho", query = "SELECT p FROM PafEcf p WHERE p.tamanho = :tamanho")
    , @NamedQuery(name = "PafEcf.findByDataGeracao", query = "SELECT p FROM PafEcf p WHERE p.dataGeracao = :dataGeracao")
    , @NamedQuery(name = "PafEcf.findByNomeResponsavel", query = "SELECT p FROM PafEcf p WHERE p.nomeResponsavel = :nomeResponsavel")
    , @NamedQuery(name = "PafEcf.findByCpfResponsavel", query = "SELECT p FROM PafEcf p WHERE p.cpfResponsavel = :cpfResponsavel")
    , @NamedQuery(name = "PafEcf.findByRgResponsavel", query = "SELECT p FROM PafEcf p WHERE p.rgResponsavel = :rgResponsavel")})
public class PafEcf implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 2147483647)
    @Column(name = "nome_comercial")
    private String nomeComercial;
    @Size(max = 2147483647)
    @Column(name = "versao")
    private String versao;
    @Size(max = 2147483647)
    @Column(name = "nome_do_principal_arq_executavel_md5")
    private String nomeDoPrincipalArqExecutavelMd5;
    @Size(max = 2147483647)
    @Column(name = "nome_do_principal_arq_executavel")
    private String nomeDoPrincipalArqExecutavel;
    @Size(max = 2147483647)
    @Column(name = "nome_arq_com_relacao_arqs_executaveis_q_realizam_procedimentos_")
    private String nomeArqComRelacaoArqsExecutaveisQRealizamProcedimentos;
    @Size(max = 2147483647)
    @Column(name = "nome_arq_com_rel_arqs_executaveis_q_realizam_procedimentos_md5")
    private String nomeArqComRelArqsExecutaveisQRealizamProcedimentosMd5;
    @Size(max = 2147483647)
    @Column(name = "linguagem_de_programacao")
    private String linguagemDeProgramacao;
    @Size(max = 2147483647)
    @Column(name = "sistema_operacional")
    private String sistemaOperacional;
    @Size(max = 2147483647)
    @Column(name = "gerenciador_banco_dados")
    private String gerenciadorBancoDados;
    @Size(max = 2147483647)
    @Column(name = "tamanho")
    private String tamanho;
    @Size(max = 2147483647)
    @Column(name = "data_geracao")
    private String dataGeracao;
    @Lob
    @Column(name = "arq_com_rel_d_executaveis_q_realizam_proced_const")
    private byte[] arqComRelDExecutaveisQRealizamProcedConst;
    @Size(max = 2147483647)
    @Column(name = "nome_responsavel")
    private String nomeResponsavel;
    @Size(max = 2147483647)
    @Column(name = "cpf_responsavel")
    private String cpfResponsavel;
    @Size(max = 2147483647)
    @Column(name = "rg_responsavel")
    private String rgResponsavel;
    @OneToMany(mappedBy = "pafEcfId")
    private List<IsPedGeramNfIntegPaf> isPedGeramNfIntegPafList;
    @OneToMany(mappedBy = "pafEcfId")
    private List<EquipamentosEcfCompativeisPafEcf> equipamentosEcfCompativeisPafEcfList;
    @JoinColumn(name = "is_ped_geram_nf_integrados_id", referencedColumnName = "id")
    @ManyToOne
    private IsPedGeramNfIntegPaf isPedGeramNfIntegradosId;
    @JoinColumn(name = "is_ped_integrados_id", referencedColumnName = "id")
    @ManyToOne
    private IsPedIntegradosPaf isPedIntegradosId;
    @JoinColumn(name = "isgrepmra_id", referencedColumnName = "id")
    @ManyToOne
    private IsgrepmraPafEcf isgrepmraId;
    @OneToMany(mappedBy = "pafId")
    private List<PafFormaImpressao> pafFormaImpressaoList;
    @OneToMany(mappedBy = "pafEcfId")
    private List<IsPedIntegradosPaf> isPedIntegradosPafList;
    @OneToMany(mappedBy = "padEcfId")
    private List<PafEcfPerfis> pafEcfPerfisList;
    @OneToMany(mappedBy = "pafId")
    private List<PafAplicacoesEspeciais> pafAplicacoesEspeciaisList;
    @OneToMany(mappedBy = "pafEcfId")
    private List<PafTipoDesenvolvimento> pafTipoDesenvolvimentoList;
    @OneToMany(mappedBy = "pafId")
    private List<PafTratamentoInterrupcaoDecf> pafTratamentoInterrupcaoDecfList;
    @OneToMany(mappedBy = "pafId")
    private List<PafTpFuncionamento> pafTpFuncionamentoList;
    @OneToMany(mappedBy = "pafEcfId")
    private List<PafEcfArquivosExecutaveis> pafEcfArquivosExecutaveisList;
    @OneToMany(mappedBy = "pafId")
    private List<PafMeioGerarArqSintegra> pafMeioGerarArqSintegraList;
    @OneToMany(mappedBy = "pafEcf")
    private List<Laudo> laudoList;
    @OneToMany(mappedBy = "pafEcfId")
    private List<PafEcfOutrosArquivos> pafEcfOutrosArquivosList;
    @OneToMany(mappedBy = "pafId")
    private List<PafIntegracaoDoPaf> pafIntegracaoDoPafList;
    @OneToMany(mappedBy = "pafEcfId")
    private List<IsgrepmraPafEcf> isgrepmraPafEcfList;

    public PafEcf() {
    }

    public PafEcf(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNomeComercial() {
        return nomeComercial;
    }

    public void setNomeComercial(String nomeComercial) {
        this.nomeComercial = nomeComercial;
    }

    public String getVersao() {
        return versao;
    }

    public void setVersao(String versao) {
        this.versao = versao;
    }

    public String getNomeDoPrincipalArqExecutavelMd5() {
        return nomeDoPrincipalArqExecutavelMd5;
    }

    public void setNomeDoPrincipalArqExecutavelMd5(String nomeDoPrincipalArqExecutavelMd5) {
        this.nomeDoPrincipalArqExecutavelMd5 = nomeDoPrincipalArqExecutavelMd5;
    }

    public String getNomeDoPrincipalArqExecutavel() {
        return nomeDoPrincipalArqExecutavel;
    }

    public void setNomeDoPrincipalArqExecutavel(String nomeDoPrincipalArqExecutavel) {
        this.nomeDoPrincipalArqExecutavel = nomeDoPrincipalArqExecutavel;
    }

    public String getNomeArqComRelacaoArqsExecutaveisQRealizamProcedimentos() {
        return nomeArqComRelacaoArqsExecutaveisQRealizamProcedimentos;
    }

    public void setNomeArqComRelacaoArqsExecutaveisQRealizamProcedimentos(String nomeArqComRelacaoArqsExecutaveisQRealizamProcedimentos) {
        this.nomeArqComRelacaoArqsExecutaveisQRealizamProcedimentos = nomeArqComRelacaoArqsExecutaveisQRealizamProcedimentos;
    }

    public String getNomeArqComRelArqsExecutaveisQRealizamProcedimentosMd5() {
        return nomeArqComRelArqsExecutaveisQRealizamProcedimentosMd5;
    }

    public void setNomeArqComRelArqsExecutaveisQRealizamProcedimentosMd5(String nomeArqComRelArqsExecutaveisQRealizamProcedimentosMd5) {
        this.nomeArqComRelArqsExecutaveisQRealizamProcedimentosMd5 = nomeArqComRelArqsExecutaveisQRealizamProcedimentosMd5;
    }

    public String getLinguagemDeProgramacao() {
        return linguagemDeProgramacao;
    }

    public void setLinguagemDeProgramacao(String linguagemDeProgramacao) {
        this.linguagemDeProgramacao = linguagemDeProgramacao;
    }

    public String getSistemaOperacional() {
        return sistemaOperacional;
    }

    public void setSistemaOperacional(String sistemaOperacional) {
        this.sistemaOperacional = sistemaOperacional;
    }

    public String getGerenciadorBancoDados() {
        return gerenciadorBancoDados;
    }

    public void setGerenciadorBancoDados(String gerenciadorBancoDados) {
        this.gerenciadorBancoDados = gerenciadorBancoDados;
    }

    public String getTamanho() {
        return tamanho;
    }

    public void setTamanho(String tamanho) {
        this.tamanho = tamanho;
    }

    public String getDataGeracao() {
        return dataGeracao;
    }

    public void setDataGeracao(String dataGeracao) {
        this.dataGeracao = dataGeracao;
    }

    public byte[] getArqComRelDExecutaveisQRealizamProcedConst() {
        return arqComRelDExecutaveisQRealizamProcedConst;
    }

    public void setArqComRelDExecutaveisQRealizamProcedConst(byte[] arqComRelDExecutaveisQRealizamProcedConst) {
        this.arqComRelDExecutaveisQRealizamProcedConst = arqComRelDExecutaveisQRealizamProcedConst;
    }

    public String getNomeResponsavel() {
        return nomeResponsavel;
    }

    public void setNomeResponsavel(String nomeResponsavel) {
        this.nomeResponsavel = nomeResponsavel;
    }

    public String getCpfResponsavel() {
        return cpfResponsavel;
    }

    public void setCpfResponsavel(String cpfResponsavel) {
        this.cpfResponsavel = cpfResponsavel;
    }

    public String getRgResponsavel() {
        return rgResponsavel;
    }

    public void setRgResponsavel(String rgResponsavel) {
        this.rgResponsavel = rgResponsavel;
    }

    @XmlTransient
    public List<IsPedGeramNfIntegPaf> getIsPedGeramNfIntegPafList() {
        return isPedGeramNfIntegPafList;
    }

    public void setIsPedGeramNfIntegPafList(List<IsPedGeramNfIntegPaf> isPedGeramNfIntegPafList) {
        this.isPedGeramNfIntegPafList = isPedGeramNfIntegPafList;
    }

    @XmlTransient
    public List<EquipamentosEcfCompativeisPafEcf> getEquipamentosEcfCompativeisPafEcfList() {
        return equipamentosEcfCompativeisPafEcfList;
    }

    public void setEquipamentosEcfCompativeisPafEcfList(List<EquipamentosEcfCompativeisPafEcf> equipamentosEcfCompativeisPafEcfList) {
        this.equipamentosEcfCompativeisPafEcfList = equipamentosEcfCompativeisPafEcfList;
    }

    public IsPedGeramNfIntegPaf getIsPedGeramNfIntegradosId() {
        return isPedGeramNfIntegradosId;
    }

    public void setIsPedGeramNfIntegradosId(IsPedGeramNfIntegPaf isPedGeramNfIntegradosId) {
        this.isPedGeramNfIntegradosId = isPedGeramNfIntegradosId;
    }

    public IsPedIntegradosPaf getIsPedIntegradosId() {
        return isPedIntegradosId;
    }

    public void setIsPedIntegradosId(IsPedIntegradosPaf isPedIntegradosId) {
        this.isPedIntegradosId = isPedIntegradosId;
    }

    public IsgrepmraPafEcf getIsgrepmraId() {
        return isgrepmraId;
    }

    public void setIsgrepmraId(IsgrepmraPafEcf isgrepmraId) {
        this.isgrepmraId = isgrepmraId;
    }

    @XmlTransient
    public List<PafFormaImpressao> getPafFormaImpressaoList() {
        return pafFormaImpressaoList;
    }

    public void setPafFormaImpressaoList(List<PafFormaImpressao> pafFormaImpressaoList) {
        this.pafFormaImpressaoList = pafFormaImpressaoList;
    }

    @XmlTransient
    public List<IsPedIntegradosPaf> getIsPedIntegradosPafList() {
        return isPedIntegradosPafList;
    }

    public void setIsPedIntegradosPafList(List<IsPedIntegradosPaf> isPedIntegradosPafList) {
        this.isPedIntegradosPafList = isPedIntegradosPafList;
    }

    @XmlTransient
    public List<PafEcfPerfis> getPafEcfPerfisList() {
        return pafEcfPerfisList;
    }

    public void setPafEcfPerfisList(List<PafEcfPerfis> pafEcfPerfisList) {
        this.pafEcfPerfisList = pafEcfPerfisList;
    }

    @XmlTransient
    public List<PafAplicacoesEspeciais> getPafAplicacoesEspeciaisList() {
        return pafAplicacoesEspeciaisList;
    }

    public void setPafAplicacoesEspeciaisList(List<PafAplicacoesEspeciais> pafAplicacoesEspeciaisList) {
        this.pafAplicacoesEspeciaisList = pafAplicacoesEspeciaisList;
    }

    @XmlTransient
    public List<PafTipoDesenvolvimento> getPafTipoDesenvolvimentoList() {
        return pafTipoDesenvolvimentoList;
    }

    public void setPafTipoDesenvolvimentoList(List<PafTipoDesenvolvimento> pafTipoDesenvolvimentoList) {
        this.pafTipoDesenvolvimentoList = pafTipoDesenvolvimentoList;
    }

    @XmlTransient
    public List<PafTratamentoInterrupcaoDecf> getPafTratamentoInterrupcaoDecfList() {
        return pafTratamentoInterrupcaoDecfList;
    }

    public void setPafTratamentoInterrupcaoDecfList(List<PafTratamentoInterrupcaoDecf> pafTratamentoInterrupcaoDecfList) {
        this.pafTratamentoInterrupcaoDecfList = pafTratamentoInterrupcaoDecfList;
    }

    @XmlTransient
    public List<PafTpFuncionamento> getPafTpFuncionamentoList() {
        return pafTpFuncionamentoList;
    }

    public void setPafTpFuncionamentoList(List<PafTpFuncionamento> pafTpFuncionamentoList) {
        this.pafTpFuncionamentoList = pafTpFuncionamentoList;
    }

    @XmlTransient
    public List<PafEcfArquivosExecutaveis> getPafEcfArquivosExecutaveisList() {
        return pafEcfArquivosExecutaveisList;
    }

    public void setPafEcfArquivosExecutaveisList(List<PafEcfArquivosExecutaveis> pafEcfArquivosExecutaveisList) {
        this.pafEcfArquivosExecutaveisList = pafEcfArquivosExecutaveisList;
    }

    @XmlTransient
    public List<PafMeioGerarArqSintegra> getPafMeioGerarArqSintegraList() {
        return pafMeioGerarArqSintegraList;
    }

    public void setPafMeioGerarArqSintegraList(List<PafMeioGerarArqSintegra> pafMeioGerarArqSintegraList) {
        this.pafMeioGerarArqSintegraList = pafMeioGerarArqSintegraList;
    }

    @XmlTransient
    public List<Laudo> getLaudoList() {
        return laudoList;
    }

    public void setLaudoList(List<Laudo> laudoList) {
        this.laudoList = laudoList;
    }

    @XmlTransient
    public List<PafEcfOutrosArquivos> getPafEcfOutrosArquivosList() {
        return pafEcfOutrosArquivosList;
    }

    public void setPafEcfOutrosArquivosList(List<PafEcfOutrosArquivos> pafEcfOutrosArquivosList) {
        this.pafEcfOutrosArquivosList = pafEcfOutrosArquivosList;
    }

    @XmlTransient
    public List<PafIntegracaoDoPaf> getPafIntegracaoDoPafList() {
        return pafIntegracaoDoPafList;
    }

    public void setPafIntegracaoDoPafList(List<PafIntegracaoDoPaf> pafIntegracaoDoPafList) {
        this.pafIntegracaoDoPafList = pafIntegracaoDoPafList;
    }

    @XmlTransient
    public List<IsgrepmraPafEcf> getIsgrepmraPafEcfList() {
        return isgrepmraPafEcfList;
    }

    public void setIsgrepmraPafEcfList(List<IsgrepmraPafEcf> isgrepmraPafEcfList) {
        this.isgrepmraPafEcfList = isgrepmraPafEcfList;
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
        if (!(object instanceof PafEcf)) {
            return false;
        }
        PafEcf other = (PafEcf) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.uft.homologadora.model.PafEcf[ id=" + id + " ]";
    }
    
}
