
package views;

import configuration.SpringConfig;
import entities.Funcionario;
import java.util.Calendar;
import services.EstadoService;
import services.FuncionarioService;

public class MainView {
    
    public static void main(String[] args) {
        
        FuncionarioService service = SpringConfig.context.getBean(FuncionarioService.class);
//        PermissaoService service = SpringConfig.context.getBean(PermissaoService.class);
//        AuditoriaService auditoriaService = SpringConfig.context.getBean(AuditoriaService.class);

        Funcionario entity = new Funcionario();
        
        entity.setNome("Alexandre");
        entity.setSobreNome("Klabunde");
        entity.setDataNascimento(Calendar.getInstance());

        service.insert(entity);

    }
    
}
