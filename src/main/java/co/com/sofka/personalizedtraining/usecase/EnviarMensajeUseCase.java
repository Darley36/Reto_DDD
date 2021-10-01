package co.com.sofka.personalizedtraining.usecase;

import co.com.sofka.business.generic.BusinessException;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.business.support.TriggeredEvent;
import co.com.sofka.personalizedtraining.domain.grupo.events.MensajeEnviado;

public class EnviarMensajeUseCase extends UseCase<TriggeredEvent<MensajeEnviado>, ResponseEvents> {

    @Override
    public void executeUseCase(TriggeredEvent<MensajeEnviado> mensajeEnviadoTriggeredEvent) {
        var event = mensajeEnviadoTriggeredEvent.getDomainEvent();
        var service = getService(EnvioDeMensajeService.class).orElseThrow();
        var ok = service.enviarMensaje("Sofka@email.com","Prueba de UseCase",event.getMensaje());

        if (!ok) {
            emit().onError((new BusinessException(
                    event.aggregateParentId(),
                    "No se pudo enviar el correo"
            )));
        }
    }
}
