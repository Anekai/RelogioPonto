
package entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "cidades")
@SequenceGenerator(allocationSize = 1, name = "seq_cidade", sequenceName = "seq_cidade")
public class Cidade implements Serializable {

    private Integer id;
    private String nome;
    private Estado estado;
    
    public Cidade() {}

    public Cidade(Integer id) {
        setId(id);
    }

    @Id
    @GeneratedValue(generator = "seq_cidade", strategy = GenerationType.IDENTITY)
    @Column(name = "id_cidade")
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
    
    @JoinColumn(name = "id_estado")
    @ManyToOne
    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }
    
}
