
package entities;

import java.io.Serializable;
import java.util.Calendar;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import types.TipoPontoType;

@Entity
@Table(name = "logs_pontos")
@SequenceGenerator(allocationSize = 1, name = "seq_log_ponto", sequenceName = "seq_log_ponto")
public class LogPonto implements Serializable {
    
    private Integer id;
    private Calendar dataPonto;
    private TipoPontoType tipoPonto;
    private Funcionario funcionario;
    
    public LogPonto() {}

    public LogPonto(Integer id) {
        setId(id);
    }

    @Id
    @GeneratedValue(generator = "seq_log_ponto", strategy = GenerationType.IDENTITY)
    @Column(name = "id_log_ponto")
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "dt_ponto")
    @Temporal(value = TemporalType.TIMESTAMP)
    public Calendar getDataPonto() {
        return dataPonto;
    }

    public void setDataPonto(Calendar dataPonto) {
        this.dataPonto = dataPonto;
    }

    @Column(name = "dm_tipo_ponto")
    @Enumerated(EnumType.STRING)
    public TipoPontoType getTipoPonto() {
        return tipoPonto;
    }

    public void setTipoPonto(TipoPontoType tipoPonto) {
        this.tipoPonto = tipoPonto;
    }
    
    @JoinColumn(name = "id_funcionario")
    @ManyToOne
    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }
    
}
