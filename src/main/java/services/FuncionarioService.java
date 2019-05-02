package services;

import daos.FuncionarioDAO;
import entities.Funcionario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class FuncionarioService {
 
    @Autowired
    FuncionarioDAO dao;

    public void insert(Funcionario entity) {
        dao.insert(entity);
    }

    public void update(Funcionario entity) {
        dao.update(entity);
    }

    public void delete(Funcionario entity) {
        dao.delete(entity);
    }
    
    public Funcionario findById(Integer id) {
        return dao.findById(id);
    }

    public List<Funcionario> find() {
        return dao.find(new Funcionario());
    }
    
    public List<Funcionario> find(Funcionario entity) {
        return dao.find(entity);
    }

    public Funcionario loginUsuario( String login, String senha ) {
        return dao.loginUsuario( login, senha );
    }
    
    public Funcionario findAnyOne() {
        return dao.findAnyOne();
    }

}
