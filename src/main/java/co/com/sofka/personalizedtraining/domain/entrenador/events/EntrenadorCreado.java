package co.com.sofka.personalizedtraining.domain.entrenador.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.personalizedtraining.domain.entrenador.values.Email;
import co.com.sofka.personalizedtraining.domain.entrenador.values.Nombre;

public class EntrenadorCreado extends DomainEvent {
    private final Nombre nombre;
    private final Email email;

    public EntrenadorCreado(Nombre nombre, Email email) {
        super("sofka.entrenador.entrenadorcreado");
        this.nombre = nombre;
        this.email = email;
    }

    public Nombre getNombre() {
        return nombre;
    }

    public Email getEmail() {
        return email;
    }
}
