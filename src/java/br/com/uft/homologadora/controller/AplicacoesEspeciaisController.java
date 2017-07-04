/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.uft.homologadora.controller;

import br.com.uft.homologadora.dao.AplicacoesEspeciaisDAO;
import br.com.uft.homologadora.model.AplicacoesEspeciais;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import org.primefaces.event.SelectEvent;

@ManagedBean
@ViewScoped
public class AplicacoesEspeciaisController implements Serializable {
    
    private AplicacoesEspeciais instancia;
    private AplicacoesEspeciaisDAO dao;
    private List<AplicacoesEspeciais> instancias;
    private List<AplicacoesEspeciais> instanciasFiltradas;
    private boolean isEdit;
    
    @PostConstruct
    public void init() {
        this.instancia = new AplicacoesEspeciais();
        this.dao = new AplicacoesEspeciaisDAO();
        this.isEdit = false;
        listar();
    }
    
    public void limpar() {
        this.instancia = new AplicacoesEspeciais();
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
    
    public List<AplicacoesEspeciais> listar() {
        this.instancias = dao.listarTodos();
        return this.instancias;
    }
    
    public void onRowSelect(SelectEvent event) {
        this.instancia = ((AplicacoesEspeciais) event.getObject());
        this.isEdit = true;
    }
    
    public AplicacoesEspeciais getInstancia() {
        return instancia;
    }

    public void setInstancia(AplicacoesEspeciais instancia) {
        this.instancia = instancia;
    }

    public List<AplicacoesEspeciais> getInstancias() {
        return instancias;
    }

    public void setInstancias(List<AplicacoesEspeciais> instancias) {
        this.instancias = instancias;
    }

    public List<AplicacoesEspeciais> getInstanciasFiltradas() {
        return instanciasFiltradas;
    }

    public void setInstanciasFiltradas(List<AplicacoesEspeciais> instanciasFiltradas) {
        this.instanciasFiltradas = instanciasFiltradas;
    }

    public boolean isIsEdit() {
        return isEdit;
    }

    public void setIsEdit(boolean isEdit) {
        this.isEdit = isEdit;
    }
    
    
}
