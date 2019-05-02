/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reportVO;

import java.math.BigDecimal;

/**
 *
 * @author alexa
 */
public class MovimentoSaldoReportVO {
    
    private String cliente;
    private String dataMovimento;
    private String tipoMovimento;
    private BigDecimal valorMovimento;

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public String getDataMovimento() {
        return dataMovimento;
    }

    public void setDataMovimento(String dataMovimento) {
        this.dataMovimento = dataMovimento;
    }

    public String getTipoMovimento() {
        return tipoMovimento;
    }

    public void setTipoMovimento(String tipoMovimento) {
        this.tipoMovimento = tipoMovimento;
    }

    public BigDecimal getValorMovimento() {
        return valorMovimento;
    }

    public void setValorMovimento(BigDecimal valorMovimento) {
        this.valorMovimento = valorMovimento;
    }
    
}