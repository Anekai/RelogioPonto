package daos;

import configuration.ParamConfig;
import entities.Funcionario;
import org.hibernate.Session;
import org.hibernate.criterion.Example;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

@Repository
public class FuncionarioDAO {
 
    @PersistenceContext
    private EntityManager em;

    public void insert(Funcionario entity) {
        em.persist(entity);
    }

    public void update(Funcionario entity) {
        em.merge(entity);
    }

    public void delete(Funcionario entity) {
        em.remove(entity);
    }
    
    public Funcionario findById(Integer id) {
        Criteria criteria = ((Session)em.getDelegate()).createCriteria(Funcionario.class);
        
        criteria.add(Restrictions.eq("id", id));
        
        return (Funcionario)criteria.uniqueResult();
    }

    public List<Funcionario> find(Funcionario entity) {
        Criteria criteria = ((Session)em.getDelegate()).createCriteria(Funcionario.class);
        
        criteria.add(Example.create(entity));
        
        if (entity.getId() != null) {
            criteria.add(Restrictions.eq("id", entity.getId()));
        }
        
        criteria.addOrder(Order.asc("id"));
        
        return criteria.list();
    }

    public Funcionario loginUsuario( String login, String senha ) {
        Funcionario entity = new Funcionario();

        entity.setLogin(login);
        entity.setSenha(senha);

        return (Funcionario)((Session)em.getDelegate()).createCriteria(Funcionario.class).add(Example.create(entity)).uniqueResult();
    }
    
    public Funcionario findAnyOne() {
        Criteria criteria = ((Session)em.getDelegate()).createCriteria(Funcionario.class);
        
        criteria.setMaxResults(1);
        
        return (Funcionario) criteria.uniqueResult();
    }

}
