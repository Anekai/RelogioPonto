
package services;

import daos.LogPontoDAO;
import entities.LogPonto;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class LogPontoService {
    
    @Autowired
    LogPontoDAO dao;

    public void insert(LogPonto entity) {
        dao.insert(entity);
    }

    public void update(LogPonto entity) {
        dao.update(entity);
    }

    public void delete(LogPonto entity) {
        dao.delete(entity);
    }
    
    public LogPonto findById(Integer id) {
        return dao.findById(id);
    }

    public List<LogPonto> find() {
        return dao.find(new LogPonto());
    }
    
    public List<LogPonto> find(LogPonto entity) {
        return dao.find(entity);
    }
    
    public LogPonto findAnyOne() {
        return dao.findAnyOne();
    }
    
}
