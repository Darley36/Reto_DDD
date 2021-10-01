package co.com.sofka.personalizedtraining.usecase;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.business.support.TriggeredEvent;
import co.com.sofka.personalizedtraining.domain.grupo.Grupo;
import co.com.sofka.personalizedtraining.domain.grupo.events.GrupoCreado;
import co.com.sofka.personalizedtraining.domain.grupo.values.GrupoId;

public class AlertaPorCreacionDeGrupoUseCase extends UseCase<TriggeredEvent<GrupoCreado>, ResponseEvents> {
    private final String mensaje = "Se creo un grupo con valor por defecto";

    @Override
    public void executeUseCase(TriggeredEvent<GrupoCreado> grupoCreadoTriggeredEvent) {
        var event = grupoCreadoTriggeredEvent.getDomainEvent();
        var grupo = Grupo.from(GrupoId.of(event.aggregateRootId()),this.retrieveEvents());

        if(event.getApelativo().value().length() < 12){
            grupo.enviarAlerta(mensaje);
            emit().onResponse(new ResponseEvents(grupo.getUncommittedChanges()));
        }

    }
}
