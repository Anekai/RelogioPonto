
package testesMapeamento;

import configuration.SpringConfig;
import entities.Funcionario;
import java.util.Calendar;
import org.junit.Assert;
import org.junit.Test;
import services.FuncionarioService;

public class FuncionarioServiceTest {
    
    @Test
    public final void baseTest() {
        FuncionarioService service = SpringConfig.context.getBean(FuncionarioService.class);
        Funcionario entity = service.findAnyOne();

        if ( entity == null ) {
            Funcionario entityInsert = new Funcionario();
            
            entityInsert.setNome("Alexandre");
            entityInsert.setSobreNome("Klabunde");
            entityInsert.setDataNascimento(Calendar.getInstance());

            service.insert( entityInsert );

            entity = entityInsert;
        } else {
            entity = service.findById( entity.getId() );

            service.update( entity );
        }

        if ( entity != null ) {
            entity = service.findById( entity.getId() );

            Funcionario entity2 = service.findAnyOne();

            Assert.assertNotNull( entity2 );
        }
    }
    
}
