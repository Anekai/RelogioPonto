
package services;

import daos.FilialDAO;
import entities.Filial;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class FilialService {
    
    @Autowired
    FilialDAO dao;

    public void insert(Filial entity) {
        dao.insert(entity);
    }

    public void update(Filial entity) {
        dao.update(entity);
    }

    public void delete(Filial entity) {
        dao.delete(entity);
    }
    
    public Filial findById(Integer id) {
        return dao.findById(id);
    }

    public List<Filial> find() {
        return dao.find(new Filial());
    }
    
    public List<Filial> find(Filial entity) {
        return dao.find(entity);
    }
    
    public Filial findAnyOne() {
        return dao.findAnyOne();
    }
    
}
