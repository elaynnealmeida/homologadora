package br.com.uft.homologadora.controller;

import br.com.uft.homologadora.dao.AplicacoesEspeciaisDAO;
import br.com.uft.homologadora.dao.EquipamentosCompativeisDAO;
import br.com.uft.homologadora.dao.ImpressaoCupomFiscalDAO;
import br.com.uft.homologadora.dao.IntegracaoPafDAO;
import br.com.uft.homologadora.dao.MeioGeracaoArqSintegraDAO;
import br.com.uft.homologadora.dao.PafEcfDAO;
import br.com.uft.homologadora.dao.TipoDesenvolvimentoDAO;
import br.com.uft.homologadora.dao.TipoFuncionamentoDAO;
import br.com.uft.homologadora.dao.TratamentoInterrupcaoCupomFiscalDAO;
import br.com.uft.homologadora.model.AplicacoesEspeciais;
import br.com.uft.homologadora.model.EquipamentosEcfCompativeisPafEcf;
import br.com.uft.homologadora.model.ImpressaoCupomFiscal;
import br.com.uft.homologadora.model.IntegracaoPaf;
import br.com.uft.homologadora.model.MeioGeracaoArqSintegra;
import br.com.uft.homologadora.model.PafEcf;
import br.com.uft.homologadora.model.TipoDesenvolvimento;
import br.com.uft.homologadora.model.TipoFuncionamento;
import br.com.uft.homologadora.model.TratamentoInterrupcaoCupomFiscal;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.servlet.http.HttpServletRequest;
import org.apache.commons.io.IOUtils;
import org.primefaces.event.SelectEvent;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;
import org.primefaces.model.UploadedFile;

/**
 *
 * @author UFT
 */
@ManagedBean
@ViewScoped
public class PafEcfController implements Serializable {

    private PafEcf instancia;
    private PafEcfDAO dao;
    private List<PafEcf> instancias;
    private List<PafEcf> instanciasFiltradas;
    private boolean isEdit;
    private UploadedFile file;
    private EquipamentosEcfCompativeisPafEcf equipamentosCompativeis;
    private List<EquipamentosEcfCompativeisPafEcf> equipamentos;
    private List<EquipamentosEcfCompativeisPafEcf> equipamentosRemover;
    private List<TipoDesenvolvimento> selectedTpDesenvolvimento;
    private List<SelectItem> TpDesenvolvimento;
    private TipoDesenvolvimentoDAO TpDesenvolvimentoDao;
    private List<MeioGeracaoArqSintegra> selectedMeioGeracaoArqSintegra;
    private List<SelectItem> meioGeracaoArqSintegra;
    private MeioGeracaoArqSintegraDAO meioGeracaoArqSintegraDao;
    private List<IntegracaoPaf> selectedIntegracaoPaf;
    private List<SelectItem> integracaoPaf;
    private IntegracaoPafDAO integracaoPafDao;
    private List<ImpressaoCupomFiscal> selectedImpressaoCupomFiscal;
    private List<SelectItem> impressaoCupomFiscal;
    private ImpressaoCupomFiscalDAO impressaoCupomFiscalDao;
    private List<TratamentoInterrupcaoCupomFiscal> selectedTratamentoInterrupcaoCupomFiscal;
    private List<SelectItem> tratamentoInterrupcaoCupomFiscal;
    private TratamentoInterrupcaoCupomFiscalDAO tratamentoInterrupcaoCupomFiscalDao;
    private List<AplicacoesEspeciais> selectedAplicacoesEspeciais;
    private List<SelectItem> aplicacoesEspeciais;
    private AplicacoesEspeciaisDAO aplicacoesEspeciaisDao;
    private List<TipoFuncionamento> selectedTpFuncionamento;
    private List<SelectItem> tpFuncionamento;
    private TipoFuncionamentoDAO tpFuncionamentoDao;

