
package br.com.uft.homologadora.dao;

import br.com.uft.homologadora.model.Usuario;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.persistence.metamodel.EntityType;

/**
 *
 * @author UFT
 */
public class UsuarioDAO extends GenericDAO<Usuario>{
    
    public UsuarioDAO() {
        super(Usuario.class);
    }
    
    public Usuario login(Usuario user){
          Usuario result = new Usuario();
    try {
            EntityManager em1 = getEM();
            em1.getTransaction().begin();
            CriteriaBuilder builder = em1.getCriteriaBuilder();
            CriteriaQuery query = builder.createQuery(Usuario.class);
            EntityType type = em1.getMetamodel().entity(Usuario.class);
            Root root = query.from(Usuario.class);
            query.where(builder.and(builder.equal(root.get(type.getDeclaredSingularAttribute("email", String.class)), user.getEmail()),
                    builder.equal(root.get(type.getDeclaredSingularAttribute("senha", String.class)), user.getSenha())));
            result = (Usuario) em1.createQuery(query).getSingleResult();
            em1.close();
            return result;
        } catch (Exception e) {
            return null;
        }
    }
    
}
