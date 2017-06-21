package br.com.uft.homologadora.controller;

import java.io.IOException;
import javax.faces.bean.ManagedBean;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

/**
 *
 * @author UFT
 */
@ManagedBean
public class NavegacaoHelper {
    
    public void cadastrar_usuario() throws IOException {
        ExternalContext externalContext = FacesContext.getCurrentInstance()
                .getExternalContext();
        try {
            externalContext.redirect(externalContext.getRequestContextPath()
                    + "/faces/cadastrousuario.xhtml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }  
    
    public void inicio() throws IOException {
        ExternalContext externalContext = FacesContext.getCurrentInstance()
                .getExternalContext();
        try {
            externalContext.redirect(externalContext.getRequestContextPath()
                    + "/faces/index.xhtml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    
     public void cadastrar_empresa_requerente() throws IOException {
        ExternalContext externalContext = FacesContext.getCurrentInstance()
                .getExternalContext();
        try {
            externalContext.redirect(externalContext.getRequestContextPath()
                    + "/faces/empresarequerente.xhtml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }   
     
     public void integracao_paf() throws IOException {
        ExternalContext externalContext = FacesContext.getCurrentInstance()
                .getExternalContext();
        try {
            externalContext.redirect(externalContext.getRequestContextPath()
                    + "/faces/integracao_paf.xhtml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }   
     
     public void meio_geracao_arq_sintegra() throws IOException {
        ExternalContext externalContext = FacesContext.getCurrentInstance()
                .getExternalContext();
        try {
            externalContext.redirect(externalContext.getRequestContextPath()
                    + "/faces/meio_geracao_arq_sintegra.xhtml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }   
     
      public void perfil_requisito_paf_ecf() throws IOException {
        ExternalContext externalContext = FacesContext.getCurrentInstance()
                .getExternalContext();
        try {
            externalContext.redirect(externalContext.getRequestContextPath()
                    + "/faces/perfil_requisito_paf_ecf.xhtml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }   
      
      public void paf_ecf() throws IOException {
        ExternalContext externalContext = FacesContext.getCurrentInstance()
                .getExternalContext();
        try {
            externalContext.redirect(externalContext.getRequestContextPath()
                    + "/faces/paf_ecf.xhtml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }   
      
      public void teste() throws IOException {
        ExternalContext externalContext = FacesContext.getCurrentInstance()
                .getExternalContext();
        try {
            externalContext.redirect(externalContext.getRequestContextPath()
                    + "/faces/newxhtml.xhtml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }   
    

}
