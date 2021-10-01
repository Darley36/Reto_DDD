package co.com.sofka.personalizedtraining.domain.grupo.events;

import co.com.sofka.domain.generic.DomainEvent;

public class MensajeEnviado extends DomainEvent {
    private  final String mensaje;
    public MensajeEnviado(String mensaje) {
        super("sofka.grupo.mensajeenviado");
        this.mensaje = mensaje;
    }

    public String getMensaje() {
        return mensaje;
    }
}
