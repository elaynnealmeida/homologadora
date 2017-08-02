
package br.com.uft.homologadora.converter;

import br.com.uft.homologadora.dao.TipoFuncionamentoDAO;
import br.com.uft.homologadora.model.TipoFuncionamento;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author UFT
 */
@FacesConverter(value = "TipoFuncionamentoConverter")
public class TipoFuncionamentoConverter implements Converter {

    private TipoFuncionamentoDAO dao = new TipoFuncionamentoDAO();

    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String string) {
        if (!string.trim().equals("")) {
            try {
                System.out.println("valor da string: " + string);
                return (TipoFuncionamento) dao.buscaPorID(Integer.valueOf(string));
            } catch (NumberFormatException e) {
                throw new ConverterException("Erro de conversão: " + e.getMessage());
            }

        }
        return null;
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object o) {
        if (o == null || o.equals("")) {
            return "";
        } else {
            return String.valueOf(((TipoFuncionamento) o).getId());
        }

    }
    
}
