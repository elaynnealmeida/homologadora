
package br.com.uft.homologadora.converter;

import br.com.uft.homologadora.dao.AplicacoesEspeciaisDAO;
import br.com.uft.homologadora.model.AplicacoesEspeciais;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author UFT
 */
@FacesConverter(value = "AplicacoesEspeciaisConverter")
public class AplicacoesEspeciaisConverter implements Converter {

    private AplicacoesEspeciaisDAO dao = new AplicacoesEspeciaisDAO();

    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String string) {
        if (!string.trim().equals("")) {
            try {
                System.out.println("valor da string: " + string);
                return (AplicacoesEspeciais) dao.buscaPorID(Integer.valueOf(string));
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
            return String.valueOf(((AplicacoesEspeciais) o).getId());
        }

    }
    
}