    @PostConstruct
    public void init() {
        this.instancia = new PafEcf();
        this.dao = new PafEcfDAO();
        this.isEdit = false;
        this.file = null;
        //equipamentos
        this.equipamentosCompativeis = new EquipamentosEcfCompativeisPafEcf();
        this.equipamentos = new ArrayList<EquipamentosEcfCompativeisPafEcf>();
        this.equipamentosRemover = new ArrayList<EquipamentosEcfCompativeisPafEcf>();
        //tipo de desenvolvimento
        this.TpDesenvolvimentoDao = new TipoDesenvolvimentoDAO();
        this.TpDesenvolvimento = listarTpDesenvolvimento();
        this.selectedTpDesenvolvimento = new ArrayList<TipoDesenvolvimento>();
        //meio de geração de arquivo sintegra ou efd (sped)
        this.meioGeracaoArqSintegraDao = new MeioGeracaoArqSintegraDAO();
        this.meioGeracaoArqSintegra = listarMeioGeracaoArqSintegra();
        this.selectedMeioGeracaoArqSintegra = new ArrayList<MeioGeracaoArqSintegra>();
        //Integraçao do programa aplicativo fiscal
        this.integracaoPafDao = new IntegracaoPafDAO();
        this.integracaoPaf = listarIntegracaoPaf();
        this.selectedIntegracaoPaf = new ArrayList<IntegracaoPaf>();
        //Formas de Impressão de Item em Cupom Fiscal
        this.impressaoCupomFiscalDao = new ImpressaoCupomFiscalDAO();
        this.impressaoCupomFiscal = listarImpressaoCupomFiscal();
        this.selectedImpressaoCupomFiscal = new ArrayList<ImpressaoCupomFiscal>();

        //Tratamento da Interrupção Durante a Emissão de Cupom Fiscal
        this.tratamentoInterrupcaoCupomFiscalDao = new TratamentoInterrupcaoCupomFiscalDAO();
        this.tratamentoInterrupcaoCupomFiscal = listarTratamentoInterrupcaoCupomFiscal();
        this.selectedTratamentoInterrupcaoCupomFiscal = new ArrayList<TratamentoInterrupcaoCupomFiscal>();

        //Aplicações Especiais
        this.aplicacoesEspeciaisDao = new AplicacoesEspeciaisDAO();
        this.aplicacoesEspeciais = listarAplicacoesEspeciais();
        this.selectedAplicacoesEspeciais = new ArrayList<AplicacoesEspeciais>();
        
        //Tipo de Funcionamento
        this.tpFuncionamentoDao = new TipoFuncionamentoDAO();
        this.tpFuncionamento = listarTpFuncionamento();
        this.selectedTpFuncionamento = new ArrayList<TipoFuncionamento>();

        listar();
    }

    public void limpar() {
        this.instancia = new PafEcf();
        this.isEdit = false;
        this.file = null;
        this.instancias = listar();

        this.equipamentosCompativeis = new EquipamentosEcfCompativeisPafEcf();
        this.equipamentos = new ArrayList<EquipamentosEcfCompativeisPafEcf>();
        this.equipamentosRemover = new ArrayList<EquipamentosEcfCompativeisPafEcf>();

        this.selectedTpDesenvolvimento = new ArrayList<TipoDesenvolvimento>();

        this.selectedMeioGeracaoArqSintegra = new ArrayList<MeioGeracaoArqSintegra>();

        this.selectedIntegracaoPaf = new ArrayList<IntegracaoPaf>();

        this.selectedImpressaoCupomFiscal = new ArrayList<ImpressaoCupomFiscal>();

        this.selectedTratamentoInterrupcaoCupomFiscal = new ArrayList<TratamentoInterrupcaoCupomFiscal>();

        this.selectedAplicacoesEspeciais = new ArrayList<AplicacoesEspeciais>();
        
        this.selectedTpFuncionamento = new ArrayList<TipoFuncionamento>();
    }

