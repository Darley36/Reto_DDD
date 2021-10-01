package co.com.sofka.personalizedtraining.usecase;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.personalizedtraining.domain.grupo.commands.agregarMiembro;
import co.com.sofka.personalizedtraining.domain.grupo.events.GrupoCreado;
import co.com.sofka.personalizedtraining.domain.grupo.events.MiembroAgregado;
import co.com.sofka.personalizedtraining.domain.grupo.values.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class AgregarMiembroUseCaseTest {

    private AgregarMiembroUseCase agregarMiembroUseCase;
    @Mock
    private DomainEventRepository repository;
    @BeforeEach
    public void setup(){
        agregarMiembroUseCase = new AgregarMiembroUseCase();
        repository = mock(DomainEventRepository.class);
        agregarMiembroUseCase.addRepository(repository);
    }
    @Test
    void AgregarMiembroGrupo(){
        //Arrange
        var command = new agregarMiembro(
                GrupoId.of("1"),
                new MiembroId("xxx"),
                new Nombre("Juanssssssss"),
                new Email("juan@gmail.com"),
                new Residencia("Medellin calle300"),
                new DatosFisicos(60.0)
        );

        when(repository.getEventsBy("1")).thenReturn(events());

        //act
        var response = UseCaseHandler
                .getInstance()
                .setIdentifyExecutor("1")
                .syncExecutor(agregarMiembroUseCase, new RequestCommand<>(command))
                .orElseThrow();
        var events = response.getDomainEvents();

        //assert
        var miembroAgregado = (MiembroAgregado) events.get(0);
        Assertions.assertEquals("xxx",miembroAgregado.getMiembroId().value());
        Assertions.assertEquals("Juanssssssss",miembroAgregado.getNombre().value());
        Assertions.assertEquals("juan@gmail.com",miembroAgregado.getEmail().value());
        Assertions.assertEquals("Medellin calle300",miembroAgregado.getResidencia().value());
        Assertions.assertEquals(60.0,miembroAgregado.getDatosFisicos().value());
    }

    private List<DomainEvent> events() {
        return List.of(
                new GrupoCreado(
                        new Apelativo("Grupo de natacion"))
        );
    }
}