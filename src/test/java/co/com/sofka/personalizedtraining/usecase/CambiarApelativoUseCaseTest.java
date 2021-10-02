package co.com.sofka.personalizedtraining.usecase;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.personalizedtraining.domain.grupo.commands.cambiarApelativo;
import co.com.sofka.personalizedtraining.domain.grupo.events.ApelativoCambiado;
import co.com.sofka.personalizedtraining.domain.grupo.events.GrupoCreado;
import co.com.sofka.personalizedtraining.domain.grupo.values.Apelativo;
import co.com.sofka.personalizedtraining.domain.grupo.values.GrupoId;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class CambiarApelativoUseCaseTest {



    @Mock
    private DomainEventRepository repository;

    @Test
    void cambiarApelativo(){
        var useCase = new CambiarApelativoUseCase();

        var command = new cambiarApelativo(
                GrupoId.of("xxx"),
                new Apelativo("Grupo de baloncesto")
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

        var event = (ApelativoCambiado)events.get(0);
        assertEquals("Grupo de baloncesto",event.getApelativo().value());
    }

    private List<DomainEvent> eventStored() {
        return List.of(
                new GrupoCreado(
                        new Apelativo("Grupo de basketboll")
                )
        );
    }
}