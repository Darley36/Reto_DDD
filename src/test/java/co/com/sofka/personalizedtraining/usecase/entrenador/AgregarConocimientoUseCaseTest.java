package co.com.sofka.personalizedtraining.usecase.entrenador;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.personalizedtraining.domain.entrenador.commands.agregarConocimiento;
import co.com.sofka.personalizedtraining.domain.entrenador.commands.agregarFuncion;
import co.com.sofka.personalizedtraining.domain.entrenador.events.ConocimientoAgregado;
import co.com.sofka.personalizedtraining.domain.entrenador.events.EntrenadorCreado;
import co.com.sofka.personalizedtraining.domain.entrenador.events.FuncionAgregada;
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
class AgregarConocimientoUseCaseTest {

    @Mock
    private DomainEventRepository repository;
    @Test
    void agregarConocimientoEntrenador(){
        var useCase = new AgregarConocimientoUseCase();

        var command = new agregarConocimiento(
                EntrenadorId.of("1"),
                new ConocimientoId("xxx"),
                new Descripcion("Esta es la descripcion"),
                new DatosClave("Estos son los datos clave"),
                new Tema("Este es el tema")
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
        var conocimientoAgregado = (ConocimientoAgregado) events.get(0);
        Assertions.assertEquals("xxx",conocimientoAgregado.getConocimientoId().value());
        Assertions.assertEquals("Esta es la descripcion",conocimientoAgregado.getDescripcion().value());
        Assertions.assertEquals("Estos son los datos clave",conocimientoAgregado.getDatosClave().value());
        Assertions.assertEquals("Este es el tema",conocimientoAgregado.getTema().value());
    }

    private List<DomainEvent> evenStored() {
        return List.of(
                new EntrenadorCreado(
                        new Nombre("Coach Name!!"),
                        new Email("Coach@email.com"))
        );
    }
}