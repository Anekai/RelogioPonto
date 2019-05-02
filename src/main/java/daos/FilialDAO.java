
package daos;

import entities.Filial;
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
public class FilialDAO {
    
    @PersistenceContext
    private EntityManager em;

    public void insert(Filial entity) {
        em.persist(entity);
    }

    public void update(Filial entity) {
        em.merge(entity);
    }

    public void delete(Filial entity) {
        em.remove(entity);
    }
    
    public Filial findById(Integer id) {
        Criteria criteria = ((Session)em.getDelegate()).createCriteria(Filial.class);
        
        criteria.add(Restrictions.eq("id", id));
        
        return (Filial)criteria.uniqueResult();
    }

    public List<Filial> find(Filial entity) {
        Criteria criteria = ((Session)em.getDelegate()).createCriteria(Filial.class);
        
        criteria.add(Example.create(entity));
        
        if (entity.getId() != null) {
            criteria.add(Restrictions.eq("id", entity.getId()));
        }
        
        criteria.addOrder(Order.asc("id"));
        
        return criteria.list();
    }
    
    public Filial findAnyOne() {
        Criteria criteria = ((Session)em.getDelegate()).createCriteria(Filial.class);
        
        criteria.setMaxResults(1);
        
        return (Filial) criteria.uniqueResult();
    }
    
}