    public void limparResponsavel() {
        this.instancia.setCpfResponsavel(null);
        this.instancia.setRgResponsavel(null);
        this.instancia.setNomeResponsavel(null);
    }

    public void limparEquipamento() {
        this.equipamentosCompativeis.setMarca(null);
        this.equipamentosCompativeis.setModelo(null);
    }

    public void limparTpDesenvolvimento() {
        this.selectedTpDesenvolvimento = new ArrayList<TipoDesenvolvimento>();
    }

    public void limparMeioGeracaoArqSintegra() {
        this.selectedMeioGeracaoArqSintegra = new ArrayList<MeioGeracaoArqSintegra>();
    }

    public void limparIntegracaoPaf() {
        this.selectedIntegracaoPaf = new ArrayList<IntegracaoPaf>();
    }

    public void limparImpressaoCupomFiscal() {
        this.selectedImpressaoCupomFiscal = new ArrayList<ImpressaoCupomFiscal>();
    }

    public void limparTratamentoInterrupcaoCupomFiscal() {
        this.selectedTratamentoInterrupcaoCupomFiscal = new ArrayList<TratamentoInterrupcaoCupomFiscal>();
    }

    public void limparAplicacoesEspeciais() {
        this.selectedAplicacoesEspeciais = new ArrayList<AplicacoesEspeciais>();
    }
    
    public void limparTpFuncionamento() {
        this.selectedTpFuncionamento = new ArrayList<TipoFuncionamento>();
    }

    public void salvar() {
        try {
            System.out.println("Entrou no salvar: ");
            FacesContext context = FacesContext.getCurrentInstance();
            HttpServletRequest request = (HttpServletRequest) context.getExternalContext().getRequest();
            //instancia.set((TbUsersystem) request.getSession().getAttribute("user"));
            gravaImagem();
            if (instancia.getArqComRelDExecutaveisQRealizamProcedConst() != null) {
                dao.salvar(instancia);
                //limpar();
                FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Inserido com Sucesso!", null);
                FacesContext.getCurrentInstance().addMessage(null, message);
            }

        } catch (Exception e) {
            limpar();
            System.out.println("ERRO: " + e.getMessage());
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro ao tentar inserir!", null);
            FacesContext.getCurrentInstance().addMessage(null, message);
        }

    }

    public void atualizar() {
        try {
            if (!file.getFileName().isEmpty()) {
                System.out.println("entrou no arq vazio ");
                instancia.setArqComRelDExecutaveisQRealizamProcedConst(null);
                gravaImagem();
            }
            //atualizaEquipamento();
            //instancia.setEquipamentosEcfCompativeisPafEcfList(equipamentos);
            dao.atualizar(instancia);
            FacesMessage msg = new FacesMessage("Atualizado com Sucesso!");
            FacesContext.getCurrentInstance().addMessage(null, msg);
            //limpar();
        } catch (Exception e) {
            System.out.println("Erro: " + e);
            limpar();
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro ao tentar editar!", null);
            FacesContext.getCurrentInstance().addMessage(null, message);
        }
    }

    public void deletar() {
        System.out.println("entoru no deletar: ");
        try {
            System.out.println("entoru no deletar: ");
            dao.deletar(instancia);
            FacesMessage msg = new FacesMessage("Excluido com Sucesso!");
            FacesContext.getCurrentInstance().addMessage(null, msg);
            limpar();

        } catch (Exception e) {
            System.out.println("Erro: " + e);
            limpar();
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro ao tentar excluir!", null);
            FacesContext.getCurrentInstance().addMessage(null, message);
        }
    }

    public List<PafEcf> listar() {
        this.instancias = dao.listarTodos();
        return this.instancias;
    }

