package co.com.sofka.personalizedtraining.usecase.entrenador;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.personalizedtraining.domain.entrenador.commands.CrearEntrenador;
import co.com.sofka.personalizedtraining.domain.entrenador.events.EntrenadorCreado;
import co.com.sofka.personalizedtraining.domain.entrenador.values.Email;
import co.com.sofka.personalizedtraining.domain.entrenador.values.EntrenadorId;
import co.com.sofka.personalizedtraining.domain.entrenador.values.Nombre;
import co.com.sofka.personalizedtraining.domain.grupo.commands.CrearGrupo;
import co.com.sofka.personalizedtraining.domain.grupo.events.GrupoCreado;
import co.com.sofka.personalizedtraining.domain.grupo.values.Apelativo;
import co.com.sofka.personalizedtraining.domain.grupo.values.GrupoId;
import co.com.sofka.personalizedtraining.usecase.grupo.CrearGrupoUseCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CrearEntrenadorUseCaseTest {
    @Test
    void crearEntrenador(){
        //arrange
        var command = new CrearEntrenador(
                EntrenadorId.of("xxxx"),
                new Nombre("CoachName!!"),
                new Email("Coach@email.com")
        );

        var useCase = new CrearEntrenadorUseCase();


        //act
        var events = UseCaseHandler
                .getInstance()
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        //assert
        Assertions.assertEquals(1,events.size());
        var event = (EntrenadorCreado)events.get(0);

        Assertions.assertEquals("CoachName!!",event.getNombre().value());
        Assertions.assertEquals("Coach@email.com",event.getEmail().value());


    }
}