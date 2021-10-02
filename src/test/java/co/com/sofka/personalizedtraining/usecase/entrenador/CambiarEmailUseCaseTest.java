package co.com.sofka.personalizedtraining.usecase.entrenador;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.personalizedtraining.domain.entrenador.commands.cambiarEmail;
import co.com.sofka.personalizedtraining.domain.entrenador.commands.cambiarNombre;
import co.com.sofka.personalizedtraining.domain.entrenador.events.EmailCambiado;
import co.com.sofka.personalizedtraining.domain.entrenador.events.EntrenadorCreado;
import co.com.sofka.personalizedtraining.domain.entrenador.events.NombreCambiado;
import co.com.sofka.personalizedtraining.domain.entrenador.values.Email;
import co.com.sofka.personalizedtraining.domain.entrenador.values.EntrenadorId;
import co.com.sofka.personalizedtraining.domain.entrenador.values.Nombre;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class CambiarEmailUseCaseTest {

    @Mock
    private DomainEventRepository repository;

    @Test
    void cambiarEmailEntrenador(){
        var useCase = new CambiarEmailUseCase();

        var command = new cambiarEmail(
                EntrenadorId.of("xxx"),
                new Email("Entrenador@email.com")
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

        var event = (EmailCambiado)events.get(0);
        assertEquals("Entrenador@email.com",event.getEmail().value());
    }

    private List<DomainEvent> eventStored() {
        return List.of(
                new EntrenadorCreado(
                        new Nombre("Coach Name!!"),
                        new Email("Coach@email.com"))
        );
    }
}