    public void onRowSelect(SelectEvent event) {
        this.instancia = ((PafEcf) event.getObject());
        this.equipamentos.addAll(this.instancia.getEquipamentosEcfCompativeisPafEcfList());
        this.selectedTpDesenvolvimento.addAll(this.instancia.getPafTipoDesenvolvimentoList());
        this.selectedMeioGeracaoArqSintegra.addAll(this.instancia.getPafMeioGerarArqSintegraList());
        this.selectedIntegracaoPaf.addAll(this.instancia.getPafIntegracaoDoPafList());
        this.selectedImpressaoCupomFiscal.addAll(this.instancia.getPafFormaImpressaoList());
        this.selectedTratamentoInterrupcaoCupomFiscal.addAll(this.instancia.getPafTratamentoInterrupcaoDecfList());
        this.selectedAplicacoesEspeciais.addAll(this.instancia.getPafAplicacoesEspeciaisList());
        this.selectedTpFuncionamento.addAll(this.instancia.getPafTpFuncionamentoList());
        this.isEdit = true;
    }

    public void gravaImagem() {
        if (file != null) {
            System.out.println("file!=null");
            try {
                byte[] bytes = IOUtils.toByteArray(file.getInputstream());
                instancia.setArqComRelDExecutaveisQRealizamProcedConst(bytes);

            } catch (Exception ex) {
                // System.out.println("arquivo: " + ex);
                ex.printStackTrace();
            }
        } else {
            System.out.println("nao setou o file, file==null");
        }

    }

    public StreamedContent download(PafEcf doc) {
        InputStream stream = new ByteArrayInputStream(doc.getArqComRelDExecutaveisQRealizamProcedConst());
        StreamedContent file1 = null;
        file1 = new DefaultStreamedContent(stream, "application/pdf", doc.getNomeComercial());

        return (StreamedContent) file1;
    }

    // Equipamentos
    public void addEquipamento() {
        System.out.println("equipamento: " + equipamentosCompativeis.getMarca());
        equipamentosCompativeis.setPafEcfId(instancia);
        this.equipamentos.add(equipamentosCompativeis);
        System.out.println("equipamento: " + equipamentos);
        this.equipamentosCompativeis = new EquipamentosEcfCompativeisPafEcf();
    }

    public void removeEquipamento(EquipamentosEcfCompativeisPafEcf e) {
        System.out.println("Excluido: " + e);
        this.equipamentos.remove(e);
        if (e.getId() != null) {
            this.equipamentosRemover.add(e);
        }
        this.equipamentosCompativeis = new EquipamentosEcfCompativeisPafEcf();
    }

    public void editaEquipamento(EquipamentosEcfCompativeisPafEcf e) {
        System.out.println("equipamentos1 " + equipamentos);
        this.equipamentosCompativeis = e;
        this.equipamentos.remove(e);
        System.out.println("equipamentos2 " + equipamentos);
    }

    public void atualizaEquipamento() {
        System.out.println("Entrou no att equipamento ");
        System.out.println("instancia: " + instancia.getId());
        EquipamentosCompativeisDAO hDao = new EquipamentosCompativeisDAO();

        if (!this.equipamentosRemover.isEmpty()) {
            for (int i = 0; i < this.equipamentosRemover.size(); i++) {
                hDao.deletar(this.equipamentosRemover.get(i));
            }
        }
        if (instancia.getEquipamentosEcfCompativeisPafEcfList() != equipamentos) {
            for (int i = 0; i < this.equipamentos.size(); i++) {
                if (this.equipamentos.get(i).getId() != null) {
                    hDao.atualizar(this.equipamentos.get(i));
                } else {
                    System.out.println("Entrou no equipamento novo ");
                    equipamentosCompativeis.setPafEcfId(instancia);
                    hDao.salvar(this.equipamentos.get(i));
                }
            }
        }
        limparEquipamento();
        this.equipamentos = new ArrayList<EquipamentosEcfCompativeisPafEcf>();
        this.equipamentosRemover = new ArrayList<EquipamentosEcfCompativeisPafEcf>();
    }

