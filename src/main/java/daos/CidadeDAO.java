
package daos;

import entities.Cidade;
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
public class CidadeDAO {
    
    @PersistenceContext
    private EntityManager em;

    public void insert(Cidade entity) {
        em.persist(entity);
    }

    public void update(Cidade entity) {
        em.merge(entity);
    }

    public void delete(Cidade entity) {
        em.remove(entity);
    }
    
    public Cidade findById(Integer id) {
        Criteria criteria = ((Session)em.getDelegate()).createCriteria(Cidade.class);
        
        criteria.add(Restrictions.eq("id", id));
        
        return (Cidade)criteria.uniqueResult();
    }

    public List<Cidade> find(Cidade entity) {
        Criteria criteria = ((Session)em.getDelegate()).createCriteria(Cidade.class);
        
        criteria.add(Example.create(entity));
        
        if (entity.getId() != null) {
            criteria.add(Restrictions.eq("id", entity.getId()));
        }
        
        criteria.addOrder(Order.asc("id"));
        
        return criteria.list();
    }
    
    public Cidade findAnyOne() {
        Criteria criteria = ((Session)em.getDelegate()).createCriteria(Cidade.class);
        
        criteria.setMaxResults(1);
        
        return (Cidade) criteria.uniqueResult();
    }
    
}
