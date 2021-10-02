package co.com.sofka.personalizedtraining.usecase;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.personalizedtraining.domain.grupo.commands.crearEquipoEntrenamiento;
import co.com.sofka.personalizedtraining.domain.grupo.events.EquipoEntrenamientoCreado;
import co.com.sofka.personalizedtraining.domain.grupo.events.GrupoCreado;
import co.com.sofka.personalizedtraining.domain.grupo.values.*;
import co.com.sofka.personalizedtraining.usecase.grupo.CrearEquipoEntrenamientoUseCase;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class CrearEquipoEntrenamientoUseCaseTest {


    @Mock
    private DomainEventRepository repository;

    @Test
    void crearEquipoEntrenamiento(){
        var useCase = new CrearEquipoEntrenamientoUseCase();

        var command = new crearEquipoEntrenamiento(
                GrupoId.of("xxx"),
                new EquipoEntrenamientoId("123"),
                new Procedencia("Esta es la procedencia"),
                new Instrucciones("Esta son las instrucciones"),
                new Cantidad(8),
                new Material("Este es el material")
        );
        Mockito.when(repository.getEventsBy("xxx")).thenReturn(eventStored());
        useCase.addRepository(repository);

        //act
        var events = UseCaseHandler
                .getInstance()
                .setIdentifyExecutor("xxx")
                .syncExecutor(useCase,new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        var event = (EquipoEntrenamientoCreado)events.get(0);
        assertEquals("123",event.getEquipoEntrenamientoId().value());
        assertEquals("Esta es la procedencia",event.getProcedencia().value());
        assertEquals("Esta son las instrucciones",event.getInstrucciones().value());
        assertEquals(8,event.getCantidad().value());
        assertEquals("Este es el material",event.getMaterial().value());
    }

    private List<DomainEvent> eventStored() {
        return List.of(
                new GrupoCreado(
                        new Apelativo("Nuevo grupo de baloncesto")
                ),
                new EquipoEntrenamientoCreado(
                        new EquipoEntrenamientoId("123"),
                        new Procedencia("Esta es la procedencia"),
                        new Instrucciones("Esta son las instrucciones"),
                        new Cantidad(8),
                        new Material("Este es el material")
                )
        );
    }
}