    //Tipo desenvolvimento
    public List<SelectItem> listarTpDesenvolvimento() {
        //System.out.println("entrou no listarTpDesenvolvimento: ");
        List<SelectItem> toReturn = new ArrayList<SelectItem>();
        List<TipoDesenvolvimento> result = new ArrayList<TipoDesenvolvimento>();
        result = TpDesenvolvimentoDao.listarTodos();
        for (int i = 0; i < result.size(); i++) {
            System.out.println("result: "+result.get(i).getDescricao());
            toReturn.add(new SelectItem(result.get(i), result.get(i).getDescricao()));
        }
        return toReturn;
    }

    public void salvarTpDesenvolvimento() {
        instancia.setPafTipoDesenvolvimentoList(selectedTpDesenvolvimento);
        dao.atualizar(instancia);
    }

    //meio de geração de arquivo sintegra ou efd (sped)
    public List<SelectItem> listarMeioGeracaoArqSintegra() {
        //System.out.println("entrou no listar tags: ");
        List<SelectItem> toReturn = new ArrayList<SelectItem>();
        List<MeioGeracaoArqSintegra> result = new ArrayList<MeioGeracaoArqSintegra>();
        result = meioGeracaoArqSintegraDao.listarTodos();
        for (int i = 0; i < result.size(); i++) {
            toReturn.add(new SelectItem(result.get(i), result.get(i).getDescricao()));
        }
        return toReturn;
    }

    public void salvarMeioGeracaoArqSintegra() {
        instancia.setPafMeioGerarArqSintegraList(selectedMeioGeracaoArqSintegra);
        dao.atualizar(instancia);
    }

    //Integraçao do programa aplicativo fiscal
    public List<SelectItem> listarIntegracaoPaf() {
        //System.out.println("entrou no listar tags: ");
        List<SelectItem> toReturn = new ArrayList<SelectItem>();
        List<IntegracaoPaf> result = new ArrayList<IntegracaoPaf>();
        result = integracaoPafDao.listarTodos();
        for (int i = 0; i < result.size(); i++) {
            toReturn.add(new SelectItem(result.get(i), result.get(i).getDescricao()));
        }
        return toReturn;
    }

    public void salvarIntegracaoPaf() {
        instancia.setPafIntegracaoDoPafList(selectedIntegracaoPaf);
        dao.atualizar(instancia);
    }

    //Formas de Impressão de Item em Cupom Fiscal        
    public List<SelectItem> listarImpressaoCupomFiscal() {
        //System.out.println("entrou no listar tags: ");
        List<SelectItem> toReturn = new ArrayList<SelectItem>();
        List<ImpressaoCupomFiscal> result = new ArrayList<ImpressaoCupomFiscal>();
        result = impressaoCupomFiscalDao.listarTodos();
        for (int i = 0; i < result.size(); i++) {
            toReturn.add(new SelectItem(result.get(i), result.get(i).getDescricao()));
        }
        return toReturn;
    }

    public void salvarImpressaoCupomFiscal() {
        instancia.setPafFormaImpressaoList(selectedImpressaoCupomFiscal);
        dao.atualizar(instancia);
    }

    //Tratamento da Interrupção Durante a Emissão de Cupom Fiscal  
    public List<SelectItem> listarTratamentoInterrupcaoCupomFiscal() {
        //System.out.println("entrou no listar tags: ");
        List<SelectItem> toReturn = new ArrayList<SelectItem>();
        List<TratamentoInterrupcaoCupomFiscal> result = new ArrayList<TratamentoInterrupcaoCupomFiscal>();
        result = tratamentoInterrupcaoCupomFiscalDao.listarTodos();
        for (int i = 0; i < result.size(); i++) {
            toReturn.add(new SelectItem(result.get(i), result.get(i).getDescricao()));
        }
        return toReturn;
    }

    public void salvarTratamentoInterrupcaoCupomFiscal() {
        instancia.setPafTratamentoInterrupcaoDecfList(selectedTratamentoInterrupcaoCupomFiscal);
        dao.atualizar(instancia);
    }

