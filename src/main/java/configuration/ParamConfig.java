
package configuration;

import entities.Funcionario;

public class ParamConfig {
    
    private static Funcionario funcionario;
    
    public ParamConfig() {}
    
    public ParamConfig(Funcionario funcionario) {
        this.funcionario = funcionario;
    }
    
    public Funcionario getFuncionarioLogado() {
        return funcionario;
    }
    
}
