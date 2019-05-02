
package daos;

import entities.Estado;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

@Repository
public class EstadoDAO {
    
    @PersistenceContext
    private EntityManager em;

    public void insert(Estado entity) {
        em.persist(entity);
    }

    public void update(Estado entity) {
        em.merge(entity);
    }

    public void delete(Estado entity) {
        em.remove(entity);
    }
    
    public Estado findById(Integer id) {
        Criteria criteria = ((Session)em.getDelegate()).createCriteria(Estado.class);
        
        criteria.add(Restrictions.eq("id", id));
        
        return (Estado)criteria.uniqueResult();
    }

    public List<Estado> find(Estado entity) {
        Criteria criteria = ((Session)em.getDelegate()).createCriteria(Estado.class);
        
        criteria.add(Example.create(entity));
        
        if (entity.getId() != null) {
            criteria.add(Restrictions.eq("id", entity.getId()));
        }
        
        criteria.setMaxResults(1);
        
        criteria.addOrder(Order.asc("id"));
        
        return criteria.list();
    }
    
    public Estado findAnyOne() {
        Criteria criteria = ((Session)em.getDelegate()).createCriteria(Estado.class);
        
        criteria.setMaxResults(1);
        
        return (Estado) criteria.uniqueResult();
    }
    
}
