package co.com.sofka.personalizedtraining.usecase.entrenador;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.personalizedtraining.domain.entrenador.commands.agregarRutina;
import co.com.sofka.personalizedtraining.domain.entrenador.events.EntrenadorCreado;
import co.com.sofka.personalizedtraining.domain.entrenador.events.RutinaAgregada;
import co.com.sofka.personalizedtraining.domain.entrenador.values.*;
import co.com.sofka.personalizedtraining.domain.entrenador.values.Email;
import co.com.sofka.personalizedtraining.domain.entrenador.values.Nombre;
import co.com.sofka.personalizedtraining.domain.grupo.commands.agregarReto;
import co.com.sofka.personalizedtraining.domain.grupo.events.GrupoCreado;
import co.com.sofka.personalizedtraining.domain.grupo.events.RetoAgregado;
import co.com.sofka.personalizedtraining.domain.grupo.values.*;
import co.com.sofka.personalizedtraining.usecase.grupo.AgregarRetoUseCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class AgregarRutinaUseCaseTest {

    @Mock
    private DomainEventRepository repository;
    @Test
    void AgregarRutinaEntrenador(){
        //Arrange
        var useCase = new AgregarRutinaUseCase();

        var command = new agregarRutina(
                EntrenadorId.of("1"),
                new RutinaId("xxx"),
                new Serie(1),
                new Afectacion("Esta es la afectacion."),
                new Caracteristica("Esta es la caracteristica")
        );

        Mockito.when(repository.getEventsBy("xxx")).thenReturn(evenStored());
        useCase.addRepository(repository);

        //act
        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor("xxx")
                .syncExecutor(useCase,new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        //assert
        var rutinaAgregada = (RutinaAgregada) events.get(0);
        Assertions.assertEquals("xxx",rutinaAgregada.getRutinaId().value());
        Assertions.assertEquals(1,rutinaAgregada.getSerie().value());
        Assertions.assertEquals("Esta es la afectacion.",rutinaAgregada.getAfectacion().value());
        Assertions.assertEquals("Esta es la caracteristica",rutinaAgregada.getCaracteristica().value());
    }

    private List<DomainEvent> evenStored() {
        return List.of(
                new EntrenadorCreado(
                        new Nombre("Coach Name!!"),
                        new Email("Coach@email.com"))
        );
    }
}