    //Aplicações Especiais
    public List<SelectItem> listarAplicacoesEspeciais() {
        //System.out.println("entrou no listar tags: ");
        List<SelectItem> toReturn = new ArrayList<SelectItem>();
        List<AplicacoesEspeciais> result = new ArrayList<AplicacoesEspeciais>();
        result = aplicacoesEspeciaisDao.listarTodos();
        for (int i = 0; i < result.size(); i++) {
            toReturn.add(new SelectItem(result.get(i), result.get(i).getDescricao()));
        }
        return toReturn;
    }

    public void salvarAplicacoesEspeciais() {
        instancia.setPafAplicacoesEspeciaisList(selectedAplicacoesEspeciais);
        dao.atualizar(instancia);
    }

    //Tipo de Funcionamento
    public List<SelectItem> listarTpFuncionamento() {
        //System.out.println("entrou no listar tags: ");
        List<SelectItem> toReturn = new ArrayList<SelectItem>();
        List<TipoFuncionamento> result = new ArrayList<TipoFuncionamento>();
        result = tpFuncionamentoDao.listarTodos();
        for (int i = 0; i < result.size(); i++) {
            toReturn.add(new SelectItem(result.get(i), result.get(i).getDescricao()));
        }
        return toReturn;
    }

    public void salvarTpFuncionamento() {
        instancia.setPafTpFuncionamentoList(selectedTpFuncionamento);
        dao.atualizar(instancia);
    }
    public PafEcf getInstancia() {
        return instancia;
    }

    public void setInstancia(PafEcf instancia) {
        this.instancia = instancia;
    }

    public List<PafEcf> getInstancias() {
        return instancias;
    }

    public void setInstancias(List<PafEcf> instancias) {
        this.instancias = instancias;
    }

    public List<PafEcf> getInstanciasFiltradas() {
        return instanciasFiltradas;
    }

    public void setInstanciasFiltradas(List<PafEcf> instanciasFiltradas) {
        this.instanciasFiltradas = instanciasFiltradas;
    }

    public boolean isIsEdit() {
        return isEdit;
    }

    public void setIsEdit(boolean isEdit) {
        this.isEdit = isEdit;
    }

    public UploadedFile getFile() {
        return file;
    }

    public void setFile(UploadedFile file) {
        this.file = file;
    }

    public EquipamentosEcfCompativeisPafEcf getEquipamentosCompativeis() {
        return equipamentosCompativeis;
    }

    public void setEquipamentosCompativeis(EquipamentosEcfCompativeisPafEcf equipamentosCompativeis) {
        this.equipamentosCompativeis = equipamentosCompativeis;
    }

    public List<EquipamentosEcfCompativeisPafEcf> getEquipamentos() {
        return equipamentos;
    }

    public void setEquipamentos(List<EquipamentosEcfCompativeisPafEcf> equipamentos) {
        this.equipamentos = equipamentos;
    }

    public List<EquipamentosEcfCompativeisPafEcf> getEquipamentosRemover() {
        return equipamentosRemover;
    }

    public void setEquipamentosRemover(List<EquipamentosEcfCompativeisPafEcf> equipamentosRemover) {
        this.equipamentosRemover = equipamentosRemover;
    }

    public List<TipoDesenvolvimento> getSelectedTpDesenvolvimento() {
        return selectedTpDesenvolvimento;
    }

    public void setSelectedTpDesenvolvimento(List<TipoDesenvolvimento> selectedTpDesenvolvimento) {
        this.selectedTpDesenvolvimento = selectedTpDesenvolvimento;
    }

    public List<SelectItem> getTpDesenvolvimento() {
        return TpDesenvolvimento;
    }

    public void setTpDesenvolvimento(List<SelectItem> TpDesenvolvimento) {
        this.TpDesenvolvimento = TpDesenvolvimento;
    }

    public List<MeioGeracaoArqSintegra> getSelectedMeioGeracaoArqSintegra() {
        return selectedMeioGeracaoArqSintegra;
    }

