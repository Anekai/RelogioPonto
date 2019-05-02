
package services;

import daos.CidadeDAO;
import entities.Cidade;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CidadeService {
    
    @Autowired
    CidadeDAO dao;

    public void insert(Cidade entity) {
        dao.insert(entity);
    }

    public void update(Cidade entity) {
        dao.update(entity);
    }

    public void delete(Cidade entity) {
        dao.delete(entity);
    }
    
    public Cidade findById(Integer id) {
        return dao.findById(id);
    }

    public List<Cidade> find() {
        return dao.find(new Cidade());
    }
    
    public List<Cidade> find(Cidade entity) {
        return dao.find(entity);
    }
    
    public Cidade findAnyOne() {
        return dao.findAnyOne();
    }
    
}
