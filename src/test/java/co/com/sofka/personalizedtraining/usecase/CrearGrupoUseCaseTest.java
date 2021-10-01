package co.com.sofka.personalizedtraining.usecase;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.personalizedtraining.domain.grupo.commands.CrearGrupo;
import co.com.sofka.personalizedtraining.domain.grupo.events.GrupoCreado;
import co.com.sofka.personalizedtraining.domain.grupo.values.Apelativo;
import co.com.sofka.personalizedtraining.domain.grupo.values.GrupoId;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CrearGrupoUseCaseTest {

    @Test
    void crearGrupoEscenarioNormal(){
        //arrange
        var command = new CrearGrupo(
                GrupoId.of("xxxxx"),
                new Apelativo("Grupo de baloncesto")
        );

        var useCase = new CrearGrupoUseCase();


        //act
        var events = UseCaseHandler.getInstance()
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        //assert
        Assertions.assertEquals(1,events.size());
        var event = (GrupoCreado)events.get(0);

        Assertions.assertEquals("Grupo de baloncesto",event.getApelativo().value());


    }

    @Test
    void crearGrupoEscenarioDefecto(){
        var command = new CrearGrupo(
                GrupoId.of("xxxxx"),
                new Apelativo("Grupo")
        );

        var useCase = new CrearGrupoUseCase();


        //act
        var events = UseCaseHandler.getInstance()
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        //assert
        Assertions.assertEquals(1,events.size());
        var event = (GrupoCreado)events.get(0);

        Assertions.assertEquals("ApelativoDefecto",event.getApelativo().value());
    }

}