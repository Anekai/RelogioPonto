/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testesMapeamento;

import configuration.SpringConfig;
import entities.Estado;
import org.junit.Assert;
import org.junit.Test;
import services.EstadoService;

public class EstadoServiceTest {

    @Test
    public final void baseTest() {
        EstadoService service = SpringConfig.context.getBean(EstadoService.class);
        Estado entity = service.findAnyOne();

        if ( entity == null ) {
            Estado entityInsert = new Estado();
            
            entityInsert.setNome("Teste");

            service.insert( entityInsert );

            entity = entityInsert;
        } else {
            entity = service.findById( entity.getId() );

            service.update( entity );
        }

        if ( entity != null ) {
            entity = service.findById( entity.getId() );

            Estado entity2 = service.findAnyOne();

            Assert.assertNotNull( entity2 );
        }
    }
}
