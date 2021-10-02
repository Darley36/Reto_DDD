package co.com.sofka.personalizedtraining.usecase.entrenador;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.personalizedtraining.domain.entrenador.commands.agregarFuncion;
import co.com.sofka.personalizedtraining.domain.entrenador.commands.agregarRutina;
import co.com.sofka.personalizedtraining.domain.entrenador.events.EntrenadorCreado;
import co.com.sofka.personalizedtraining.domain.entrenador.events.FuncionAgregada;
import co.com.sofka.personalizedtraining.domain.entrenador.events.RutinaAgregada;
import co.com.sofka.personalizedtraining.domain.entrenador.values.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class AgregarFuncionUseCaseTest {

    @Mock
    private DomainEventRepository repository;
    @Test
    void AgregarFuncionEntrenador(){
        //Arrange
        var useCase = new AgregarFuncionUseCase();

        var command = new agregarFuncion(
                EntrenadorId.of("1"),
                new FuncionId("xxx"),
                new Nombre("Este es el nombre"),
                new Capacidad("Este es la capcidad"),
                new Experiencia("este es la experiencia"),
                new Descripcion("esta es la descripcion")
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
        var funcionAgregada = (FuncionAgregada) events.get(0);
        Assertions.assertEquals("xxx",funcionAgregada.getFuncionId().value());
        Assertions.assertEquals("Este es el nombre",funcionAgregada.getNombre().value());
        Assertions.assertEquals("Este es la capcidad",funcionAgregada.getCapacidad().value());
        Assertions.assertEquals("esta es la descripcion",funcionAgregada.getDescripcion().value());
        Assertions.assertEquals("este es la experiencia",funcionAgregada.getExperiencia().value());
    }

    private List<DomainEvent> evenStored() {
        return List.of(
                new EntrenadorCreado(
                        new Nombre("Coach Name!!"),
                        new Email("Coach@email.com"))
        );
    }
}