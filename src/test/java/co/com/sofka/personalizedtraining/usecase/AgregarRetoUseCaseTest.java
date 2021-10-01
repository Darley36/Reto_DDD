package co.com.sofka.personalizedtraining.usecase;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.personalizedtraining.domain.grupo.commands.agregarMiembro;
import co.com.sofka.personalizedtraining.domain.grupo.commands.agregarReto;
import co.com.sofka.personalizedtraining.domain.grupo.events.GrupoCreado;
import co.com.sofka.personalizedtraining.domain.grupo.events.MiembroAgregado;
import co.com.sofka.personalizedtraining.domain.grupo.events.RetoAgregado;
import co.com.sofka.personalizedtraining.domain.grupo.values.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
class AgregarRetoUseCaseTest {

    private AgregarRetoUseCase agregarRetoUseCase;
    @Mock
    private DomainEventRepository repository;
    @BeforeEach
    public void setup(){
        agregarRetoUseCase = new AgregarRetoUseCase();
        repository = mock(DomainEventRepository.class);
        agregarRetoUseCase.addRepository(repository);
    }
    @Test
    void AgregarRetoGrupo(){
        //Arrange
        var command = new agregarReto(
                GrupoId.of("1"),
                new RetoId("xxx"),
                new Descripcion("esto es la descripcion"),
                new Duracion("esta es la duracion"),
                new FechaEjecucion("esta es la fecha"),
                new Dificultad("esta es la dificultad"),
                new Estado("este es el estado")
        );

        when(repository.getEventsBy("1")).thenReturn(events());

        //act
        var response = UseCaseHandler
                .getInstance()
                .setIdentifyExecutor("1")
                .syncExecutor(agregarRetoUseCase, new RequestCommand<>(command))
                .orElseThrow();
        var events = response.getDomainEvents();

        //assert
        var retoAgregado = (RetoAgregado) events.get(0);
        Assertions.assertEquals("xxx",retoAgregado.getRetoId().value());
        Assertions.assertEquals("esto es la descripcion",retoAgregado.getDescripcion().value());
        Assertions.assertEquals("esta es la duracion",retoAgregado.getDuracion().value());
        Assertions.assertEquals("esta es la fecha",retoAgregado.getFechaEjecucion().value());
        Assertions.assertEquals("esta es la dificultad",retoAgregado.getDificultad().value());
        Assertions.assertEquals("este es el estado",retoAgregado.getEstado().value());
    }

    private List<DomainEvent> events() {
        return List.of(
                new GrupoCreado(
                        new Apelativo("Grupo de natacion"))
        );
    }
}