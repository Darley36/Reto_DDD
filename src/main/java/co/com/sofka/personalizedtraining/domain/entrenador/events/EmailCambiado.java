package co.com.sofka.personalizedtraining.domain.entrenador.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.personalizedtraining.domain.entrenador.values.Email;

public class EmailCambiado extends DomainEvent {
    private final Email email;

    public EmailCambiado(Email email) {
        super("sofka.entrenador.emailcambiado");
        this.email = email;
    }

    public Email getEmail() {
        return email;
    }
}
