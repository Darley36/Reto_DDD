package co.com.sofka.personalizedtraining.usecase;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
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

@ExtendWith(MockitoExtension.class)
class AgregarRetoUseCaseTest {

    @Mock
    private DomainEventRepository repository;

    @Test
    void AgregarMiembroGrupo(){
        //Arrange
        var useCase = new AgregarRetoUseCase();

        var command = new agregarReto(
                GrupoId.of("1"),
                new RetoId("xxx"),
                new Descripcion("esto es la descripcion"),
                new Duracion("esta es la duracion"),
                new FechaEjecucion("esta es la fecha"),
                new Dificultad("esta es la dificultad"),
                new Estado("este es el estado")
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
        var retoAgregado = (RetoAgregado) events.get(0);
        Assertions.assertEquals("xxx",retoAgregado.getRetoId().value());
        Assertions.assertEquals("esto es la descripcion",retoAgregado.getDescripcion().value());
        Assertions.assertEquals("esta es la duracion",retoAgregado.getDuracion().value());
        Assertions.assertEquals("esta es la fecha",retoAgregado.getFechaEjecucion().value());
        Assertions.assertEquals("esta es la dificultad",retoAgregado.getDificultad().value());
        Assertions.assertEquals("este es el estado",retoAgregado.getEstado().value());
    }

    private List<DomainEvent> evenStored() {
        return List.of(
                new GrupoCreado(
                        new Apelativo("Grupo de natacion"))
        );
    }


}