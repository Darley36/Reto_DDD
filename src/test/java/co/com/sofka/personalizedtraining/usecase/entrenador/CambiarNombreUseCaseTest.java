package co.com.sofka.personalizedtraining.usecase.entrenador;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.personalizedtraining.domain.entrenador.commands.cambiarNombre;
import co.com.sofka.personalizedtraining.domain.entrenador.events.EntrenadorCreado;
import co.com.sofka.personalizedtraining.domain.entrenador.events.NombreCambiado;
import co.com.sofka.personalizedtraining.domain.entrenador.values.Email;
import co.com.sofka.personalizedtraining.domain.entrenador.values.EntrenadorId;
import co.com.sofka.personalizedtraining.domain.entrenador.values.Nombre;
import co.com.sofka.personalizedtraining.domain.grupo.commands.cambiarApelativo;
import co.com.sofka.personalizedtraining.domain.grupo.events.ApelativoCambiado;
import co.com.sofka.personalizedtraining.domain.grupo.events.GrupoCreado;
import co.com.sofka.personalizedtraining.domain.grupo.values.Apelativo;
import co.com.sofka.personalizedtraining.domain.grupo.values.GrupoId;
import co.com.sofka.personalizedtraining.usecase.grupo.CambiarApelativoUseCase;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class CambiarNombreUseCaseTest {

    @Mock
    private DomainEventRepository repository;

    @Test
    void cambiarNombre(){
        var useCase = new CambiarNombreUseCase();

        var command = new cambiarNombre(
                EntrenadorId.of("xxx"),
                new Nombre("Nuevo nombre")
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

        var event = (NombreCambiado)events.get(0);
        assertEquals("Nuevo nombre",event.getNombre().value());
    }

    private List<DomainEvent> eventStored() {
        return List.of(
                new EntrenadorCreado(
                        new Nombre("Coach Name!!"),
                        new Email("Coach@email.com"))
        );
    }
}