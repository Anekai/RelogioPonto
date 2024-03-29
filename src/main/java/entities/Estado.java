
package entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "estados")
@SequenceGenerator(allocationSize = 1, name = "seq_estado", sequenceName = "seq_estado")
public class Estado implements Serializable {
    
    private Integer id;
    private String nome;
    
    public Estado() {}

    public Estado(Integer id) {
        setId(id);
    }

    @Id
    @GeneratedValue(generator = "seq_estado", strategy = GenerationType.IDENTITY)
    @Column(name = "id_estado")
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
    
}
