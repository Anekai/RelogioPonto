
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
@Table(name = "filiais")
@SequenceGenerator(allocationSize = 1, name = "seq_filial", sequenceName = "seq_filial")
public class Filial implements Serializable {
    
    private Integer id;
    private String endereco;
    private String telefone;
    private Cidade cidade;
    
    public Filial() {}

    public Filial(Integer id) {
        setId(id);
    }

    @Id
    @GeneratedValue(generator = "seq_filial", strategy = GenerationType.IDENTITY)
    @Column(name = "id_filial")
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    
    @Column(name = "tx_endereco")
    public String getEndereco() {
        return endereco;
    }
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
    
    @Column(name = "nr_telefone")
    public String getTelefone() {
        return telefone;
    }
    
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    
    @JoinColumn(name = "id_cidade")
    @ManyToOne
    public Cidade getCidade() {
        return cidade;
    }

    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }
    
}
