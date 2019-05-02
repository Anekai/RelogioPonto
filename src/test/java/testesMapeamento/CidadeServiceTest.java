
package testesMapeamento;

import configuration.SpringConfig;
import entities.Cidade;
import org.junit.Assert;
import org.junit.Test;
import services.CidadeService;
import services.EstadoService;

public class CidadeServiceTest {
    
    @Test
    public final void baseTest() {
        CidadeService service = SpringConfig.context.getBean(CidadeService.class);
        Cidade entity = service.findAnyOne();

        if ( entity == null ) {
            Cidade entityInsert = new Cidade();
            
            entityInsert.setNome("Teste");
            entityInsert.setEstado(SpringConfig.context.getBean(EstadoService.class).findAnyOne());

            service.insert( entityInsert );

            entity = entityInsert;
        } else {
            entity = service.findById( entity.getId() );

            service.update( entity );
        }

        if ( entity != null ) {
            entity = service.findById( entity.getId() );

            Cidade entity2 = service.findAnyOne();

            Assert.assertNotNull( entity2 );
        }
    }
    
}
