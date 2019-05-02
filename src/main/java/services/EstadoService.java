
package services;

import daos.EstadoDAO;
import entities.Estado;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class EstadoService {
    
    @Autowired
    EstadoDAO dao;

    public void insert(Estado entity) {
        dao.insert(entity);
    }

    public void update(Estado entity) {
        dao.update(entity);
    }

    public void delete(Estado entity) {
        dao.delete(entity);
    }
    
    public Estado findById(Integer id) {
        return dao.findById(id);
    }

    public List<Estado> find() {
        return dao.find(new Estado());
    }
    
    public List<Estado> find(Estado entity) {
        return dao.find(entity);
    }
    
    public Estado findAnyOne() {
        return dao.findAnyOne();
    }

}
