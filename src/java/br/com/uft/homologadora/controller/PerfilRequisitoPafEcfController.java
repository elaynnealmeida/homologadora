
package br.com.uft.homologadora.controller;

import br.com.uft.homologadora.dao.EstadoDAO;
import br.com.uft.homologadora.dao.PerfilRequisitoPafEcfDAO;
import br.com.uft.homologadora.model.Estado;
import br.com.uft.homologadora.model.PerfilRequisitoPafEcf;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import org.primefaces.event.SelectEvent;

/**
 *
 * @author UFT
 */
@ManagedBean
@ViewScoped
public class PerfilRequisitoPafEcfController implements Serializable {

    private PerfilRequisitoPafEcf instancia;
    private PerfilRequisitoPafEcfDAO dao;
    private List<PerfilRequisitoPafEcf> instancias;
    private List<PerfilRequisitoPafEcf> instanciasFiltradas;
    private boolean isEdit;

    @PostConstruct
    public void init() {
        this.instancia = new PerfilRequisitoPafEcf();
        this.dao = new PerfilRequisitoPafEcfDAO();
        this.isEdit = false;
        listar();
    }

    public void limpar() {
        this.instancia = new PerfilRequisitoPafEcf();
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
    public List<PerfilRequisitoPafEcf> listar() {
        this.instancias = dao.listarTodos();
        return this.instancias;
    }

    public void onRowSelect(SelectEvent event) {
        this.instancia = ((PerfilRequisitoPafEcf) event.getObject());
        this.isEdit = true;
    }
    
    public List<SelectItem> getEstado() {
        System.out.println("entrou no listar estados: ");
        List<SelectItem> toReturn = new ArrayList<SelectItem>();
        EstadoDAO tpdDao = new EstadoDAO();
        List<Estado> result = new ArrayList<Estado>();
        result = tpdDao.listarTodos();
        for (int i = 0; i < result.size(); i++) {
            toReturn.add(new SelectItem(result.get(i), result.get(i).getSigla()));
            //System.out.println("perfil: " + result.get(i).toString());
        }
        return toReturn;
    }

    public PerfilRequisitoPafEcf getInstancia() {
        return instancia;
    }

    public void setInstancia(PerfilRequisitoPafEcf instancia) {
        this.instancia = instancia;
    }

    public List<PerfilRequisitoPafEcf> getInstancias() {
        return instancias;
    }

    public void setInstancias(List<PerfilRequisitoPafEcf> instancias) {
        this.instancias = instancias;
    }

    public List<PerfilRequisitoPafEcf> getInstanciasFiltradas() {
        return instanciasFiltradas;
    }

    public void setInstanciasFiltradas(List<PerfilRequisitoPafEcf> instanciasFiltradas) {
        this.instanciasFiltradas = instanciasFiltradas;
    }

    public boolean isIsEdit() {
        return isEdit;
    }

    public void setIsEdit(boolean isEdit) {
        this.isEdit = isEdit;
    }
    
}