    public void setSelectedMeioGeracaoArqSintegra(List<MeioGeracaoArqSintegra> selectedMeioGeracaoArqSintegra) {
        this.selectedMeioGeracaoArqSintegra = selectedMeioGeracaoArqSintegra;
    }

    public List<SelectItem> getMeioGeracaoArqSintegra() {
        return meioGeracaoArqSintegra;
    }

    public void setMeioGeracaoArqSintegra(List<SelectItem> meioGeracaoArqSintegra) {
        this.meioGeracaoArqSintegra = meioGeracaoArqSintegra;
    }

    public List<IntegracaoPaf> getSelectedIntegracaoPaf() {
        return selectedIntegracaoPaf;
    }

    public void setSelectedIntegracaoPaf(List<IntegracaoPaf> selectedIntegracaoPaf) {
        this.selectedIntegracaoPaf = selectedIntegracaoPaf;
    }

    public List<SelectItem> getIntegracaoPaf() {
        return integracaoPaf;
    }

    public void setIntegracaoPaf(List<SelectItem> integracaoPaf) {
        this.integracaoPaf = integracaoPaf;
    }

    public List<ImpressaoCupomFiscal> getSelectedImpressaoCupomFiscal() {
        return selectedImpressaoCupomFiscal;
    }

    public void setSelectedImpressaoCupomFiscal(List<ImpressaoCupomFiscal> selectedImpressaoCupomFiscal) {
        this.selectedImpressaoCupomFiscal = selectedImpressaoCupomFiscal;
    }

    public List<SelectItem> getImpressaoCupomFiscal() {
        return impressaoCupomFiscal;
    }

    public void setImpressaoCupomFiscal(List<SelectItem> impressaoCupomFiscal) {
        this.impressaoCupomFiscal = impressaoCupomFiscal;
    }

    public List<TratamentoInterrupcaoCupomFiscal> getSelectedTratamentoInterrupcaoCupomFiscal() {
        return selectedTratamentoInterrupcaoCupomFiscal;
    }

    public void setSelectedTratamentoInterrupcaoCupomFiscal(List<TratamentoInterrupcaoCupomFiscal> selectedTratamentoInterrupcaoCupomFiscal) {
        this.selectedTratamentoInterrupcaoCupomFiscal = selectedTratamentoInterrupcaoCupomFiscal;
    }

    public List<SelectItem> getTratamentoInterrupcaoCupomFiscal() {
        return tratamentoInterrupcaoCupomFiscal;
    }

    public void setTratamentoInterrupcaoCupomFiscal(List<SelectItem> tratamentoInterrupcaoCupomFiscal) {
        this.tratamentoInterrupcaoCupomFiscal = tratamentoInterrupcaoCupomFiscal;
    }

    public List<AplicacoesEspeciais> getSelectedAplicacoesEspeciais() {
        return selectedAplicacoesEspeciais;
    }

    public void setSelectedAplicacoesEspeciais(List<AplicacoesEspeciais> selectedAplicacoesEspeciais) {
        this.selectedAplicacoesEspeciais = selectedAplicacoesEspeciais;
    }

    public List<SelectItem> getAplicacoesEspeciais() {
        return aplicacoesEspeciais;
    }

    public void setAplicacoesEspeciais(List<SelectItem> aplicacoesEspeciais) {
        this.aplicacoesEspeciais = aplicacoesEspeciais;
    }

    public List<TipoFuncionamento> getSelectedTpFuncionamento() {
        return selectedTpFuncionamento;
    }

    public void setSelectedTpFuncionamento(List<TipoFuncionamento> selectedTpFuncionamento) {
        this.selectedTpFuncionamento = selectedTpFuncionamento;
    }

    public List<SelectItem> getTpFuncionamento() {
        return tpFuncionamento;
    }

    public void setTpFuncionamento(List<SelectItem> tpFuncionamento) {
        this.tpFuncionamento = tpFuncionamento;
    }

}
