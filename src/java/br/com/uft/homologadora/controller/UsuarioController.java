package br.com.uft.homologadora.controller;

import br.com.uft.homologadora.dao.UsuarioDAO;
import br.com.uft.homologadora.model.Usuario;
import br.com.uft.homologadora.util.Servicos;
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
public class UsuarioController implements Serializable {

    private Usuario instancia;
    private UsuarioDAO dao;
    private List<Usuario> instancias;
    private List<Usuario> instanciasFiltradas;
    private boolean isEdit;

    @PostConstruct
    public void init() {
        this.instancia = new Usuario();
        this.dao = new UsuarioDAO();
        this.isEdit = false;
        listar();
    }

    public void limpar() {
        this.instancia = new Usuario();
        this.isEdit = false;
        this.instancias = listar();
    }

    public void salvar() {
        Servicos servico = new Servicos();
        try {
            instancia.setSenha(servico.criptografa(instancia.getSenha()));
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
        Servicos servico = new Servicos();
        try {
            instancia.setSenha(servico.criptografa(instancia.getSenha()));
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
            if (instancia.getOrgaoTecnicoCredenciadoList().isEmpty()) {
                dao.deletar(instancia);
                FacesMessage msg = new FacesMessage("Excluido com Sucesso!");
                FacesContext.getCurrentInstance().addMessage(null, msg);
                limpar();
            } else {
                FacesMessage msg = new FacesMessage("Valor não pode ser excluido!");
                FacesContext.getCurrentInstance().addMessage(null, msg);
            }

        } catch (Exception e) {
            limpar();
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro ao tentar excluir!", null);
            FacesContext.getCurrentInstance().addMessage(null, message);
        }
    }

    public List<Usuario> listar() {
        this.instancias = dao.listarTodos();
        return this.instancias;
    }

    public void onRowSelect(SelectEvent event) {
        this.instancia = ((Usuario) event.getObject());       
        this.isEdit = true;
    }

    public Usuario getInstancia() {
        return instancia;
    }

    public void setInstancia(Usuario instancia) {
        this.instancia = instancia;
    }

    public List<Usuario> getInstancias() {
        return instancias;
    }

    public void setInstancias(List<Usuario> instacias) {
        this.instancias = instacias;
    }

    public List<Usuario> getInstanciasFiltradas() {
        return instanciasFiltradas;
    }

    public void setInstanciasFiltradas(List<Usuario> instaciasFiltradas) {
        this.instanciasFiltradas = instaciasFiltradas;
    }

    public boolean isIsEdit() {
        return isEdit;
    }

    public void setIsEdit(boolean isEdit) {
        this.isEdit = isEdit;
    }

    
    
}
