package br.com.uft.homologadora.controller;

import br.com.uft.homologadora.dao.EmpresaRequerenteDAO;
import br.com.uft.homologadora.dao.UsuarioDAO;
import br.com.uft.homologadora.model.EmpresaRequerente;
import br.com.uft.homologadora.model.Usuario;
import br.com.uft.homologadora.util.Servicos;
import java.io.Serializable;
import java.util.List;
import java.util.UUID;
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
public class EmpresaRequerenteControler implements Serializable {

    private EmpresaRequerente instancia;
    private Usuario user;
    private UsuarioDAO userDao;
    private EmpresaRequerenteDAO dao;
    private List<EmpresaRequerente> instancias;
    private List<EmpresaRequerente> instanciasFiltradas;
    private boolean isEdit;

    @PostConstruct
    public void init() {
        this.instancia = new EmpresaRequerente();
        this.user = new Usuario();
        this.userDao = new UsuarioDAO();
        this.dao = new EmpresaRequerenteDAO();
        this.isEdit = false;
        listar();
    }

    public void limpar() {
        this.instancia = new EmpresaRequerente();
        this.user = new Usuario();
        this.isEdit = false;
        this.instancias = listar();
    }

    public void salvar() {
        try {
            Servicos s = new Servicos();
            String senha = new String();
            senha = s.criptografa(gerarSenha());
            user.setCpfCnpj(instancia.getCnpj());
            user.setEmail(instancia.getEmail());
            user.setSenha(senha);
            user.setNome(instancia.getRazaoSocial());
            user.setTelefone(instancia.getTelefone());
            user.setPerfil("Empresa Requerente");

            userDao.salvar(user);
            instancia.setUsuario(user);
            dao.salvar(instancia);

            s.enviarEmail(user, senha);
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
            //  if (instancia) {
            dao.deletar(instancia);
            FacesMessage msg = new FacesMessage("Excluido com Sucesso!");
            FacesContext.getCurrentInstance().addMessage(null, msg);
            limpar();
            /* } else {
                FacesMessage msg = new FacesMessage("Valor não pode ser excluido!");
                FacesContext.getCurrentInstance().addMessage(null, msg);
            }*/

        } catch (Exception e) {
            limpar();
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro ao tentar excluir!", null);
            FacesContext.getCurrentInstance().addMessage(null, message);
        }
    }

    public String gerarSenha() {
        UUID uuid = UUID.randomUUID();
        String myRandom = uuid.toString();
        String senha = myRandom.substring(0, 6);
        System.out.println("senha: " + senha);
        return senha;
    }

    public List<EmpresaRequerente> listar() {
        this.instancias = dao.listarTodos();
        return this.instancias;
    }

    public void onRowSelect(SelectEvent event) {
        this.instancia = ((EmpresaRequerente) event.getObject());
        this.isEdit = true;
    }

    public EmpresaRequerente getInstancia() {
        return instancia;
    }

    public void setInstancia(EmpresaRequerente instancia) {
        this.instancia = instancia;
    }

    public List<EmpresaRequerente> getInstancias() {
        return instancias;
    }

    public void setInstancias(List<EmpresaRequerente> instancias) {
        this.instancias = instancias;
    }

    public List<EmpresaRequerente> getInstanciasFiltradas() {
        return instanciasFiltradas;
    }

    public void setInstanciasFiltradas(List<EmpresaRequerente> instanciasFiltradas) {
        this.instanciasFiltradas = instanciasFiltradas;
    }

    public boolean isIsEdit() {
        return isEdit;
    }

    public void setIsEdit(boolean isEdit) {
        this.isEdit = isEdit;
    }

}
