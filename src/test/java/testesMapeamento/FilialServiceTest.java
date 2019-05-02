
package testesMapeamento;

import configuration.SpringConfig;
import entities.Filial;
import org.junit.Assert;
import org.junit.Test;
import services.CidadeService;
import services.FilialService;

public class FilialServiceTest {
    
    @Test
    public final void baseTest() {
        FilialService service = SpringConfig.context.getBean(FilialService.class);
        Filial entity = service.findAnyOne();

        if ( entity == null ) {
            Filial entityInsert = new Filial();
            
            entityInsert.setEndereco("Teste");
            entityInsert.setTelefone("37548962");
            entityInsert.setCidade(SpringConfig.context.getBean(CidadeService.class).findAnyOne());

            service.insert( entityInsert );

            entity = entityInsert;
        } else {
            entity = service.findById( entity.getId() );

            service.update( entity );
        }

        if ( entity != null ) {
            entity = service.findById( entity.getId() );

            Filial entity2 = service.findAnyOne();

            Assert.assertNotNull( entity2 );
        }
    }
    
}
