package entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Calendar;

@Entity
@Table(name = "funcionarios")
@SequenceGenerator(allocationSize = 1, name = "seq_funcionario", sequenceName = "seq_funcionario")
public class Funcionario implements Serializable {
 
    private Integer id;
    private String nome;
    private String sobrenome;
    private Calendar dataNascimento;
    private String login;
    private String senha;

    public Funcionario() {}

    public Funcionario(Integer id) {
        setId(id);
    }

    @Id
    @GeneratedValue(generator = "seq_funcionario", strategy = GenerationType.IDENTITY)
    @Column(name = "id_funcionario")
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "tx_nome")
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    
    @Column(name = "tx_sobrenome")
    public String getSobreNome() {
        return sobrenome;
    }
    public void setSobreNome(String sobrenome) {
        this.sobrenome = sobrenome;
    }
    
    @Column(name = "dt_nascimento")
    @Temporal(value = TemporalType.DATE)
    public Calendar getDataNascimento() {
        return dataNascimento;
    }
    
    public void setDataNascimento(Calendar dataNascimento) {
        this.dataNascimento = dataNascimento;
    }
    
    @Column(name = "tx_login")
    public String getLogin() {
        return login;
    }
    public void setLogin(String login) {
        this.login = login;
    }

    @Column(name = "tx_senha")
    public String getSenha() {
        return senha;
    }
    public void setSenha(String senha) {
        this.senha = senha;
    }

}
