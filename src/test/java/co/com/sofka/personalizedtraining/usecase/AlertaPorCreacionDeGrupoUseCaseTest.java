package co.com.sofka.personalizedtraining.usecase;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.TriggeredEvent;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.personalizedtraining.domain.grupo.events.GrupoCreado;
import co.com.sofka.personalizedtraining.domain.grupo.events.MensajeEnviado;
import co.com.sofka.personalizedtraining.domain.grupo.values.Apelativo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class AlertaPorCreacionDeGrupoUseCaseTest {

    @Mock
    private DomainEventRepository repository;


    @Test
    void Alertarpormensaje(){

        //arrange
        var aggregateId = "xxxx";
        var event = new GrupoCreado(new Apelativo("Estupendo"));
        event.setAggregateRootId(aggregateId);
        var useCase = new AlertaPorCreacionDeGrupoUseCase();
        Mockito.when(repository.getEventsBy(aggregateId)).thenReturn(eventStored());
        useCase.addRepository(repository);

        //act
        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(aggregateId)
                .syncExecutor(useCase,new TriggeredEvent<>(event))
                .orElseThrow()
                .getDomainEvents();

        //assert
        var mensajeEnviado = (MensajeEnviado)events.get(0);

        Assertions.assertEquals("Se creo un grupo con valor por defecto",mensajeEnviado.getMensaje());
        Mockito.verify(repository).getEventsBy(aggregateId);
    }

    private List<DomainEvent> eventStored() {
        var event = new GrupoCreado(new Apelativo("Estupendo"));
        return List.of(
                event
        );
    }

}