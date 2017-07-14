
package br.com.uft.homologadora.converter;

import br.com.uft.homologadora.dao.MeioGeracaoArqSintegraDAO;
import br.com.uft.homologadora.model.MeioGeracaoArqSintegra;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author UFT
 */
@FacesConverter(value = "MeioGeracaoArqSintegraConverter")
public class MeioGeracaoArqSintegraConverter implements Converter{
    private MeioGeracaoArqSintegraDAO dao = new MeioGeracaoArqSintegraDAO();

    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String string) {
        if (!string.trim().equals("")) {
            try {
                System.out.println("valor da string: "+string);
                return (MeioGeracaoArqSintegra) dao.buscaPorID(Integer.valueOf(string));
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
            return String.valueOf(((MeioGeracaoArqSintegra) o).getId());
        }

    }
    
}
