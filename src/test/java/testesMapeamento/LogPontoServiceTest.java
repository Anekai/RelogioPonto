
package testesMapeamento;

import configuration.SpringConfig;
import entities.LogPonto;
import java.util.Calendar;
import org.junit.Assert;
import org.junit.Test;
import services.FuncionarioService;
import services.LogPontoService;
import types.TipoPontoType;

public class LogPontoServiceTest {
    
    @Test
    public final void baseTest() {
        LogPontoService service = SpringConfig.context.getBean(LogPontoService.class);
        LogPonto entity = service.findAnyOne();

        if ( entity == null ) {
            LogPonto entityInsert = new LogPonto();
            
            entityInsert.setTipoPonto(TipoPontoType.ENTRADA);
            entityInsert.setDataPonto(Calendar.getInstance());
            entityInsert.setFuncionario(SpringConfig.context.getBean(FuncionarioService.class).findAnyOne());

            service.insert( entityInsert );

            entity = entityInsert;
        } else {
            entity = service.findById( entity.getId() );

            service.update( entity );
        }

        if ( entity != null ) {
            entity = service.findById( entity.getId() );

            LogPonto entity2 = service.findAnyOne();

            Assert.assertNotNull( entity2 );
        }
    }
    
}
