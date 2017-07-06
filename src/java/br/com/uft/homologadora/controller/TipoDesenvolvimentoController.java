/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.uft.homologadora.controller;

import br.com.uft.homologadora.dao.TipoDesenvolvimentoDAO;
import br.com.uft.homologadora.model.TipoDesenvolvimento;
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
public class TipoDesenvolvimentoController implements Serializable {
    
    private TipoDesenvolvimento instancia;
    private TipoDesenvolvimentoDAO dao;
    private List<TipoDesenvolvimento> instancias;
    private List<TipoDesenvolvimento> instanciasFiltradas;
    private boolean isEdit;
    
    @PostConstruct
    public void init() {
        this.instancia = new TipoDesenvolvimento();
        this.dao = new TipoDesenvolvimentoDAO();
        this.isEdit = false;
        listar();
    }
    
    public void limpar() {
        this.instancia = new TipoDesenvolvimento();
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
    
    public List<TipoDesenvolvimento> listar() {
        this.instancias = dao.listarTodos();
        return this.instancias;
    }
    
    public void onRowSelect(SelectEvent event) {
        this.instancia = ((TipoDesenvolvimento) event.getObject());
        this.isEdit = true;
    }
    
    public TipoDesenvolvimento getInstancia() {
        return instancia;
    }

    public void setInstancia(TipoDesenvolvimento instancia) {
        this.instancia = instancia;
    }

    public List<TipoDesenvolvimento> getInstancias() {
        return instancias;
    }

    public void setInstancias(List<TipoDesenvolvimento> instancias) {
        this.instancias = instancias;
    }

    public List<TipoDesenvolvimento> getInstanciasFiltradas() {
        return instanciasFiltradas;
    }

    public void setInstanciasFiltradas(List<TipoDesenvolvimento> instanciasFiltradas) {
        this.instanciasFiltradas = instanciasFiltradas;
    }

    public boolean isIsEdit() {
        return isEdit;
    }

    public void setIsEdit(boolean isEdit) {
        this.isEdit = isEdit;
    }
    
}
