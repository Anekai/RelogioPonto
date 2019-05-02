
package daos;

import entities.LogPonto;
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
public class LogPontoDAO {
    
    @PersistenceContext
    private EntityManager em;

    public void insert(LogPonto entity) {
        em.persist(entity);
    }

    public void update(LogPonto entity) {
        em.merge(entity);
    }

    public void delete(LogPonto entity) {
        em.remove(entity);
    }
    
    public LogPonto findById(Integer id) {
        Criteria criteria = ((Session)em.getDelegate()).createCriteria(LogPonto.class);
        
        criteria.add(Restrictions.eq("id", id));
        
        return (LogPonto)criteria.uniqueResult();
    }

    public List<LogPonto> find(LogPonto entity) {
        Criteria criteria = ((Session)em.getDelegate()).createCriteria(LogPonto.class);
        
        criteria.add(Example.create(entity));
        
        if (entity.getId() != null) {
            criteria.add(Restrictions.eq("id", entity.getId()));
        }
        
        criteria.addOrder(Order.asc("id"));
        
        return criteria.list();
    }
    
    public LogPonto findAnyOne() {
        Criteria criteria = ((Session)em.getDelegate()).createCriteria(LogPonto.class);
        
        criteria.setMaxResults(1);
        
        return (LogPonto) criteria.uniqueResult();
    }
    
}
