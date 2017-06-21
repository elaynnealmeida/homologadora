package br.com.uft.homologadora.controller;

import br.com.uft.homologadora.dao.PafEcfDAO;
import br.com.uft.homologadora.model.PafEcf;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import org.apache.commons.io.IOUtils;
import org.primefaces.event.SelectEvent;
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

    @PostConstruct
    public void init() {
        this.instancia = new PafEcf();
        this.dao = new PafEcfDAO();
        this.isEdit = false;
        this.file = null;
        listar();
    }

    public void limpar() {
        this.instancia = new PafEcf();
        this.isEdit = false;
        this.file = null;
        this.instancias = listar();
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
                limpar();
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
            dao.atualizar(instancia);
            FacesMessage msg = new FacesMessage("Atualizado com Sucesso!");
            FacesContext.getCurrentInstance().addMessage(null, msg);
            limpar();
        } catch (Exception e) {
            limpar();
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro ao tentar editar!", null);
            FacesContext.getCurrentInstance().addMessage(null, message);
        }
    }

    public void deletar() {
        try {
            dao.deletar(instancia);
            FacesMessage msg = new FacesMessage("Excluido com Sucesso!");
            FacesContext.getCurrentInstance().addMessage(null, msg);
            limpar();

        } catch (Exception e) {
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
    
    

}
