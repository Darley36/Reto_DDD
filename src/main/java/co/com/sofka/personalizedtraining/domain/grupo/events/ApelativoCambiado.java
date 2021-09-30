package co.com.sofka.personalizedtraining.domain.grupo.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.personalizedtraining.domain.grupo.values.Apelativo;

public class ApelativoCambiado extends DomainEvent {
    private final Apelativo apelativo;

    public ApelativoCambiado(Apelativo apelativo) {
        super("sofka.grupo.apelativocreado");
        this.apelativo = apelativo;
    }

    public Apelativo getApelativo() {
        return apelativo;
    }
}
