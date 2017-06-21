
package br.com.uft.homologadora.controller;


import br.com.uft.homologadora.dao.IntegracaoPafDAO;
import br.com.uft.homologadora.model.IntegracaoPaf;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import org.primefaces.event.SelectEvent;

/**
 *
 * @author UFT
 */
@ManagedBean
@ViewScoped
public class IntegracaoPafController implements Serializable {

    private IntegracaoPaf instancia;
    private IntegracaoPafDAO dao;
    private List<IntegracaoPaf> instancias;
    private List<IntegracaoPaf> instanciasFiltradas;
    private boolean isEdit;

    @PostConstruct
    public void init() {
        this.instancia = new IntegracaoPaf();
        this.dao = new IntegracaoPafDAO();
        this.isEdit = false;
        listar();
    }

    public void limpar() {
        this.instancia = new IntegracaoPaf();
        this.isEdit = false;
        this.instancias = listar();
    }

    public void salvar() {
        try {
            dao.salvar(instancia);
            limpar();
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Inserido com Sucesso!", null);
            FacesContext.getCurrentInstance().addMessage(null, message);
        } catch (Exception e) {
            limpar();
            System.out.println("ERRO: " + e.getMessage());
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro ao tentar inserir!", null);
            FacesContext.getCurrentInstance().addMessage(null, message);
        }

    }

    public void atualizar() {
        try {
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
    public List<IntegracaoPaf> listar() {
        this.instancias = dao.listarTodos();
        return this.instancias;
    }

    public void onRowSelect(SelectEvent event) {
        this.instancia = ((IntegracaoPaf) event.getObject());
        this.isEdit = true;
    }

    public IntegracaoPaf getInstancia() {
        return instancia;
    }

    public void setInstancia(IntegracaoPaf instancia) {
        this.instancia = instancia;
    }

    public List<IntegracaoPaf> getInstancias() {
        return instancias;
    }

    public void setInstancias(List<IntegracaoPaf> instancias) {
        this.instancias = instancias;
    }

    public List<IntegracaoPaf> getInstanciasFiltradas() {
        return instanciasFiltradas;
    }

    public void setInstanciasFiltradas(List<IntegracaoPaf> instanciasFiltradas) {
        this.instanciasFiltradas = instanciasFiltradas;
    }

    public boolean isIsEdit() {
        return isEdit;
    }

    public void setIsEdit(boolean isEdit) {
        this.isEdit = isEdit;
    }
    
    
}
